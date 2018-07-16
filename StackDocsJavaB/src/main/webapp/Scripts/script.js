window.addEventListener("load", function () {
    // Access the form element...
    var form = document.getElementById("myForm");
    // ...and take over its submit event.
    form.addEventListener("submit", function (event) {
        event.preventDefault();
        Search();
    });
});

function Search() {
    var language = document.getElementById("language").value;
    var searchField = document.getElementById("search-field").value;
    location.href = "/servletindex?language=" + language + "&search=" + searchField;
}


function GetTopicInfo(number){
    location.href = "/topics?topicId=" + number;
  }


function changePage(id){
    var language = getParam("language");
    var search = getParam("search");
    var pageNum = parseInt(document.getElementById("page-number").firstElementChild.text);
    var trRows = document.getElementsByTagName("tr");
    if (trRows.length !== 0) {
        var topicId = trRows[0].id;
        var next;
        if (id === "next") {
            next = true;
            pageNum++;
            location.href = "/servletindex?language=" + language + "&search=" + search + "&after=" + next +
                "&topicid=" + topicId + "&page=" + pageNum;
        } else if (id === "previous" && pageNum > 1) {
            next = false;
            pageNum--;
            location.href = "/servletindex?language=" + language + "&search=" + search + "&after=" + next +
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
