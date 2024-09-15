//acuatlizar los precios para la boleta
function actualizarPreciosTotalesTabla(input) {
    let cantidad = input.value;
    let precioElement = input.parentNode.previousElementSibling; // Accede a la celda de Precio
    let totalElement = input.parentNode.nextElementSibling; // Accede a la celda de Total

    let precio = parseFloat(precioElement.textContent);
    let total = precio * cantidad;
    
    totalElement.textContent = total;
    actualizarPrecioTotal();
}
function actualizarPrecioTotal() {
    let tabla = document.getElementById('tabla_productos_comprar');
    let filas = tabla.getElementsByTagName('tr');
    let suma_total=0;
    for (let i = 1; i < filas.length; i++) {
        let celdas = filas[i].getElementsByTagName('td');
        let total = celdas[3].textContent;
        suma_total=parseFloat(suma_total)+ parseFloat(total);
    }
    document.getElementById("p_subtotal").textContent = "S/."+suma_total;
}
