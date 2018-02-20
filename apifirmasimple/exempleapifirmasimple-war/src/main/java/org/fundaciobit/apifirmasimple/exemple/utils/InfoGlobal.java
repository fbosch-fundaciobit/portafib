package org.fundaciobit.apifirmasimple.exemple.utils;

import org.fundaciobit.apifirmawebsimple.beans.FirmaSimpleFileInfoSignature;
import org.fundaciobit.apifirmawebsimple.beans.FirmaSimpleSignatureResult;

/**
 * 
 * @author anadal
 *
 */
public class InfoGlobal {

  final FirmaSimpleFileInfoSignature peticio;

  FirmaSimpleSignatureResult resultat;

  /**
   * @param peticio
   */
  public InfoGlobal(FirmaSimpleFileInfoSignature peticio) {
    super();
    this.peticio = peticio;
  }

  public FirmaSimpleSignatureResult getResultat() {
    return resultat;
  }

  public void setResultat(FirmaSimpleSignatureResult resultat) {
    this.resultat = resultat;
  }

  public FirmaSimpleFileInfoSignature getPeticio() {
    return peticio;
  }

}