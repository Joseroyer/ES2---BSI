function editar(id) {
    // alert(id)
    document.getElementById("modal").style.display = 'block'
    document.getElementById("id").value = id;
    //var input = `<th><input type="text" id="teste"><input type="submit" value="Alterar" onclick='editar2(${id})'></th>`;
    //document.getElementById("qlq").innerHTML+=input;

}
function editar2() {
    // var Identificador=id;
    let Identificador = document.getElementById("id").value;
    let Nome = document.getElementById("novo_nome").value;
    let Telefone = document.getElementById("novo_telefone");
    let Email = document.getElementById("novo_email");
    const URL_TO_FETCH = `/apis/editarBibliotecario?Identificador=${Identificador}&Nome=${Nome}&Telefone=${Telefone}&Email=${Email}`;
    fetch(URL_TO_FETCH, { headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' }, method: 'POST' })
        .then(function (response) {
            return response.json();
        })
        .then(function (text) {
            window.location.href = "editora.html";
        })
        .catch(function (err) {
            console.log('error: ' + err);
        });

}
function CarregaLista()
{
    const URL_TO_FETCH = '/apis/listaradm';
    fetch(URL_TO_FETCH, {method: 'POST',
       headers:{'Authorization':`${localStorage.getItem("token")}`,}})
    .then(response=> response.text())
    .then(result=> 
        {
                fetch("/apis/listaradm")
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
                    table +=`<tr><th>Identificador</th><th>Nome do usuário</th><th>Telefone</th><th>Email</th><th>Editar</th><th>Excluir</th></tr>`
                    for (let i=0;i<data.length;i++)
                    {
                            table+=`<tr>
                            <td>${data[i].id}</td>
                            <td>${data[i].nome}</td>
                            <td>${data[i].telefone}</td>
                            <td>${data[i].email}</td>                            
                            <td><img width="30px" src='img/change.png' onclick='editar(${data[i].id})'></td>
                            <td><img width="30px" src='img/trash.png' onclick='excluir(${data[i].id})'></td>
                            </tr>`;        
                    }
                    document.getElementById("qlq").innerHTML=table;
                }
            }
        )
    .catch(err=> console.error(err));
}

function excluir(id)
{
    if(window.confirm("Deseja realmente excluir o Administrador?"))
    {
        fetch("/apis/excluirAdm?id="+id)
        .then(function (response) {
            return response.json();
        })
        .then(function (text) {
            window.location.href = "ExcluirUsuario.html";
        })
        .catch(function (err) {
            console.log('error: ' + err);
        });
    }
}


function closeModal() {
    document.getElementById("modal").style.display = 'none'
}


// function FormsBibliotecario(){
//         fetch("/api/listar-todos")
//             .then(function (response) {
//                 return response.json();
//             })
//             .then(function (data) {
//                 appendData(data);
//             })
//             .catch(function (err) {
//                 console.log('error: ' + err);
//             });
//         function appendData(data) {
//             let 
//         }

// }

// function CarregaFiltro()
// {
//     var filtro = document.getElementById("busca").value
//     const URL_TO_FETCH = '/apis/listar-editora';
//     var status;
//     fetch(URL_TO_FETCH, {method: 'POST',
//        headers:{'Authorization':`${localStorage.getItem("token")}`,}})
//     .then(response=> response.text())
//     .then(result=> 
//         {
//                 fetch("/apis/listar-editora?filtro="+filtro)
//                 .then(function (response) {
//                     return response.json();
//                 })
//                 .then(function (data) {
//                     appendData(data);
//                 })
//                 .catch(function (err) {
//                     console.log('error: ' + err);
//                 });
//                 function appendData(data) {

                    

//                     var table="";
//                     table+=`<tr><th>Identificador</th><th>Editora</th><th>Editar</th><th>Excluir</th></tr>`
//                     for (let i=0;i<data.length;i++)
//                     {
//                             table+=`<tr>
//                             <td>${data[i].id_editora}</td>
//                             <td>${data[i].nome_editora}</td>
//                             <td><img width="30px" src='img/change.png'></td>
//                             <td><img width="30px" src='img/trash.png' onclick='excluir(${data[i].id_editora})'></td>
//                             </tr>`;        
//                     }
//                     document.getElementById("qlq").innerHTML=table;
//                 }
//             }
//         )
//     .catch(err=> console.error(err));
// }