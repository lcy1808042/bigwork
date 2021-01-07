<%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/24
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="css/style1.css">

<ul >
    <li><a href="listStudentsByPaging.jsp?page=1">首  页</a></li>
    <%
        if(currentPage!=1){
    %>
    <li><a href="listStudentsByPaging.jsp?page=<%=currentPage-1%>">上一页</a></li>
    <%
        }
    %>
    <%
        if(currentPage!=pageUtil.getMaxPage()){
    %>
    <li><a href="listStudentsByPaging.jsp?page=<%=currentPage+1%>">下一页</a></li>
    <%
        }
    %>
    <li><a href="listStudentsByPaging.jsp?page=<%=pageUtil.getMaxPage()%>">尾  页</a></li>
    <li style="width: 300px">

        <form action="listStudentsByPaging.jsp" method="post">
            跳转到  <select name="page" id="selectPage">
            <option >请选择</option>
        </select>  页   <input type="submit" name="submit" value="确定">
        </form>

    </li>
</ul>
<script>
    function insertPage(element,maxPage){
        for(i=1;i<=maxPage;i++){
            element.options.add(new Option(i,i));
        }
    }
    insertPage(document.getElementById("selectPage"),"<%=pageUtil.getMaxPage()%>");
</script>
<%
    int pageSize2=5;
    for(int i=1;i<=pageSize2;i++){


%>
<a href="listStudentsByPaging.jsp?page=<%=i%>"> <%=i%> </a>
        <%
    }


%>