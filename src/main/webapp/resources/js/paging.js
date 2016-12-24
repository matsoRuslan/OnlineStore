$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/home/product-page?size=" + size + "&page=" + page,
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            var products = [];
            for (var i = 0; i < data.length; i++) {
                var stringifiedData = JSON.stringify(data[i]);
                products.push(JSON.parse(stringifiedData));

                if (products[i].active === false) {
                    addProduct(products[i].price, products[i].title, products[i].description, products[i].id, true, products[i].image.name, products[i].image.image);
                }
                else {
                    addProduct(products[i].price, products[i].title, products[i].description, products[i].id, false, products[i].image.name, products[i].image.image)
                }
            }
            if (products.length == 0) {
                $('#pages').html("No items to show");
            }
            createPagination();
        }
    });
    function createDiv(className) {
        var div = document.createElement("div");
        div.className = className;
        return div;
    }

    function addProduct(price, title, description, id, faded, image, byteImage) {
        if (faded === true) {
            var itemSlotDiv = createDiv("col-sm-4 col-lg-4 col-md-4 faded");
            var title2 = "Item not available";
            var hreff = "/home/item-not-available";
        }
        else {
            var itemSlotDiv = createDiv("col-sm-4 col-lg-4 col-md-4");
            var hreff = "/home/shop-item/" + id + "";
            var title2 = title;
        }
        var thumbnailDiv = createDiv("thumbnail");
        var img = document.createElement('img');
        if (byteImage == null) {
            if (image == "" || image == null) {
                var a = document.createElement('a');
                img.src = "http://placehold.it/320x305";
                a.setAttribute("href", hreff);
                a.appendChild(img);
                img = a;

            }
            else {
                img.src = "/home/resources/img/" + image;
                img.setAttribute("style", "width: 320px; height: 250px");
                var a = document.createElement('a');
                a.setAttribute("href", hreff);
                a.appendChild(img);
                img = a;
            }
        }
        else {
            img.src = "data:image/png;base64," + byteImage;
            img.setAttribute("style", "width: 320px; height: 250px");
            var a = document.createElement('a');
            a.setAttribute("href", hreff);
            a.appendChild(img);
            img = a;
        }

        var detailDiv = createDiv("caption");
        detailDiv.innerHTML = '<h4><a href=' + hreff + ' title="' + title2 + '">' + title + '</a></h4>' +
            '<h4>$' + price + '</h4>' +
            '<p>' + description + '</p>';

        thumbnailDiv.appendChild(img);
        thumbnailDiv.appendChild(detailDiv);
        itemSlotDiv.appendChild(thumbnailDiv);
        $('.products').append(itemSlotDiv);
    }

    function createPagination() {
        var ul = document.getElementById("paging");
        ul.appendChild(createLiSide(true, false));
        for (var i = 1; i <= pageCount; i++) {
            ul.appendChild(createLi(i));
        }
        ul.appendChild(createLiSide(false, true));
    }

    function createLiSide(prev, next) {
        var hreffPrev;
        var hreffNext;
        if (page == 1) {
            hreffPrev = "/home/paging?size=" + size + "&page=" + page;
        }
        else {
            hreffPrev = "/home/paging?size=" + size + "&page=" + (page - 1);
        }
        if (page == pageCount) {
            hreffNext = "/home/paging?size=" + size + "&page=" + page;
        }
        else {
            hreffNext = "/home/paging?size=" + size + "&page=" + (Number(page) + 1);
        }
        var li = document.createElement("li");

        var a = document.createElement("a");
        if (prev == true) {
            a.setAttribute("href", hreffPrev);
            a.setAttribute("aria-label", "Previous");
        }
        if (next == true) {
            a.setAttribute("href", hreffNext);
            a.setAttribute("aria-label", "Next");
        }
        var span = document.createElement("span");
        span.setAttribute("aria-hidden", "true");
        if (prev == true) {
            span.innerHTML = "&laquo;";
        }
        if (next == true) {
            span.innerHTML = "&raquo;";
        }
        li.appendChild(a);
        a.appendChild(span);
        return li;
    }

    function createLi(index) {
        var hreff = "/home/paging?size=" + size + "&page=" + index;
        var li = document.createElement("li");
        if (index == page) {
            li.className = "active"
        }
        var a = document.createElement("a");
        a.setAttribute("href", hreff);
        a.innerHTML = index;
        li.appendChild(a);
        return li;
    }
});