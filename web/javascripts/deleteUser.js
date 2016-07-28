$(document).ready(function() {
    
    var id;

    $('#tablaUsuarios .glyphicon-remove').on( 'click' , function (e)  {
 
        //var xmlHttp = new XMLHttpRequest(); 
        id = $(this).parent().parent().parent().children(':first-child').text();
        var nombre=$(this).parent().parent().parent().children(':nth-child(2)').text();
        var email=$(this).parent().parent().parent().children(':nth-child(3)').text();
        var rol =$(this).parent().parent().parent().children(':nth-child(4)').text();
        console.log(id);


        $.ajax({
            
            url: "UsuariosServletDel",
            data: {"id": id, "nombre":nombre, "email":email, "rol":rol},
            type: "POST"
        });

    } );
} );
