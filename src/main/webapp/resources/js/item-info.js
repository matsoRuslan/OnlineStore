$(document).ready(function () {
    var productId = window.location.pathname.split('/')[3];
    $.ajax({
        type: "GET",
        url: "/home/product/" + productId,
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            var stringifiedData = JSON.stringify(data);
            var product = JSON.parse(stringifiedData);
            defineItem(product.title, product.price, product.fullDescription, product.amount, product.image.name, product.image.image);
            document.getElementById("add-to-cart").setAttribute("href", "/home/add-to-cart?product=" + productId);
        }
    });
    function defineItem(title, price, fullDescription, amount, image, byteImage) {

        var img = document.createElement('img');
        if (byteImage == null) {
            if (image == "" || image == null) {
                var a = document.createElement('a');
                img.src = "http://placehold.it/320x320";
                a.appendChild(img);
                img = a;

            }
            else {
                img.src = "/home/resources/img/" + image;
                img.setAttribute("style", "width: 320px; height: 320px");
                var a = document.createElement('a');
                a.appendChild(img);
                img = a;
            }
        }
        else {
            img.src = "data:image/png;base64," + byteImage;
            img.setAttribute("style", "width: 320px; height: 320px");
            var a = document.createElement('a');
            a.appendChild(img);
            img = a;
        }
        var productImage = document.getElementById("product-image");
        productImage.appendChild(img);
        $('#title').html(title);
        $('#fullDescription').html(fullDescription);
        if (amount === 0) {
            $('#available').attr("class", "label label-default pull-right");
            $('#available').html("Not available");
            $('#add-to-cart').remove();
        }
        else {
            $('#available').html("Available: " + amount);
            $('#price').html("Price: $" + price);
        }
    }

    Element.prototype.remove = function () {
        this.parentElement.removeChild(this);
    }
});