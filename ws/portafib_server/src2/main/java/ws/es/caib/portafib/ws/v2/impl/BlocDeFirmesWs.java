package es.caib.portafib.ws.v2.impl;

import java.util.HashSet;
import java.util.Set;

import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.portafib.jpa.BlocDeFirmesJPA;
import es.caib.portafib.jpa.FirmaJPA;
import es.caib.portafib.logic.FitxerLogicaLocal;
import es.caib.portafib.model.bean.FirmaBean;
import es.caib.portafib.model.bean.BlocDeFirmesBean;
import es.caib.portafib.model.entity.BlocDeFirmes;
import es.caib.portafib.ws.v2.impl.utils.JPAConversion;

/**
 * 
 * @author anadal
 * 
 */
public class BlocDeFirmesWs extends BlocDeFirmesBean {

  /**
   * 
   */
  public BlocDeFirmesWs() {
    super();
  }

  /**
   * @param __bean
   */
  public BlocDeFirmesWs(BlocDeFirmes __bean) {
    super(__bean);
  }


  private Set<FirmaBean> firmes = new HashSet<FirmaBean>(0);

  public Set<FirmaBean> getFirmes() {
    return this.firmes;
  }

  public void setFirmes(Set<FirmaBean> firmes) {
    this.firmes = firmes;
  }
  
  
  public static BlocDeFirmesJPA toJPA(BlocDeFirmesWs blocDeFirmesWs, 
      FitxerLogicaLocal fitxerEjb, Set<Long> fitxersCreats) throws I18NException {
    if (blocDeFirmesWs == null) {
      return null;
    }
    // Bean
    BlocDeFirmesJPA jpa = BlocDeFirmesJPA.toJPA(blocDeFirmesWs);
    // Firmes
    if (blocDeFirmesWs.getFirmes() != null) {
      Set<FirmaJPA> firmesJPA = new HashSet<FirmaJPA>();
      for (FirmaBean firmaBean : blocDeFirmesWs.getFirmes()) {

        firmesJPA.add(JPAConversion.toFirmaJPA(firmaBean, fitxerEjb,  fitxersCreats));
      }
      jpa.setFirmas(firmesJPA);
    }

    return jpa;
  }
  
  
  public static BlocDeFirmesWs toWs(BlocDeFirmesJPA jpa) {
    if (jpa == null) {
      return null;
    }
    // Bean
    BlocDeFirmesWs blocDeFirmesWs = new BlocDeFirmesWs(jpa);
    
    // Firmes
    if (jpa.getFirmas() != null) {
      Set<FirmaBean> firmesBean = new HashSet<FirmaBean>();
      for (FirmaJPA firmaJPA : jpa.getFirmas()) {
        firmesBean.add(new FirmaBean(firmaJPA));
      }
      blocDeFirmesWs.setFirmes(firmesBean);
    }

    return blocDeFirmesWs;
  }
  

}