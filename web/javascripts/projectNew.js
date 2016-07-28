/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function addNewProyTable( dataTableProys, data ){
    // llenar los datos(key, value) en la tabla 'tablaProyectos'
    var id = dataTableProys.rows().count() + 1;
                var newProy = $("<tr>").append("<th scope='row'>"+id+"</th>")
                                       .append("<td>"+data.nombre+"</td>")
                                       .append("<td>"+data.descripcion+"</td>")
                                       .append("<td>"+data.usuarioResp+"</td>")
                                       .append('<td><a href="#" data-toggle="modal" data-target="#modalEditProyectos"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>')
                                       .append('<td><a href="#"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>');
                dataTableProys.row.add(newProy);
}



function updateTable( dataTableProys ) {
    // alert('into updateTable');
    $.ajax({
        type: "GET",
        url: "proyectoIndexServlet",
        success: function(data) {
//            console.log(data);
            $("#tablaProyectos tbody").empty();
            $.each(data, function(key, value) {
                // llenar los datos(key, value) en la tabla 'tablaProyectos'
                addNewProyTable( dataTableProys, value );
            });
            dataTableProys.draw();
        }
    });
}



/*
 * Main function principal that init when page is rear.
 * and open the template in the editor.
 */
$(document).ready(function() {
    // alert('update table');
    var dataTableProys = $('#tablaProyectos').DataTable({
                                "language": {
                                    url: 'i18n/dt-spanish.json'
                                },
                                "aoColumnDefs": [
                                    { 'bSortable': false, 'aTargets': [ 4, 5 ] }
                                 ]
                            });
           
    updateTable( dataTableProys );
    
    $("#newProjectForm").submit(function(e) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            headers: {
                'action': 'CREATE'
            },
            url: "ProyectoServlet",
            data: $("#newProjectForm").serialize(),
            success: function(data) {
                console.log(data)
                var value = data.proyect;
                
                //insert new row
                addNewProyTable( dataTableProys, value );
//                dataTableProys.draw();
                var pag = dataTableProys.page();
                console.log("pag: "+ pag);
                dataTableProys.draw(false);
                
                $("#modalProyectos").modal('hide');
                
            }
        });

    });
});
