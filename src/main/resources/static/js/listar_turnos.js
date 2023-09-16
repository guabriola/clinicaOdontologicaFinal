function cargarTablaTurnos(turnos) {
    const tablaTurnos = document.getElementById('tablaTurnos');
    tablaTurnos.innerHTML = '';

    turnos.forEach(turno => {
        const fila = document.createElement('tr');

        // Realizar una solicitud para obtener los detalles del paciente
        fetch(`/pacientes/${turno.pacienteId}`)
            .then(response => response.json())
            .then(paciente => {
                // Realizar una solicitud para obtener los detalles del odontólogo
                fetch(`/odontologos/${turno.odontologoId}`)
                    .then(response => response.json())
                    .then(odontologo => {
                        fila.innerHTML = `
                            <td>${turno.id}</td>
                            <td>${paciente.nombre} ${paciente.apellido}</td>
                            <td>${odontologo.nombre} ${odontologo.apellido}</td>
                            <td>${new Date(turno.fechaYHora).toLocaleString()}</td>
                        `;
                        tablaTurnos.appendChild(fila);
                    });
            });
    });
}

document.addEventListener("DOMContentLoaded", function() {
    fetch('/turnos')
        .then(response => response.json())
        .then(data => {
            cargarTablaTurnos(data);
        });
});
