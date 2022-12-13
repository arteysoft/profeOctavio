function obtenerEncuentros(callback) {
    fetch('http://localhost/integrador/server.php/encuentro')
        .then(function(response) {
            return response.json();
        })
        .then(function(data) {
            console.log('data = ', data);
            callback(data);
        })
        .catch(function(err) {
            alert(err);
        });
}

function obtenerUsusarios(callback) {
    fetch('http://localhost/integrador/server.php/usuario')
        .then(function(response) {
            if (response.status!==200) {
                return new Promise((resolve, reject)=>{
                    reject('hubo un error*****');
                });    
            }
            return response.json();
        })
        .then(function(data) {
            console.log('data = ', data);
            callback(data);
        })
        .catch(function(err) {
            alert(err);
        });
} 

function obtenerRegistroUsuarios(callback) {
    fetch('http://localhost/integrador/server.php/regusu')
        .then(function(response) {
            if (response.status!==200) {
                return new Promise((resolve, reject)=>{
                    reject('hubo un error*****');
                });    
            }
            return response.json();
        })
        .then(function(data) {
            console.log('data = ', data);
            callback(data);
        })
        .catch(function(err) {
            alert(err);
        });
} 

function realizarRegistroUsuarioEncuentro(idUsu, idEnc, callback) {
    fetch('http://localhost/integrador/server.php/regusu', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin':'*'
        },
        body: JSON.stringify({
            idusuario:idUsu, 
            idencuentro:idEnc})
        })
        .then(function(response) {
            console.log(response);
            if (response.status===400) {
                return new Promise((resolve, reject)=>{
                    reject("Usuario ya registrado");
                });
            }    
            console.log('response =', response);
            return response.json();
        })
        .then(function(data) {
            console.log('data = ', data);
            callback();
        })
        .catch(function(err) {
            alert(err);
        });
}

function borrarRelacionUsuarioEncuentro(idUsu, idEnc, callback) {
    let url = [
        'http://localhost/integrador/server.php/regusu',
        idUsu,
        idEnc
    ].join('/');
    fetch(url, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin':'*'
        }})
        .then(function(response) {
            console.log('response =', response);
            return response.json();
        })
        .then(function(data) {
            console.log('data = ', data);
            callback();
        })
        .catch(function(err) {
            console.error(err);
        });
}