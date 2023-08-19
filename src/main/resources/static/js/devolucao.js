// $(document).ready(function () {
//
//     //For Card Number formatted input
//     var cardNum = document.getElementById('cr_no');
//     cardNum.onkeyup = function (e) {
//         if (this.value == this.lastValue) return;
//         var caretPosition = this.selectionStart;
//         var sanitizedValue = this.value.replace(/[^0-9]/gi, '');
//         var parts = [];
//
//         for (var i = 0, len = sanitizedValue.length; i < len; i += 4) {
//             parts.push(sanitizedValue.substring(i, i + 4));
//         }
//
//         for (var i = caretPosition - 1; i >= 0; i--) {
//             var c = this.value[i];
//             if (c < '0' || c > '9') {
//                 caretPosition--;
//             }
//         }
//         caretPosition += Math.floor(caretPosition / 4);
//
//         this.value = this.lastValue = parts.join('-');
//         this.selectionStart = this.selectionEnd = caretPosition;
//     }
//
//     //For Date formatted input
//     var expDate = document.getElementById('exp');
//     expDate.onkeyup = function (e) {
//         if (this.value == this.lastValue) return;
//         var caretPosition = this.selectionStart;
//         var sanitizedValue = this.value.replace(/[^0-9]/gi, '');
//         var parts = [];
//
//         for (var i = 0, len = sanitizedValue.length; i < len; i += 2) {
//             parts.push(sanitizedValue.substring(i, i + 2));
//         }
//
//         for (var i = caretPosition - 1; i >= 0; i--) {
//             var c = this.value[i];
//             if (c < '0' || c > '9') {
//                 caretPosition--;
//             }
//         }
//         caretPosition += Math.floor(caretPosition / 2);
//
//         this.value = this.lastValue = parts.join('/');
//         this.selectionStart = this.selectionEnd = caretPosition;
//     }
//
//     // Radio button
//     $('.radio-group .radio').click(function () {
//         $(this).parent().find('.radio').removeClass('selected');
//         $(this).addClass('selected');
//     });
//
//     $('#meuModal').on('shown.bs.modal', function () {
//         $('#meuInput').trigger('focus')
//     })
// });

function closeModal() {
    document.getElementById("modal").style.display = 'none'
}

function ValidaCPF() {
    var RegraValida = document.getElementById("RegraValida").value;
    var cpfValido = /^(([0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2})|([0-9]{11}))$/;
    if (cpfValido.test(RegraValida) == true) {
        alert("CPF Válido");
    } else {
        alert("CPF Inválido");
    }
}

function fMasc(objeto, mascara) {
    obj = objeto
    masc = mascara
    setTimeout("fMascEx()", 1)
}

function fMascEx() {
    obj.value = masc(obj.value)
}

function mCPF(cpf) {
    cpf = cpf.replace(/\D/g, "")
    cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2")
    cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2")
    cpf = cpf.replace(/(\d{3})(\d{1,2})$/, "$1-$2")
    return cpf
}

function isAdmin() {
    let isAdmin = true;
    var display = document.getElementById("listaFunc").style.display;
    if (isAdmin)
        document.getElementById("listaFunc").style.display = 'block'
    else
        document.getElementById("listaFunc").style.display = 'none'

}

function Parameters() {
    let parameters = true;
    if (!parameters) {
        alert("A parametrização não foi realizada, você será redirecionado!")
        window.location.href = "parametrizacao.html"

    }

}

