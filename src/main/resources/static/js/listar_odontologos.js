window.addEventListener('load', function () {
    (function(){

      //con fetch invocamos a la API de odontologs con el método GET
      //nos devolverá un JSON con una colección de odontologs
      const url = '/odontologos';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
      //recorremos la colección de odontologs del JSON
         for(odontologo of data){
            //por cada odontolo armaremos una fila de la tabla
            //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos la odontolo
            var table = document.getElementById("tabla-odontologos");
            var odontologoRow =table.insertRow();
            let tr_id = 'tr_' + odontologo.id;
            odontologoRow.id = tr_id;

            //por cada odontolo creamos un boton delete que agregaremos en cada fila para poder eliminar la misma
            //dicho boton invocara a la funcion de java script deleteByKey que se encargará
            //de llamar a la API para eliminar una odontolo
            let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + odontologo.id + '\"' +
                                      ' type="button" oneclick="deleteBy('+odontologo.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

            //por cada odontolo creamos un boton que muestra el id y que al hacerle clic invocará
            //a la función de java script findBy que se encargará de buscar la odontolo que queremos
            //modificar y mostrar los datos de la misma en un formulario.
            let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                      ' type="button" onclick="findBy('+odontologo.id+')" class="btn btn-info btn_id">' +
                                      odontologo.id +
                                      '</button>';

            //armamos cada columna de la fila
            //como primer columna pondremos el boton modificar
            //luego los datos de la odontolo
            //como ultima columna el boton eliminar
            odontologoRow.innerHTML = '<td>' + odontologo.id + '</td>' +
                    '<td class=\"td_titulo\">' + odontologo.nombre.toUpperCase() + '</td>' +
                     '<td class=\"td_titulo\">' + odontologo.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_categoria\">' + odontologo.matricula.toUpperCase() + '</td>' +
                    '<td>' + deleteButton + '</td>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/lista_odontologos.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })


    })