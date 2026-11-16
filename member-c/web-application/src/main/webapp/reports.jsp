<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="pageTitle" value="Reports"/>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<h1>Staff reports</h1>
<h2>Course capacity</h2>
<c:choose>
  <c:when test="${empty capacityReport}"><p class="empty">No capacity data.</p></c:when>
  <c:otherwise>
  <div class="scroll"><table>
    <caption class="sr">Capacity by course</caption>
    <thead><tr><th scope="col">Course</th><th scope="col">Enrolled</th><th scope="col">Capacity</th><th scope="col">Waiting</th></tr></thead>
    <tbody><c:forEach var="row" items="${capacityReport}">
      <tr><td><c:out value="${row.courseCode}"/></td><td><c:out value="${row.enrolled}"/></td>
          <td><c:out value="${row.capacity}"/></td><td><c:out value="${row.waiting}"/></td></tr>
    </c:forEach></tbody>
  </table></div>
  </c:otherwise>
</c:choose>
<h2>Request workload</h2>
<c:choose>
  <c:when test="${empty workloadReport}"><p class="empty">No request data.</p></c:when>
  <c:otherwise>
  <div class="scroll"><table>
    <caption class="sr">Requests per staff member</caption>
    <thead><tr><th scope="col">Staff</th><th scope="col">Open</th><th scope="col">Closed</th></tr></thead>
    <tbody><c:forEach var="w" items="${workloadReport}">
      <tr><td><c:out value="${w.staff}"/></td><td><c:out value="${w.open}"/></td><td><c:out value="${w.closed}"/></td></tr>
    </c:forEach></tbody>
  </table></div>
  </c:otherwise>
</c:choose>
<h2>Recent audit events</h2>
<c:choose>
  <c:when test="${empty auditEvents}"><p class="empty">No audit events yet.</p></c:when>
  <c:otherwise>
  <div class="scroll"><table>
    <caption class="sr">Audit trail</caption>
    <thead><tr><th scope="col">When</th><th scope="col">Actor</th><th scope="col">Action</th><th scope="col">Entity</th></tr></thead>
    <tbody><c:forEach var="e" items="${auditEvents}">
      <tr><td><c:out value="${e.occurredAt}"/></td><td><c:out value="${e.actor}"/></td>
          <td><c:out value="${e.action}"/></td><td><c:out value="${e.entityType}"/> <c:out value="${e.entityId}"/></td></tr>
    </c:forEach></tbody>
  </table></div>
  </c:otherwise>
</c:choose>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
