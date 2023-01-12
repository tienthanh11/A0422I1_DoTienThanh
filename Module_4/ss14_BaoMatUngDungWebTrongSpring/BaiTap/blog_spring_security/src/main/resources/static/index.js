let baseUrl = window.location.origin;

function showInfoEdit(id, name, content, title, category) {
    document.getElementById("idEdit").value = id;
    document.getElementById("nameEdit").value = name;
    document.getElementById("contentEdit").value = content;
    document.getElementById("titleEdit").value = title;
    document.getElementById("categoryEdit").value = category;
}

function showInfoDelete(id, content) {
    document.getElementById("deleteId").value = id;
    document.getElementById("contentDelete").innerText = content;
}

$(document).ready(function () {
    $('#editData').on('click', function () {
        if ($("#idEdit").val() == null) {
            createData();
            return
        }
        editData();
    });
    $('#deleteData').on('click', function () {
        deleteData();
    });
    $('#closeTopic').on('click', function () {
        window.location = `${baseUrl}`
    })
})

function createData() {
    const data = {
        name: $("#nameEdit").val(),
        content: $("#contentEdit").val(),
        title: $("#titleEdit").val(),
        category: $("#categoryEdit").val()
    }
    $.ajax({
        type: "POST",
        url: `${baseUrl}/api/create`,
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(data),
        success: function () {
            window.location = `${baseUrl}`;
        },
        error: function (event) {
            checkError(event);
        }
    })
}

function editData() {
    const data = {
        id: $("#idEdit").val(),
        name: $("#nameEdit").val(),
        content: $("#contentEdit").val(),
        title: $("#titleEdit").val(),
        category: $("#categoryEdit").val()
    }

    $.ajax({
        type: "PATCH",
        url: `${baseUrl}/api/edit`,
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(data),
        success: function () {
            window.location = `${baseUrl}`;
        },
        error: function (event) {
            checkError(event);
        }
    })
}

function deleteData() {
    $.ajax({
        type: "DELETE",
        url: `${baseUrl}/api/delete/${$("#deleteId").val()}`,
        contentType: "application/json",
        dataType: 'json',
        success: function () {
            window.location = `${baseUrl}`;
        },
        error: function (event) {
            checkError(event);
        }
    })
}

function checkError(data) {
    switch (data.status) {
        case 400:
            $("#errorName").html(data.responseJSON.name);
            $("#errorContent").html(data.responseJSON.content);
            $("#errorTitle").html(data.responseJSON.title);
            break;
        case 404:
            $("#message").html(data.responseJSON.loginError);
            $("#statusModal").modal("show");
            break;
        case 500:
            $("#message").html(data.responseJSON.message);
            $("#statusModal").modal("show");
            break;
    }
}