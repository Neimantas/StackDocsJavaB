<%@ page import="static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java" %>
<html>
<body>
<h2>Hello World!</h2>
=======
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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

        <tr>

            <td id="isvedamas-tekstas">

                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias aut ducimus eveniet minima non
                praesentium
                quidem repellendus sunt. Beatae commodi consequuntur dicta et facilis necessitatibus placeat quam
                quasi
                recusandae voluptatum.
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aspernatur at autem cupiditate dolorum et
                exercitationem illum impedit laudantium libero maiores placeat quibusdam recusandae rem saepe,
                similique,
                sint sit unde voluptate.
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquam asperiores, commodi cupiditate est
                eum
                facere itaque iure maxime molestias nemo non nulla odio perferendis placeat quam quas quidem quos
                rerum!

            </td>
        </tr>

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


>>>>>>> F10
</body>
</html>
