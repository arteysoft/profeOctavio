function cargarComboEncuentros() {
    obtenerEncuentros(encuentros => {
        let tmpl = $('#templateComboEncuentros').text();
        let html = Mustache.render(tmpl, {lista: encuentros});
        $('#selEncuentro').html(html);
    });
}

function cargaComboUsuarios() {
    obtenerUsusarios(usuarios => {
        let tmpl = $('#templateComboUsuarios').text();
        let html = Mustache.render(tmpl, {lista: usuarios});
        $('#selUsuario').html(html);
    });
}

function cargaTablaEncuentros() {
    obtenerRegistroUsuarios(regUsu => {
        let tmpl = $('#templateTablaPrincipal').text();
        let html = Mustache.render(tmpl, {lista: regUsu});
        $('#tabusucursos').html(html);
    });
}

function controllers() {
    $(document).on('click', '#btnRegistrar', evt => {
        console.log(evt.target.id);
        realizarRegistroUsuarioEncuentro(
            $('#selUsuario')[0].value,
            $('#selEncuentro')[0].value,
            () => { 
                cargaTablaEncuentros();
            }
        );
    })

    $(document).on('click', '.js-borrar', evt => {
        let idUsuario = evt.target.id.split('___')[0];
        let idEvento = evt.target.id.split('___')[1];
        borrarRelacionUsuarioEncuentro(idUsuario, idEvento, () => {
            cargaTablaEncuentros();
        })
    });
}

function initProcess() {
    cargarComboEncuentros();
    cargaComboUsuarios();
    cargaTablaEncuentros();
    controllers();
}

function ejemploGet() {
    obtenerEncuentros(data => {
        data.forEach(element => {
            alert(JSON.stringify(element));
        });
    });
}

function ejemploPostFormulario() {
    fetch('http://localhost:8080/mi', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            'Access-Control-Allow-Origin':'*'
        },
        body: 'a=1&b=2'
        })
        .then(function(response) {
            console.log('response =', response);
            return response.json();
        })
        .then(function(data) {
            console.log('data = ', data);
        })
        .catch(function(err) {
            console.error(err);
        });
}

function ejemploPostObject() {
    fetch('http://localhost:8080/mi', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin':'*'
        },
        body: JSON.stringify({nombre:'aldo', apellido:'sierra'})
        })
        .then(function(response) {
            console.log('response =', response);
            return response.json();
        })
        .then(function(data) {
            console.log('data = ', data);
        })
        .catch(function(err) {
            console.error(err);
        });
}
