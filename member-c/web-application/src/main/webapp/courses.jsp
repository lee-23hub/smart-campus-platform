<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="pageTitle" value="Courses"/>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<h1>Course catalogue</h1>
<form method="get" action="${pageContext.request.contextPath}/courses" class="inline">
  <label for="q">Search</label>
  <input id="q" name="q" value="<c:out value='${param.q}'/>">
  <label for="sort">Sort by</label>
  <select id="sort" name="sort">
    <option value="code" ${param.sort == 'code' ? 'selected' : ''}>Code</option>
    <option value="title" ${param.sort == 'title' ? 'selected' : ''}>Title</option>
    <option value="seats" ${param.sort == 'seats' ? 'selected' : ''}>Seats left</option>
  </select>
  <button type="submit">Apply</button>
</form>
<c:choose>
  <c:when test="${empty courses}"><p class="empty">No courses match your search.</p></c:when>
  <c:otherwise>
  <div class="scroll"><table>
    <caption class="sr">Available courses</caption>
    <thead><tr><th scope="col">Code</th><th scope="col">Title</th><th scope="col">Enrolled</th>
      <th scope="col">Capacity</th><th scope="col">Status</th><th scope="col">Action</th></tr></thead>
    <tbody>
    <c:forEach var="c" items="${courses}">
      <tr>
        <td><c:out value="${c.courseCode}"/></td>
        <td><c:out value="${c.title}"/></td>
        <td><c:out value="${c.enrolled}"/></td>
        <td><c:out value="${c.capacity}"/></td>
        <td><span class="badge ${c.status}"><c:out value="${c.status}"/></span></td>
        <td>
          <c:if test="${sessionScope.user.role == 'STUDENT'}">
          <form method="post" action="${pageContext.request.contextPath}/registrations">
            <input type="hidden" name="csrfToken" value="<c:out value='${sessionScope.csrfToken}'/>">
            <input type="hidden" name="courseCode" value="<c:out value='${c.courseCode}'/>">
            <button type="submit"><c:out value="${c.enrolled >= c.capacity ? 'Join waiting list' : 'Register'}"/></button>
          </form>
          </c:if>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table></div>
  </c:otherwise>
</c:choose>

<c:if test="${sessionScope.user.role == 'STAFF'}">
<section class="card">
  <h2>Add or update a course</h2>
  <form method="post" action="${pageContext.request.contextPath}/courses" novalidate>
    <input type="hidden" name="csrfToken" value="<c:out value='${sessionScope.csrfToken}'/>">
    <label for="courseCode">Course code</label>
    <input id="courseCode" name="courseCode" value="<c:out value='${param.courseCode}'/>">
    <span class="field-err"><c:out value="${errors.courseCode}"/></span>
    <label for="title">Title</label>
    <input id="title" name="title" value="<c:out value='${param.title}'/>">
    <span class="field-err"><c:out value="${errors.title}"/></span>
    <label for="capacity">Capacity</label>
    <input id="capacity" name="capacity" inputmode="numeric" value="<c:out value='${param.capacity}'/>">
    <span class="field-err"><c:out value="${errors.capacity}"/></span>
    <button type="submit">Save course</button>
  </form>
</section>
</c:if>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
