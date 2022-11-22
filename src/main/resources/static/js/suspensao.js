//Validar RA suspensão.
function somenteNumeros(num) {
    var er = /[^0-9.]/;
    er.lastIndex = 0;
    var campo = num;
    if (er.test(campo.value)) {
        campo.value = "";
        alert("Informe apenas números.");
      campo.style.border = "solid 2px red";
      return false;
    }
    else return true;
}

function validarNome() {
    nome = document.querySelector("#empsus");
    if (nome.value.length < 6) {
        nome.value = "";
        alert("Dados inseridos menor que 6 dígitos.");
        nome.style.border = "solid 2px red";
        return false;
    }
    return true;
}

//validações acima.
//remover uma suspensao
function excluir(id)
{
    alert(id);
    if(window.confirm("Remover essa suspensao?"))
    {
        fetch("/apis/remover-suspensao?id="+id)
        .then(function (response) {
            return response.json();
        })
        .then(function (text) {
            window.location.href = "suspensao.html";
        })
        .catch(function (err) {
            console.log('error: ' + err);
        });
    }
}

function CadastrarSusp() {
    const URL = "/apis/Cadastrar-Suspensao";
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
            if(response.ok){
                alert("Cadastrado");
                return response.text();
            }
            else throw Error;
        })
        .catch(function (error) {
            console.error(error);
        });
    event.preventDefault("fdados");
}



























//Filtro para gerenciar a parte de suspensao cadastradas.
function CarregaFiltro()
{
    var filtro = document.getElementById("--").value
    const URL_TO_FETCH = '/apis/listar-um-titulo';
    var status;
    fetch(URL_TO_FETCH, {method: 'POST',
       headers:{'Authorization':`${localStorage.getItem("token")}`,}})
    .then(response=> response.text())
    .then(result=> 
        {
                fetch("/apis/listar-um-titulo?filtro="+filtro)
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


                    var table="";
                    table+=`<tr><th>ID</th><th>Titulo</th><th>Editar</th><th>Excluir dados</th></tr>`
                    for (let i=0;i<data.length;i++)
                    {
                            table+=`<tr>
                            <td>${data[i].id_livro}</td>
                            <td>${data[i].titulo_livro}</td>
                            <td><img width="30px" src='img/change.png'onclick='editar (${data[i].id_livro})'></td>
                            <td><img width="30px" src='img/trash.png' onclick='excluir(${data[i].id_livro})'></td>
                            </tr>`;        
                    }
                    document.getElementById("tab").innerHTML=table;
                }
            }
        )
    .catch(err=> console.error(err));
}

