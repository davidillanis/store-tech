//comportamiento de la barra izquierda
document.querySelector("#btn_menu").addEventListener("click", function(){
    let aulta=document.querySelector("#main_section").offsetHeight-190;
    document.querySelector("#main_aside").style.height=aulta+"px";
    document.querySelector("#main_aside").style.display=document.querySelector("#main_aside").style.display=='block'? 'none': 'block';
});

//para llamar una la funcion de cerrar session de spring boot
function cerrarSession(){
    //alerta de ventana
    Swal
    .fire({
        title: "Session",
        text: "Desea cerrar Session",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: "Sí",
        cancelButtonText: "no",
    })
    .then(resultado => {
        if (resultado.value) {
            //ejecutar la funcion '/cli/cerrar-session' de spring boot
            fetch('http://localhost:8083/cli/cerrar-session')
            .then(response => {
                if (response.ok) {
                    Swal.fire("sesión cerrada exitosamente");
                    //Tiempo de espera
                    setTimeout(() => {
                        window.location.href = '/web/index';
                    }, 1000);
                } else {
                    console.error('Error al cerrar sesión');
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });
        } else {
            // Dijeron que no
            console.log("*NO se elimina la venta*");
        }
    });


}
