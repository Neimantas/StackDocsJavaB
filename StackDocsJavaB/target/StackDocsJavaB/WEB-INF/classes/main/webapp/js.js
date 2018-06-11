// var paieska = document.getElementById("paieskos-laukas");
// var kalbos_pasirinkimas = document.getElementById("kalba");
// var teksto_laukas = document.getElementById("isvedamas-tekstas");
// var mygtukas_atgal = document.getElementById("mugtukas-atgal");
// var mygtukas_pirmyn = document.getElementById("mygtukas-atgal");
// var puslapio_numeris = document.getElementById("puslapio-numeris");
// var kalba = document.getElementById("kalba");

// var kelintasPirmyn = 0;
// var kelintasAtgal=0;


function vykstaPaieska() {


    var kalba = document.getElementById("kalba").value;
    var paieskos_laukas = document.getElementById("paieskos-laukas").value;

    url = "index.jsp?kalba=" + kalba + "&paieska=" + paieskos_laukas;
    location.href = url;


}


function funkcija_pirmyn() {

    var currentLocation = window.location;
    // kelintasAtgal++;
    url = currentLocation + "&pirmyn=true";
    location.href = url;

}

function funkcija_atgal() {

    var currentLocation = window.location;
    // kelintasAtgal++;
    url = currentLocation + "&atgal=true";
    location.href = url;
}
