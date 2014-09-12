package es.caib.portafib.jpa.validator;

import es.caib.portafib.jpa.EstatDeFirmaJPA;
import org.fundaciobit.genapp.common.validation.BeanValidatorResult;
import java.util.List;
import org.fundaciobit.genapp.common.i18n.I18NFieldError;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.validation.AbstractBeanValidator;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class EstatDeFirmaBeanValidator 
      extends AbstractBeanValidator<EstatDeFirmaJPA> {


  // EJB's
  protected final es.caib.portafib.model.dao.IColaboracioDelegacioManager __colaboracioDelegacioManager;

  protected final es.caib.portafib.model.dao.IEstatDeFirmaManager __estatDeFirmaManager;

  protected final es.caib.portafib.model.dao.IFirmaManager __firmaManager;

  protected final es.caib.portafib.model.dao.ITipusEstatDeFirmaFinalManager __tipusEstatDeFirmaFinalManager;

  protected final es.caib.portafib.model.dao.ITipusEstatDeFirmaInicialManager __tipusEstatDeFirmaInicialManager;

  protected final es.caib.portafib.model.dao.IUsuariEntitatManager __usuariEntitatManager;


  public final EstatDeFirmaValidator<EstatDeFirmaJPA> _validator;


  public EstatDeFirmaBeanValidator(es.caib.portafib.model.dao.IColaboracioDelegacioManager __colaboracioDelegacioManager,
     es.caib.portafib.model.dao.IEstatDeFirmaManager __estatDeFirmaManager,
     es.caib.portafib.model.dao.IFirmaManager __firmaManager,
     es.caib.portafib.model.dao.ITipusEstatDeFirmaFinalManager __tipusEstatDeFirmaFinalManager,
     es.caib.portafib.model.dao.ITipusEstatDeFirmaInicialManager __tipusEstatDeFirmaInicialManager,
     es.caib.portafib.model.dao.IUsuariEntitatManager __usuariEntitatManager) { 
    this.__colaboracioDelegacioManager = __colaboracioDelegacioManager;
    this.__estatDeFirmaManager = __estatDeFirmaManager;
    this.__firmaManager = __firmaManager;
    this.__tipusEstatDeFirmaFinalManager = __tipusEstatDeFirmaFinalManager;
    this.__tipusEstatDeFirmaInicialManager = __tipusEstatDeFirmaInicialManager;
    this.__usuariEntitatManager = __usuariEntitatManager;
    _validator = new EstatDeFirmaValidator<EstatDeFirmaJPA>();
  }

  public EstatDeFirmaBeanValidator(EstatDeFirmaValidator<EstatDeFirmaJPA> _validator,
     es.caib.portafib.model.dao.IColaboracioDelegacioManager __colaboracioDelegacioManager,
     es.caib.portafib.model.dao.IEstatDeFirmaManager __estatDeFirmaManager,
     es.caib.portafib.model.dao.IFirmaManager __firmaManager,
     es.caib.portafib.model.dao.ITipusEstatDeFirmaFinalManager __tipusEstatDeFirmaFinalManager,
     es.caib.portafib.model.dao.ITipusEstatDeFirmaInicialManager __tipusEstatDeFirmaInicialManager,
     es.caib.portafib.model.dao.IUsuariEntitatManager __usuariEntitatManager) {
    this.__colaboracioDelegacioManager = __colaboracioDelegacioManager;
    this.__estatDeFirmaManager = __estatDeFirmaManager;
    this.__firmaManager = __firmaManager;
    this.__tipusEstatDeFirmaFinalManager = __tipusEstatDeFirmaFinalManager;
    this.__tipusEstatDeFirmaInicialManager = __tipusEstatDeFirmaInicialManager;
    this.__usuariEntitatManager = __usuariEntitatManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(EstatDeFirmaJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<EstatDeFirmaJPA> _bvr_ = new BeanValidatorResult<EstatDeFirmaJPA>();
    _validator.validate(_bvr_, target, isNou, __colaboracioDelegacioManager, __estatDeFirmaManager, __firmaManager, __tipusEstatDeFirmaFinalManager, __tipusEstatDeFirmaInicialManager, __usuariEntitatManager);
    return _bvr_.getErrors();
  }
}
