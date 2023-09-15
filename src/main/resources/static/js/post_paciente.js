window.addEventListener('load', function () {
    const formulario = document.querySelector('#guardar_paciente');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        const datosFormulario = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            fechaAlta: document.querySelector('#fecha-alta').value,
            domicilio: {
                calle: document.querySelector('#calle').value,
                numero: document.querySelector('#numero').value,
                provincia: document.querySelector('#provincia').value,
                ciudad: document.querySelector('#ciudad').value,
            }
        };

        const url = '/pacientes';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(datosFormulario)
        };

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Paciente agregado</strong></div>';

                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();
            })
            .catch(error => {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Error, intente nuevamente</strong></div>';

                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();
            });
    });

    function resetUploadForm() {
        formulario.reset();
    }

});