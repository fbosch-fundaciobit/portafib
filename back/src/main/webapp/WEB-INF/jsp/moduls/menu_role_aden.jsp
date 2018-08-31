<%@page import="es.caib.portafib.utils.Configuracio"%>
<%@page import="es.caib.portafib.back.security.LoginInfo"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
%><%@ include  file="/WEB-INF/jsp/moduls/includes.jsp"%>
<sec:authorize access="hasRole('ROLE_ADEN')">
<div>
  <h5><fmt:message key="ROLE_ADEN.menu" /></h5>
<%!

final String[] menu1 = {
    "entitat.modificar", // Modificació de les dades d'una Entitat
    "propietatglobal.entitat.gestio",
    "tipusdocument.gestio", // Gestió Tipus de Documents
    "",
    "usuaripersona.alta",    
    "usuaripersona.modificar",
    "usuarientitat.gestio",
    "",
    "carrec.gestio",
    "colaboradordecarrec.plural",
    "solicitant.gestio",
    "grups.gestio",
    "",
    "moduldefirmaenservidor.gestio",
    "",
    "moduldefirma.gestio",
    "modulDeFirmaPerTipusDeDocument.short", // /aden/modulfirmatipusdoc
    "",
    "segelldetemps.gestio",
    "plantillacustodia.gestio", // "/aden/plantillacustodia"
    "",
    "validaciodefirmes.gestio", // /aden/validaciofirmes
    "",
    "peticionscaducades.llistat", // Llistar peticions de firma caducades
    "aturarpeticionsdefirma",
    "peticiodefirma.netejaesborrat"
};

final String[] menu2 = {
    "usuariaplicacio.gestio", // Alta d'Usuari-Aplicació"}    
    "plantillaFluxDeFirmes.plantillaFluxDeFirmes.plural",
    "peticiodefirma.llistar", // Llistar Peticions de Firma de usauris Aplicacio
    "custodiaInfo.custodiaInfo.plural",
    "notificaciows.llistat"
};


public static final Map<String, String> mapping;


static {
  //Mapping to existent path
  mapping = new HashMap<String, String>();
  
  mapping.put("entitat.modificar", "/aden/entitat/" + LoginInfo.getInstance().getEntitatID() + "/edit" );

  mapping.put("usuaripersona.alta", "/aden/usuariPersona/alta");
  mapping.put("usuaripersona.modificar", "/aden/usuariPersona/modificar");

  mapping.put("usuarientitat.gestio", "/aden/usuariEntitat/selecciousuari");

  mapping.put("carrec.gestio", "/aden/carrec/list");
  mapping.put("colaboradordecarrec.plural", "/aden/colaboradordecarrec/list");
  
  mapping.put("tipusdocument.gestio", "/aden/gestiotipusdoc/list");

  mapping.put("moduldefirmaenservidor.gestio", "/aden/moduldefirmaenservidor/list");
  
  mapping.put("moduldefirma.gestio", "/aden/modulDeFirma/list");
  mapping.put("segelldetemps.gestio", "/aden/segelldetemps/list");
  mapping.put("plantillacustodia.gestio", "/aden/plantillacustodia/list");
  
  mapping.put("modulDeFirmaPerTipusDeDocument.short", "/aden/modulfirmatipusdoc/list");
  
  mapping.put("validaciodefirmes.gestio", "/aden/validaciofirmes/list");

  mapping.put("grups.gestio", "/aden/grup/list");
  
  mapping.put("solicitant.gestio", "/aden/solicitant/selecciousuari");
  
  
  mapping.put("peticionscaducades.llistat", "/aden/peticionscaducades/list");
  mapping.put("aturarpeticionsdefirma", "/aden/aturarpeticions/selecciousuari");
  
  
  mapping.put("usuariaplicacio.gestio", "/aden/usuariAplicacio/list");

  mapping.put("plantillaFluxDeFirmes.plantillaFluxDeFirmes.plural", "/aden/plantilla/list/1");

  mapping.put("notificaciows.llistat", "/aden/notificaciows/list");

  mapping.put("peticiodefirma.llistar", "/aden/peticiofirmaaplicacio/list");
  
  mapping.put("custodiaInfo.custodiaInfo.plural", "/aden/peticio/custodiainfo/list");
  
  mapping.put("propietatglobal.entitat.gestio", "/aden/propietatglobal/list");
  
  mapping.put("peticiodefirma.netejaesborrat", "/aden/peticio/netejaesborrat/list");
  
}

%><%
if (Configuracio.isCAIB()) {
%>
   <li style="list-style-type: disc; list-style-position: inside;">
    <a href="<c:url value="/aden/generarfiltrecaib/new"/>">
      <span style="${(fn:contains(urlActual, '/aden/generarfiltrecaib/new'))? 'font-weight: bold;' : ''} ">Filtre CAIB</span>
    </a>
   </li>
   <hr  style="margin-top: 6px;  margin-bottom: 6px;" />   
<%
}

session.setAttribute("mapping", mapping);


final String[][] menus  = { menu1 , menu2 };


int count = 0;

for(String[] menu : menus) {

  session.setAttribute("menu", menu);

%>
  
  <ul class="tree" style="margin: 3px; padding: 0px;">
    <c:forEach var="item" items="${menu}" >

    <c:if test="${empty item }">
    <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
    </c:if>
    <c:if test="${not empty item }">
      <fmt:message var="traduccio" key="${item}" />
      
      <c:if test="${empty mapping[item]}">
        <c:set var="theurl" value="/aden/${item}"/>
      </c:if>
      <c:if test="${not (empty mapping[item])}">
        <c:set var="theurl" value="${mapping[item]}"/>
      </c:if>
      
      <li style="list-style-type: disc; list-style-position: inside;">
        <a href="<c:url value="${theurl}"/>">
          <span style="${(fn:contains(urlActual, theurl))? "font-weight: bold;" : ""} ${(fn:endsWith(traduccio, '(*)'))? "color: red;" : ""}">${traduccio}</span>
        </a>
      </li>
    </c:if>
    </c:forEach>

  </ul>
  
  <%
  if (count == 0) { %>
      </div>
      </div>
      <br/>
      <div class="thumbnail">
      <div>
      <h5><fmt:message key="ROLE_ADEN.menu2" /></h5>
  <%    
  }
  count++;
  
}  // final FOR 
  %>
  
</div>
</sec:authorize>
