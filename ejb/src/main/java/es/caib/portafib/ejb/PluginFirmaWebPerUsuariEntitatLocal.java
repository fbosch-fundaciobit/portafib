
package es.caib.portafib.ejb;

import javax.ejb.Local;

import es.caib.portafib.jpa.PluginFirmaWebPerUsuariEntitatJPA;
import es.caib.portafib.model.dao.IPluginFirmaWebPerUsuariEntitatManager;

@Local
public interface PluginFirmaWebPerUsuariEntitatLocal extends IPluginFirmaWebPerUsuariEntitatManager {

 public static final String JNDI_NAME = "portafib/PluginFirmaWebPerUsuariEntitatEJB/local";
  public PluginFirmaWebPerUsuariEntitatJPA findByPrimaryKey(Long _ID_);
}