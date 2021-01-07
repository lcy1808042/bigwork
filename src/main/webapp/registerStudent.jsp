<%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2021/1/2
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body align="center">
<form action="saveStudentServlet" method="post">
    请输入学号:<input type="text" id="stuno" name="stuno" > <br>
    请输入姓名:<input type="text" id="stuname" name="stuname"><br>
    请输入班级:<select name="classes" id="classes">
    <option value="1808041">软件工程1808041</option>
    <option value="1808042">软件工程1808042</option>
    <option value="j1808011">计算机应用技术1808011</option>
    <option value="j1808012">计算机应用技术1808012</option>
</select>
    <br>
    请输入性别:<select id="gender" name="gender">

    <option value="男">男</option>
    <option value="女">女</option>

</select>
    <br>
    请选择系部:<select id="department" name="department">
    <option value="软件工程">软件工程</option>
    <option value="计算机应用">计算机应用</option>
</select>
    <br>
    请输入电话:<input type="text" id="tel" name="tel"><br>
    请输入宿舍:<select id="dormno" name="dormo">
    <option value="3-101">3-101</option>
    <option value="10410">10410</option>
    <option value="10536">10536</option>
    <option value="10425">10425</option>
    <option value="10408">10408</option>
</select>
    <input type="submit" name="submit" value="注册"/>
</form>
</body>
</html>
