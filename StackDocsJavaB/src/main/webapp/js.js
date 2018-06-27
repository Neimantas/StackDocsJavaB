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

    url = "/servletindex?kalba=" + kalba + "&paieska=" + paieskos_laukas;
    location.href = url;
}


function GetTopicInfo(skaicius){


    url = "/topics?topicId="+skaicius;
    location.href = url;

}


function funkcija_pirmyn() {


    // kelintasAtgal++;
    url = "index.jsp?pirmyn=true";
    location.href = url;

}

function funkcija_atgal() {

    // kelintasAtgal++;
    url = "servletindex?kalba=&paieska=";
    location.href = url;
}

