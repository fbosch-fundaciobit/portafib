
package es.caib.portafib.ejb;

import javax.ejb.Local;

import es.caib.portafib.jpa.EntitatJPA;
import es.caib.portafib.model.dao.IEntitatManager;

@Local
public interface EntitatLocal extends IEntitatManager {

 public static final String JNDI_NAME = "portafib/EntitatEJB/local";
  public EntitatJPA findByPrimaryKey(String _ID_);
}