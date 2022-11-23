function ValidaUsuario()
{
    let filtro = document.getElementById("busca");
    fetch("/apis/existe-cliente?filtro="+filtro)
        .then(function (response) {
            return response.json();
        })
        .then(function (text) {
                fetch("/apis/qual-situacao?filtro="+filtro)
                .then(function (response) {
                    return response.json();
                })
                .then(function (text) {
                    window.location.href = "RealizarEmprestimo.html";
                })
                .catch(function (err) {
                    document.getElementById("modal").style.display = "block";
                    console.log('error: ' + err);
                });
        })
        .catch(function (err) {
            alert("Cliente não existente!")
            console.log('error: ' + err);

        });
}

function closeModal()
{
    document.getElementById("modal").style.display = 'none';
}


function Alugar()
{
    document.getElementById("modal").style.display = 'block';
}

function CarregaLista()
{
    
    const URL_TO_FETCH = '/apis/livros';
    fetch(URL_TO_FETCH, {method: 'POST',
       headers:{'Authorization':`${localStorage.getItem("token")}`,}})
    .then(response=> response.text())
    .then(result=> 
        {
                fetch("/apis/livros")
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
                 
                    for (let i=0;i<data.length;i++)
                    { 
                        if(data[i].livro_id_livro.quantidade > 0)
                        {
                            table+=`<tr>
                            <td>${data[i].id_exemplar}</td>
                            <td>${data[i].livro_id_livro.titulo_livro}</td>
                            <td>Teste</td>
                            <td>${data[i].livro_id_livro.autor_livro}</td>
                            <td>${data[i].editora_id_editora.nome_editora}</td>
                            <td>Disponível</td>
                            <td><img src="img/accept_green.png" onclick='Alugar()'/>
                            </td>
                            `;
                        }
                        else
                        {
                            table+=`<tr>
                            <td>${data[i].id_exemplar}</td>
                            <td>${data[i].livro_id_livro.titulo_livro}</td>
                            <td>${data[i].livro_id_livro.genero_fk.tipo_genero}</td>
                            <td>${data[i].livro_id_livro.autor_livro}</td>
                            <td>${data[i].editora_id_editora.nome_editora}</td>
                            <td>Indisponível</td>
                            <td><img src="img/ban.png"/></td>
                            `;
                        }
       
                    }

                    document.getElementById("qlq").innerHTML=table;
                }
            }
        )
    .catch(err=> console.error(err));
}


function Filtro()
{
    var filtro = document.getElementById("busca").value;
    const URL_TO_FETCH = '/apis/filtro';
    fetch(URL_TO_FETCH, {method: 'POST',
       headers:{'Authorization':`${localStorage.getItem("token")}`,}})
    .then(response=> response.text())
    .then(result=> 
        {
                fetch("/apis/filtro?filtro="+filtro)
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
                 
                    for (let i=0;i<data.length;i++)
                    { 
                        if(data[i].livro_id_livro.quantidade > 0)
                        {
                            table+=`<tr>
                            <td>${data[i].id_exemplar}</td>
                            <td>${data[i].livro_id_livro.titulo_livro}</td>
                            <td>Teste</td>
                            <td>${data[i].livro_id_livro.autor_livro}</td>
                            <td>${data[i].editora_id_editora.nome_editora}</td>
                            <td>Disponível</td>
                            <td><img src="img/accept_green.png" onclick='Alugar()'/>
                            </td>
                            `;
                        }
                        else
                        {
                            table+=`<tr>
                            <td>${data[i].id_exemplar}</td>
                            <td>${data[i].livro_id_livro.titulo_livro}</td>
                            <td>${data[i].livro_id_livro.genero_fk.tipo_genero}</td>
                            <td>${data[i].livro_id_livro.autor_livro}</td>
                            <td>${data[i].editora_id_editora.nome_editora}</td>
                            <td>Indisponível</td>
                            <td><img src="img/ban.png"/></td>
                            `;
                        }
       
                    }

                    document.getElementById("qlq").innerHTML=table;
                }
            }
        )
    .catch(err=> console.error(err));
}


function Confirmar()
{
    let filtro = document.getElementById("cpf").value;
    fetch("/apis/existe-cliente?filtro="+filtro)
        .then(function(response) {
            if(response.ok)
                alert("Cliente Existente!");
            else
                alert("Cliente nao existente!");
        }) 
        .catch(function (err) {

            console.log('error: ' + err);

        });
}

function Confirmar2()
{
    let filtro = document.getElementById("cpf").value;
    fetch("/apis/existe-cliente?filtro="+filtro)
        .then(function(response) {
            if(response.ok)
            {
                fetch("/apis/qual-situacao?filtro="+filtro)
                .then(function (response) {
                    if(response.ok)
                        window.location.href = "RealizarEmprestimo.html";
                    else
                        document.getElementById("modal").style.display = "block";
                    
                })
                .catch(function (err) {
                   
                    console.log('error: ' + err);
                });
            }
            else
                alert("Cliente nao existente!");
        }) 
        .catch(function (err) {

            console.log('error: ' + err);

        });
}