function CarregaLista() {

    const URL_TO_FETCH = '/apis/listar-emprestimos';
    fetch(URL_TO_FETCH, {
        method: 'POST',
        headers: {'Authorization': `${localStorage.getItem("token")}`,}
    })
        .then(response => response.text())
        .then(result => {
                fetch("/apis/listar-emprestimos")
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

                    const date = new Date();

                    var table = "";
                    for (let i = 0; i < data.length; i++) {
                        var status = "";
                        var dia_atual = date.getDate();
                        var mes_atual = date.getMonth() + 1;
                        var ano_atual = date.getFullYear();
                        var devol = ano_atual + "-" + mes_atual + "-" + dia_atual
                        var dt_emp = data[i].data_emprestimo.split("-");
                        var aux = dt_emp[2] + "/" + dt_emp[1] + "/" + dt_emp[0];
                        var dt_dv = data[i].data_devolucao.split("-");
                        var aux2 = dt_dv[2] + "/" + dt_dv[1] + "/" + dt_dv[0];
                        if (devol > data[i].data_devolucao) {
                            status = "Atrasado"
                            table += `<tr>
                                      <td>${data[i].id_emprestimo}</td>
                                      <td>${data[i].cliente.nome}</td>
                                      <td>${aux}</td>
                                      <td>${aux2}</td>
                                      <td>${data[i].exemplar_id.livro_id_livro.titulo_livro}</td>
                                      
                                      <td style="color: red; font-weight: bold">${status}</td>
                                     
                                      <td>
                                          <a href="#" title="Suspensão" data-toggle="tooltip"><img src="img/ban.png"></a>
                                          
                                      </td>
                                      <td>
                                      <img src="img/pay.png" onclick='Pagamento(${data[i].id_emprestimo})'>
                                      </td>
                                  </tr>
                                  `;
                        } else {
                            status = "Em dia";
                            table += `<tr>
                                      <td>${data[i].id_emprestimo}</td>
                                      <td>${data[i].cliente.nome}</td>
                                      <td>${aux}</td>
                                      <td>${aux2}</td>
                                      <td>${data[i].exemplar_id.livro_id_livro.titulo_livro}</td>
                                      
                                      <td style="color: green; font-weight: bold">${status}</td>
                                      <td>
                                          <img src="img/accept_green.png" onclick='Devolver(${data[i].id_emprestimo})'>
                                      </td>
                                      
                                      <td>
                                          <img src="img/pay.png" onclick='Pagamento(${data[i].id_emprestimo})'>
                                      </td>
                                  </tr>
                                  `;


                        }
                        //         table+=`<tr>
                        //         <td>${data[i].id_emprestimo}</td>
                        //         <td>${data[i].cliente.nome}</td>
                        //         <td>${data[i].data_emprestimo}</td>
                        //         <td>${data[i].data_devolucao}</td>
                        //         <td>${data[i].exemplar_id.livro_id_livro.titulo_livro}</td>

                        //         <td style="color: red">${status}</td>
                        //          <td>
                        //             <a href="#" title="Devolver" data-toggle="tooltip"><img src="img/accept_green.png"></a>
                        //         </td>
                        //         <td>
                        //             <a href="#" title="Suspensão" data-toggle="tooltip"><img src="img/ban.png"></a>

                        //         </td>
                        //         <td>
                        //             <a href="#" title="Pagamento" data-toggle="tooltip"><img src="img/pay.png"></a>
                        //         </td>
                        //     </tr>
                        //     `;
                    }
                    document.getElementById("qlq").innerHTML = table;
                }
            }
        )
        .catch(err => console.error(err));
}

function CarregaFiltro() {
    var filtro = document.getElementById("busca").value
    const URL_TO_FETCH = '/apis/listar-emprestimos';
    fetch(URL_TO_FETCH, {
        method: 'POST',
        headers: {'Authorization': `${localStorage.getItem("token")}`,}
    })
        .then(response => response.text())
        .then(result => {
                fetch("/apis/listar-emprestimos-filtro?filtro=" + filtro)
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

                    const date = new Date();

                    var table = "";
                    for (let i = 0; i < data.length; i++) {
                        var status = "";
                        var dia_atual = date.getDate();
                        var mes_atual = date.getMonth() + 1;
                        var ano_atual = date.getFullYear();
                        var devol = ano_atual + "-" + mes_atual + "-" + dia_atual
                        var dt_emp = data[i].data_emprestimo.split("-");
                        var aux = dt_emp[2] + "/" + dt_emp[1] + "/" + dt_emp[0];
                        var dt_dv = data[i].data_devolucao.split("-");
                        var aux2 = dt_dv[2] + "/" + dt_dv[1] + "/" + dt_dv[0];
                        if (devol > data[i].data_devolucao) {
                            status = "Atrasado"
                            table += `<tr>
                                      <td>${data[i].id_emprestimo}</td>
                                      <td>${data[i].cliente.nome}</td>
                                      <td>${aux}</td>
                                      <td>${aux2}</td>
                                      <td>${data[i].exemplar_id.livro_id_livro.titulo_livro}</td>
                                      
                                      <td style="color: red; font-weight: bold">${status}</td>
                                     
                                      <td>
                                          <a href="#" title="Suspensão" data-toggle="tooltip"><img src="img/ban.png"></a>
                                          
                                      </td>
                                      <td>
                                      <img src="img/pay.png" onclick='Pagamento()'>
                                      </td>
                                  </tr>
                                  `;
                        } else {
                            status = "Em dia";
                            table += `<tr>
                                      <td>${data[i].id_emprestimo}</td>
                                      <td>${data[i].cliente.nome}</td>
                                      <td>${aux}</td>
                                      <td>${aux2}</td>
                                      <td>${data[i].exemplar_id.livro_id_livro.titulo_livro}</td>
                                      
                                      <td style="color: green; font-weight: bold">${status}</td>
                                      <td>
                                          <img src="img/accept_green.png" onclick='Devolver(${data[i].id_emprestimo})'>
                                      </td>
                                      
                                      <td>
                                          <img src="img/pay.png" onclick='Pagamento()'>
                                      </td>
                                  </tr>
                                  `;


                        }
                        //         table+=`<tr>
                        //         <td>${data[i].id_emprestimo}</td>
                        //         <td>${data[i].cliente.nome}</td>
                        //         <td>${data[i].data_emprestimo}</td>
                        //         <td>${data[i].data_devolucao}</td>
                        //         <td>${data[i].exemplar_id.livro_id_livro.titulo_livro}</td>

                        //         <td style="color: red">${status}</td>
                        //          <td>
                        //             <a href="#" title="Devolver" data-toggle="tooltip"><img src="img/accept_green.png"></a>
                        //         </td>
                        //         <td>
                        //             <a href="#" title="Suspensão" data-toggle="tooltip"><img src="img/ban.png"></a>

                        //         </td>
                        //         <td>
                        //             <a href="#" title="Pagamento" data-toggle="tooltip"><img src="img/pay.png"></a>
                        //         </td>
                        //     </tr>
                        //     `;
                    }
                    document.getElementById("qlq").innerHTML = table;
                }
            }
        )
        .catch(err => console.error(err));
}

