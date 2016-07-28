/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*$(document).ready(function() {
    // alert('update table');
    updateTable();
    $("#editUserForm").submit(function(e) {
        e.preventDefault();

        $.ajax({
            type: "POST",
            url: "usuarioServletEditar",
            data: $("#editUserForm").serialize(),
            success: function(data) {
                alert(data.msg);
                updateTable();
                alert('hizo update');
                $("#modalEditUsuarios").modal('hide');
                //window.location = data.url;
            }
        });
    });
});*/
var editor; // use a global for the submit and return data rendering in the examples
 
 var id;
$(document).ready(function() {
    // Activate an inline edit on click of a table cell
    //var id;
    $('#tablaUsuarios .glyphicon-edit').on( 'click', function (e) {
        id = $(this).parent().parent().parent().children(':first-child').text();
        var nombre=$(this).parent().parent().parent().children(':nth-child(2)').text();
        var email=$(this).parent().parent().parent().children(':nth-child(3)').text();
        var rol =$(this).parent().parent().parent().children(':nth-child(4)').text();
        $('#inputNombreEdit').val(nombre);
        $('#inputEmailEdit').val(email);
        if (rol==="Desarrollador") {
            $('#selectRolEdit').val("1");
        } else if (rol==="Diseñador"){
            $('#selectRolEdit').val("2");
        } else if (rol==="Administrador"){
            $('#selectRolEdit').val("3");
        } else {
            $('#selectRolEdit').val("");
        }
        
    } );
    $("#editUserForm").submit(function(e) {
        e.preventDefault();

        console.log(id);
        $.ajax({
            type: "POST",
            url: "usuarioServletEditar",
            data: $("#editUserForm").serialize() + '&id='+ id,
            success: function(data) {
                alert(data.msg);
                updateTable();
                alert('hizo update');
                $("#modalEditUsuarios").modal('hide');
                //window.location = data.url;
            }
        });
        
    });
} );

