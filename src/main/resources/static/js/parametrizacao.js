
function estilo()
{
  fetch("/apis/estilo")
    .then(function (response) {
        return response.json();
    })
    .then(function (data) {
        appendData(data);
        
    })
    .catch(function (err) {
        console.log('error: ' + err);
    });
    function appendData(data)
    {
      const sheet = new CSSStyleSheet();
      sheet.insertRule(`#header .logo {
        font-size: 30px;
        margin: 0;
        padding: 0;
        line-height: 1;
        font-weight: 500;
        letter-spacing: 2px;
        text-transform: uppercase;
        font-family: "Jost", sans-serif;
        color: white
      }`
      
      );
      
      document.adoptedStyleSheets = [sheet];
      
      var home=`<a href="index.html">${data[0].nome_empresa}</a>`;
      var resp = data[0].nome_empresa;
      document.getElementById("titulo").innerHTML=home;
      document.getElementById("footer2").innerHTML = resp;
      document.getElementById("empresa").innerHTML = resp;
      document.getElementById("title").innerHTML += " - "+resp;
      var logo = data[0].imagem
      document.getElementById("logoParam").innerHTML=logo;
      document.getElementById("logoPage")=logo;
      
  }
}

function verificar()
{
    const URL_TO_FETCH = '/apis/testar-param';
    fetch(URL_TO_FETCH)
    .then(response=> response.text())
    .then(result=> {
        if(result.includes("Não"))
        {
            alert("Você não realizou a parametrização!")
            window.location.href = "parametrizacao.html";
        }
    })
    .catch(function (err) {
        console.log(err)
    });
}


async function gravarParametrizacao()
{  
    var cnpj = validarCNPJ()
    if(!cnpj)
        document.getElementById("valida").style.display = 'block'
    else
    {
        var data = JSON.stringify(Object.fromEntries(new FormData(fdados)));
        var response = await fetch("/apis/salvar",{headers: {'Accept': 'application/json','Content-Type': 'application/json'}, method: 'POST', body: data});
        var userData = await response.text();
        return userData;
    }

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

function validarCNPJ() {
 
    var cnpj = document.getElementById("cnpj").value
    cnpj = cnpj.replace(/[^\d]+/g,'');
 
    if(cnpj == '') return false;
     
    if (cnpj.length != 14)
        return false;
 
    // Elimina CNPJs invalidos conhecidos
    if (cnpj == "00000000000000" || 
        cnpj == "11111111111111" || 
        cnpj == "22222222222222" || 
        cnpj == "33333333333333" || 
        cnpj == "44444444444444" || 
        cnpj == "55555555555555" || 
        cnpj == "66666666666666" || 
        cnpj == "77777777777777" || 
        cnpj == "88888888888888" || 
        cnpj == "99999999999999")
        return false;
         
    // Valida DVs
    tamanho = cnpj.length - 2
    numeros = cnpj.substring(0,tamanho);
    digitos = cnpj.substring(tamanho);
    soma = 0;
    pos = tamanho - 7;
    for (i = tamanho; i >= 1; i--) {
      soma += numeros.charAt(tamanho - i) * pos--;
      if (pos < 2)
            pos = 9;
    }
    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
    if (resultado != digitos.charAt(0))
        return false;
         
    tamanho = tamanho + 1;
    numeros = cnpj.substring(0,tamanho);
    soma = 0;
    pos = tamanho - 7;
    for (i = tamanho; i >= 1; i--) {
      soma += numeros.charAt(tamanho - i) * pos--;
      if (pos < 2)
            pos = 9;
    }
    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
    if (resultado != digitos.charAt(1))
          return false;
           
    return true;
    
}