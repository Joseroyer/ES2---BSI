function CarregaLista() {
    const URL_TO_FETCH = '/apis/listar_exemplares';
    fetch(URL_TO_FETCH, {
        method: 'Post',
        headers: { 'Authorization': `${localStorage.getItem("token")}`, }
    })
        .then(response => response.text())
        .then(result => {
            fetch("/apis/listar_exemplares")
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
                console.log(data);
                var table = "";
                table += `<tr><th>#</th><th>Livro</th><th>Editora</th><th>Quantidade</th><th>Ano Publicado</th><th>Editar</th><th>Excluir</th></tr>`
                for (let i = 0; i < data.length; i++) {
                    table += `<tr>
                            <td>${data[i].id}</td>
                            <td>${data[i].livro_fk.titulo}</td>
                            <td>${data[i].editora_fk.nome_editora}</td>
                            <td>${data[i].qtd}</td> 
                            <td>${data[i].ano_publicado}</td>                            
                            <td><img width="30px" src='img/change.png' onclick='editar(${data[i].id})'></td>
                            <td><img width="30px" src='img/trash.png' onclick='excluir(${data[i].id})'></td>
                            </tr>`;
                }
                document.getElementById("tbody").innerHTML = table;
            }
        })
        .catch(err => console.error(err));
}
// function exibirCat() {
//     fetch("/api/listar-todos")
//         .then(function (response) {
//             return response.json();
//         })
//         .then(function (data) {
//             appendData(data);
//         })
//         .catch(function (err) {
//             console.log('error: ' + err);
//         });
//     function appendData(data) {

//         var resp = "";
//         for (let i = 0; i < data.length; i++)
//             resp += `<option value="` + (i + 1) + `">` + `${data[i].nome}</option>`;
//         document.getElementById("categoria").innerHTML = resp;
//     }

// }