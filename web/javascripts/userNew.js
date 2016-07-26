/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function updateTable() {
    // alert('into updateTable');
    $.ajax({
        type: "GET",
        url: "UserIndexServlet",
        async: false,
        success: function(data) {
            var trHTML = '';
            var cont = 1;
            $("#tablaUsuarios tbody").empty();
            $.each(data, function(key, value) {
                // llenar los datos(key, value) en la tabla 'tablaUsuarios'
                $("#tablaUsuarios tbody").append(
                            "<tr>"
                                +"<th scope='row'>"+cont+"</th>"
                                +"<td>"+value.nombre+"</td>"
                                +"<td>"+value.email+"</td>"
                                +"<td>"+value.rol+"</td>"
                                +'<td><a href="#"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>'
                                +'<td><a href="#"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>'
                            +"</tr>" )
                cont++;
            });
        }
    });
}


$(document).ready(function() {
    // alert('update table');
    updateTable();
    $("#newUserForm").submit(function(e) {
        e.preventDefault();

        $.ajax({
            type: "POST",
            url: "UsuarioServletNew",
            data: $("#newUserForm").serialize(),
            success: function(data) {
                alert(data.msg);
                updateTable();
                alert('hizo update');
                $("#modalUsuarios").modal('hide');
                //window.location = data.url;
            }
        });
    });
});
