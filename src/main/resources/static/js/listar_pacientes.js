window.addEventListener('load', function () {
    (function(){
      const url = '/pacientes/completo';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
        .then(response => response.json())
        .then(data => {
      //recorremos la colección
         for(paciente of data){
            var table = document.getElementById("tabla-pacientes");
            var pacienteRow =table.insertRow();
            let tr_id = 'tr_' + paciente.id;
            pacienteRow.id = tr_id;

            let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + paciente.id + '\"' +
                                      ' type="button" oneclick="deleteBy('+paciente.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

            let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                      ' type="button" onclick="findBy('+paciente.id+')" class="btn btn-info btn_id">' +
                                      paciente.id +
                                      '</button>';

            pacienteRow.innerHTML = '<td>' + paciente.id + '</td>' +
                    '<td class=\"td_titulo\">' + paciente.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_titulo\">' + paciente.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_titulo\">' + paciente.dni + '</td>' +
                    '<td class=\"td_categoria\">' + paciente.fechaAlta + '</td>' +
                    '<td>' + updateButton + '</td>'+
                    '<td>' + deleteButton + '</td>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/get_all_pacientes.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })


    })