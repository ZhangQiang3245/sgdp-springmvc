<%--
  Created by IntelliJ IDEA.
  User: ZQ
  Date: 2018/3/19
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${mess}</title>
</head>
<body>
<form action="/user/create" method="post">
    姓名：<input type="text" name="username">
    密码：<input type="text" name="password">
    账号：<input type="text" name="usercode">
    组织：<input type="text" name="orgid">
    <input type="submit" value="提交">
</form>
<form action="/user/update" method="post">
    id：<input type="text" name="userid">
    姓名：<input type="text" name="username">
    密码：<input type="text" name="password">
    账号：<input type="text" name="usercode">
    组织：<input type="text" name="orgid">
    <input type="submit" value="提交">
</form>

</body>
</html>
