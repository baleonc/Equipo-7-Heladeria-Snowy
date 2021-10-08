function eliminar(Cedula)
{
    swal({
            title: "Esta seguro de Eliminar el registro?",
            text: "Una vez eliminado el registro no puede ser recuperado!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
            .then((OK) => {
                if (OK) {
                    $.ajax({
                        url:"/Home/LogIn/Menu/Module/{module}/OptionCRUD/{actionCRUD}",
                        success: function(res){
                            console.log(res);
                    }
                });
                swal("Poof! el Registro ha sido eliminado!", {
                    icon: "success",
                }).then((ok) => {
                    if(ok){
                        location.href="/listar";
                    }
                });
            } else {
                swal("Su registro NO se ha eliminado!");
            }
        });
}