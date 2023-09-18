document.addEventListener("DOMContentLoaded", function() {
    // Obtener la lista de pacientes y odontólogos y llenar los select
    fetch('/turnos/listopacientes')
        .then(response => response.json())
        .then(data => {
            const pacienteSelect = document.getElementById('pacienteSelect');
            data.forEach(paciente => {
                const option = document.createElement('option');
                option.value = paciente.id;
                option.textContent = `${paciente.nombre} ${paciente.apellido}`;
                pacienteSelect.appendChild(option);
            });
        });

    fetch('/turnos/listoodontologos')
        .then(response => response.json())
        .then(data => {
            const odontologoSelect = document.getElementById('odontologoSelect');
            data.forEach(odontologo => {
                const option = document.createElement('option');
                option.value = odontologo.id;
                option.textContent = `${odontologo.nombre} ${odontologo.apellido}`;
                odontologoSelect.appendChild(option);
            });
        });

    // Manejar el formulario de carga de turno
    const turnoForm = document.getElementById('turnoForm');
    turnoForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const pacienteId = document.getElementById('pacienteSelect').value;
        const odontologoId = document.getElementById('odontologoSelect').value;
        const fechaYHora = document.getElementById('fechaYHora').value;

        const turnoData = {
            paciente:{
                id:pacienteId
            },
            odontologo:{
                id:odontologoId
            },
            fechaYHora: fechaYHora
        };

        // Enviar la solicitud POST para crear el turno
        fetch('/turnos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(turnoData)
        })
        .then(response => response.json())
        .then(data => {
            alert('Turno creado con éxito');
            // Limpiar el formulario después de la creación exitosa
            turnoForm.reset();
            console.log(fechaYHora);
        })
        .catch(error => {
            console.error('Error al crear el turno:', error);
            alert('Error al crear el turno. Por favor, inténtelo de nuevo.');
        });
    });
});
