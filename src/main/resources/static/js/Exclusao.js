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
                    table+=`<tr><th>Identificador</th><th>Nome do usuário</th><th>Excluir</th></tr>`
                    for (let i=0;i<data.length;i++)
                    {
                            table+=`<tr>
                            <td>${data[i].id}</td>
                            <td>${data[i].nome}</td>
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