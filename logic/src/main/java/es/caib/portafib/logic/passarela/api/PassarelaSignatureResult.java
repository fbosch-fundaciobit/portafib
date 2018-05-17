package es.caib.portafib.logic.passarela.api;

import es.caib.portafib.model.bean.FitxerBean;

/**
 * Resultat d'una firma
 * 
 * @author anadal
 *
 */
public class PassarelaSignatureResult extends PassarelaSignatureStatus {

  protected FitxerBean signedFile;

  protected String signID;
  
  protected java.lang.String custodyFileID = null;

  protected java.lang.String custodyFileURL = null;

  public FitxerBean getSignedFile() {
    return signedFile;
  }

  public void setSignedFile(FitxerBean signedFile) {
    this.signedFile = signedFile;
  }

  public String getSignID() {
    return signID;
  }

  public void setSignID(String signID) {
    this.signID = signID;
  }

  public java.lang.String getCustodyFileID() {
    return custodyFileID;
  }

  public void setCustodyFileID(java.lang.String custodyFileID) {
    this.custodyFileID = custodyFileID;
  }

  public java.lang.String getCustodyFileURL() {
    return custodyFileURL;
  }

  public void setCustodyFileURL(java.lang.String custodyFileURL) {
    this.custodyFileURL = custodyFileURL;
  }

}
