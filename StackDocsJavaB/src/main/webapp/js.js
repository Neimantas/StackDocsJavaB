window.addEventListener("load", function () {
    // Access the form element...
    var form = document.getElementById("myForm");
    // ...and take over its submit event.
    form.addEventListener("submit", function (event) {
        event.preventDefault();
        vykstaPaieska();
    });
});

function vykstaPaieska() {
    var kalba = document.getElementById("kalba").value;
    var paieskos_laukas = document.getElementById("paieskos-laukas").value;
    location.href = "/servletindex?kalba=" + kalba + "&paieska=" + paieskos_laukas;
}


function GetTopicInfo(skaicius){
    location.href = "/topicsservlet?topicId=" + skaicius;
}


function changePage(id){
    var language = getParam("kalba");
    var search = getParam("paieska");
    var pageNum = parseInt(document.getElementById("puslapio-numeris").firstElementChild.text);
    var trRows = document.getElementsByTagName("tr");
    if (trRows.length !== 0) {
        var topicId = trRows[0].id;
        var next;
        if (id === "next") {
            next = true;
            pageNum++;
            location.href = "/servletindex?kalba=" + language + "&paieska=" + search + "&after=" + next +
                "&topicid=" + topicId + "&page=" + pageNum;
        } else if (id === "previous" && pageNum > 1) {
            next = false;
            pageNum--;
            location.href = "/servletindex?kalba=" + language + "&paieska=" + search + "&after=" + next +
                "&topicid=" + topicId + "&page=" + pageNum;
        }
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
