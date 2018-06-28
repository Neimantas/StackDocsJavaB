<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 6/19/2018
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="java" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="css.css">

    <title>Topics</title>
</head>
<body>
<div class="header">
    <h2>${data.getTitle()}</h2>
</div>

<div class="container2">

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
                <p>${data.getRemarksHtml()}</p>
            </li>
        </ul>
    </div>
    <div class="row justify-content-center">
        <!-- Button trigger modal -->
        <button class="col-auto btn btn-info" type="button" data-toggle="modal" data-target=".bd-example-modal-lg">
            Example
        </button>
        <div class="col-sm-2 offset-sm-2"></div>
        <div class="col-sm-2 offset-sm-2"></div>
        <button class="col-auto btn btn-secondary" onclick="funkcija_atgal();">Back</button>

    </div>
</div>



<%--Modal--%>
<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">${data.getTitle()}</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <ul>
                    <li>
                        <java:forEach var="id" items="${exData}">
                         <p>${id.getBodyHtml()}</p>
                        </java:forEach>
                    </li>
                </ul>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <%--<button type="button" class="btn btn-primary">Button 2</button>--%>
            </div>
        </div>
    </div>
</div>


<script src="js.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
        integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
        integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
        crossorigin="anonymous"></script>
</body>
</html>
