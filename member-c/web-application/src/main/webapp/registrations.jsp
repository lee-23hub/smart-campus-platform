<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="pageTitle" value="My registrations"/>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<h1>My registrations</h1>
<c:choose>
  <c:when test="${empty registrations}"><p class="empty">You have no registrations yet. Visit the <a href="${pageContext.request.contextPath}/courses">course catalogue</a>.</p></c:when>
  <c:otherwise>
  <div class="scroll"><table>
    <caption class="sr">Registrations and waiting-list positions</caption>
    <thead><tr><th scope="col">Course</th><th scope="col">Status</th><th scope="col">Waiting position</th><th scope="col">Since</th><th scope="col">Action</th></tr></thead>
    <tbody>
    <c:forEach var="r" items="${registrations}">
      <tr>
        <td><c:out value="${r.courseCode}"/></td>
        <td><span class="badge ${r.status}"><c:out value="${r.status}"/></span></td>
        <td><c:out value="${r.status == 'WAITLISTED' ? r.position : '-'}"/></td>
        <td><c:out value="${r.createdAt}"/></td>
        <td>
          <form method="post" action="${pageContext.request.contextPath}/registrations/withdraw">
            <input type="hidden" name="csrfToken" value="<c:out value='${sessionScope.csrfToken}'/>">
            <input type="hidden" name="courseCode" value="<c:out value='${r.courseCode}'/>">
            <button type="submit">Withdraw</button>
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table></div>
  </c:otherwise>
</c:choose>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
