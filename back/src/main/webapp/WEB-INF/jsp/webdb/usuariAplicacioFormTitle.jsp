<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
  <c:if test="${empty usuariAplicacioForm.entityNameCode}">
    <fmt:message var="entityname" key="usuariAplicacio.usuariAplicacio"/>
  </c:if>
  <c:if test="${not empty usuariAplicacioForm.entityNameCode}">
    <fmt:message var="entityname" key="${usuariAplicacioForm.entityNameCode}"/>
  </c:if>
  <c:if test="${not empty usuariAplicacioForm.titleCode}">
    <fmt:message key="${usuariAplicacioForm.titleCode}" >
      <fmt:param value="${usuariAplicacioForm.titleParam}" />
    </fmt:message>
  </c:if>
  <c:if test="${empty usuariAplicacioForm.titleCode}">
    <c:set var="keytitle" value="${usuariAplicacioForm.nou?'genapp.createtitle':(usuariAplicacioForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
  </c:if>
  
  <c:if test="${not empty usuariAplicacioForm.subTitleCode}">
  <br/><h5 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;">
<c:set var="subtitleTranslated" value="${fn:startsWith(usuariAplicacioForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(usuariAplicacioForm.subTitleCode, '=')}"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${usuariAplicacioForm.subTitleCode}" />
</c:if>
</h5>
  </c:if>
</div>