
package es.caib.portafib.back.form.webdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.portafib.back.form.PortaFIBBaseFilterForm;

import es.caib.portafib.model.fields.TipusNotificacioFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class TipusNotificacioFilterForm extends PortaFIBBaseFilterForm implements TipusNotificacioFields {

  private java.lang.Long tipusNotificacioIDDesde;

  public java.lang.Long getTipusNotificacioIDDesde() {
    return this.tipusNotificacioIDDesde;
  }

  public void setTipusNotificacioIDDesde(java.lang.Long tipusNotificacioIDDesde) {
    this.tipusNotificacioIDDesde = tipusNotificacioIDDesde;
  }


  private java.lang.Long tipusNotificacioIDFins;

  public java.lang.Long getTipusNotificacioIDFins() {
    return this.tipusNotificacioIDFins;
  }

  public void setTipusNotificacioIDFins(java.lang.Long tipusNotificacioIDFins) {
    this.tipusNotificacioIDFins = tipusNotificacioIDFins;
  }


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
  }


  private java.lang.String descripcio;

  public java.lang.String getDescripcio() {
    return this.descripcio;
  }

  public void setDescripcio(java.lang.String descripcio) {
    this.descripcio = descripcio;
  }


  public TipusNotificacioFilterForm() {
  }
  
  public TipusNotificacioFilterForm(TipusNotificacioFilterForm __toClone) {
    super(__toClone);
    this.tipusNotificacioIDDesde = __toClone.tipusNotificacioIDDesde;
    this.tipusNotificacioIDFins = __toClone.tipusNotificacioIDFins;
    this.nom = __toClone.nom;
    this.descripcio = __toClone.descripcio;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] {  }));
  }

  @Override
  public List<Field<?>> getDefaultGroupByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { ESAVIS }));
  }


  protected OrderBy[] defaultOrderBy = null;


  public OrderBy[] getDefaultOrderBy() {
    return this.defaultOrderBy;
  }

  public void setDefaultOrderBy(OrderBy[] defOrderBy) {
    this.defaultOrderBy = defOrderBy;
  }

  @Override
  public String getTableModelName() {
    return _TABLE_MODEL;
  }

   // -----------------------
   // Maps de referencies.
   // -----------------------

   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}