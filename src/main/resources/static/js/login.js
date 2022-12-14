
function verificarLogin()
{
    var listaFunc = document.getElementById("listaFunc").style.display = 'none'
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
            document.getElementById("listaFunc").style.display = 'block'
            document.getElementById("logButton").style.display = 'none'
            
        }
    })
    .catch(function (err) {
        console.log(err)
    });
}


//falta verificar a mensagem se está ativo ou não
function logando() {
    let signup = document.getElementById("SignUp").style.display = "none";
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
        .then(text => { 
            // signup.style.display = "none";
            resultado_login.style.display = "none";
            logado.style.display = "block"; 
            localStorage.setItem("token", text);
            setTimeout(function() {
                window.location.href = "index.html";
            }, 3000);
             })
        .catch(err => resultado_login.style.display = "block")
    event.preventDefault("fdados");

}
