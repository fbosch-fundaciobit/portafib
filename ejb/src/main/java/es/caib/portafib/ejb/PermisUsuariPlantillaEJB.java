
package es.caib.portafib.ejb;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.portafib.model.entity.PermisUsuariPlantilla;
import es.caib.portafib.jpa.PermisUsuariPlantillaJPA;
import es.caib.portafib.jpa.PermisUsuariPlantillaJPAManager;

@Stateless(name = "PermisUsuariPlantillaEJB")
@SecurityDomain("seycon")
public class PermisUsuariPlantillaEJB extends PermisUsuariPlantillaJPAManager implements PermisUsuariPlantillaLocal {

  @Override
	@RolesAllowed({"PFI_ADMIN","PFI_USER"})
	public void delete(PermisUsuariPlantilla instance) {
		super.delete(instance);
	}

  @Override
	@RolesAllowed({"PFI_ADMIN","PFI_USER"})
	public PermisUsuariPlantilla create(PermisUsuariPlantilla instance) throws I18NException {
		return super.create(instance);
	}

  @Override
	@RolesAllowed({"PFI_ADMIN","PFI_USER"})
	public PermisUsuariPlantilla update(PermisUsuariPlantilla instance) throws I18NException {
		 return super.update(instance);
	}

  @Override
	@RolesAllowed({"PFI_ADMIN","PFI_USER"})
  public PermisUsuariPlantillaJPA findByPrimaryKey(Long _ID_) {
    return (PermisUsuariPlantillaJPA)super.findByPrimaryKey(_ID_);
  }

}