function CarregaLista() {
    const URL_TO_FETCH = '/apis/listar_exemplares';
    fetch(URL_TO_FETCH, {
            method: 'Post',
            headers: { 'Authorization': `${localStorage.getItem("token")}`, }
        })
        .then(response => response.text())
        .then(result => {
            fetch("/apis/listar_exemplares")
                .then(function(response) {
                    return response.json();
                })
                .then(function(data) {
                    appendData(data);
                })
                .catch(function(err) {
                    console.log('error: ' + err);
                });

            function appendData(data) {
                console.log(data);
                var table = "";
                var string;
                var aux;
                table += `<tr><th>#</th><th>Livro</th><th>Editora</th><th>Quantidade</th><th>Ano Publicado</th><th>Editar</th><th>Excluir</th></tr>`
                for (let i = 0; i < data.length; i++) {
                    aux = data[i].ano_publicado.split("T")[0].split("-");
                    string = aux[2] + "/" + aux[1] + "/" + aux[0];
                    table += `<tr>
                            <td>${data[i].id}</td>
                            <td>${data[i].livro_fk.titulo_livro}</td>
                            <td>${data[i].editora_fk.nome_editora}</td>
                            <td>${data[i].qtd}</td> 
                            <td>${string}</td>                            
                            <td><img width="30px" src='img/change.png' onclick='editar(${data[i].id})'></td>
                            <td><img width="30px" src='img/trash.png' onclick='excluir(${data[i].id})'></td>
                            </tr>`;
                }
                document.getElementById("tbody").innerHTML = table;
            }
        })
        .catch(err => console.error(err));
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
            method: 'POST',
            body: jsontext
        })
        .then(function(response) {
            if (response.ok) {
                document.getElementById("error").style.display = 'none';
                document.getElementById("cadastradoExemplar").style.display = "block";
                window.location.href = "RegistrarExemplar.html";
                return response.json();
            }
        }).catch(function(error) {
            document.getElementById("error").style.display = 'block';
        });

}

function validarQuantidade() {
    var qtd = document.getElementById("qtd");
    if (qtd.value < 1 || qtd.value > 9999) {
        qtd.value = "";
        qtd.style.border = "solid 2px #00B9BC";
        document.getElementById("error_quantidade").style.display = "block";
    }
}
// function validarData() {
//     var data = document.getElementById("ano_publicado").replaceAll("-", "");
//     var hoje = new Date();
//     console.log("🚀 ~ file: RegistrarExemplar.js ~ line 55 ~ validarData ~ data", data)
//     alert(data);

//     if (data.value > Data().getYear()) {
//         data.value = "";
//         data.style.border = "solid 2px #00B9BC";
//         document.getElementById("resultado_ano_publicado").style.display = "block";
//     }
// }
function excluir(id) {
    console.log(id);
    if (window.confirm("Deseja realmente excluir o Exemplar?")) {
        fetch("/apis/excluirExemplar?id=" + id)
            .then(function(response) {
                return response.json();
            })
            .then(function(text) {
                window.location.href = "RegistrarExemplar.html";
            })
            .catch(function(err) {
                console.log('error: ' + err);
            });
    }
}

function exibirLivros() {
    fetch("/apis/listar_livros")
        .then(function(response) {
            return response.json();
        })
        .then(function(data) {
            appendData(data);
        })
        .catch(function(err) {
            console.log('error: ' + err);
        });

    function appendData(data) {
        var resp = "";
        for (let i = 0; i < data.length; i++)
            resp += `<option value="` + (i + 1) + `">` + `${data[i].titulo_livro}</option>`;
        document.getElementById("livro_fk").innerHTML = resp;
    }
}

function exibirEditoras() {
    fetch("/apis/listar-todas-editoras")
        .then(function(response) {
            return response.json();
        })
        .then(function(data) {
            appendData(data);
        })
        .catch(function(err) {
            console.log('error: ' + err);
        });

    function appendData(data) {
        var resp = "";
        for (let i = 0; i < data.length; i++)
            resp += `<option data-tokens="${data[i].nome_editora}" value="` + (i + 1) + `">` + `${data[i].nome_editora}</option>`;
        document.getElementById("editora_fk").innerHTML = resp;
    }
}


function abrir() {
    document.getElementById("modal").style.display = 'block'
    exibirLivros();
    exibirEditoras();
}



function closeModal() {
    document.getElementById("modal").style.display = 'none'
}


function editar(id) {
    // alert(id)
    document.getElementById("modal_editar").style.display = 'block'
    document.getElementById("id").value = id;

    const URL_TO_FETCH = `/apis/listar-bi?Identificador=${id}`;
    fetch(URL_TO_FETCH, { headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' }, method: 'POST' })
        .then(function(response) {
            response.json().then(valores => {
                appendData(valores);
            });
        })
        .catch(function(err) {
            console.log(err);
        });

    function appendData(data) {
        console.log(data);
        var nome = data.nome;
        document.getElementById("novo_nome").value = nome;
        var telefone = data.telefone;
        document.getElementById("novo_telefone").value = telefone;
        var email = data.email;
        document.getElementById("novo_email").value = email;

    }

}

//var input = `<th><input type="text" id="teste"><input type="submit" value="Alterar" onclick='editar2(${id})'></th>`;
//document.getElementById("qlq").innerHTML+=input;


function editar2() {
    // var Identificador=id;
    let Identificador = document.getElementById("id").value;
    let Quantidade = document.getElementById("novo_qtd").value;
    let Data = document.getElementById("novo_ano_publicado").value;

    const URL_TO_FETCH = `/apis/editarExemplar?Identificador=${Identificador}&Quantidade=${Quantidade}&Data=${Data}`;
    fetch(URL_TO_FETCH, { headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' }, method: 'POST' })
        .then(function(response) {
            return response.json();
        })
        .then(function(text) {
            document.getElementById("cadastrado").style.display = "block";
            window.location.href = "RegistrarExemplar.html";
        })
        .catch(function(err) {
            console.log('error: ' + err);
        });

}