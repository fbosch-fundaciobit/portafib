package es.caib.portafib.back.controller.common;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.Select;
import org.fundaciobit.genapp.common.query.SelectConstant;
import org.fundaciobit.genapp.common.query.StringField;
import org.fundaciobit.genapp.common.query.SubQuery;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.caib.portafib.back.form.webdb.UsuariEntitatRefList;
import es.caib.portafib.back.form.webdb.UsuariPersonaRefList;
import es.caib.portafib.back.security.LoginInfo;
import es.caib.portafib.jpa.UsuariEntitatJPA;
import es.caib.portafib.jpa.UsuariPersonaJPA;
import es.caib.portafib.logic.UsuariEntitatLogicaLocal;
import es.caib.portafib.logic.UsuariPersonaLogicaLocal;
import es.caib.portafib.model.entity.UsuariEntitat;
import es.caib.portafib.model.fields.UsuariEntitatFields;
import es.caib.portafib.model.fields.UsuariEntitatQueryPath;
import es.caib.portafib.model.fields.UsuariPersonaFields;
import es.caib.portafib.model.fields.UsuariPersonaQueryPath;
import es.caib.portafib.utils.Configuracio;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *  
 * @autor anadal
 * 
 */
@Controller
@RequestMapping(value = "/common/json")
public class SearchJSONController {

  protected final Logger log = Logger.getLogger(getClass());
  
  
  @EJB(mappedName = "portafib/UsuariEntitatLogicaEJB/local")
  protected UsuariEntitatLogicaLocal usuariEntitatLogicaEjb;
 
  @EJB(mappedName = UsuariPersonaLogicaLocal.JNDI_NAME)
  protected UsuariPersonaLogicaLocal usuariPersonaLogicaEjb;

  
  @RequestMapping(value = "/usuarientitat", method = RequestMethod.GET)
  public void usuariEntitatGet(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    usuariEntitat(request, response);
  }
  
  @Autowired
  protected UsuariEntitatRefList usuariEntitatRefList;
  
  @Autowired
  protected UsuariPersonaRefList usuariPersonaRefList;
  
  @PostConstruct
  public void init() {

    { 
      this.usuariEntitatRefList = new UsuariEntitatRefList(usuariEntitatRefList);

      final UsuariPersonaQueryPath personaQueryPath = new UsuariEntitatQueryPath().USUARIPERSONA();
      this.usuariEntitatRefList.setSelects(new Select<?>[] { 
          personaQueryPath.LLINATGES().select , new SelectConstant(", "), 
          personaQueryPath.NOM().select, new SelectConstant(" ("), 
          personaQueryPath.NIF().select, new SelectConstant(" - "),
          personaQueryPath.USUARIPERSONAID().select,new SelectConstant(")") });
      
      this.usuariEntitatRefList.setSeparator("");
    }
    
    {
      this.usuariPersonaRefList = new UsuariPersonaRefList(usuariPersonaRefList);

      this.usuariPersonaRefList.setSelects(new Select<?>[] { 
          UsuariPersonaFields.LLINATGES.select , new SelectConstant(", "), 
          UsuariPersonaFields.NOM.select, new SelectConstant(" ("), 
          UsuariPersonaFields.NIF.select, new SelectConstant(" - "),
          UsuariPersonaFields.USUARIPERSONAID.select,new SelectConstant(")") });
      
      this.usuariPersonaRefList.setSeparator("");
    }
  }
  
  
  /**
   * Filtre totes les persones de PortaFIB
   * @param request
   * @param response
   * @throws Exception
   */
  @RequestMapping(value = "/usuaripersona", method = RequestMethod.POST)
  public void usuaripersona(HttpServletRequest request, HttpServletResponse response
     ) throws Exception {

    final Where additionalWhere = null;
    
    processUsuariPersonaRequest(request, response, additionalWhere);
    
  }
  
  
  /**
   * Filtre per les persones que estan donades d'alta a l'entitat actual
   * @param request
   * @param response
   * @throws Exception
   */
  @RequestMapping(value = "/usuaripersonaentitat", method = RequestMethod.POST)
  public void usuaripersonaentitat(HttpServletRequest request, HttpServletResponse response
     ) throws Exception {

    SubQuery<UsuariEntitat, String> subquery;
    
    try {
      subquery = usuariEntitatLogicaEjb.getSubQuery(UsuariEntitatFields.USUARIPERSONAID,
          Where.AND(
            UsuariEntitatFields.ENTITATID.equal(LoginInfo.getInstance().getEntitatID()),
            UsuariEntitatFields.CARREC.isNull(),
            UsuariEntitatFields.ACTIU.equal(true)
            ) 
          );
    } catch (I18NException e) {
      log.error("Error cercant usuaris dins del mètode usuaripersonaentitat()", e);
      subquery = null;
    }
    
    Where additionalWhere = UsuariPersonaFields.USUARIPERSONAID.in(subquery);
    
    processUsuariPersonaRequest(request, response, additionalWhere);

  }



