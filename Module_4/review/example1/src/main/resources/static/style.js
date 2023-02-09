let baseUrl = window.location.origin;



$(document).ready(function () {
    $("#edit").on("click", function () {
        createNew();
    });
    $("#close").on("click", function () {
      window.location = baseUrl;
    });
    // $("#edit").on("click", function () {
    //
    // })

    $("#editForm").on('hide.bs.modal',function () {
        document.getElementById("idEdit").value = '';
        document.getElementById("nameEdit").value = '';
        document.getElementById("manufacturerEdit").value = '';
        document.getElementById("priceEdit").value = '';
        document.getElementById("emailEdit").value = '';
        document.getElementById("name").value= '';
        document.getElementById("price").value= '';
        document.getElementById("email").value= '';
    })
    $("#deleteThis").on("click", function () {
        deleteThis();
    })
})

function checkError(data) {
    switch (data.status) {
        case 400:
            $("#name").html(data.responseJSON.name);
            $("#price").html(data.responseJSON.price);
            $("#email").html(data.responseJSON.email);
            break;
        case 500:
            $("#editForm").modal("hide");
            $("#message").html("server is maintenance.Try again!!")
            $("#modelConfirm").modal("show");
            break;
    }

}
function createNew() {
    let id = document.getElementById("idEdit").value;
    if(id !== ''){
        saveEdit();
        return
    }

    let name = document.getElementById("nameEdit").value;
    let price = document.getElementById("priceEdit").value;
    let manufacturer = document.getElementById("manufacturerEdit").value;
    let email = document.getElementById("emailEdit").value;
    let category = document.getElementById("categoryEdit").value;

    let jsonText = {
        "name": name,
        "price": price,
        "manufacturer": manufacturer,
        "email": email,
        "category": category,
    }
    console.log(jsonText);

    $.ajax({
        type: "POST",
        url: "/api/",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(jsonText),
        success: function () {
            // alert("create ok ")
            $("#editForm").modal("hide");
            $("#message").html("create ok")
            $("#modelConfirm").modal("show");
        },
        error: function (event) {
            checkError(event)
        }

    })
}
function showInfoDelete(id) {
    document.getElementById("deleteId").value = id;
}
function deleteThis() {
    $.ajax({
        // const id= document.getElementById("deleteId").value;
        type: "DELETE",
        url: `/api/${$("#deleteId").val()}`,
        dataType: "json",
        contentType: "application/json",
        success: function () {
            $("#delete").modal("hide");
            $("#message").html("DELETE   ok")
            $("#modelConfirm").modal("show");
        },
        error: function () {
            $("#editForm").modal("hide");
            $("#message").html("DELETE not ok")
            $("#modelConfirm").modal("show");
        }
    })
}
function showInfoEdit(id, name, price, manufacturer, email, category_id, ) {
    document.getElementById("idEdit").value = id;
    document.getElementById("nameEdit").value = name;
    document.getElementById("priceEdit").value = price;
    document.getElementById("manufacturerEdit").value = manufacturer;
    document.getElementById("emailEdit").value = email;
    document.getElementById("categoryEdit").value = category_id;

}

function saveEdit() {
    let jsonText = {
        "id": document.getElementById("idEdit").value,
        "name": document.getElementById("nameEdit").value,
        "manufacturer": document.getElementById("manufacturerEdit").value,
        "price": document.getElementById("priceEdit").value,
        "email": document.getElementById("emailEdit").value,
        "category": document.getElementById("categoryEdit").value,

    }
    console.log(jsonText);
    $.ajax({
        type: "PATCH",
        url: "/api/",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(jsonText),
        success: function (event) {
            $("#editForm").modal("hide");
            $("#message").html("edit ok")
            $("#modelConfirm").modal("show");
        },
        error: function (event) {
            checkError(event)

        }

    })
}
