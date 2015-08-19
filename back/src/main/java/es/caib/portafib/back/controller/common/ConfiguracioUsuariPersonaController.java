package es.caib.portafib.back.controller.common;

import es.caib.portafib.back.controller.webdb.UsuariPersonaController;
import es.caib.portafib.back.form.webdb.UsuariPersonaForm;
import es.caib.portafib.back.reflist.IdiomaSuportatRefList;
import es.caib.portafib.back.security.LoginInfo;
import es.caib.portafib.jpa.UsuariPersonaJPA;
import es.caib.portafib.model.entity.UsuariPersona;
import es.caib.portafib.utils.Configuracio;
import es.caib.portafib.utils.Constants;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

/**
 * Created 18/06/13 8:39
 *
 * @author mgonzalez
 * @author anadal
 */
@Controller
@RequestMapping(value= "/common/configuracio/usuaripersona")
public class ConfiguracioUsuariPersonaController extends UsuariPersonaController {

  @Override
  public String getTileForm() {
    return "configuracioUsuariPersonaForm";
  }
  
  @PostConstruct
  public void init() {
    this.idiomaRefList = new IdiomaSuportatRefList(this.idiomaRefList);
  }


  @Override
  public UsuariPersonaForm getUsuariPersonaForm(UsuariPersonaJPA _jpa, boolean __isView,
      HttpServletRequest request, ModelAndView mav) throws I18NException {

      UsuariPersonaForm form = super.getUsuariPersonaForm(_jpa,__isView, request, mav);

      // Obtenim l'usuari persona logueat
      LoginInfo loginInfo = LoginInfo.getInstance();
      UsuariPersonaJPA usuari = loginInfo.getUsuariPersona();

      // Obtenim l'usuaripersona carregat al form
      UsuariPersona up = form.getUsuariPersona();

      // Comprovam que no es modifiqui un usuari que no es amb el que t'has logueat
      if(!up.getUsuariPersonaID().equals(usuari.getUsuariPersonaID())){
          throw  new I18NException("error.unknown",
              "No es pot modificar un usuari persona que no és el teu");
      }

      // Només de lectura
      form.addReadOnlyField(NIF);
      form.addReadOnlyField(USUARIPERSONAID);
     
      if (Configuracio.isCAIB() || request.isUserInRole(Constants.ROLE_ADMIN)
          || Configuracio.getDefaultEntity() != null) {
        // Podem modificar el nom i llinatge
      } else {
        form.addReadOnlyField(NOM);
        form.addReadOnlyField(LLINATGES);
      }

      form.addHiddenField(RUBRICAID);

      if(up.getEmail()!=null && !Configuracio.isEditableUser()){
          form.addReadOnlyField(EMAIL);
      }

      // Ocultam boto Cancelar i Borrar
      form.setCancelButtonVisible(false);
      form.setDeleteButtonVisible(false);
      
      // Posar titol
      form.setTitleCode("configuracio_usuari_persona");
      
      return form;
  }

  @Override
  public String getRedirectWhenModified(HttpServletRequest request, UsuariPersonaForm usuariPersonaForm, Throwable __e) {
    return "redirect:" + getContextWeb() +"/"+usuariPersonaForm.getUsuariPersona().getUsuariPersonaID()+"/edit";
  }
  
  /*
  @Override
  public void preList(HttpServletRequest request, ModelAndView mav, 
      UsuariPersonaFilterForm filterForm)  throws Exception {
      throw new Exception("Pagina no disponible");
  }
  */
  @Override
  public boolean isActiveList() {
    return false;
  }

  @Override
  public boolean isActiveFormNew() {
    return false;
  }


  @Override
  public boolean isActiveDelete() {
    return false;
  }

}
