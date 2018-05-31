<%@page contentType="text/html; ISO-8859-1" pageEncoding="utf-8" %>
<!DOCTYPE html>

<html>

<head>
    <link rel="stylesheet" href="css.css">
    <title>Stack Docs JAVA</title>

</head>
<body class="bg-light">


<!--7.	Čia sukuriam front ent lentelę, su mygtukai pirmyn/atgal bei-->
<!--dabartinio puslapio numeriu. Šitas template turi turėti mygtuką -->
<!--„search“ ir dropdown (kalbų);-->

<div class="container">

    <div class="py-5 text-center">
        <img src="IMG/logo.png" alt="" class="paveikslelis">
        <h2>Stack Docs JAVA</h2>


    </div>


    <div class="row">

        <div class="col-md-4 order-md-2 mb-4">

            <h4 class="d-flex justify-content-between align-items-center mb-3">

                <span class="text-muted">Pasirinkite kalbą</span>
            </h4>

            <select class="custom-select d-block w-100" id="kalba" required>

                <option value>

                    "Pasirinkimas..."

                </option>
                <option>

                    "JAVA"

                </option>


            </select>

        </div>

        <div class="col-md-8 order-md-1">

            <h4 class="mb-3"> Paieška pagal frazę</h4>

            <form class="needs-validation was-validated">

                <div class="row">

                    <div class="col-md-12 mb-3">

                        <input class="form-control" type="text" placeholder="Įveskite frazę">


                    </div>

                </div>


            </form>


        </div>

    </div>

    <!--<div class="container">-->

        <table class="table table-bordered shadow-lg p-3 mb-5 bg-white rounded">

            <thead>

            <tr>

                <td>

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

            </thead>

        </table>

        <nav aria-label="Puslapiu navigacija">

            <ul class="pagination justify-content-center">

                <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1">Previous</a>
                </li>

                <!--KIEK BUS PUSLAPIU?-->

                <li class="page-item"><a class="page-link text-dark" href="#">1</a></li>
                <li class="page-item"><a class="page-link text-dark" href="#">2</a></li>
                <li class="page-item"><a class="page-link text-dark" href="#">3</a></li>
                <li class="page-item"><a class="page-link text-dark" href="#">4</a></li>
                <li class="page-item"><a class="page-link text-dark" href="#">5</a></li>


                <li class="page-item">
                    <a class="page-link text-dark" href="#">Next</a>
                </li>

            </ul>
        </nav>


    <!--</div>-->


</div>


</body>
</html>