  protected void processUsuariPersonaRequest(HttpServletRequest request,
      HttpServletResponse response, Where additionalWhere) throws IOException {
    String queryFull = request.getParameter("query");
    
    final UsuariPersonaQueryPath personaQueryPath = new UsuariPersonaQueryPath();

    StringField keyField = UsuariPersonaFields.USUARIPERSONAID;
    
    IRefBaseReferenceList refListBase = new RefBaseReferenceListUsuariPersona(usuariPersonaRefList);
    
    String json = genericSearch(queryFull, personaQueryPath, usuariPersonaLogicaEjb, additionalWhere, keyField,
        refListBase);
    
    
    PrintWriter pw= response.getWriter();
    
    pw.write(json);
    pw.flush();
  }
  
  
  
  /**
   * Filtre usuaris-entitat de l'entitat actual.
   * @param request
   * @param response
   * @throws Exception
   */
  @RequestMapping(value = "/usuarientitat", method = RequestMethod.POST)
  public void usuariEntitat(HttpServletRequest request, HttpServletResponse response
     ) throws Exception {

    
    String queryFull = request.getParameter("query");
    
    final UsuariPersonaQueryPath personaQueryPath = new UsuariEntitatQueryPath().USUARIPERSONA();
 
    Where additionalWhere = Where.AND(
        UsuariEntitatFields.ENTITATID.equal(LoginInfo.getInstance().getEntitatID()),
        UsuariEntitatFields.CARREC.isNull(),
        UsuariEntitatFields.ACTIU.equal(true)
        );
    
    StringField keyField = UsuariEntitatFields.USUARIENTITATID;
    
    IRefBaseReferenceList refListBase = new RefBaseReferenceListUsuariEntitat(usuariEntitatRefList);
    
    String json = genericSearch(queryFull, personaQueryPath, usuariEntitatLogicaEjb,
        additionalWhere, keyField, refListBase);
    
    
    PrintWriter pw= response.getWriter();
    
    pw.write(json);
    pw.flush();
    
  }




  protected String genericSearch(String queryFull,
      final UsuariPersonaQueryPath personaQueryPath,
      org.fundaciobit.genapp.common.query.ITableManager<?,?> uem, Where additionalWhere,
      StringField keyField, IRefBaseReferenceList refListBase) throws IOException {
    
      final boolean isDebug = log.isDebugEnabled();
    
      if (isDebug) {
        log.debug("JSON CRIDADA FULL ]" + queryFull  + "[");
      }

      final OrderBy orderBy = new OrderBy(personaQueryPath.LLINATGES());

      List<Where> wheres = new ArrayList<Where>();
      for(String query: queryFull.split(" ")) {
      
        final String like = "%" + query + "%";
        final Where whereQuery = Where.OR( 
            personaQueryPath.NOM().like(like),
            personaQueryPath.LLINATGES().like(like),
            personaQueryPath.NIF().like(like),
            personaQueryPath.USUARIPERSONAID().like(like)
            );
        
        wheres.add(whereQuery);
      }
      
      Where whereQueryFull = Where.AND(wheres.toArray(new Where[wheres.size()]));
      
      final Where where = Where.AND(
          additionalWhere,
          whereQueryFull
          );
      
  
      final long max = Configuracio.getMaxItemsToShowInAutocomplete();
      
      List<StringKeyValue> values;
      try {
        Long count = uem.count(where); 
        if (count > max) {
          if (isDebug) {
            log.debug("S'han trobat " + count 
              + " usuaris però només es permet mostrar amb resultats menors que " + max);
          }
          values = new ArrayList<StringKeyValue>();
        } else { 
          values = refListBase.getReferenceList(keyField, where, orderBy);
        }
      } catch (I18NException e) {
        log.error(I18NUtils.getMessage(e), e);
        values = new ArrayList<StringKeyValue>();
      }
  
      if (isDebug) {
        log.debug(" ========================================== ");
        log.debug(" RESULTATS.SIZE = " + values.size());
      }
  
      //usuariEntitatLogicaEjb.s
      StringBuffer str = new StringBuffer();
      str.append('[');
  
      for (int i = 0; i < values.size(); i++) {
        StringKeyValue skv = values.get(i);
  
        if (i != 0) {
          str.append(',');
        }
        str.append("{\"Id\":\"" + escapeJSON(skv.getKey()) + "\",\"Name\":\"" + escapeJSON(skv.getValue()) + "\"}");
        
        if (isDebug) {
          log.debug(" RESULTAT[" + i 
            + "] = {\"Id\":\"" + skv.getKey() + "\",\"Name\":\"" + skv.getValue() + "\"}");
        }
        
      }
  
      
      str.append(" ]");
    
     return str.toString();
    
  }
  
  
  public String escapeJSON(String txt) {
    
    return txt.replace("\\","\\\\").replace("\"", "\\\"");
    // \"  Double quote
    //\\  Backslash caracte
  }
  
  
  
