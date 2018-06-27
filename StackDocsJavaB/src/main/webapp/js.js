
function vykstaPaieska() {
    var kalba = document.getElementById("kalba").value;
    var paieskos_laukas = document.getElementById("paieskos-laukas").value;
    location.href = "/servletindex?kalba=" + kalba + "&paieska=" + paieskos_laukas;
}


function GetTopicInfo(skaicius){
<<<<<<< HEAD
    location.href = "/topicsservlet?topicId=" + skaicius;
=======


    url = "/topics?topicId="+skaicius;
    location.href = url;

>>>>>>> F19
}


function changePage(id){
    var kalba = getParam("kalba");
    var paieskos_laukas = getParam("paieska");
    var trRows = document.getElementsByTagName("tr");
    if (trRows.length === 0) {
            return;
        }
    var topicId = trRows[0].id;
    var next;
    if (id === "next") {
        next = true;
    } else if (id === "previous") {
        next = false;
    }
    location.href = "/servletindex?kalba=" + kalba + "&paieska=" + paieskos_laukas + "&after=" + next +
        "&topicid=" + topicId;
}

<<<<<<< HEAD
function getParam(parameter) {
    var urlParams = new URLSearchParams(window.location.search);
    if (urlParams.has(parameter)) {
        return urlParams.get(parameter);
    } else {
        return -1;
    }
=======
function funkcija_atgal() {

    // kelintasAtgal++;
    url = "servletindex?kalba=&paieska=";
    location.href = url;
>>>>>>> F19
}

