function mascara(m, t, e) {
    var cursor = t.selectionStart;
    var texto = t.value;
    texto = texto.replace(/\D/g, '');
    var l = texto.length;
    var lm = m.length;
    if (window.event) {
        id = e.keyCode;
    } else if (e.which) {
        id = e.which;
    }
    cursorfixo = false;
    if (cursor < l) cursorfixo = true;
    var livre = false;
    if (id == 16 || id == 19 || (id >= 33 && id <= 40)) livre = true;
    ii = 0;
    mm = 0;
    if (!livre) {
        if (id != 8) {
            t.value = "";
            j = 0;
            for (i = 0; i < lm; i++) {
                if (m.substr(i, 1) == "#") {
                    t.value += texto.substr(j, 1);
                    j++;
                } else if (m.substr(i, 1) != "#") {
                    t.value += m.substr(i, 1);
                }
                if (id != 8 && !cursorfixo) cursor++;
                if ((j) == l + 1) break;

            }
        }
    }
    if (cursorfixo && !livre) cursor--;
    t.setSelectionRange(cursor, cursor);
}


function validarNome() {
    let nome = document.querySelector("#novo_nome");
    if (nome.value.length < 8) {
        nome.value = "";
        nome.style.border = "solid 2px #00B9BC";
        document.getElementById("resultado_nome").style.display = "block";
        return false;
    }
    return true;
}

function validarEmail() {
    let email = document.querySelector("#novo_email");
    var atpos = email.value.indexOf("@");
    var dotpos = email.value.lastIndexOf(".");
    if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length) {
        email.value = "";
        email.style.border = "solid 2px #00B9BC";
        document.getElementById("resultado_email").style.display = "block";
        return false;
    }
    return true;
}

function validarCPF() {
    let result = document.getElementById("resultado_CPF");
    var cpf = event.target.value;
    var ok = 1;
    var add;
    if (cpf != "") {
        cpf = cpf.replace(/[^\d]+/g, '');
        if (cpf.length != 11 ||
            cpf == "00000000000" ||
            cpf == "11111111111" ||
            cpf == "22222222222" ||
            cpf == "33333333333" ||
            cpf == "44444444444" ||
            cpf == "55555555555" ||
            cpf == "66666666666" ||
            cpf == "77777777777" ||
            cpf == "88888888888" ||
            cpf == "99999999999")
            ok = 0;
        if (ok == 1) {
            add = 0;
            for (i = 0; i < 9; i++)
                add += parseInt(cpf.charAt(i)) * (10 - i);
            rev = 11 - (add % 11);
            if (rev == 10 || rev == 11)
                rev = 0;
            if (rev != parseInt(cpf.charAt(9)))
                ok = 0;
            if (ok == 1) {
                add = 0;
                for (i = 0; i < 10; i++)
                    add += parseInt(cpf.charAt(i)) * (11 - i);
                rev = 11 - (add % 11);
                if (rev == 10 || rev == 11)
                    rev = 0;
                if (rev != parseInt(cpf.charAt(10)))
                    ok = 0;
            }
        }
        if (ok == 0) {
            // cpf.style.border = "solid 2px #00B9BC";
            event.target.style.border = "solid 2px #00B9BC";
            result.style.display = "";
            // event.target.focus();
        }
    }
}

function validarTelefone() {
    let telefone = document.getElementById("telefone");
    if (telefone.value == "" || telefone.value.length < 2) {
        telefone.display.border = "solid 2px #00B9BC";
        telefone.value = "";
        document.getElementById("resultado_telefone").style.display = "block";
        return false;
    }
    return true;
}


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
    let Telefone = document.getElementById("novo_telefone").value;
    let Email = document.getElementById("novo_email").value;

    const URL_TO_FETCH = `/apis/editarBibliotecario?Identificador=${Identificador}&Nome=${Nome}&Telefone=${Telefone}&Email=${Email}`;
    fetch(URL_TO_FETCH, { headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' }, method: 'POST' })
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
                table += `<tr><th>Identificador</th><th>Nome do usuário</th><th>Telefone</th><th>Email</th><th>Editar</th><th>Excluir</th></tr>`
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
                document.getElementById("qlq").innerHTML = table;
            }
        }
        )
        .catch(err => console.error(err));
}

function excluir(id) {
    if (window.confirm("Deseja realmente excluir o Administrador?")) {
        fetch("/apis/excluirAdm?id=" + id)
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
