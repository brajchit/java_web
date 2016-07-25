/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
    $("#newUserForm").submit(function(e){
       e.preventDefault();

       $.ajax({
           type: "POST",
           url:  "UsuarioServletNew",
           data: $("#newUserForm").serialize(),
           success: function(data){
            //    if(data.error){
            //        $("#errorLogin").show();
            //        $("#errorLogin").text(data.errormsg);
            //    } else {
            //        window.location = data.url;
            //    }
            alert(data.msg);
                window.location = data.url;
           }
       });
    });
});
