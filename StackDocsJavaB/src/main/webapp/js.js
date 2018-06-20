
function vykstaPaieska() {
    var kalba = document.getElementById("kalba").value;
    var paieskos_laukas = document.getElementById("paieskos-laukas").value;
    var url = "/servletindex?kalba=" + kalba + "&paieska=" + paieskos_laukas;
    location.href = url;
}


function GetTopicInfo(skaicius){
    location.href = "/topicsservlet?topicId=" + skaicius;
}


function funkcija_pirmyn() {
    // Need to check whether there actually is a list to move through
    var kalba = GetParam("kalba");
    var paieskos_laukas = GetParam("paieska");
    var puslapis = parseInt(GetParam("puslapis"));
    if (puslapis === -1) {
        puslapis = 1;
    }
    puslapis += 1;
    var url = "/servletindex?kalba=" + kalba + "&paieska=" + paieskos_laukas + "&puslapis=" + puslapis;
    location.href = url;

}

function funkcija_atgal() {
    var kalba = document.getElementById("kalba").value;
    var paieskos_laukas = document.getElementById("paieskos-laukas").value;
    var puslapis = parseInt(GetParam("puslapis"));
    var url;
    if (puslapis > 1) {
        puslapis -= 1;
        url = "/servletindex?kalba=" + kalba + "&paieska=" + paieskos_laukas + "&puslapis=" + puslapis;
        location.href = url;
    }
}

function GetParam(parameter) {
    var urlParams = new URLSearchParams(window.location.search);
    if (urlParams.has(parameter)) {
        return urlParams.get(parameter);
    } else {
        return -1;
    }
}
