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
            console.log("entra a la tabla");
            $("#tablaProyectos tbody").empty();
            $.each(data, function(key, value) {
                // llenar los datos(key, value) en la tabla 'tablaProyectos'
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
<<<<<<< HEAD
            headers: {
                'action': 'CREATE'
            },
            url: "Proyecto",
            data: $("#newUserForm").serialize(),
=======
            url: "ProyectoServletNew",
            data: $("#newProjectForm").serialize(),
>>>>>>> 500fb6a150d34eb4ca9c40cf52aa475492ef33b3
            success: function(data) {
                alert(data.error);
                // updateTable();
                // alert('hizo update');
                $("#modalProyectos").modal('hide');
                //window.location = data.url;
            }
        });

    });
});
