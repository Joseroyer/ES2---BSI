function ValidaCPF(){	
	var RegraValida=document.getElementById("RegraValida").value; 
	var cpfValido = /^(([0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2})|([0-9]{11}))$/;	 
	if (cpfValido.test(RegraValida) == true)	{ 
	alert("CPF Válido");	
	} else	{	 
	alert("CPF Inválido");	
	}
    }
  function fMasc(objeto,mascara) {
obj=objeto
masc=mascara
setTimeout("fMascEx()",1)
}

function fMascEx() {
    obj.value=masc(obj.value)
    }
    
       function mCPF(cpf){
    cpf=cpf.replace(/\D/g,"")
    cpf=cpf.replace(/(\d{3})(\d)/,"$1.$2")
    cpf=cpf.replace(/(\d{3})(\d)/,"$1.$2")
    cpf=cpf.replace(/(\d{3})(\d{1,2})$/,"$1-$2")
    return cpf
    }

function isAdmin()
{
  let isAdmin = true;
  var display = document.getElementById("listaFunc").style.display;
  if(isAdmin)
    document.getElementById("listaFunc").style.display ='block'
  else 
    document.getElementById("listaFunc").style.display = 'none'

}

function Parameters()
{
  let parameters = true;
  if(!parameters)
  {
    alert("A parametrização não foi realizada, você será redirecionado!")
    window.location.href="parametrizacao.html"
    
  }
  
}

function CarregaLista()
{
    var filtro = document.getElementById("busca").value
    const URL_TO_FETCH = '/apis/listar-emprestimos';
    var status;
    fetch(URL_TO_FETCH, {method: 'POST',
       headers:{'Authorization':`${localStorage.getItem("token")}`,}})
    .then(response=> response.text())
    .then(result=> 
        {
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

                    

                    var table="";
                    for (let i=0;i<data.length;i++)
                    {
                            table+=`<tr>
                            <td>${data[i].id_editora}</td>
                            <td>${data[i].nome_editora}</td>
                            <td>${data[i].cidade_editora}</td>
                            <td>${data[i].estado_editora}</td>
                            <td><img width="30px" src='img/change.png' onclick='editar(${data[i].id_editora})'></td>
                            <td><img width="30px" src='img/trash.png' onclick='excluir(${data[i].id_editora})'></td>
                            </tr>`;        
                    }
                    document.getElementById("qlq").innerHTML=table;
                }
            }
        )
    .catch(err=> console.error(err));
}