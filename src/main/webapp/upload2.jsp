<%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/30
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传照片</title>
</head>
<style>
    #img01{
        display: none;
    }
</style>
<body>
<form>
    请上传照片：<input type="file" id="uploadfile" name="uploadfile"/>
</form>
<img src="" id="img01" style="width: 300px;height: 300px">
<script>

    var img01=document.getElementById("img01");
    uploadfile.addEventListener("change",function () {
        var uploadfiles=document.getElementById("uploadfile").files;
        var reader=new FileReader();
        // var result=reader.readAsDataURL(uploadfiles);
        reader.readAsDataURL(uploadfiles[0])
        reader.onload=function () {
            img01.src=reader.result;
            img01.style.display="block"
        }
    });
</script>
</body>
</html>
