document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('div_registrar').style.display = 'none';
    document.getElementById('div_recuperar').style.display = 'none';
    
    document.getElementById('recuperar_registro').addEventListener('click', function() {
        document.getElementById('div_iniciar_sesion').style.display = 'none';
        document.getElementById('div_registrar').style.display = 'none';
        document.getElementById('div_recuperar').style.display = 'block';
    });
    document.getElementById('registrarse_sesion').addEventListener('click', function() {
        document.getElementById('div_iniciar_sesion').style.display = 'none';
        document.getElementById('div_registrar').style.display = 'block';
        document.getElementById('div_recuperar').style.display = 'none';
    });
    document.getElementById('iniciar_sesion_registro').addEventListener('click', function() {
        document.getElementById('div_iniciar_sesion').style.display = 'block';
        document.getElementById('div_registrar').style.display = 'none';
        document.getElementById('div_recuperar').style.display = 'none';
    });

    document.getElementById('recuperar_sesion').addEventListener('click', function() {
        document.getElementById('div_iniciar_sesion').style.display = 'none';
        document.getElementById('div_registrar').style.display = 'none';
        document.getElementById('div_recuperar').style.display = 'block';
    });
    document.getElementById('registrarse_recuperar').addEventListener('click', function() {
        document.getElementById('div_iniciar_sesion').style.display = 'none';
        document.getElementById('div_registrar').style.display = 'block';
        document.getElementById('div_recuperar').style.display = 'none';
    });
    document.getElementById('iniciar_sesion_recuperar').addEventListener('click', function() {
        document.getElementById('div_iniciar_sesion').style.display = 'block';
        document.getElementById('div_registrar').style.display = 'none';
        document.getElementById('div_recuperar').style.display = 'none';
    });
});