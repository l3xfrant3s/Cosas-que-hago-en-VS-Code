// Obtener el valor almacenado del contador o establecerlo en 0 si no existe
let contador = parseInt(localStorage.getItem('contador')) || 0;

// Función para incrementar el contador
function incrementarContador() {
    contador++;
    actualizarContador();
}

// Función para reiniciar el contador
function resetearContador() {
    contador = 0;
    actualizarContador();
}

// Función para actualizar el contador en la pantalla y almacenarlo localmente
function actualizarContador() {
    const contadorElemento = document.getElementById('contador');
    contadorElemento.innerText = contador;

    // Almacenar el contador en el almacenamiento local del navegador
    localStorage.setItem('contador', contador.toString());
}

// Inicializar el contador al cargar la página
actualizarContador();