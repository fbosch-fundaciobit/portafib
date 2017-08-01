package es.caib.portafib.ws.v1.impl;

import javax.annotation.security.RolesAllowed;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.fundaciobit.genapp.common.ws.WsI18NException;
import org.fundaciobit.genapp.common.ws.WsValidationException;

import es.caib.portafib.utils.Constants;

/**
 * 
 * @author anadal
 *
 */
@WebService
public interface PortaFIBPassarelaDeFirmaEnServidorWs extends AbstractPortaFIBPassarelaDeFirmaWs {

  //--------------------------------------------------------------------
  // -------------------------------------------------------------------
  // -----------------------| Firma de documents  |---------------------
  // -------------------------------------------------------------------
  // -------------------------------------------------------------------

  @RolesAllowed({ Constants.PFI_ADMIN, Constants.PFI_USER })
  @WebMethod
  public PassarelaFullResultsWs signDocuments(
      @WebParam(name = "signaturesSet") PassarelaSignaturesSetWs signaturesSet)
      throws WsI18NException, WsValidationException, Throwable;

}
