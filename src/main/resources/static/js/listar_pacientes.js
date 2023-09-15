// Función para eliminar un paciente por ID
function deleteBy(id) {
    const url = '/pacientes/' + id;
    const settings = {
        method: 'DELETE'
    };

    fetch(url, settings)
        .then(response => {
            if (response.ok) {
                // Eliminación hecha, elimino la fila de la tabla
                const row = document.getElementById('tr_' + id);
                if (row) {
                    row.remove();
                }
            } else {
                // TODO Acá tengo que manejar los Errores
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

// Función muestra los campos del paciente en el formulario de actualización
function findBy(id) {
    const url = '/pacientes/completo/' + id;
    fetch(url)
        .then(response => response.json())
        .then(data => {
            // Relleno formulario de actualización con los datos del paciente
            document.getElementById('paciente_id').value = data.id;
            document.getElementById('nombre').value = data.nombre;
            document.getElementById('apellido').value = data.apellido;
            document.getElementById('dni').value = data.dni;
            document.getElementById('fecha-alta').value = data.fechaAlta;
            document.getElementById('id-direccion').value = data.domicilio.id;
            document.getElementById('calle').value = data.domicilio.calle;
            document.getElementById('numero').value = data.domicilio.numero;
            document.getElementById('provincia').value = data.domicilio.provincia;
            document.getElementById('ciudad').value = data.domicilio.ciudad;
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

// Función para mostrar el formulario de actualización
function showUpdateForm() {
    const updateForm = document.getElementById('div_actualizar_paciente');
    updateForm.style.display = 'block';
}

//Oculto el formulario de actualización
function hideUpdateForm() {
    const updateForm = document.getElementById('div_actualizar_paciente');
    updateForm.style.display = 'none';
}

// Función para actualizar un paciente
function updatePaciente() {

    const id = document.getElementById('paciente_id').value;
    const nombre = document.getElementById('nombre').value;
    const apellido = document.getElementById('apellido').value;
    const dni = document.getElementById('dni').value;
    const fechaAlta = document.getElementById('fecha-alta').value;
    const idDomicilio = document.getElementById('id-direccion').value;
    const calle = document.getElementById('calle').value;
    const numero = document.getElementById('numero').value;
    const provincia = document.getElementById('provincia').value;
    const ciudad = document.getElementById('ciudad').value;


    const url = '/pacientes'
    const data = {
        id: id,
        nombre: nombre,
        apellido: apellido,
        dni: dni,
        fechaAlta: fechaAlta,
        domicilio: {
            id: idDomicilio,
            calle: calle,
            numero: numero,
            provincia: provincia,
            ciudad: ciudad
        }
    };

    const settings = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    };

    fetch(url, settings)
        .then(response => {
            if (response.ok) {
                console.log(data);
                // La actualización fué hecha
                //Todo Ver opciones de mensajes
            } else {
                // TODO trabajar errores de actualización
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

document.addEventListener('DOMContentLoaded', function () {
    (function () {
        // con fetch invocamos a la API de Pacientes con el método GET
        // nos devolverá un JSON con una colección de pacientes
        const url = '/pacientes/completo';
        const settings = {
            method: 'GET'
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                // recorro la colección de pacientes del JSON
                for (paciente of data) {
                    // por cada paciente armaremos una fila de la tabla
                    // cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos la paciente
                    var table = document.getElementById("tabla-pacientes");
                    var pacienteRow = table.insertRow();
                    let tr_id = 'tr_' + paciente.id;
                    pacienteRow.id = tr_id;

                    // armamos cada columna de la fila
                    // como primer columna pondremos el boton modificar
                    // luego los datos del paciente
                    // como ultima columna el boton eliminar
                    pacienteRow.innerHTML = '<td>' + paciente.id + '</td>' +
                        '<td class=\"td_titulo\">' + paciente.nombre.toUpperCase() + '</td>' +
                        '<td class=\"td_titulo\">' + paciente.apellido.toUpperCase() + '</td>' +
                        '<td class=\"td_titulo\">' + paciente.dni + '</td>' +
                        '<td class=\"td_categoria\">' + paciente.fechaAlta + '</td>' +
                        '<td>' + '<button id="btn_id_' + paciente.id + '" type="button" onclick="findBy(' + paciente.id + ')" class="btn btn-info btn_id">' + paciente.id + '</button>' + '</td>' +
                        '<td>' + '<button id="btn_delete_' + paciente.id + '" type="button" onclick="deleteBy(' + paciente.id + ')" class="btn btn-danger btn_delete">&times</button>' + '</td>';
                }
            });
    })();

    (function () {
        let pathname = window.location.pathname;
        if (pathname == "/lista_pacientes.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    });

    const updateForm = document.getElementById('update_paciente_form');

    updateForm.addEventListener('submit', function (event) {
        event.preventDefault();

        // Llama a la función para actualizar el paciente
        updatePaciente();
        //Oculta el formulario
        hideUpdateForm();
        //Recarga la página
        location.reload();
    });

    // Event listener para el botón de actualizar en la fila de la tabla
    document.addEventListener('click', function (event) {
        if (event.target.classList.contains('btn_id')) {
            const id = event.target.id.split('_')[2];
            findBy(id);
            showUpdateForm(); // Llama a la función para mostrar el formulario
        }
    });
});