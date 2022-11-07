// function parametrizacao()
// {
//   return alert("AAAAAAAAAAAAA")
// }

function isAdmin()
{
  let isAdmin = true;
  var display = document.getElementById("listaFunc").style.display;
  if(isAdmin)
    document.getElementById("listaFunc").style.display ='block'
  else 
    document.getElementById("listaFunc").style.display = 'none'

}

function verificar()
{
    const URL_TO_FETCH = '/apis/testar-acesso';
    var status;
    fetch(URL_TO_FETCH, {method: 'POST',
       headers:{'Authorization':`${localStorage.getItem("token")}`,}})
    .then(response=> response.text())
    .then(result=> {
        if(result.includes("Logado"))
            window.location.href = "loginUser.html";
        else
        {
            alert("Você precisa estar logado para acessar o recurso!")
            window.location.href = "loginUser.html";
        }
    })
    .catch(function (err) {
        console.log(err)
    });
}