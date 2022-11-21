function CarregaLista() {
    const URL_TO_FETCH = '/apis/listaradm';
    fetch(URL_TO_FETCH, {
        method: 'POST',
        headers: { 'Authorization': `${localStorage.getItem("token")}`, }
    })
        .then(response => response.text())
        .then(result => {
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

                var table = "";
                for (let i = 0; i < data.length; i++) {
                    table += `<tr>
                            <td>${data[i].id}</td>
                            <td>${data[i].nome}</td>
                            <td>${data[i].telefone}</td>
                            <td>${data[i].email}</td>                            
                            <td><img width="30px" src='img/change.png' onclick='editar(${data[i].id})'></td>
                            <td><img width="30px" src='img/trash.png' onclick='excluir(${data[i].id})'></td>
                            </tr>`;
                }
                document.getElementById("thead").style.display = "block";
                document.getElementById("tbody").innerHTML = table;
            }
        }
        )
        .catch(err => console.error(err));
}