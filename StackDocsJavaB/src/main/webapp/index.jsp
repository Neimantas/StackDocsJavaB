<%@ taglib prefix="java" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ page import="static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@page import="org.omg.CORBA.Request"%>--%>
<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"--%>
<%--pageEncoding="ISO-8859-1"%>--%>


<html>

<head>
    <link rel="stylesheet" href="css.css">
    <script src="js.js"></script>
    <title>Stack Docs JAVA</title>

</head>


<body class="bg-light">
<div class="container">

    <div class="py-5 text-center">
        <img src="IMG/logo.png" alt="" class="paveikslelis">
        <h2>Stack Docs JAVA</h2>
    </div>


    <div class="row">


        <div class="col-md-4 order-md-1 mb-4">
            <h4 class="d-flex justify-content-between align-items-center mb-3">
                <span class="text-muted">Pasirinkite kalbą</span>
            </h4>
            <select class="custom-select d-block w-100" id="kalba" required>
                <option value="0">
                    "Pasirinkimas..."
                </option>
                <option value="1">
                    Java
                </option>
                <option value="2">
                    .NET
                </option>
                <option value="3">
                    C#
                </option>
                <option value="4">
                    JavaScript
                </option>
            </select>

            <button type="submit" class="btn btn-light" onclick="vykstaPaieska();">Paieška</button>
        </div>


        <div class="col-md-8 order-md-2">
            <h4 class="mb-3"> Paieška pagal frazę</h4>
            <form class="needs-validation was-validated">
                <div class="row">
                    <div class="col-md-12 mb-3">
                        <input class="form-control" id="paieskos-laukas" type="text" placeholder="Įveskite frazę">

                    </div>
                </div>
            </form>


        </div>

    </div>

    <!--<div class="container">-->

    <table class="table table-bordered shadow-lg p-3 mb-5 bg-white rounded">

        <tbody>


        <java:forEach var="topic" items="${data}">
            <tr onclick="GetTopicInfo(${topic.getId()});">
                <td>${topic.getId()}</td>
                <td>${topic.getTitle()}</td>

            </tr>
        </java:forEach>


        </tbody>

    </table>

    <nav aria-label="Puslapiu navigacija">

        <ul class="pagination justify-content-center">

            <!--<li class="page-item">-->
            <!--<a class="page-link text-dark" id="mugtukas-atgal" href="#" tabindex="-1" onclick="funkcija_atgal()">Atgal</a>-->
            <!--</li>-->

            <!--KIEK BUS PUSLAPIU?-->
            <li class="page-item" id="mugtukas-atgal"><a class="page-link text-dark"
                                                         onclick="funkcija_atgal()">Atgal</a>
            </li>
            <li class="page-item" id="puslapio-numeris"><a class="page-link text-dark">1</a></li>

            <li class="page-item" id="mygtukas-pirmyn"><a class="page-link text-dark"
                                                          onclick="funkcija_pirmyn()">Pirmyn</a></li>

            <!--<li class="page-item">-->
            <!--<a class="page-link text-dark" id="mygtukas-pirmyn" href="#" onclick="funkcija_pirmyn()">Pirmyn</a>-->
            <!--</li>-->

        </ul>
    </nav>


    <!--</div>-->


</div>


</body>
</html>
