      <%--  CHECK DE SELECCIO MULTIPLE  --%>
      <c:if test="${__theFilterForm.visibleMultipleSelection}">
      <td>
       <form:checkbox path="selectedItems" value="${notificacioWS.notificacioID}"/>
       &nbsp;
      </td>
      </c:if>
