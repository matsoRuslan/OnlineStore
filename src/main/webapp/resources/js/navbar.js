$(document).ready(function () {
    document.getElementById("search").onclick = function () {
        search();
    };
    function search() {
        var href = document.getElementById('search-input').value;
        document.getElementById("search").setAttribute("href", "/home/product?search=" + href);
    }

});
