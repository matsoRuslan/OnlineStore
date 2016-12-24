$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/home/category/",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            var categories = [];
            for (var i = 0; i < data.length; i++) {
                var stringifiedData = JSON.stringify(data[i]);
                categories.push(JSON.parse(stringifiedData));
            }
            for (var i = 0; i < categories.length; i++) {
                if (categories[i].parent !== null) {
                    createRow(i + 1, categories[i].title, categories[i].parent.title, categories[i].id);
                }
                else {
                    createRow(i + 1, categories[i].title, "No parent", categories[i].id);
                }
            }
            document.getElementById("edit-items").setAttribute("href", "/home/admin-config/edit-products-paging?size=" + totalSize + "&page=1");

        }
    });
    function createRow(index, title, parentCategory, categoryId) {
        var tr = document.createElement("tr");
        tr.appendChild(createTd(index));
        tr.appendChild(createTd(title));
        tr.appendChild(createTd(parentCategory));
        tr.appendChild(createIcon(categoryId));
        document.getElementById("table-body").appendChild(tr);
    }

    function createIcon(categoryId) {
        var td = document.createElement("td");
        var a = document.createElement("a");
        a.setAttribute("id", "edit-category" + categoryId);
        a.setAttribute("href", "/home/admin-config/adm-edit-category?category=" + categoryId);
        a.setAttribute("title", "update category");
        var i2 = document.createElement("a");
        i2.className = "icon-pencil";
        a.appendChild(i2);
        td.appendChild(a);
        return td;
    }

    function createTd(text) {
        var td = document.createElement("td");
        td.innerHTML = "" + text;
        return td;
    }
});
