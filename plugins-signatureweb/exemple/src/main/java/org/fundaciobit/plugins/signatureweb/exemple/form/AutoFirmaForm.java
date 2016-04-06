package org.fundaciobit.plugins.signatureweb.exemple.form;

import java.util.Map;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 
 * @author anadal
 * 
 */
public class AutoFirmaForm {

  protected java.lang.String motiu;

  protected String idioma;

  protected int posicioTaulaFirmesID;

  protected Map<Integer, String> listOfPosicioTaulaFirmes;

  protected String username;

  protected String nif;
  
  protected String email;
  
  protected String location;

  protected transient String mimeType = null;

  CommonsMultipartFile fitxerAFirmarID;

  boolean jnlp;

  long id;

  boolean segellDeTemps;
  
  // --------------- CSV .....................
  
  boolean cvsActivat = false;
  
  String cvsPagines;
  
  String cvsMissatge;
  
  int cvsPosicio;
  
  String cvsTipusCodiBarres;
  
  String cvsCodiBarresText;
  

  public AutoFirmaForm() {
  }

  public CommonsMultipartFile getFitxerAFirmarID() {
    return fitxerAFirmarID;
  }

  public void setFitxerAFirmarID(CommonsMultipartFile fitxerAFirmarID) {
    this.fitxerAFirmarID = fitxerAFirmarID;
  }

  public boolean isJnlp() {
    return jnlp;
  }

  public void setJnlp(boolean jnlp) {
    this.jnlp = jnlp;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Map<Integer, String> getListOfPosicioTaulaFirmes() {
    return this.listOfPosicioTaulaFirmes;
  }

  public void setListOfPosicioTaulaFirmes(Map<Integer, String> listOfPosicioTaulaFirmes) {
    this.listOfPosicioTaulaFirmes = listOfPosicioTaulaFirmes;
  }

  public java.lang.String getMotiu() {
    return motiu;
  }

  public void setMotiu(java.lang.String motiu) {
    this.motiu = motiu;
  }

  public int getPosicioTaulaFirmesID() {
    return posicioTaulaFirmesID;
  }

  public void setPosicioTaulaFirmesID(int posicioTaulaFirmesID) {
    this.posicioTaulaFirmesID = posicioTaulaFirmesID;
  }

  public String getIdioma() {
    return idioma;
  }

  public void setIdioma(String idioma) {
    this.idioma = idioma;
  }

  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getNif() {
    return nif;
  }

  public void setNif(String nif) {
    this.nif = nif;
  }
  
  

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public boolean isSegellDeTemps() {
    return segellDeTemps;
  }

  public void setSegellDeTemps(boolean segellDeTemps) {
    this.segellDeTemps = segellDeTemps;
  }

  public boolean isCvsActivat() {
    return cvsActivat;
  }

  public void setCvsActivat(boolean cvsActivat) {
    this.cvsActivat = cvsActivat;
  }

  public String getCvsPagines() {
    return cvsPagines;
  }

  public void setCvsPagines(String cvsPagines) {
    this.cvsPagines = cvsPagines;
  }

  public String getCvsMissatge() {
    return cvsMissatge;
  }

  public void setCvsMissatge(String cvsMissatge) {
    this.cvsMissatge = cvsMissatge;
  }

  public int getCvsPosicio() {
    return cvsPosicio;
  }

  public void setCvsPosicio(int cvsPosicio) {
    this.cvsPosicio = cvsPosicio;
  }

  public String getCvsTipusCodiBarres() {
    return cvsTipusCodiBarres;
  }

  public void setCvsTipusCodiBarres(String cvsTipusCodiBarres) {
    this.cvsTipusCodiBarres = cvsTipusCodiBarres;
  }

  public String getCvsCodiBarresText() {
    return cvsCodiBarresText;
  }

  public void setCvsCodiBarresText(String cvsCodiBarresText) {
    this.cvsCodiBarresText = cvsCodiBarresText;
  }

}