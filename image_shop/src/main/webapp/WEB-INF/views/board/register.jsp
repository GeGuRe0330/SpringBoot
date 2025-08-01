<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div align="center">
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <jsp:include page="/WEB-INF/views/common/menu.jsp"/>
    <h2><spring:message code="board.header.register"/></h2>
    <form:form modelAttribute="board" action="register">
        <table>
            <tr>
                <td><spring:message code="board.title"/></td>
                <td><form:input path="title"/></td>
                <td><font color="red"><form:errors path="title"
                /></font></td>
            </tr>
            <tr>
                <td><spring:message code="board.writer"/></td>
                <td><form:input path="writer" readonly="true"/></td>
                <td><font color="red"><form:errors path="writer"
                /></font></td>
            </tr>
            <tr>
                <td><spring:message code="board.content"/></td>
                <td><form:textarea path="content"/></td>
                <td><font color="red"><form:errors path="content"
                /></font></td>
            </tr>
        </table>
    </form:form>
    <div>
        <sec:authorize access="isAuthenticated()">
            <button type="submit" id="btnRegister"><spring:message
                    code="action.register"/></button>
        </sec:authorize>
        <button type="submit" id="btnList"><spring:message code="action.list"
        /></button>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</div>
<script>
    $(document).ready(function () {
        var formObj = $("#board");
        $("#btnRegister").on("click", function () {
            formObj.submit();
        });
        $("#btnList").on("click", function () {
            self.location = "list";
        });
    });
</script>
</body>
</html>