  interface IRefBaseReferenceList {
    public List<StringKeyValue> getReferenceList(Field<?> keyField, Where where, OrderBy ... orderBy) throws I18NException;
  }

  class RefBaseReferenceListUsuariEntitat implements IRefBaseReferenceList {
    
    final UsuariEntitatRefList usuariEntitatRefList;

    public RefBaseReferenceListUsuariEntitat(UsuariEntitatRefList usuariEntitatRefList) {
      super();
      this.usuariEntitatRefList = usuariEntitatRefList;
    }

    @Override
    public List<StringKeyValue> getReferenceList(Field<?> keyField, Where where,
        OrderBy... orderBy) throws I18NException {
      return this.usuariEntitatRefList.getReferenceList(keyField, where, orderBy);
    }

  }
  
  
  class RefBaseReferenceListUsuariPersona implements IRefBaseReferenceList {
    
    final UsuariPersonaRefList usuariPersonaRefList;

    public RefBaseReferenceListUsuariPersona(UsuariPersonaRefList usuariPersonaRefList) {
      super();
      this.usuariPersonaRefList = usuariPersonaRefList;
    }

    @Override
    public List<StringKeyValue> getReferenceList(Field<?> keyField, Where where,
        OrderBy... orderBy) throws I18NException {
      return this.usuariPersonaRefList.getReferenceList(keyField, where, orderBy);
    }

  }
  
  
  public static List<StringKeyValue> favoritsToUsuariPersona(List<UsuariEntitatJPA> list) {
    if (list == null) return null;

    List<StringKeyValue> listSKV = new ArrayList<StringKeyValue>(list.size());
    
    for (UsuariEntitatJPA favorit : list) {
      UsuariPersonaJPA up = favorit.getUsuariPersona();
      String value = usuariPersonaToString(up);
      
      listSKV.add(new StringKeyValue(up.getUsuariPersonaID(), value));
    }
    
    return listSKV;
  }
  
  
  public static List<StringKeyValue> favoritsToUsuariEntitat(List<UsuariEntitatJPA> list) {
    if (list == null) return null;

    List<StringKeyValue> listSKV = new ArrayList<StringKeyValue>(list.size());
    
    for (UsuariEntitatJPA favorit : list) {
      UsuariPersonaJPA up = favorit.getUsuariPersona();
      String value = usuariPersonaToString(up);
      
      listSKV.add(new StringKeyValue(favorit.getUsuariEntitatID(), value));
    }
    
    return listSKV;
  }



  protected static String usuariPersonaToString(UsuariPersonaJPA up) {
    String tmp = up.getLlinatges() + ", " + up.getNom() + "(" + up.getNif() 
        + " - " + up.getUsuariPersonaID() + ")";
    
    return tmp.replace('"', '\'');
  }
  

}