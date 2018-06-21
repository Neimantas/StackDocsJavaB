<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/19/2018
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css.css">
    <script src="js.js"></script>
    <title>Topics</title>
</head>
<body>
<div class="header">
    <h2>${data}</h2>
</div>

<div class="container2">

    <%--<div class=".col-xs-12 .col-sm-6 .col-md-8">--%>

    <div class="mainbody">
        <ul>
            <li>
                <h3>Introduction</h3>
                <p>${data}</p>
            </li>
            <li>
                <h3>SyntaxHtml</h3>
                <p>${data}</p>
            </li>
            <li>
                <h3>ParametersHtml</h3>
                <p>${data}</p>
            </li>
            <li>
                <h3>RemarksHtml</h3>
                <p>${data}</p>
            </li>
        </ul>
    </div>
    <button class="backBtn" class="btn btn-light" onclick="funkcija_atgal();">Back</button>

</div>


</body>
</html>
