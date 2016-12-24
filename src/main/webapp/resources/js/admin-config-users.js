$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/home/user/",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            var users = [];
            for (var i = 0; i < data.length; i++) {
                var stringifiedData = JSON.stringify(data[i]);
                if (JSON.parse(stringifiedData).role.role !== "ADMIN") {
                    users.push(JSON.parse(stringifiedData));
                }
            }
            for (var i = 0; i < users.length; i++) {
                createRow(i + 1, users[i].firstName, users[i].lastName, users[i].userName, users[i].email, users[i].phoneNumber, users[i].address, users[i].id, users[i].active);
                $("#active" + users[i].id).click({param1: users[i].id}, activeClick);
                $("#deactive" + users[i].id).click({param1: users[i].id}, deActiveClick);
            }
            document.getElementById("edit-items").setAttribute("href", "/home/admin-config/edit-products-paging?size=" + totalSize + "&page=1");

        }
    });
    function createRow(index, firstName, lastName, userName, email, phoneNumber, address, userId, active) {
        var tr = document.createElement("tr");
        tr.appendChild(createTd(index));
        tr.appendChild(createTd(firstName));
        tr.appendChild(createTd(lastName));
        tr.appendChild(createTd(userName));
        tr.appendChild(createTd(email));
        tr.appendChild(createTd(phoneNumber));
        tr.appendChild(createTd(address));
        tr.appendChild(createIcons(userId, active));
        document.getElementById("table-body").appendChild(tr);
    }

    function createIcons(userId, active) {
        var td = document.createElement("td");
        var a = document.createElement("a");
        if (active == true) {
            a.setAttribute("id", "active" + userId);
            a.setAttribute("title", "deactivate user");
        }
        else {
            a.setAttribute("id", "deactive" + userId);
            a.setAttribute("title", "activate user");
        }
        var i = document.createElement("i");
        if (active == true) {
            i.className = "icon-ok";
        }
        else {
            i.className = "icon-remove";
        }
        i.innerHTML = "&nbsp";
        a.appendChild(i);
        var a2 = document.createElement("a");
        a2.setAttribute("id", "edit-user" + userId);
        a2.setAttribute("href", "/home/admin-config/adm-edit-user?user=" + userId);
        a2.setAttribute("title", "update user");
        var i2 = document.createElement("a");
        i2.className = "icon-pencil";
        a2.appendChild(i2);
        td.appendChild(a);
        td.appendChild(a2);
        return td;
    }

    function createTd(text) {
        var td = document.createElement("td");
        td.innerHTML = "" + text;
        return td;
    }

    function activeClick(userId) {
        $.ajax({
            type: "post",
            contentType: "application/json; charset=utf-8",
            url: "set-user-inactive",
            data: "" + userId.data.param1,
            success: function () {
            }
        });
        location.reload();
    }

    function deActiveClick(userId) {
        $.ajax({
            type: "post",
            contentType: "application/json; charset=utf-8",
            url: "set-user-active",
            data: "" + userId.data.param1,
            success: function () {
            }
        });
        location.reload();
    }
});
