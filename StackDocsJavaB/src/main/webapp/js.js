
function vykstaPaieska() {
    var kalba = document.getElementById("kalba").value;
    var paieskos_laukas = document.getElementById("paieskos-laukas").value;
    var url = "/servletindex?kalba=" + kalba + "&paieska=" + paieskos_laukas;
    location.href = url;
}


function GetTopicInfo(skaicius){
    location.href = "/topicsservlet?topicId=" + skaicius;
}


function changePage(id){
    var kalba = GetParam("kalba");
    var paieskos_laukas = getParam("paieska");
    var puslapis = parseInt(getParam("puslapis"));
    if (puslapis === -1) {
        puslapis = 1;
    }
    if (id == "next") {
        puslapis++;
    } else if (id == "previous") {
        if (puslapis > 1) {
            puslapis--;
        } else {
            return;
        }
    }
    location.href = "/servletindex?kalba=" + kalba + "&paieska=" + paieskos_laukas + "&puslapis" + puslapis;
}

function funkcija_pirmyn() {
    // Need to check whether there actually is a list to move through
    var kalba = GetParam("kalba");
    var paieskos_laukas = getParam("paieska");
    var puslapis = parseInt(getParam("puslapis"));
    if (puslapis === -1) {
        puslapis = 1;
    }
    puslapis += 1;
    location.href = "/servletindex?kalba=" + kalba + "&paieska=" + paieskos_laukas + "&puslapis=" + puslapis;

}

function funkcija_atgal() {
    var kalba = document.getElementById("kalba").value;
    var paieskos_laukas = document.getElementById("paieskos-laukas").value;
    var puslapis = parseInt(getParam("puslapis"));
    var url;
    if (puslapis > 1) {
        puslapis -= 1;
        location.href = "/servletindex?kalba=" + kalba + "&paieska=" + paieskos_laukas + "&puslapis=" + puslapis;
    }
}

function getParam(parameter) {
    var urlParams = new URLSearchParams(window.location.search);
    if (urlParams.has(parameter)) {
        return urlParams.get(parameter);
    } else {
        return -1;
    }
}
