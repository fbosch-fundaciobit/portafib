package org.fundaciobit.apisib.apifirmasimple.v1.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author anadal(u80067)
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FirmaSimpleUpgradeRequest {

  String profileCode;

  FirmaSimpleFile signature;

  /** Certificat del que penjar l'upgrade a l'hora de fer cofirmes i contrafirmes */
  FirmaSimpleFile targetCertificate;

  String languageUI;

  public FirmaSimpleUpgradeRequest() {
    super();
  }

  public FirmaSimpleUpgradeRequest(String profileCode, FirmaSimpleFile signature,
      FirmaSimpleFile targetCertificate, String languageUI) {
    super();
    this.profileCode = profileCode;
    this.signature = signature;
    this.targetCertificate = targetCertificate;
    this.languageUI = languageUI;
  }

  public String getProfileCode() {
    return profileCode;
  }

  public void setProfileCode(String profileCode) {
    this.profileCode = profileCode;
  }

  public String getLanguageUI() {
    return languageUI;
  }

  public void setLanguageUI(String languageUI) {
    this.languageUI = languageUI;
  }

  public FirmaSimpleFile getSignature() {
    return signature;
  }

  public void setSignature(FirmaSimpleFile signature) {
    this.signature = signature;
  }

  public FirmaSimpleFile getTargetCertificate() {
    return targetCertificate;
  }

  public void setTargetCertificate(FirmaSimpleFile targetCertificate) {
    this.targetCertificate = targetCertificate;
  }

}