function Devolver(id) {
    if (window.confirm("Deseja realmente devolver o exemplar?")) {
        fetch("/apis/devolver?id=" + id)
            .then(function (response) {
                return response.json();
            })
            .then(function (text) {
                window.location.href = "devoluçao.html";
            })
            .catch(function (err) {
                console.log('error: ' + err);
            });
    }
}

const searchFocus = document.getElementById('search-focus');
const keys = [
    {keyCode: 'AltLeft', isTriggered: false},
    {keyCode: 'ControlLeft', isTriggered: false},
];

window.addEventListener('keydown', (e) => {
    keys.forEach((obj) => {
        if (obj.keyCode === e.code) {
            obj.isTriggered = true;
        }
    });

    const shortcutTriggered = keys.filter((obj) => obj.isTriggered).length === keys.length;

    if (shortcutTriggered) {
        searchFocus.focus();
    }
});

window.addEventListener('keyup', (e) => {
    keys.forEach((obj) => {
        if (obj.keyCode === e.code) {
            obj.isTriggered = false;
        }
    });
});

function Pagamento(id) {

    document.getElementById("modal").style.display = 'block'
    var div = `<div class="btn btn-primary payment" onclick="ConfirmarPag(${id})">
                Confirmar Pagamento
                </div>`
    document.getElementById("div_pag").innerHTML = div;
}




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

function ConfirmarPag(id) {

    var identificador = id;
    var num = document.getElementById("num_cart").value;
    var qtd = document.getElementById("qtd_parc").value;
    const URL_TO_FETCH = `/apis/pagar?identificador=${identificador}&num=${num}&qtd=${qtd}`;
    fetch(URL_TO_FETCH, {headers: {'Accept': 'application/json', 'Content-Type': 'application/json'}, method: 'POST'})
        .then(function (response) {

            return response.json();
        })
        .then(function (text) {

            window.location.href = "devoluçao.html";
        })
        .catch(function (err) {
            console.log('error: ' + err);
        });

}

function validaParcela() {
    var num = document.getElementById("qtd_parc").value
    // alert(num)
    if (num > 5 || num < 1) {
        document.getElementById("esconder").style.display = 'block';
        document.getElementById("qtd_parc").style.border = '2px solid red'
    } else {
        document.getElementById("esconder").style.display = 'none';
        document.getElementById("qtd_parc").style.border = '2px solid #008000'
    }
}

function validaNumero() {
    var num = document.getElementById("num_cart").value
    if (num == "") {
        document.getElementById("num_cart").style.border = '2px solid red'
    } else {
        document.getElementById("num_cart").style.border = '2px solid #008000'
    }
}

function validaData() {

    var data = document.getElementById("data").value
    if (data == "") {
        document.getElementById("data").style.border = '2px solid red'
    } else {
        document.getElementById("data").style.border = '2px solid #008000'
    }

}

function validaCVV() {

    var cvv = document.getElementById("cvv").value
    if (cvv == "") {
        document.getElementById("cvv").style.border = '2px solid red'
    } else {
        document.getElementById("cvv").style.border = '2px solid #008000'
    }

}

function validaNome() {

    var nome = document.getElementById("nome").value
    if (nome == "") {
        document.getElementById("nome").style.border = '2px solid red'
    } else {
        document.getElementById("nome").style.border = '2px solid #008000'
    }

}