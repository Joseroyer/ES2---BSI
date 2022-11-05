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
    nome = document.querySelector("#nome");
    if (nome.value.length < 8) {
        nome.value = "";
        nome.style.border = "solid 2px red";
        return false;
    }
    return true;
}

function validarEmail() {
    email = document.querySelector("#email");
    var atpos = email.value.indexOf("@");
    var dotpos = email.value.lastIndexOf(".");
    if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length) {
        email.value = "";
        email.style.border = "solid 2px red";
        return false;
    }
    return true;
}


//arrumar
function validarCPF() {
    var cpf = document.getElementById("CPF").value;
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
            cpf.style.border = "solid 2px red";
            // event.target.style.border = "solid 2px red";
            // event.target.focus();
        }
    }
}

function validarUser() {
    var user = document.getElementById("user");
    if (user.value.length < 5) {
        user.value = "";
        user.style.border = "solid 2px red";
        return false;
    }
    return true;
}

function validarSenha() {
    var senha = document.getElementById("senha");
    if (senha.value.length < 5) {
        senha.value = "";
        senha.style.border = "solid 2px red";
        return false;
    }
    return true;
}

function esconder() {
    let resultado_nome = document.getElementById("resultado_nome");
    let resultado_user = document.getElementById("resultado_user");
    let resultado_senha = document.getElementById("resultado_senha");
    let resulta_CPF = document.getElementById("resultado_CPF");
    let resultado_email = document.getElementById("resultado_email");
}

function verifica() {

    if (!validarNome())
        document.getElementById("resultado_nome").style.display = "";
    if (!validarEmail())
        document.getElementById("resultado_email").style.display = "";
    if (!validarCPF())
        document.getElementById("resultado_CPF").style.display = "";
    if (!validarUser())
        document.getElementById("resultado_user").style.display = "";
    if (!validarSenha())
        document.getElementById("resultado_senha").style.display = "";

    return true;
}

//Nome, Email, nome, Senha
function gravarUsuario() {
    const URL = "/apis/registrar";
    var fdados = document.getElementById("fdados");
    var jsontext = JSON.stringify(Object.fromEntries(
        new FormData(fdados)));
    let nome = document.getElementById("nome").value;
    let celular = document.getElementById("telefone").value;
    let email = document.getElementById("email").value;
    let cpf = document.getElementById("CPF").value;
    let senha = document.getElementById("senha").value;
    let user = document.getElementById("user").value;

    if (!verifica())
        verifica();
    else {
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
                alert("Usuario Cadastrado");
                nome = "";
                celular = "";
                email = "";
                cpf = "";
                senha = "";
                user = "";
            }).catch(function (error) {
                console.error(error);
            });
    }
}