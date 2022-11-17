$('#meuModal').on('shown.bs.modal', function () {
    $('#meuInput').trigger('focus')
  })
function CarregaLista()
{
    var filtro = document.getElementById("busca").value
    const URL_TO_FETCH = '/apis/listar-todas-editoras';
    var status;
    fetch(URL_TO_FETCH, {method: 'POST',
       headers:{'Authorization':`${localStorage.getItem("token")}`,}})
    .then(response=> response.text())
    .then(result=> 
        {
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

                    

                    var table="";
                    table+=`<tr><th>Identificador</th><th>Editora</th><th>Cidade</th><th>Estado</th><th>Editar</th><th>Excluir</th></tr>`
                    for (let i=0;i<data.length;i++)
                    {
                            table+=`<tr>
                            <td>${data[i].id_editora}</td>
                            <td>${data[i].nome_editora}</td>
                            <td>${data[i].cidade_editora}</td>
                            <td>${data[i].estado_editora}</td>
                            <td><img width="30px" src='img/change.png' onclick='editar(${data[i].id_editora})'></td>
                            <td><img width="30px" src='img/trash.png' onclick='excluir(${data[i].id_editora})'></td>
                            </tr>`;        
                    }
                    document.getElementById("qlq").innerHTML=table;
                }
            }
        )
    .catch(err=> console.error(err));
}
function editar(id)
{
    // alert(id)
    document.getElementById("modal").style.display = 'block'
    document.getElementById("identificador").value = id;
    const URL_TO_FETCH = `/apis/listar-ed?Identificador=${id}`;
    fetch(URL_TO_FETCH, { headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' }, method: 'POST' })
        .then(function (response) {
            response.json().then(valores => {
                appendData(valores);
            });
        })
        .catch(function (err) {
            console.log(err);
        });
    function appendData(data) {
        console.log(data);
        var nome = data.nome_editora;
        document.getElementById("novo_nome").value = nome;
        var cidade = data.cidade_editora;
        document.getElementById("novo_nome_cid").value = cidade;
        var estado = data.estado_editora;
        document.getElementById("novo_nome_est").value = estado;

    }
    //var input = `<th><input type="text" id="teste"><input type="submit" value="Alterar" onclick='editar2(${id})'></th>`;
    //document.getElementById("qlq").innerHTML+=input;
   
}
function editar2()
{
    // var Identificador=id;
    var Nome = document.getElementById("novo_nome").value
    var Identificador = document.getElementById("identificador").value
    const URL_TO_FETCH = `/apis/editar?Identificador=${Identificador}&Nome=${Nome}`;
    fetch(URL_TO_FETCH,{headers: {'Accept': 'application/json','Content-Type': 'application/json'}, method: 'POST'})
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
async function Cadastrar()
{  

    var data = JSON.stringify(Object.fromEntries(new FormData(fdados)));
    let response = await fetch("/apis/cadEditora",{headers: {'Accept': 'application/json','Content-Type': 'application/json'}, method: 'POST', body: data});
    let userData = await response.text();
    return userData; // não é necessário o await no return
     
}

function excluir(id)
{
    if(window.confirm("Deseja realmente excluir a Editora?"))
    {
        fetch("/apis/excluir?id="+id)
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
   
}

function closeModal()
{
    document.getElementById("modal").style.display = 'none'
}

function CarregaFiltro()
{
    var filtro = document.getElementById("busca").value
    const URL_TO_FETCH = '/apis/listar-editora';
    var status;
    fetch(URL_TO_FETCH, {method: 'POST',
       headers:{'Authorization':`${localStorage.getItem("token")}`,}})
    .then(response=> response.text())
    .then(result=> 
        {
                fetch("/apis/listar-editora?filtro="+filtro)
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
                    table+=`<tr><th>Identificador</th><th>Editora</th><th>Cidade</th><th>Estado</th><th>Editar</th><th>Excluir</th></tr>`
                    for (let i=0;i<data.length;i++)
                    {
                            table+=`<tr>
                            <td>${data[i].id_editora}</td>
                            <td>${data[i].nome_editora}</td>
                            <td>${data[i].cidade_editora}</td>
                            <td>${data[i].estado_editora}</td>
                            <td><img width="30px" src='img/change.png' onclick='editar(${data[i].id_editora})'></td>
                            <td><img width="30px" src='img/trash.png' onclick='excluir(${data[i].id_editora})'></td>
                            </tr>`;        
                    }
                    
                    document.getElementById("qlq").innerHTML=table;
                }
            }
        )
    .catch(err=> console.error(err));
}

