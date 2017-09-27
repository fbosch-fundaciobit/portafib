<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
          <c:if test="${__theFilterForm.editButtonVisible || __theFilterForm.deleteButtonVisible || not empty __theFilterForm.additionalButtonsForEachItem || not empty __theFilterForm.additionalButtonsByPK}">
          <td>
          <c:set var="pk" value="${posicioPagina.posicioPaginaID}"/>
          <c:choose>
           <c:when test="${__theFilterForm.actionsRenderer == 1}">
            <div class="btn-group" data-toggle="buttons-checkbox">
            <c:if test="${__theFilterForm.editButtonVisible}">
            <a class="btn " href="<c:url value="${contexte}/${posicioPagina.posicioPaginaID}/edit"/>" onclick="" title="<fmt:message key="genapp.edit"/>">
               <i class="icon-pencil"></i>
            </a>
            </c:if>
            <c:if test="${__theFilterForm.deleteButtonVisible}">
            <a class="btn btn-danger" href="#myModal" onclick="openModal('<c:url value="${contexte}/${posicioPagina.posicioPaginaID}/delete"/>','show');" title="<fmt:message key="genapp.delete"/>">
               <i class="icon-trash icon-white"></i>
            </a>
            </c:if>
            <c:set var="bracket" value="{0}"/>
            <c:forEach var="button" items="${__theFilterForm.additionalButtonsForEachItem}">
                  <c:set var="thehref" value="#"/>
                  <c:set var="thelink" value="${fn:replace(button.link,bracket, pk)}" />
                  <c:if test="${!fn:startsWith(thelink,'javascript:')}">
                  <c:url var="thehref" value="${thelink}"/>
                  <c:url var="thelink" value=""/>
                  </c:if>
                  <a class="btn ${button.type}" href="${thehref}" onclick="${thelink}" title="<fmt:message key="${button.codeText}"/>">
                     <c:if test="${fn:startsWith(button.icon, '/')}">
                     <img src="<c:url value="${button.icon}"/>"/>
                     </c:if>                     <c:if test="${!fn:startsWith(button.icon, '/')}">
                     <i class="${button.icon}"></i>
                     </c:if>
                  </a>
            </c:forEach>

            <c:if test="${not empty __theFilterForm.additionalButtonsByPK}">
              <c:if test="${not empty __theFilterForm.additionalButtonsByPK[pk]}">
                  <c:forEach var="button" items="${__theFilterForm.additionalButtonsByPK[pk]}">
                  <c:set var="thehref" value="#"/>
                  <c:set var="thelink" value="${fn:replace(button.link,bracket, pk)}" />
                  <c:if test="${!fn:startsWith(thelink,'javascript:')}">
                  <c:url var="thehref" value="${thelink}"/>
                  <c:url var="thelink" value=""/>
                  </c:if>
                  <a class="btn ${button.type}" href="${thehref}" onclick="${thelink}" title="<fmt:message key="${button.codeText}"/>">
                     <c:if test="${fn:startsWith(button.icon, '/')}">
                     <img src="<c:url value="${button.icon}"/>"/>
                     </c:if>                     <c:if test="${!fn:startsWith(button.icon, '/')}">
                     <i class="${button.icon}"></i>
                     </c:if>
                  </a>
                  </c:forEach>

               </c:if>

            </c:if>

            </div>
            </c:when>
           <c:when test="${__theFilterForm.actionsRenderer == 2}">
                <div class="btn-group">
      <a class="btn btn-small ${__theFilterForm.additionalInfoForActionsRendererByPK[pk]}" href="#" style="${(empty __theFilterForm.additionalInfoForActionsRendererByPK[pk])? '' : 'color: white;'}"><i class="icon-list ${(empty __theFilterForm.additionalInfoForActionsRendererByPK[pk])? '' : 'icon-white'}"></i> <fmt:message key="genapp.actions" /></a>
      <a class="btn btn-small ${__theFilterForm.additionalInfoForActionsRendererByPK[pk]} dropdown-toggle" data-toggle="dropdown" href="#">&nbsp;<span class="caret"> </span></a>
      <ul class="dropdown-menu pull-right" style="min-width:35px;padding:5px 5px 0px 5px;margin:0px;font-size: 12px" >
            <c:if test="${__theFilterForm.editButtonVisible}">
            <li>
            <a class="btn  btn-small a_item" style="margin-bottom:5px;" href="<c:url value="${contexte}/${posicioPagina.posicioPaginaID}/edit"/>" onclick="">
            <i class="icon-pencil"></i>
             <fmt:message key="genapp.edit"/>
            </a>
            </li>
            </c:if>
            <c:if test="${__theFilterForm.deleteButtonVisible}">
            <li>
            <a class="btn btn-danger btn-small a_item" style="margin-bottom:5px;color: white;" href="#myModal" onclick="openModal('<c:url value="${contexte}/${posicioPagina.posicioPaginaID}/delete"/>','show');">
            <i class="icon-trash icon-white"></i>
             <fmt:message key="genapp.delete"/>
            </a>
            </li>
            </c:if>
            <c:set var="bracket" value="{0}"/>
            <c:forEach var="button" items="${__theFilterForm.additionalButtonsForEachItem}">
                  <c:set var="thehref" value="#"/>
                  <c:set var="thelink" value="${fn:replace(button.link,bracket, pk)}" />
                  <c:if test="${!fn:startsWith(thelink,'javascript:')}">
                  <c:url var="thehref" value="${thelink}"/>
                  <c:url var="thelink" value=""/>
                  </c:if>
                  <li>
                  <a class="btn ${button.type} btn-small a_item" style="margin-bottom:5px;${(empty button.type)? '' : 'color: white;'};" href="${thehref}" onclick="${thelink}">
                  <c:if test="${fn:startsWith(button.icon, '/')}">
                  <img src="<c:url value="${button.icon}"/>"/>
                  </c:if>                  <c:if test="${!fn:startsWith(button.icon, '/')}">
                  <i class="${button.icon}"></i>
                  </c:if>
                   <fmt:message key="${button.codeText}"/>
                  </a>
                  </li>
            </c:forEach>

            <c:if test="${not empty __theFilterForm.additionalButtonsByPK}">
              <c:if test="${not empty __theFilterForm.additionalButtonsByPK[pk]}">
                  <c:forEach var="button" items="${__theFilterForm.additionalButtonsByPK[pk]}">
                  <c:set var="thehref" value="#"/>
                  <c:set var="thelink" value="${fn:replace(button.link,bracket, pk)}" />
                  <c:if test="${!fn:startsWith(thelink,'javascript:')}">
                  <c:url var="thehref" value="${thelink}"/>
                  <c:url var="thelink" value=""/>
                  </c:if>
                  <li>
                  <a class="btn ${button.type} btn-small a_item" style="margin-bottom:5px;${(empty button.type)? '' : 'color: white;'};" href="${thehref}" onclick="${thelink}">
                  <c:if test="${fn:startsWith(button.icon, '/')}">
                  <img src="<c:url value="${button.icon}"/>"/>
                  </c:if>                  <c:if test="${!fn:startsWith(button.icon, '/')}">
                  <i class="${button.icon}"></i>
                  </c:if>
                   <fmt:message key="${button.codeText}"/>
                  </a>
                  </li>
                  </c:forEach>

               </c:if>

            </c:if>

                 </ul>
    </div>
            </c:when>
            <c:otherwise>
              &nbsp;<!-- Sense Render d'accions -->
            </c:otherwise>
          </c:choose>
           </td>
           </c:if>
