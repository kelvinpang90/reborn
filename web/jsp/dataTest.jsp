<%--
  Created by IntelliJ IDEA.
  User: pengw
  Date: 12/1/2018
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.pwk.com" prefix="pwk" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/first/arrayData" method="post">
        <table border="1">
            <tr>
                <td>select</td>
                <td>id</td>
                <td>loginName</td>
                <td>password</td>
            </tr>

                <c:forEach items="${pwk:getAllUsers()}" var="user">
                    <tr>
                            <td><input name="ids" type="checkbox" value="${user.id}"></td>
                            <td>${user.id}</td>
                            <td>${user.loginName}</td>
                            <td>${user.password}</td>
                    </tr>
                </c:forEach>

        </table>
        <input type="submit" value="check">
    </form>
    <br>


    <form action="${pageContext.request.contextPath}/first/listData" method="post">
        <table border="1">
            <tr>
                <td>select</td>
                <td>id</td>
                <td>loginName</td>
                <td>password</td>
            </tr>
            <c:forEach items="${pwk:getAllUsers()}" var="user" varStatus="vs">
                <tr>
                    <td><input name="users[${vs.index}].id" type="checkbox" value="${user.id}"></td>
                    <td>${user.id}</td>
                    <td><input name="users[${vs.index}].loginName" type="text" value="${user.loginName}"></td>
                    <td><input name="users[${vs.index}].password" type="text" value="${user.password}"></td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" value="check">
    </form>
    <br>


    <input type="button" onclick="jsonData()" value="Test Json">
    <br>
    <br>
    <input type="button" onclick="restfulData()" value="Test RESTful">
    <br>
    <br>

    <form action="${pageContext.request.contextPath}/first/fileUpload" method="post" enctype="multipart/form-data" name="fileUpload">
        Please select file:<input type="file" name="files" multiple>
        <input type="submit" value="submit" name="submit">
    </form>
    <br>
    <br>

    <c:forEach items="${pwk:getAllUploadFiles()}" var="uploadFile">
        <a href="${pageContext.request.contextPath}/first/fileDownload1/${uploadFile.id}">${uploadFile.fileName}.${uploadFile.type}</a>
        <br>
    </c:forEach>
    <br>
    <br>

    <div>
        Redis Key<input type="text" name="key" id="key"><br>
        Redis Value<input type="text" name="value" id="value"><br>
        <input type="button" value="Add String" onclick="ajaxRedisList()">
    </div>
    <div id="redisList"></div>

    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script>
        function jsonData(){

            $.ajax({
               url:"${pageContext.request.contextPath}/first/jsonData",
                type:"POST",
                data:JSON.stringify({id:1,loginName:"kelvin",password:"123456"}),
                contentType:"application/json;charset=UTF-8",
                dataType:"json",
                success:function(data){
                   alert(data.loginName+" "+data.password);
                }
            });
        }

        function restfulData() {
            $.ajax({
               url:"${pageContext.request.contextPath}/first/restfulData/11" ,
                type:"GET",
                dataType:"json",
                contentType:"application/json;charset=UTF-8",
                success:function(data){
                    alert(data.loginName+" "+data.password);
                }
            });
        }

        function ajaxRedisList() {
            var key = $("#key");
            var value = $("#value");
            $.ajax({
                url:"${pageContext.request.contextPath}/first/redisListAdd/"+key.val()+"/"+value.val(),
                type:"get",
                dataType:"json",
                contentType:"application/json;charset=UTF-8",
                success:function(data){
                    $("#redisList").html("success "+data);
                }
            })
        }
    </script>
</body>
</html>
