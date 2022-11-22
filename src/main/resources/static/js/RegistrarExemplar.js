function CarregaLista() {
    const URL_TO_FETCH = '/apis/listar_exemplares';
    fetch(URL_TO_FETCH, {
        method: 'Post',
        headers: { 'Authorization': `${localStorage.getItem("token")}`, }
    })
        .then(response => response.text())
        .then(result => {
            fetch("/apis/listar_exemplares")
                .then(function (response) {
                    return response.json();
                })
                .then(function (data) {
                    appendData(data);
                })
                .catch(function (err) {
                    console.log('error: ' + err);
                });
            function appendData(data) {
                console.log(data);
                var table = "";
                table += `<tr><th>#</th><th>Livro</th><th>Editora</th><th>Quantidade</th><th>Ano Publicado</th><th>Editar</th><th>Excluir</th></tr>`
                for (let i = 0; i < data.length; i++) {
                    table += `<tr>
                            <td>${data[i].id}</td>
                            <td>${data[i].livro_fk.titulo}</td>
                            <td>${data[i].editora_fk.nome_editora}</td>
                            <td>${data[i].qtd}</td> 
                            <td>${data[i].ano_publicado}</td>                            
                            <td><img width="30px" src='img/change.png' onclick='editar(${data[i].id})'></td>
                            <td><img width="30px" src='img/trash.png' onclick='excluir(${data[i].id})'></td>
                            </tr>`;
                }
                document.getElementById("tbody").innerHTML = table;
            }
        })
        .catch(err => console.error(err));
}
function excluir(id) {
    console.log(id);
    if (window.confirm("Deseja realmente excluir o Exemplar?")) {
        fetch("/apis/excluirExemplar?id=" + id)
            .then(function (response) {
                return response.json();
            })
            .then(function (text) {
                window.location.href = "RegistrarExemplar.html";
            })
            .catch(function (err) {
                console.log('error: ' + err);
            });
    }
}

function exibirLivros() {
    fetch("/api/listar-exemplares")
        .then(function (response) {
            return response.json();
        })
        .then(function (data) {
            appendData(data);
        })
        .catch(function (err) {
            console.log('error: ' + err);
        });
    function appendData(data) {

        var resp = "";
        for (let i = 0; i < data.length; i++)
            resp += `<option value="` + (i + 1) + `">` + `${data[i].titulo}</option>`;
        document.getElementById("categoria").innerHTML = resp;
    }
}
// window.onload = Function => {
//     exibirLivros();
// }

function abrir() {
    document.getElementById("modal").style.display = 'block'
}

function salvar() {

    const URL_TO_FETCH = `/apis/saveExemplar`;
    fetch(URL_TO_FETCH, { headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' }, method: 'POST' })
        .then(function (response) {
            return response.json();
        })
        .then(function (text) {
            document.getElementById("cadastrado").style.display = "block";
            window.location.href = "ExcluirUsuario.html";
        })
        .catch(function (err) {
            console.log('error: ' + err);
        });
}

function closeModal() {
    document.getElementById("modal").style.display = 'none'
}