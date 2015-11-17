package es.caib.portafib.back.controller.admin;

import java.util.Arrays;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.portafib.back.controller.webdb.PluginController;
import es.caib.portafib.back.form.webdb.PluginFilterForm;
import es.caib.portafib.back.form.webdb.PluginForm;
import es.caib.portafib.back.security.LoginInfo;
import es.caib.portafib.jpa.PluginJPA;
import es.caib.portafib.utils.Constants;


/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = "/admin/modulDeFirma")
@SessionAttributes(types = { PluginForm.class, PluginFilterForm.class })
public class ModulDeFirmaAdminController extends PluginController {
  
  
  
  @Override
  public String getTileForm() {
    return "modulDeFirmaFormAdmin";
  }

  @Override
  public String getTileList() {
    return "modulDeFirmaListAdmin";
  }


  @Override
  public String getSessionAttributeFilterForm() {
    return "ModulDeFirmaAdmin_FilterForm";
  }
  
  @Override
  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return Where.AND(
        ENTITATID.isNull(),
        TIPUS.equal(Constants.TIPUS_PLUGIN_MODULDEFIRMA));
  }

  @Override
  public PluginFilterForm getPluginFilterForm(Integer pagina, ModelAndView mav,
      HttpServletRequest request) throws I18NException {
      PluginFilterForm modulDeFirmaFilterForm;
      modulDeFirmaFilterForm = super.getPluginFilterForm(pagina, mav, request);
      if(modulDeFirmaFilterForm.isNou()) {
        
         Field<?>[] fields = ALL_PLUGIN_FIELDS;
         
         HashSet<Field<?>>  campsOcults = new HashSet<Field<?>>(Arrays.asList(fields));
        
         campsOcults.remove(NOMID);         
         //campsOcults.remove(CLASSE);
         campsOcults.remove(ACTIU);
         
         modulDeFirmaFilterForm.getHiddenFields().addAll(campsOcults);
         
       

      }
      
      return modulDeFirmaFilterForm;
  }
  
  
  @Override
  public PluginForm getPluginForm(PluginJPA _jpa,
      boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
     PluginForm modulDeFirmaForm = super.getPluginForm(_jpa, __isView, request, mav);
     if(modulDeFirmaForm.isNou()) {
       modulDeFirmaForm.getPlugin().setActiu(true);
       modulDeFirmaForm.getPlugin().setTipus(Constants.TIPUS_PLUGIN_MODULDEFIRMA);
     }
     
     modulDeFirmaForm.addHiddenField(ENTITATID);
     modulDeFirmaForm.addHiddenField(TIPUS);
   
     return modulDeFirmaForm;
   }
  

  

  @Override
  public String getEntityNameCode() {
    return "moduldefirma.plantilla";
  }

  @Override
  public String getEntityNameCodePlural() {
    return "moduldefirma.plantilla.plural";
  }
  
}