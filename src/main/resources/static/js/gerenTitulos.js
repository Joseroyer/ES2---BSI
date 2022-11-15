const input = document.getElementById("search-input");
const searchBtn = document.getElementById("search-btn");

const expand = () => {
  searchBtn.classList.toggle("close");
  input.classList.toggle("square");
};

searchBtn.addEventListener("click", expand);


//button acima.

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
                    table+=`<tr><th>Identificador</th><th>Editora</th><th>Editar</th><th>Excluir</th></tr>`
                    for (let i=0;i<data.length;i++)
                    {
                            table+=`<tr>
                            <td>${data[i].id_editora}</td>
                            <td>${data[i].nome_editora}</td>
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
    var input = `<td><input type="text" id="teste"><input type="submit" value="Alterar" onclick='editar2(${id})'></td>`;
    document.getElementById("qlq").innerHTML+=input;
   
}
function editar2(id)
{
    var Identificador=id;
    var Nome = document.getElementById("teste").value
    
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
    window.location.href = "index.html";
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
                    table+=`<tr><th>Identificador</th><th>Editora</th><th>Editar</th><th>Excluir</th></tr>`
                    for (let i=0;i<data.length;i++)
                    {
                            table+=`<tr>
                            <td>${data[i].id_editora}</td>
                            <td>${data[i].nome_editora}</td>
                            <td><img width="30px" src='img/change.png'></td>
                            <td><img width="30px" src='img/trash.png' onclick='excluir(${data[i].id_editora})'></td>
                            </tr>`;        
                    }
                    document.getElementById("qlq").innerHTML=table;
                }
            }
        )
    .catch(err=> console.error(err));
}