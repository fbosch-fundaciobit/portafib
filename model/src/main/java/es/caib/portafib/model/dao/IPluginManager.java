package es.caib.portafib.model.dao;

import es.caib.portafib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IPluginManager extends org.fundaciobit.genapp.common.query.ITableManager<Plugin, Long> {


	public Plugin create( long _nomID_, long _descripcioCurtaID_, java.lang.String _classe_, int _tipus_, java.lang.String _propertiesAdmin_, java.lang.String _propertiesEntitat_, java.lang.String _entitatID_, boolean _actiu_) throws I18NException;

	public Plugin findByPrimaryKey(long _pluginID_);

	public void delete(long _pluginID_);

}