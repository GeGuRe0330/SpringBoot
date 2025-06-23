<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%-- 헤더 영역 --%> <%@ include file="./header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%-- 헤더 영역 --%> 
<%@ include file="./header.jsp" %>

<!-- 화면영역 -->
<main>
  <h3>회원 상세 정보</h3>
  <form:form modelAttribute="member" id="member">
    <form:hidden path="no" />

    <table>
      <tr>
        <td>Id</td>
        <td><form:input path="id" readonly="true" /></td>
      </tr>
      <tr>
        <td>Name</td>
        <td><form:input path="name" readonly="true" /></td>
      </tr>
    </table>
  </form:form>
  <div>
    <button type="submit" id="btnModify">Modify</button>
    <button type="submit" id="btnRemove">Remove</button>
    <button type="submit" id="btnList">List</button>
  </div>
</main>

<%-- 푸터 영역 --%> <%@ include file="./footer.jsp" %>

<script>
  $(document).ready(function () {
    var formObj = $("#member");
    console.log(formObj);
    $("#btnModify").on("click", function () {
      formObj.attr("action", "/member/modify");
      formObj.attr("method", "get");
      formObj.submit();
    });
    $("#btnRemove").on("click", function () {
      formObj.attr("method", "post");
      formObj.attr("action", "/member/remove");
      formObj.submit();
    });
    $("#btnList").on("click", function () {
      self.location = "/member/list";
    });
  });
</script>
