<%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/23
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<h1>添加学生</h1>
<form action="dealaddstudent.jsp" method="post">
    请输入学号:<input type="text" id="stuno" name="stuno"> <br>
    请输入姓名:<input type="text" id="stuname" name="stuname"><br>
    请输入班级:<select name="classes" id="classes">
    <option>软件工程1808041</option>
    <option>软件工程1808042</option>
    <option>计算机应用技术1808011</option>
    <option>计算机应用技术1808012</option>
</select>
    <br>

    请输入性别:<select id="gender" name="gender">
    <option value="男">男</option>
    <option value="女">女</option>
</select>
    <br>
    请输入系部:<select id="department" name="department">
    <option value="软件工程">软件工程</option>
    <option value="计算机应用">计算机应用</option>
</select>
    <br>
    请输入电话:<input type="text" id="tel" name="tel"><br>
    请输入宿舍:<select id="dormo" name="dormo">
    <option value="3-101">3-101</option>
    <option value="10410">10410</option>
    <option value="10536">10536</option>
    <option value="10425">10425</option>
    <option value="10408">10408</option>
</select>
    <br>
    <input type="submit">
</form>
</body>
</html>
