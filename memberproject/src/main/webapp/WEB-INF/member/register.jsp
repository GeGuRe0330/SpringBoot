<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%-- 헤더 영역 --%> <%@ include file="./header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- 화면영역 -->
<main>
  <h3>회원 등록</h3>
  <form:form modelAttribute="member" action="/member/register">
    <table>
      <tr>
        <td>아이디</td>
        <td><form:input path="id" /></td>
        <td>
          <font color="red"><form:errors path="id" /></font>
        </td>
      </tr>
      <tr>
        <td>패스워드</td>
        <td><form:input path="pw" /></td>
        <td>
          <font color="red"><form:errors path="pw" /></font>
        </td>
      </tr>
      <tr>
        <td>이름</td>
        <td><form:input path="name" /></td>
        <td>
          <font color="red"><form:errors path="name" /></font>
        </td>
      </tr>
    </table>
  </form:form>
  <div>
    <button type="submit" id="btnRegister">등록</button>
  </div>
</main>

<%-- 푸터 영역 --%> 
<%@ include file="./footer.jsp" %>

<script>
  $(document).ready(function () {
    var formObj = $("#member");
    $("#btnRegister").on("click", function () {
      formObj.attr("action", "/member/register");
      formObj.attr("method", "post");
      formObj.submit();
    });
  });
</script>
