
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
    var status;
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

    var data = JSON.stringify(Object.fromEntries(new FormData(fdados)));
    let response = await fetch("/apis/params",{headers: {'Accept': 'application/json','Content-Type': 'application/json'}, method: 'POST', body: data});
    let userData = await response.text();
    window.location.href = "index.html";
    return userData; // não é necessário o await no return
     
}

