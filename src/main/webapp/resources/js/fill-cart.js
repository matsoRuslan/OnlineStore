$(document).ready(function () {
    var totalPrice = 0;
    $.ajax({
        type: "GET",
        url: "/home/cart/" + cartId,
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            var stringifiedData = JSON.stringify(data);
            var cart = JSON.parse(stringifiedData);
            var products = [];
            for (var i = 0; i < cart.cartProducts.length; i++) {
                if (cart.cartProducts[i].productBought !== true) {
                    products.push(cart.cartProducts[i].product);
                    totalPrice = totalPrice + cart.cartProducts[i].product.price;
                    addProduct("products", cart.cartProducts[i].product.price, cart.cartProducts[i].product.title, cart.cartProducts[i].product.description, cart.cartProducts[i].product.id, false, "itemDivid", i, cart.cartProducts[i].product.image.name, false, cart.cartProducts[i].product.image.image);
                    createButtonIds(cart.cartProducts[i].product.id, cart.cartProducts[i].id, cart.cartProducts[i].product.price, i);

                }
            }
            if (products.length == 0) {
                $('#cart').html("There are no items in your cart");
            }
            document.getElementById("modal-product-button").onclick = function () {
                modalFill();
                $('#myModal').modal('show');
            };
            document.getElementById("total-price").innerHTML = "Total price <strong>$" + totalPrice.toFixed(2) + "</strong>";
        }
    });
    function createButtonIds(productId, cartProductId, productPrice, index) {
        document.getElementById("createId" + index).onclick = function () {
            confirmfunc(productId, cartProductId, productPrice, index);
        };
        document.getElementById("deleteId" + index).onclick = function () {
            deletefunc(productId, cartProductId, productPrice, index);
        };
    }

    function createDiv(className) {
        var div = document.createElement("div");
        div.className = className;
        return div;
    }

    function addProduct(productsDiv, price, title, description, productId, isModal, itemDivid, index, image, productsBought, byteImage) {
        var itemSlotDiv = createDiv("col-sm-4 col-lg-4 col-md-4");
        itemSlotDiv.setAttribute("id", itemDivid + index);
        var title2 = title;
        var thumbnailDiv = createDiv("thumbnail");
        var img = document.createElement('img');
        if (byteImage == null) {
            if (image == "" || image == null) {
                var a = document.createElement('a');
                img.src = "http://placehold.it/320x305";
                a.appendChild(img);
                img = a;

            }
            else {
                img.src = "/home/resources/img/" + image;
                if (productsBought == true) {
                    img.setAttribute("style", "width: 165px; height: 165px");
                }
                else {
                    img.setAttribute("style", "width: 320px; height: 270px");
                }
                var a = document.createElement('a');
                a.appendChild(img);
                img = a;
            }
        }
        else {
            img.src = "data:image/png;base64," + byteImage;
            if (productsBought == true) {
                img.setAttribute("style", "width: 165px; height: 165px");
            }
            else {
                img.setAttribute("style", "width: 320px; height: 270px");
            }
            var a = document.createElement('a');
            a.appendChild(img);
            img = a;
        }

        var detailDiv = createDiv("caption");
        detailDiv.innerHTML = '<h4><p title="' + title2 + '">' + title + '</p></h4>' +
            '<h4>$' + price + '</h4>' +
            '<p>' + description + '</p>';

        thumbnailDiv.appendChild(img);
        thumbnailDiv.appendChild(detailDiv);
        if (!isModal) {
            thumbnailDiv.appendChild(cartButtons(index));
        }
        itemSlotDiv.appendChild(thumbnailDiv);
        $('.' + productsDiv).append(itemSlotDiv);

    }

    function cartButtons(productId) {
        var div = document.createElement("div");
        div.className = "cart-buttons";

        var button1 = document.createElement("button");
        button1.className = "btn btn-success btn-block";
        button1.setAttribute("type", "button");
        button1.setAttribute("id", "createId" + productId);
        button1.innerHTML = "Confirm purchase";

        var button2 = document.createElement("button");
        button2.className = "btn btn-danger btn-block";
        button2.setAttribute("type", "button");
        button2.setAttribute("id", "deleteId" + productId);
        button2.innerHTML = "Delete from cart";

        div.appendChild(button1);
        div.appendChild(button2);
        return div;
    }

    function confirmfunc(productId, cartProductId, productPrice, index) {
        $.ajax({
            type: "post",
            contentType: "application/json; charset=utf-8",
            url: "confirm-purchase",
            data: "" + cartProductId,
            success: function () {
            }
        });
        document.getElementById("itemDivid" + index).remove();
        totalPrice = totalPrice - productPrice;
        document.getElementById("total-price").innerHTML = "Total price <strong>$" + totalPrice.toFixed(2) + "</strong>";
    }

    function deletefunc(productId, cartProductId, productPrice, index) {
        $.ajax({
            type: "post",
            contentType: "application/json; charset=utf-8",
            url: "delete-from-cart",
            data: "" + cartProductId,
            success: function () {
            }
        });
        totalPrice = totalPrice - productPrice;
        document.getElementById("total-price").innerHTML = "Total price <strong>$" + totalPrice.toFixed(2) + "</strong>";
        document.getElementById("itemDivid" + index).remove();
    }

    function modalFill() {

        $.ajax({
            type: "GET",
            url: "/home/cart/" + cartId,
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                var productsbought = [];
                var stringifiedData = JSON.stringify(data);
                var cart = JSON.parse(stringifiedData);
                for (var i = 0; i < cart.cartProducts.length; i++) {
                    if (cart.cartProducts[i].productBought === true) {
                        productsbought.push(cart.cartProducts[i].product)
                    }
                }
                for (var i = 0; i < productsbought.length; i++) {
                    if (document.getElementById("itemModalDivid" + i) !== null) {
                        document.getElementById("itemModalDivid" + i).remove();
                    }
                    addProduct("modal-products", productsbought[i].price, productsbought[i].title, productsbought[i].description, productsbought[i].id, true, "itemModalDivid", i, productsbought[i].image.name, true, productsbought[i].image.image);
                }
                if (productsbought.length == 0) {
                    $('#recent').html("There are no recent bought products");
                }
            }
        });

    }

    Element.prototype.remove = function () {
        this.parentElement.removeChild(this);
    }
});