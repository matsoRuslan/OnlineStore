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
                if (categories[i].hasChildren === true) {
                    if (categories[i].parent !== null) {
                        createParentButtons(categories[i].parent.title + '.' + categories[i].title, categories[i].id);
                    }
                    else  createParentButtons(categories[i].title, categories[i].id);
                }
                else if (categories[i].parent !== null) {

                }
                else createButtons("/home/category/" + categories[i].id, categories[i].title);
            }
            for (var i = 0; i < categories.length; i++) {
                if (categories[i].hasChildren === true) {
                }
                else if (categories[i].parent !== null) {
                    attachToParent(categories[i].parent.id, categories[i].id, categories[i].title);
                }
            }
        }
    });
    function attachToParent(parentID, categoryId, categoryTitle) {
        var parent = document.getElementById("dropdownMenu" + parentID);
        if (parent.childElementCount < 2) {
            var ul = createul();
            ul.appendChild(createChildCategory("/home/category/" + categoryId, categoryTitle));
            parent.appendChild(ul);

        }
        else {
            parent.firstChild.nextSibling.appendChild(createChildCategory("/home/category/" + categoryId, categoryTitle));
        }
    }

    function createChildCategory(href, title) {
        var li = document.createElement("li");
        var a = document.createElement("a");
        a.innerHTML = title;
        a.setAttribute("href", href);
        li.appendChild(a);
        return li;
    }

    function createul() {
        var ul = document.createElement("ul");
        ul.className = "dropdown-menu";
        return ul;
    }

    function createParentButtons(buttonText, dropdownMenuId) {
        var dropdown = createDiv("dropdown");
        dropdown.setAttribute("id", "dropdownMenu" + dropdownMenuId);
        var buttons = document.getElementById("category-buttons");
        var buttonWithDropdown = document.createElement("button");
        buttonWithDropdown.className = "btn btn-default btn-block";
        buttonWithDropdown.setAttribute("type", "button");
        buttonWithDropdown.setAttribute("aria-haspopup", "true");
        buttonWithDropdown.setAttribute("aria-expanded", "true");
        buttonWithDropdown.setAttribute("data-toggle", "dropdown");
        buttonWithDropdown.innerHTML = buttonText;
        var caretSpan = document.createElement("span");
        caretSpan.className = "caret";
        buttonWithDropdown.appendChild(caretSpan);
        buttons.appendChild(dropdown);
        dropdown.appendChild(buttonWithDropdown);
    }

    function createButtons(href, buttonText) {
        var buttons = document.getElementById("category-buttons");
        var buttonWithoutDropdown = document.createElement("button");
        buttonWithoutDropdown.className = "btn btn-default ";
        buttonWithoutDropdown.setAttribute("type", "button");
        buttonWithoutDropdown.setAttribute("aria-haspopup", "true");
        buttonWithoutDropdown.setAttribute("aria-expanded", "true");
        var a = document.createElement("a");
        a.innerHTML = buttonText;
        a.setAttribute("href", href);
        a.setAttribute("style", "text-decoration: none; color: black");
        buttonWithoutDropdown.appendChild(a);
        buttons.appendChild(buttonWithoutDropdown);
    }

    function createDiv(className) {
        var div = document.createElement("div");
        div.className = className;
        return div;
    }
});