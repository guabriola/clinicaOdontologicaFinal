// Función para eliminar un odontólogo por ID
function deleteBy(id) {
    const url = '/odontologos/' + id;
    const settings = {
        method: 'DELETE'
    };

    fetch(url, settings)
        .then(response => {
            if (response.ok) {

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

// Función que muestra los campos del odontologo en el formulario de actualización
function findBy(id) {
    const url = '/odontologos/' + id;
    fetch(url)
        .then(response => response.json())
        .then(data => {
            // Relleno formulario de actualización con los datos del odontólogo
            document.getElementById('odontologo_id').value = data.id;
            document.getElementById('nombre').value = data.nombre;
            document.getElementById('apellido').value = data.apellido;
            document.getElementById('matricula').value = data.matricula;
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

// Función para mostrar el formulario de actualización
function showUpdateForm() {
    const updateForm = document.getElementById('div_odontologos_updating');
    updateForm.style.display = 'block';
}

//Oculto el formulario de actualización
function hideUpdateForm() {
    const updateForm = document.getElementById('div_odontologos_updating');
    updateForm.style.display = 'none';
}

// Función para actualizar un odontólogo
function updateOdontologo() {
    const id = document.getElementById('odontologo_id').value;
    const nombre = document.getElementById('nombre').value;
    const apellido = document.getElementById('apellido').value;
    const matricula = document.getElementById('matricula').value;

    const url = '/odontologos'
    const data = {
        id: id,
        nombre: nombre,
        apellido: apellido,
        matricula: matricula
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
        // con fetch invocamos a la API de odontologs con el método GET
        // nos devolverá un JSON con una colección de odontologs
        const url = '/odontologos';
        const settings = {
            method: 'GET'
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                // recorremos la colección de odontologs del JSON
                for (odontologo of data) {
                    // por cada odontolo armaremos una fila de la tabla
                    // cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos la odontolo
                    var table = document.getElementById("tabla-odontologos");
                    var odontologoRow = table.insertRow();
                    let tr_id = 'tr_' + odontologo.id;
                    odontologoRow.id = tr_id;

                    // armamos cada columna de la fila
                    // como primer columna pondremos el boton modificar
                    // luego los datos de la odontolo
                    // como ultima columna el boton eliminar
                    odontologoRow.innerHTML = '<td>' + odontologo.id + '</td>' +
                        '<td class=\"td_titulo\">' + odontologo.nombre.toUpperCase() + '</td>' +
                        '<td class=\"td_titulo\">' + odontologo.apellido.toUpperCase() + '</td>' +
                        '<td class=\"td_categoria\">' + odontologo.matricula.toUpperCase() + '</td>' +
                        '<td>' + '<button id="btn_id_' + odontologo.id + '" type="button" onclick="findBy(' + odontologo.id + ')" class="btn btn-info btn_id">' + odontologo.id + '</button>' + '</td>' +
                        '<td>' + '<button id="btn_delete_' + odontologo.id + '" type="button" onclick="deleteBy(' + odontologo.id + ')" class="btn btn-danger btn_delete">&times</button>' + '</td>';
                }
            });
    })();

    (function () {
        let pathname = window.location.pathname;
        if (pathname == "/lista_odontologos.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    });

    const updateForm = document.getElementById('update_odontologos_form');

    updateForm.addEventListener('submit', function (event) {
        event.preventDefault();

        // Llama a la función para actualizar el odontólogo
        updateOdontologo();
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