/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function updateTable() {
    // alert('into updateTable');
    $.ajax({
        type: "GET",
        url: "proyectoIndexServlet",
        async: false,
        success: function(data) {
            console.log(data);
            var trHTML = '';
            var cont = 1;
            $("#tablaProyectos tbody").empty();
            $.each(data, function(key, value) {
                // llenar los datos(key, value) en la tabla 'tablaUsuarios'
                $("#tablaProyectos tbody").append(
                            "<tr>"
                                +"<th scope='row'>"+cont+"</th>"
                                +"<td>"+value.nombre+"</td>"
                                +"<td>"+value.descripcion+"</td>"
                                +"<td>"+value.usuarioResp+"</td>"
                                +'<td><a href="#" data-toggle="modal" data-target="#modalEditProyectos"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>'
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
    $("#newProjectForm").submit(function(e) {
        e.preventDefault();

        $.ajax({
            type: "POST",
            headers: {
                'action': 'CREATE'
            },
            url: "Proyecto",
            data: $("#newUserForm").serialize(),
            success: function(data) {
               alert(data.msg);
                 updateTable();
                // alert('hizo update');
                $("#modalProyectos").modal('hide');
                //window.location = data.url;
            }
        });

    });
});
