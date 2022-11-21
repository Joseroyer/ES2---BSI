function ValidaUsuario()
{
    let filtro = document.getElementById("busca");
    fetch("/apis/existe-cliente?filtro="+filtro)
        .then(function (response) {
            return response.json();
        })
        .then(function (text) {
                fetch("/apis/qual-situacao?filtro="+filtro)
                .then(function (response) {
                    return response.json();
                })
                .then(function (text) {
                    window.location.href = "RealizarEmprestimo.html";
                })
                .catch(function (err) {
                    document.getElementById("modal").style.display = "block";
                    console.log('error: ' + err);
                });
        })
        .catch(function (err) {
            alert("Cliente não existente!")
            console.log('error: ' + err);

        });
}