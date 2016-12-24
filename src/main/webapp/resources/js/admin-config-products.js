$(document).ready(function () {
    document.getElementById("search2").onclick = function () {
        search();
    };
    function search() {
        var href = document.getElementById('search-input2').value;
        document.getElementById("search2").setAttribute("href", "/home/admin-config/edit-products-paging?size=" + size + "&page=" + page + "&search=" + href);
    }

    $.ajax({
        type: "GET",
        url: "/home/product-page?size=" + size + "&page=" + page + "&search=" + productSearch,
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            var products = [];
            for (var i = 0; i < data.length; i++) {
                var stringifiedData = JSON.stringify(data[i]);
                products.push(JSON.parse(stringifiedData));
            }
            for (var i = 0; i < products.length; i++) {
                createRow(i + 1, products[i].image.name, products[i].title, products[i].description, products[i].fullDescription, products[i].price, products[i].amount, products[i].category.title, products[i].active, products[i].id, products[i].image.image);
                $("#active" + products[i].id).click({param1: products[i].id}, activeClick);
                $("#deactive" + products[i].id).click({param1: products[i].id}, deActiveClick);
            }
            if (products.length == 0) {
                $('#items').html("No items found");
            }
            document.getElementById("allHref").setAttribute("href", "/home/admin-config/edit-products-paging?size=" + totalSize + "&page=1");
            document.getElementById("edit-items").setAttribute("href", "/home/admin-config/edit-products-paging?size=" + totalSize + "&page=1");
            createPagination();
        }
    });


    function createRow(index, image, title, description, fullDescription, price, amount, category, active, productId, byteImage) {
        var tr = document.createElement("tr");
        tr.appendChild(createTd(index));
        tr.appendChild(createImage(image, byteImage));
        tr.appendChild(createTd(title));
        tr.appendChild(createTd(description));
        tr.appendChild(fullDesc(productId, title, fullDescription));
        tr.appendChild(createTd("$" + price));
        tr.appendChild(createTd(amount));
        tr.appendChild(createTd(category));
        tr.appendChild(createIcons(productId, active));
        document.getElementById("table-body").appendChild(tr);
    }

    function createIcons(productId, active) {
        var td = document.createElement("td");
        var a = document.createElement("a");
        if (active == true) {
            a.setAttribute("id", "active" + productId);
            a.setAttribute("title", "deactivate product");
        }
        else {
            a.setAttribute("id", "deactive" + productId);
            a.setAttribute("title", "activate product");
        }
        var i = document.createElement("i");
        if (active == true) {
            i.className = "icon-ok";
        }
        else {
            i.className = "icon-remove";
        }
        a.appendChild(i);
        var a2 = document.createElement("a");
        a2.setAttribute("id", "edit-product" + productId);
        a2.setAttribute("href", "/home/admin-config/adm-edit-product?product=" + productId);
        a2.setAttribute("title", "update product");
        var i2 = document.createElement("a");
        i2.className = "icon-pencil";
        a2.appendChild(i2);

        var a3 = document.createElement("a");
        a3.setAttribute("id", "delete-product" + productId);
        a3.setAttribute("href", "/home/admin-config/adm-delete-product?product=" + productId);
        a3.setAttribute("title", "delete product");
        var i3 = document.createElement("a");
        i3.className = "icon-trash";
        a3.appendChild(i3);

        td.appendChild(a);
        td.appendChild(a2);
        td.appendChild(a3);
        return td;
    }

    function createTd(text) {
        var td = document.createElement("td");
        td.innerHTML = "" + text;
        return td;
    }

    function activeClick(productId) {
        $.ajax({
            type: "post",
            contentType: "application/json; charset=utf-8",
            url: "set-product-inactive",
            data: "" + productId.data.param1,
            success: function () {
            }
        });
        location.reload();
    }

    function deActiveClick(productId) {
        $.ajax({
            type: "post",
            contentType: "application/json; charset=utf-8",
            url: "set-product-active",
            data: "" + productId.data.param1,
            success: function () {
            }
        });
        location.reload();
    }

    function fullDesc(productId, title, fullDescription) {
        var modals = document.getElementById("modals");

        var myModal = createDiv("modal fade");
        var modalDialog = createDiv("modal-dialog");
        var modalContent = createDiv("modal-content");
        var modalHeader = createDiv("modal-header");
        var modalBody = createDiv("modal-body");
        var modalFooter = createDiv("modal-footer");

        myModal.setAttribute("id", "myModal" + productId);
        myModal.setAttribute("role", "dialog");

        var headerChild1 = document.createElement("button");
        headerChild1.className = "close";
        headerChild1.setAttribute("data-dismiss", "modal");
        headerChild1.setAttribute("type", "button");
        headerChild1.innerHTML = "&times;";
        var headerChild2 = document.createElement("h4");
        headerChild2.className = "modal-title";
        headerChild2.innerHTML = "Full description of " + title;
        modalHeader.appendChild(headerChild1);
        modalHeader.appendChild(headerChild2);

        var bodyChild1 = document.createElement("p");
        bodyChild1.innerHTML = "" + fullDescription;
        modalBody.appendChild(bodyChild1);

        var footerChild1 = document.createElement("button");
        footerChild1.className = "btn btn-default";
        footerChild1.setAttribute("type", "button");
        footerChild1.setAttribute("data-dismiss", "modal");
        footerChild1.innerHTML = "Close";
        modalFooter.appendChild(footerChild1);

        modalContent.appendChild(modalHeader);
        modalContent.appendChild(modalBody);
        modalContent.appendChild(modalFooter);
        modalDialog.appendChild(modalContent);
        myModal.appendChild(modalDialog);
        modals.appendChild(myModal);

        var td = document.createElement("td");
        td.appendChild(modalButton(productId));

        return td;
    }

    function modalButton(productId) {
        var button = document.createElement("button");
        button.className = "btn btn-info btn-lg";
        button.setAttribute("data-toggle", "modal");
        button.setAttribute("data-target", "#myModal" + productId);
        button.innerHTML = "View description";
        return button;
    }

    function createDiv(className) {
        var div = document.createElement("div");
        div.className = className;
        return div;
    }

    function createImage(image, byteImage) {
        var td = document.createElement("td");

        var img = document.createElement('img');
        if (byteImage == null) {
            if (image == "" || image == null) {
                var a = document.createElement('a');
                img.src = "http://placehold.it/150x150";
                a.appendChild(img);
                img = a;

            }
            else {
                img.src = "/home/resources/img/" + image;
                img.setAttribute("style", "width: 150px; height: 150px");
                var a = document.createElement('a');
                a.appendChild(img);
                img = a;
            }
        }
        else {
            img.src = "data:image/png;base64," + byteImage;
            img.setAttribute("style", "width: 150px; height: 150px");
            var a = document.createElement('a');
            a.appendChild(img);
            img = a;
        }
        td.appendChild(img);
        return td;
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
            hreffPrev = "/home/admin-config/edit-products-paging?size=" + size + "&page=" + page;
        }
        else {
            hreffPrev = "/home/admin-config/edit-products-paging?size=" + size + "&page=" + (page - 1);
        }
        if (page == pageCount) {
            hreffNext = "/home/admin-config/edit-products-paging?size=" + size + "&page=" + page;
        }
        else {
            hreffNext = "/home/admin-config/edit-products-paging?size=" + size + "&page=" + (Number(page) + 1);
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
        var hreff = "/home/admin-config/edit-products-paging?size=" + size + "&page=" + index;
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
