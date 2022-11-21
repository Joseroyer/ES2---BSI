//Validar RA suspensão.
function somenteNumeros(num) {
    var er = /[^0-9.]/;
    er.lastIndex = 0;
    var campo = num;
    if (er.test(campo.value)) {
        campo.value = "";
        alert("Informe apenas números.");
      campo.style.border = "solid 2px red";
      return false;
    }
    else return true;
}

function validarNome() {
    nome = document.querySelector("#teste123");
    if (nome.value.length < 6) {
        nome.value = "";
        alert("Dados inseridos menor que 6 dígitos.");
        nome.style.border = "solid 2px red";
        return false;
    }
    return true;
}


