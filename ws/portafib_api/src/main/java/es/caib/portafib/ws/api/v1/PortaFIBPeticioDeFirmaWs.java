package es.caib.portafib.ws.api.v1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.4
 * 2017-07-26T09:51:04.916+02:00
 * Generated source version: 2.6.4
 * 
 */
@WebService(targetNamespace = "http://impl.v1.ws.portafib.caib.es/", name = "PortaFIBPeticioDeFirmaWs")
@XmlSeeAlso({ObjectFactory.class})
public interface PortaFIBPeticioDeFirmaWs {

    @RequestWrapper(localName = "startPeticioDeFirma", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.StartPeticioDeFirma")
    @WebMethod
    @ResponseWrapper(localName = "startPeticioDeFirmaResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.StartPeticioDeFirmaResponse")
    public void startPeticioDeFirma(
        @WebParam(name = "peticioDeFirmaID", targetNamespace = "")
        long peticioDeFirmaID
    ) throws WsI18NException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getEntitatID", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.GetEntitatID")
    @WebMethod
    @ResponseWrapper(localName = "getEntitatIDResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.GetEntitatIDResponse")
    public java.lang.String getEntitatID();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getLastSignedFileOfPeticioDeFirma", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.GetLastSignedFileOfPeticioDeFirma")
    @WebMethod
    @ResponseWrapper(localName = "getLastSignedFileOfPeticioDeFirmaResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.GetLastSignedFileOfPeticioDeFirmaResponse")
    public es.caib.portafib.ws.api.v1.FitxerBean getLastSignedFileOfPeticioDeFirma(
        @WebParam(name = "peticioDeFirmaID", targetNamespace = "")
        long peticioDeFirmaID
    ) throws WsI18NException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createPeticioDeFirma", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.CreatePeticioDeFirma")
    @WebMethod
    @ResponseWrapper(localName = "createPeticioDeFirmaResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.CreatePeticioDeFirmaResponse")
    public es.caib.portafib.ws.api.v1.PeticioDeFirmaWs createPeticioDeFirma(
        @WebParam(name = "peticioDeFirmaWs", targetNamespace = "")
        es.caib.portafib.ws.api.v1.PeticioDeFirmaWs peticioDeFirmaWs
    ) throws WsI18NException, WsValidationException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getStateOfPeticioDeFirma", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.GetStateOfPeticioDeFirma")
    @WebMethod
    @ResponseWrapper(localName = "getStateOfPeticioDeFirmaResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.GetStateOfPeticioDeFirmaResponse")
    public java.lang.Integer getStateOfPeticioDeFirma(
        @WebParam(name = "peticioDeFirmaID", targetNamespace = "")
        long peticioDeFirmaID
    ) throws WsI18NException;

    @RequestWrapper(localName = "deletePeticioDeFirma", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.DeletePeticioDeFirma")
    @WebMethod
    @ResponseWrapper(localName = "deletePeticioDeFirmaResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.DeletePeticioDeFirmaResponse")
    public void deletePeticioDeFirma(
        @WebParam(name = "peticioDeFirmaID", targetNamespace = "")
        long peticioDeFirmaID
    ) throws WsI18NException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createAndStartPeticioDeFirma", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.CreateAndStartPeticioDeFirma")
    @WebMethod
    @ResponseWrapper(localName = "createAndStartPeticioDeFirmaResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.CreateAndStartPeticioDeFirmaResponse")
    public es.caib.portafib.ws.api.v1.PeticioDeFirmaWs createAndStartPeticioDeFirma(
        @WebParam(name = "peticioDeFirmaWs", targetNamespace = "")
        es.caib.portafib.ws.api.v1.PeticioDeFirmaWs peticioDeFirmaWs
    ) throws WsI18NException, WsValidationException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getPeticioDeFirma", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.GetPeticioDeFirma")
    @WebMethod
    @ResponseWrapper(localName = "getPeticioDeFirmaResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.GetPeticioDeFirmaResponse")
    public es.caib.portafib.ws.api.v1.PeticioDeFirmaWs getPeticioDeFirma(
        @WebParam(name = "peticioDeFirmaID", targetNamespace = "")
        long peticioDeFirmaID
    ) throws WsI18NException;

    @RequestWrapper(localName = "deletePlantillaFluxDeFirmes", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.DeletePlantillaFluxDeFirmes")
    @WebMethod
    @ResponseWrapper(localName = "deletePlantillaFluxDeFirmesResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.DeletePlantillaFluxDeFirmesResponse")
    public void deletePlantillaFluxDeFirmes(
        @WebParam(name = "plantillaDeFluxDeFirmesID", targetNamespace = "")
        long plantillaDeFluxDeFirmesID
    ) throws WsI18NException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getVersionWs", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.GetVersionWs")
    @WebMethod
    @ResponseWrapper(localName = "getVersionWsResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.GetVersionWsResponse")
    public int getVersionWs();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createPlantillaFluxDeFirmes", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.CreatePlantillaFluxDeFirmes")
    @WebMethod
    @ResponseWrapper(localName = "createPlantillaFluxDeFirmesResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.CreatePlantillaFluxDeFirmesResponse")
    public java.lang.Long createPlantillaFluxDeFirmes(
        @WebParam(name = "fluxDeFirmesWs", targetNamespace = "")
        es.caib.portafib.ws.api.v1.FluxDeFirmesWs fluxDeFirmesWs,
        @WebParam(name = "compartir", targetNamespace = "")
        boolean compartir
    ) throws WsI18NException, WsValidationException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "instantiatePlantillaFluxDeFirmes", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.InstantiatePlantillaFluxDeFirmes")
    @WebMethod
    @ResponseWrapper(localName = "instantiatePlantillaFluxDeFirmesResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.InstantiatePlantillaFluxDeFirmesResponse")
    public es.caib.portafib.ws.api.v1.FluxDeFirmesWs instantiatePlantillaFluxDeFirmes(
        @WebParam(name = "plantillaDeFluxDeFirmesID", targetNamespace = "")
        long plantillaDeFluxDeFirmesID
    ) throws WsI18NException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getSupportedLanguages", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.GetSupportedLanguages")
    @WebMethod
    @ResponseWrapper(localName = "getSupportedLanguagesResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.GetSupportedLanguagesResponse")
    public java.util.List<java.lang.String> getSupportedLanguages() throws WsI18NException;

    @RequestWrapper(localName = "pausePeticioDeFirma", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.PausePeticioDeFirma")
    @WebMethod
    @ResponseWrapper(localName = "pausePeticioDeFirmaResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.PausePeticioDeFirmaResponse")
    public void pausePeticioDeFirma(
        @WebParam(name = "peticioDeFirmaID", targetNamespace = "")
        long peticioDeFirmaID
    ) throws WsI18NException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "downloadFileUsingEncryptedFileID", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.DownloadFileUsingEncryptedFileID")
    @WebMethod
    @ResponseWrapper(localName = "downloadFileUsingEncryptedFileIDResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.DownloadFileUsingEncryptedFileIDResponse")
    public es.caib.portafib.ws.api.v1.FitxerBean downloadFileUsingEncryptedFileID(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    ) throws WsI18NException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getDefaultCustodiaInfo", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.GetDefaultCustodiaInfo")
    @WebMethod
    @ResponseWrapper(localName = "getDefaultCustodiaInfoResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.GetDefaultCustodiaInfoResponse")
    public es.caib.portafib.ws.api.v1.CustodiaInfoBean getDefaultCustodiaInfo(
        @WebParam(name = "title", targetNamespace = "")
        java.lang.String title,
        @WebParam(name = "language", targetNamespace = "")
        java.lang.String language
    ) throws WsI18NException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "resetPeticioDeFirma", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.ResetPeticioDeFirma")
    @WebMethod
    @ResponseWrapper(localName = "resetPeticioDeFirmaResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.ResetPeticioDeFirmaResponse")
    public es.caib.portafib.ws.api.v1.PeticioDeFirmaWs resetPeticioDeFirma(
        @WebParam(name = "peticioDeFirmaID", targetNamespace = "")
        long peticioDeFirmaID
    ) throws WsI18NException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getVersion", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.GetVersion")
    @WebMethod
    @ResponseWrapper(localName = "getVersionResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.GetVersionResponse")
    public java.lang.String getVersion();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getTipusDeDocuments", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.GetTipusDeDocuments")
    @WebMethod
    @ResponseWrapper(localName = "getTipusDeDocumentsResponse", targetNamespace = "http://impl.v1.ws.portafib.caib.es/", className = "es.caib.portafib.ws.api.v1.GetTipusDeDocumentsResponse")
    public java.util.List<es.caib.portafib.ws.api.v1.TipusDocumentInfoWs> getTipusDeDocuments(
        @WebParam(name = "idioma", targetNamespace = "")
        java.lang.String idioma
    ) throws WsI18NException;
}
