<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${codiBarresFilterForm.contexte}"/>
  <c:set var="formName" value="codiBarres" />
  <c:set var="__theFilterForm" value="${codiBarresFilterForm}" />
  <c:if test="${empty codiBarresFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="codiBarres.codiBarres"/>
  </c:if>
  <c:if test="${not empty codiBarresFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${codiBarresFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty codiBarresFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="codiBarres.codiBarres"/>
  </c:if>
  <c:if test="${not empty codiBarresFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${codiBarresFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.codiBarres.submit();  
  }
</script>