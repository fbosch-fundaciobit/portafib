package es.caib.portafib.back.controller.aden;

import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.portafib.back.controller.dest.DelegacioDestController;
import es.caib.portafib.back.form.dest.ColaboracioDelegacioDestForm;
import es.caib.portafib.back.form.webdb.ColaboracioDelegacioFilterForm;
import es.caib.portafib.back.form.webdb.ColaboracioDelegacioForm;
import es.caib.portafib.ejb.UsuariEntitatLocal;

import es.caib.portafib.back.form.SeleccioUsuariForm;
/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = "/aden/colaboradordecarrec")
@SessionAttributes(types = { ColaboracioDelegacioDestForm.class, SeleccioUsuariForm.class,
    ColaboracioDelegacioForm.class, ColaboracioDelegacioFilterForm.class })
public class ColaboracioDeCarrecAdenController extends DelegacioDestController {

  
  @EJB(mappedName = UsuariEntitatLocal.JNDI_NAME)
  protected UsuariEntitatLocal usuariEntitatEjb;

  /**
   * 
   * @return
   */
  @Override
  public boolean esDelegat() {
    return false;
  }
  
  @Override
  public boolean esDeCarrec() {
    return true;
  }
  
  
  @Override
  public String getTileForm() {
    return "colaboracioDelegacioDeCarrecAdenForm";
  }

  @Override
  public String getTileList() {
    return "colaboracioDelegacioDeCarrecAdenList";
  }

  @Override
  public String getSessionAttributeFilterForm() {
    return getEntityNameCode() + "_Aden_FilterForm";
  }

}