<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="pageTitle" value="Log in"/>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<section class="card narrow">
  <h1>Log in</h1>
  <form method="post" action="${pageContext.request.contextPath}/login" novalidate>
    <label for="userId">User ID</label>
    <input id="userId" name="userId" value="<c:out value='${param.userId}'/>" autocomplete="username" required
           aria-describedby="userId-err">
    <span id="userId-err" class="field-err"><c:out value="${errors.userId}"/></span>

    <label for="password">Password</label>
    <input id="password" name="password" type="password" autocomplete="current-password" required>
    <span class="field-err"><c:out value="${errors.password}"/></span>

    <button type="submit">Log in</button>
  </form>
  <p class="hint">Demo accounts are listed in the user guide. Never use real credentials.</p>
</section>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
