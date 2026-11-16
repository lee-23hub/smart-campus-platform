<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="pageTitle" value="Dashboard"/>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<h1>Welcome, <c:out value="${sessionScope.user.name}"/></h1>
<section class="grid">
  <div class="card"><h2>Registrations</h2><p class="big"><c:out value="${registrationCount}" default="0"/></p></div>
  <div class="card"><h2>Open requests</h2><p class="big"><c:out value="${openRequestCount}" default="0"/></p></div>
  <div class="card"><h2>Waiting list</h2><p class="big"><c:out value="${waitlistCount}" default="0"/></p></div>
</section>
<h2>Announcements</h2>
<c:choose>
  <c:when test="${empty announcements}"><p class="empty">No announcements for you right now.</p></c:when>
  <c:otherwise>
    <ul class="plain">
      <c:forEach var="a" items="${announcements}">
        <li><strong><c:out value="${a.title}"/></strong> - <c:out value="${a.body}"/></li>
      </c:forEach>
    </ul>
  </c:otherwise>
</c:choose>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
