function esconder() {
    let resultado_login = document.getElementById("resultado_login");
}


// async function gravarUsuario() {
//     var data = JSON.stringify(Object.fromEntries(new FormData(form)));
//     let response = await fetch("/apis/usuario", { headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' }, method: 'POST', body: data });
//     let userData = await response.text();
//     return userData; // não é necessário o await no return
// }

function verificarLogin()
{
    const URL_TO_FETCH = '/security/testar-cliente-login';
    fetch(URL_TO_FETCH, {method: 'POST',
       headers:{'Authorization':`${localStorage.getItem("token")}`,}})
    .then(response=> response.text())
    .then(result=> {
        if(result.includes("Erro"))
        {
            document.getElementById("listaFunc").style.display = 'none'
            // alert("Você precisa estar logado para acessar o recurso!")
            // window.location.href = "loginUser.html";
        } 
        if(result.includes("Logado"))
            
        {  
            // document.getElementById("listaFunc").style.display = 'block'
            document.getElementById("logButton").style.display = 'none'
            
        }
    })
    .catch(function (err) {
        console.log(err)
    });
}

// function verificacao() {
//     let isAdmin;
//     let isLog;
//     const URL_TO_FETCH = '/security/testar-cliente-login';
//     fetch(URL_TO_FETCH, {method: 'POST',
//        headers:{'Authorization':`${localStorage.getItem("token")}`,}})
//     .then(response=> response.text())
//     .then(result=> {
//         if(result.includes("Erro"))
//         {
//             isLog = false;
//             isAdmin = false;
//             alert(isLog)
//         }
//         else{
//             isLog = true;
//             isAdmin = true;
//         }
       
//     })
//     .catch(function (err) {
//         console.log(err)
//     });
//     if (!isLog)
//     {
//         document.getElementById("listaFunc").style.display = 'none'
//         document.getElementById("consultar").style.display = 'none'
//         document.getElementById("emprestimo").style.display = 'none'

//     }
// }

function logando() {

    let adm = document.getElementById("isAdm").checked;
    let logado = document.getElementById("logado");
    let resultado_login = document.getElementById("resultado_login");
    var login = document.getElementById("login").value;
    var senha = document.getElementById("senha").value;
    const URL_TO_FETCH = `/security/autenticar?login=${login}&senha=${senha}&adm=${adm}`;
    const data = new URLSearchParams();
    var token = localStorage.getItem("token");
    for (const pair of new FormData(document.getElementById('fdados'))) {
        data.append(pair[0], pair[1]);
    }
    fetch(URL_TO_FETCH, { method: 'post', body: senha })
        .then(response => { if (response.ok) return response.text(); else throw Error("Erro ao fazer login") })
        .then(text => { logado.style.display = "block"; alert("Logado");localStorage.setItem("token", text);alert(token);window.location.href="index.html"; })
        .catch(err => resultado_login.style.display = "block")
    event.preventDefault("fdados");

}
