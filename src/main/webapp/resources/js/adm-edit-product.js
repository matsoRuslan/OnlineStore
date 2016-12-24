$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/home/product/" + productId,
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            var stringifiedData = JSON.stringify(data);
            var product = JSON.parse(stringifiedData);

            createImage(product.image.name, product.image.image);
            document.getElementById("close-tab").setAttribute("href", "/home/admin-config/edit-products-paging?size=" + totalSize + "&page=1");
        }
    });


    function createImage(image, byteImage) {
        var img = document.createElement('img');
        if (byteImage == null) {
            if (image == "" || image == null) {
                var a = document.createElement('a');
                img.src = "http://placehold.it/300x300";
                a.appendChild(img);
                img = a;

            }
            else {
                img.src = "/home/resources/img/" + image;
                img.setAttribute("style", "width: 300px; height: 300px");
                var a = document.createElement('a');
                a.appendChild(img);
                img = a;
            }
        }
        else {
            img.src = "data:image/png;base64," + byteImage;
            img.setAttribute("style", "width: 300px; height: 300px");
            var a = document.createElement('a');
            a.appendChild(img);
            img = a;
        }
        document.getElementById("product-image").appendChild(img);
    }


});