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
    fetch("/apis/listar_livros")
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
        document.getElementById("livro_fk").innerHTML = resp;
    }
}

function exibirEditoras() {
    fetch("/apis/listar-todas-editoras")
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
            resp += `<option value="` + (i + 1) + `">` + `${data[i].nome_editora}</option>`;
        document.getElementById("editora_fk").innerHTML = resp;
    }
}


function abrir() {
    document.getElementById("modal").style.display = 'block'
    exibirLivros();
    exibirEditoras();
}

function salvar1() {

    const URL_TO_FETCH = `/apis/saveExemplar`;
    fetch(URL_TO_FETCH, { headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' }, method: 'POST' })
        .then(function (response) {
            if (response.ok) {
                document.getElementById("error").style.display = 'none';
                document.getElementById("cadastrado").style.display = "block";
                // window.location.href = "RegistrarExemplar.html";
                return response.json();
            }
        })
        .catch(function (err) {
            document.getElementById("error").style.display = 'block';
        });
}
function salvar() {
    const URL = "/apis/saveExemplar";
    var fdados = document.getElementById("fdados");
    var jsontext = JSON.stringify(Object.fromEntries(
        new FormData(fdados)));
    fetch(URL, {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'POST', body: jsontext
    })
        .then(function (response) {
            if (response.ok) {
                document.getElementById("error").style.display = 'none';
                document.getElementById("cadastrado").style.display = "block";
                // window.location.href = "RegistrarExemplar.html";
                return response.json();
            }
        })
        .catch(function (error) {
            document.getElementById("error").style.display = 'block';
        });

}

function closeModal() {
    document.getElementById("modal").style.display = 'none'
}

function validarQuantidade() {
    let qtd = document.getElementById("qtd");
    console.log(qtd.value);
    if (qtd.length < 1) {
        qtd.style.border = "solid 2px #00B9BC";
        document.getElementById("resultado_qtd").display.style = block;
    }
}