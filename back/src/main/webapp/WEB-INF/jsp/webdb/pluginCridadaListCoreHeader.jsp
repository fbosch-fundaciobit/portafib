<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="PluginCridadaFields" className="es.caib.portafib.model.fields.PluginCridadaFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${pfi:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PluginCridadaFields.PLUGINCRIDADAID)}">
        <th>${pfi:getSortIcons(__theFilterForm,PluginCridadaFields.PLUGINCRIDADAID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PluginCridadaFields.ENTITATID)}">
        <th>${pfi:getSortIcons(__theFilterForm,PluginCridadaFields.ENTITATID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PluginCridadaFields.DATA)}">
        <th>${pfi:getSortIcons(__theFilterForm,PluginCridadaFields.DATA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PluginCridadaFields.PLUGINID)}">
        <th>${pfi:getSortIcons(__theFilterForm,PluginCridadaFields.PLUGINID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PluginCridadaFields.METODEPLUGIN)}">
        <th>${pfi:getSortIcons(__theFilterForm,PluginCridadaFields.METODEPLUGIN)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PluginCridadaFields.PARAMETRESTEXT)}">
        <th>${pfi:getSortIcons(__theFilterForm,PluginCridadaFields.PARAMETRESTEXT)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PluginCridadaFields.PARAMETRESFITXERID)}">
        <th>${pfi:getSortIcons(__theFilterForm,PluginCridadaFields.PARAMETRESFITXERID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PluginCridadaFields.RETORNTEXT)}">
        <th>${pfi:getSortIcons(__theFilterForm,PluginCridadaFields.RETORNTEXT)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PluginCridadaFields.RETORNFITXERID)}">
        <th>${pfi:getSortIcons(__theFilterForm,PluginCridadaFields.RETORNFITXERID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PluginCridadaFields.TIPUSTESULTAT)}">
        <th>${pfi:getSortIcons(__theFilterForm,PluginCridadaFields.TIPUSTESULTAT)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,PluginCridadaFields.TEMPSEXECUCIO)}">
        <th>${pfi:getSortIcons(__theFilterForm,PluginCridadaFields.TEMPSEXECUCIO)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${pfi:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

