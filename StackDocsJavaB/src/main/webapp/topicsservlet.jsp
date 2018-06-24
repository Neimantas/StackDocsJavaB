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
    <h2>${data.getTitle()}</h2>
</div>

<div class="container2">

    <%--<div class=".col-xs-12 .col-sm-6 .col-md-8">--%>

    <div class="mainbody">
        <ul>
            <li>
                <h3>Introduction</h3>
                <p>${data.getIntroductionHtml()}</p>
            </li>
            <li>
                <h3>Syntax</h3>
                <p>${data.getSyntaxHtml()}</p>
            </li>
            <li>
                <h3>Parameters</h3>
                <p>${data.getParametersHtml()}</p>
            </li>
            <li>
                <h3>Remarks</h3>
                <p>${exData.getBodyHtml()}</p>
            </li>
        </ul>
    </div>
    <button class="backBtn" class="btn btn-light" onclick="funkcija_atgal();">Back</button>

</div>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
    Examples
</button>

<!-- Modal -->
<div class="modal right fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">${data.getTitle()</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Lastname</th>
                        <th>Balance</th>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
