const input = document.getElementById("search-input");
const searchBtn = document.getElementById("search-btn");

const expand = () => {
  searchBtn.classList.toggle("close");
  input.classList.toggle("square");
};

searchBtn.addEventListener("click", expand);


//button acima.

//carregar lista
function CarregaLista()
{
    var filtro = document.getElementById("search-input").value
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
                    table+=`<tr><th>ID</th><th>Titulo</th><th>Editar</th><th>Excluir dados</th></tr>`
                    for (let i=0;i<data.length;i++)
                    {
                            table+=`<tr>
                            <td>${data[i].id_livro}</td>
                            <td>${data[i].titulo_livro}</td>
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

// async function Cadastrar()
// {  

//     var data = JSON.stringify(Object.fromEntries(new FormData(fdados)));
//     let response = await fetch("/apis/CadastrarNovosTitulos",{headers: {'Accept': 'application/json','Content-Type': 'application/json'}, method: 'POST', body: data});
//     let userData = await response.text();
//     window.location.href = "cadtitulos.html";
//     return userData; 
// }
async function Cadastrar() {
    const URL = "/apis/CadastrarNovosTitulos";
    var fdados = document.getElementById("fdados");
    var jsontext = JSON.stringify(Object.fromEntries(
        new FormData(fdados)));
    
    let titulo = document.getElementById("titulo").value;

    console.log(titulo);


    if(titulo=="")
        alert("O campo título deve ser informado!!");
    // else
    // if(texto=="")
    //     alert("O campo do texto da piada precisa ser informado");
    // else
    // if(keywords=="")
    //     alert("O campos do keywords deve ser informado!");
    else
        fetch(URL, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: 'POST', body: jsontext
        })
            .then(function (response) {
                return response.text();
            })
            .then(function (text) {
                alert("Titulo cadastrado!!!!!");
                titulo="";
            }).catch(function (error) {
                console.error(error);
            });
        
}

function excluir(id)
{
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
                            <td><img width="30px" src='img/change.png'></td>
                            <td><img width="30px" src='img/trash.png' onclick='excluir(${data[i].id_livro})'></td>
                            </tr>`;        
                    }
                    document.getElementById("tab").innerHTML=table;
                }
            }
        )
    .catch(err=> console.error(err));
}



// function appendTabela(data) {
//     var table = "";
//     document.querySelector("#tabela").classList.remove("d-none");
//     table += `<tr><th>Titulo</th><th>Texto</th><th>Curtidas</th><th>Curtir</th></tr>`
//     for (let i = 0; i < data.length; i++)
//         table += `<tr>
//             <td>${data[i].titulo}</td>
//             <td>${data[i].texto}</td>
//             <td>${data[i].ranking}</td>
//             <td><a role="button" class="cursor-pointer" onclick="UpdateRanking(${data[i].id})"><svg width="25" height="25" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><!--! Font Awesome Pro 6.1.1 by @fontawesome - https://fontawesome.com/ License - https://fontawesome.com/license (Commercial License) Copyright 2022 Fonticons, Inc. --><path d="M128 447.1V223.1c0-17.67-14.33-31.1-32-31.1H32c-17.67 0-32 14.33-32 31.1v223.1c0 17.67 14.33 31.1 32 31.1h64C113.7 479.1 128 465.6 128 447.1zM512 224.1c0-26.5-21.48-47.98-48-47.98h-146.5c22.77-37.91 34.52-80.88 34.52-96.02C352 56.52 333.5 32 302.5 32c-63.13 0-26.36 76.15-108.2 141.6L178 186.6C166.2 196.1 160.2 210 160.1 224c-.0234 .0234 0 0 0 0L160 384c0 15.1 7.113 29.33 19.2 38.39l34.14 25.59C241 468.8 274.7 480 309.3 480H368c26.52 0 48-21.47 48-47.98c0-3.635-.4805-7.143-1.246-10.55C434 415.2 448 397.4 448 376c0-9.148-2.697-17.61-7.139-24.88C463.1 347 480 327.5 480 304.1c0-12.5-4.893-23.78-12.72-32.32C492.2 270.1 512 249.5 512 224.1z"/></svg></a></td> 
//             </tr>`;
//     document.getElementById("resultPiad").innerHTML = table;
   
// }

// function pesquisar() {
//     var filtro = document.getElementById("buscar").value;
//     fetch("/apis/listar-piadas?filtro=" + filtro)
//         .then(function (response) {
//             return response.json();
//         })
//         .then(function (data) {
//             appendTabela(data);
//         })
//         .catch(function (err) {
//             console.log('Error' + err);
//         });
// }