<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="pageTitle" value="Service requests"/>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<h1>Academic service requests</h1>
<c:if test="${sessionScope.user.role == 'STUDENT'}">
<section class="card">
  <h2>New request</h2>
  <form method="post" action="${pageContext.request.contextPath}/requests" novalidate>
    <input type="hidden" name="csrfToken" value="<c:out value='${sessionScope.csrfToken}'/>">
    <label for="category">Category</label>
    <select id="category" name="category">
      <option value="TRANSCRIPT" ${param.category == 'TRANSCRIPT' ? 'selected' : ''}>Transcript</option>
      <option value="CLEARANCE" ${param.category == 'CLEARANCE' ? 'selected' : ''}>Clearance</option>
      <option value="APPEAL" ${param.category == 'APPEAL' ? 'selected' : ''}>Appeal enquiry</option>
    </select>
    <span class="field-err"><c:out value="${errors.category}"/></span>
    <label for="priority">Priority</label>
    <select id="priority" name="priority">
      <option value="NORMAL">Normal</option><option value="HIGH">High</option>
      <option value="URGENT">Urgent</option><option value="LOW">Low</option>
    </select>
    <span class="field-err"><c:out value="${errors.priority}"/></span>
    <label for="description">Description</label>
    <textarea id="description" name="description" rows="4" maxlength="500"><c:out value="${param.description}"/></textarea>
    <span class="field-err"><c:out value="${errors.description}"/></span>
    <button type="submit">Submit request</button>
  </form>
</section>
</c:if>
<h2><c:out value="${sessionScope.user.role == 'STAFF' ? 'All requests (by priority)' : 'My requests'}"/></h2>
<c:choose>
  <c:when test="${empty requests}"><p class="empty">No requests to show.</p></c:when>
  <c:otherwise>
  <div class="scroll"><table>
    <caption class="sr">Service requests</caption>
    <thead><tr><th scope="col">ID</th><th scope="col">Category</th><th scope="col">Priority</th>
      <th scope="col">Status</th><th scope="col">Assigned to</th></tr></thead>
    <tbody>
    <c:forEach var="q" items="${requests}">
      <tr>
        <td><c:out value="${q.requestId}"/></td>
        <td><c:out value="${q.category}"/></td>
        <td><c:out value="${q.priority}"/></td>
        <td><span class="badge ${q.status}"><c:out value="${q.status}"/></span></td>
        <td><c:out value="${empty q.assignedTo ? 'Unassigned' : q.assignedTo}"/></td>
      </tr>
    </c:forEach>
    </tbody>
  </table></div>
  </c:otherwise>
</c:choose>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
