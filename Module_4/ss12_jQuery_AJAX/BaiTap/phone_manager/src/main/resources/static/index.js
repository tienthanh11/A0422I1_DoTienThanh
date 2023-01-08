const BASE_URL = window.location.origin;
const MAX_LIMIT = 5;
const BEGIN_PAGE = 0;


$(document).ready(function () {
    $('#getList').on('click', function () {
        getListPhone();
    });
    $('#create').on('click', function () {
        createPhone();
    });
    $('#deleteIt').on('click', function () {
        deletePhone();
    });
    $('#edit').on('click', function () {
        editPhone();
    });
    $('#search').on('click', function () {
        searchPhone();
    });
})

function saveLocalStorage(dataApi) {
    const dataStr = JSON.stringify(dataApi);
    localStorage.setItem('AllPhones', dataStr);
}

function searchPhone() {
    const modelSearch = $('#model_search').val();
    $.ajax({
        type: "GET",
        url: `${BASE_URL}/api?searchModel=${modelSearch}`,
        contentType: "application/json",
        dataType: 'json',
        success: function (event) {
            saveLocalStorage(event);
            document.getElementById("pageController").innerHTML = drawPage(event);
            drawBodyTable(BEGIN_PAGE);
        },
        error: function (event) {
            if (event.status === 404) {
                alert("No phone have " + modelSearch);
            }
        }
    })
}

function editPhone() {
    const newId = $('#idEdit').val();
    // const idnew = document.getElementById("idEdit").value;
    const newProducer = $('#edit-producer').val();
    const newModel = $('#edit-model').val();
    const newPrice = $('#edit-price').val();
    const data = {
        id: newId,
        producer: newProducer,
        model: newModel,
        price: newPrice
    }
    $.ajax({
        type: "PUT",
        url: `${BASE_URL}/api/`,
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(data),
        success: function (event) {
            $('#editModal').modal("hide");
            saveLocalStorage(event);
            drawBodyTable(BEGIN_PAGE);
        },
        error: function (event) {
            $("#error-producer-edit").html(event.responseJSON.producer);
            $("#error-model-edit").html(event.responseJSON.model);
            $("#error-price-edit").html(event.responseJSON.price);
        }
    });
}

function createPhone() {
    const producer = $('#new-producer').val();
    const model = $('#new-model').val();
    const price = $('#new-price').val();
    const data = {
        producer: producer,
        model: model,
        price: price
    }
    $.ajax({
        type: "POST",
        url: `${BASE_URL}/api`,
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(data),
        success: function (event) {
            $('#createModal').modal("hide");
            saveLocalStorage(event)
            drawBodyTable(BEGIN_PAGE);
        },
        error: function (event) {
            $("#error-producer-create").html(event.responseJSON.producer);
            $("#error-model-create").html(event.responseJSON.model);
            $("#error-price-create").html(event.responseJSON.price);
        }
    })
}

function getListPhone() {
    $.ajax({
        type: "GET",
        url: `${BASE_URL}/api`,
        contentType: "application/json",
        dataType: 'json',
        success: function (event) {
            saveLocalStorage(event);
            document.getElementById("pageController").innerHTML = drawPage(event);
            drawBodyTable(BEGIN_PAGE);
        },
        error: function (event) {
            if (event.status === 404) {
                alert("Data empty ! Input something !!!")
            }
        }
    })
}

function drawPage(data) {
    let max_page = Math.ceil(data.length / MAX_LIMIT);
    let page_list = "<ul class='pagination'>";
    for (let i = 0; i < max_page; i++) {
        page_list += `<li class="page-item"><li class="page-item"><button class="page-link" onclick="drawBodyTable(${i})"> ${i + 1}</button></li>`
    }
    return page_list + "</ul>";
}

function drawBodyTable(page) {
    let bodyTable = ""
    const dataStr = localStorage.getItem('AllPhones');
    const phones = JSON.parse(dataStr);
    let i = page * MAX_LIMIT;
    for (let j = 0; j < MAX_LIMIT; j++) {
        if (phones[i] == null) continue;
        bodyTable += drawRecord(j, phones[i++]);
    }

    document.getElementById("bodyTable").innerHTML = bodyTable;
}

function deletePhone() {
    const id = $("#deleteId").val();
    $.ajax({
        type: "PATCH",
        url: `${BASE_URL}/api/${id}`,
        contentType: "application/json",
        dataType: 'json',
        success: function (event) {
            $('#delete').modal("hide");
            // $("[data-dismiss=modal]").trigger({ type: "click" });
            saveLocalStorage(event);
            document.getElementById("pageController").innerHTML = drawPage(event);
            drawBodyTable(BEGIN_PAGE);
            // let checkItem = document.querySelector(".row-" + id);
            // if (checkItem) {
            //     checkItem.remove();
            // }
        },
        error: function (event) {
            alert(event.responseJSON.messageError);
        }

    })
}

function drawRecord(index, row) {
    return `<tr class = "row-${row.id}">
            <td>${index + 1}</td>
            <td>${row.producer}</td>
            <td>${row.model}</td>
            <td>${row.price}</td>
            <td> 
               <button onclick="showInfoDelete(${row.id} ,'${row.model}')" type="button"
                    class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#deleteModal">
                    <i class="fa-solid fa-eraser"></i>
               </button>   
               <button onclick="showInfoEdit(${row.id},'${row.producer}','${row.model}',${row.price})" type="button"
                    class="btn btn-outline-warning" data-bs-toggle="modal" data-bs-target="#editModal">
                    <i class="fa-solid fa-highlighter"></i>
                </button> 
            </tr>`
}

function showInfoDelete(id, model) {
    document.getElementById("deleteId").value = id;
    document.getElementById("nameDelete").innerText = model;
}

function showInfoEdit(id, producer, model, price) {
    document.getElementById("idEdit").value = id;
    document.getElementById("edit-producer").value = producer;
    document.getElementById("edit-model").value = model;
    document.getElementById("edit-price").value = price;
}

window.onload = () => {
    getListPhone();
}
