//carregar lista
function CarregaLista()
{
    var filtro = document.getElementById("buscartitulo").value
    const URL_TO_FETCH = '/apis/listar-titulos';
    var status;
    fetch(URL_TO_FETCH, {method: 'POST',
       headers:{'Authorization':`${localStorage.getItem("token")}`,}})
    .then(response=> response.text())
    .then(result=> 
        {
                fetch("/apis/listar-titulos")
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
                    table+=`<tr><th>ID</th><th>Titulo</th><th>Qtde</th><th>Autor</th><th>Genero</th><th>Editar</th><th>Excluir dados</th></tr>`
                    for (let i=0;i<data.length;i++)
                    {
                            table+=`<tr>
                            <td>${data[i].id_livro}</td>
                            <td>${data[i].titulo_livro}</td>
                            <td>${data[i].quantidade}</td>
                            <td>${data[i].genero_id_generofk}</td>
                            <td>${data[i].autor_autor_nome}</td>
                            <td><img width="30px" src='img/change.png' onclick='editar(${data[i].id_livro})'></td>
                            <td><img width="30px" src='img/trash.png' onclick='excluir(${data[i].id_livro})'></td>
                            </tr>`;        
                    }
                    document.getElementById("tab").innerHTML=table;
                }
            }
        )
    .catch(err=> console.error(err));
}


function editar(id)
{
   
    var input = `<td><input type="text" id="edt"><input type="submit" value="Alterar" onclick='editar2(${id})'></td>`;
    document.getElementById("tab").innerHTML+=input;
   
}
function editar2(id)
{
    var Identificador=id;
    var Nome = document.getElementById("edt").value
    
    const URL_TO_FETCH = `/apis/editar-titulos-gerenciados?Identificador=${Identificador}&Nome=${Nome}`;
    fetch(URL_TO_FETCH,{headers: {'Accept': 'application/json','Content-Type': 'application/json'}, method: 'POST'})
    .then(function (response) {
      
        return response.json();
    })
    .then(function (text) {
        window.location.href = "gerentitulos.html";
    })
    .catch(function (err) {
        console.log('error: ' + err);
    });

}

function Cadastrar() {
    const URL = "/apis/CadastrarNovosTitulos";
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

async function Cadastrar1()
{

    var data = JSON.stringify(Object.fromEntries(new FormData(fdados)));
    var response = await fetch("/apis/CadastrarNovosTitulos",{headers: {'Accept': 'application/json','Content-Type': 'application/json'}, method: 'POST', body: data});
    var userData = await response.text();
    return userData;
 

}


function excluir(id)
{
    alert(id);
    if(window.confirm("Remover mesmo o titulo?"))
    {
        fetch("/apis/excluir-titulo?id="+id)
        .then(function (response) {
            return response.json();
        })
        .then(function (text) {
            window.location.href = "gerentitulos.html";
        })
        .catch(function (err) {
            console.log('error: ' + err);
        });
    }
   
}


function CarregaFiltro()
{
    var filtro = document.getElementById("buscartitulo").value
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

function somenteNumeros(num) {
    var er = /[^0-9.]/;
    er.lastIndex = 0;
    var campo = num;
    if (er.test(campo.value)) {
      campo.value = "";
    }
}


function ExibirGenero()
{
    fetch("/apis/listar-todos-generos")
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

        var resp="";
        for (let i=0;i<data.length;i++)
            resp+=`<option value="`+(i+1)+`">`+`${data[i].nome}</option>`;        
        document.getElementById("genero_id_generofk").innerHTML=resp;
    }
    
}


function validarNome() {
    nome = document.querySelector("#titulo_livro");
    if (nome.value.length < 8) {
        nome.value = "";
        nome.style.border = "solid 2px red";
        return false;
    }
    return true;
}

function validarGenero() {
    nome = document.querySelector("#genero_id_generofk");
    if (nome.value.length < 8) {
        nome.value = "";
        nome.style.border = "solid 2px red";
        return false;
    }
    return true;
}

function validarAutor() {
    nome = document.querySelector("#autor_autor_nome");
    if (nome.value.length < 8) {
        nome.value = "";
        nome.style.border = "solid 2px red";
        return false;
    }
    return true;
}