/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var id;
$(document).ready(function() {
    editarProyecto();
    $("#editProyectosForm").submit(function(e) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: "proyectoEditServlet",
            data: $("#editProyectosForm").serialize() + '&id='+ id,
            success: function(data) {
                updateTable();
                editarProyecto();
                alert('hizo update');
                $("#modalEditProyectos").modal('hide');
                //window.location = data.url;
            }
        });  
    });
} );

function editarProyecto(){
    var links = $('#tablaProyectos .glyphicon-edit');
    for (i = 0; i < links.length; i++) {
        links[i].onclick = function(e){
            id = $(this).parent().parent().parent().children(':first-child').text();
            var nombre=$(this).parent().parent().parent().children(':nth-child(2)').text();
            var descripcion=$(this).parent().parent().parent().children(':nth-child(3)').text();
            var usuarioResp =$(this).parent().parent().parent().children(':nth-child(4)').text();
            $('#inputNombreEdit').val(nombre);
            $('#inputDescripcionEdit').val(descripcion);
            $('#inputUsuarioRespEdit').val(usuarioResp);
        } ;
    }
}