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

async function Cadastrar()
{  

    var data = JSON.stringify(Object.fromEntries(new FormData(fdados)));
    let response = await fetch("/apis/CadastrarNovosTitulos",{headers: {'Accept': 'application/json','Content-Type': 'application/json'}, method: 'POST', body: data});
    let userData = await response.text();
    window.location.href = "cadtitulos.html";
    return userData; 
     
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
    var filtro = document.getElementById("search-input").value
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