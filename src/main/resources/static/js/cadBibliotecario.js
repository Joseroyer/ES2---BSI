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
    let nome = document.querySelector("#nome");
    if (nome.value.length < 8) {
        nome.value = "";
        nome.style.border = "solid 2px #00B9BC";
        document.getElementById("resultado_nome").style.display = "block";
        return false;
    }
    return true;
}

function validarEmail() {
    let email = document.querySelector("#email");
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

function validarUser() {
    let user = document.getElementById("login");
    if (user.value.length < 5 || user.value == "") {
        user.value = "";
        user.style.border = "solid 2px #00B9BC";
        document.getElementById("resultado_user").style.display = "block";
        return false;
    }
    return true;
}

function validarSenha() {
    let senha = document.getElementById("senha");
    if (senha.value.length < 5 || senha.value == "") {
        senha.value = "";
        senha.style.border = "solid 2px #00B9BC";
        document.getElementById("resultado_senha").style.display = "block";
        return false;
    }
    return true;
}

function esconder() {
    document.getElementById("resultado_nome").style.display = "none";
    document.getElementById("resultado_telefone").style.display = "none";
    document.getElementById("resultado_email").style.display = "none";
    document.getElementById("resultado_user").style.display = "none";
    document.getElementById("resultado_senha").style.display = "none";
}

function limparForms() {
    document.getElementById("nome").value = "";
    document.getElementById("telefone").value = "";
    document.getElementById("email").value = "";
    document.getElementById("cpf").value = "";
    document.getElementById("login").value = "";
    document.getElementById("senha").value = "";
}

function gravarUsuario() {
    const URL = "/apis/saveBi";
    var fdados = document.getElementById("fdados");
    var jsontext = JSON.stringify(Object.fromEntries(
        new FormData(fdados)));
    fetch(URL, {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'POST', body: jsontext
    })
        .then(function (response) {
            if (response.ok) {
                document.getElementById("cpf_error").style.display = "none";
                document.getElementById("resultados_div").style.display = "none";
                document.getElementById("cad").style.display = "block";
                limparForms();
                return response.json();
            }
            else if (response.status == 406) {
                document.getElementById("cadastrado").style.display = "none";
                document.getElementById("resultados_div").style.display = "none";
                document.getElementById("cpf_error").style.display = "block";
            }
        })
        .catch(function (error) {
            // console.error();
        });
    event.preventDefault("fdados");
}