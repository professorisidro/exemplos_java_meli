function loadGeneros(){
    fetch("http://localhost:8080/generos")
        .then(res => res.json())
        .then(res => popularCombo(res))
        .catch(err => alert("Erro ao recuperar generos"))
}

function popularCombo(res){
    console.log(res);
    let strOption = "";
    for (i=0;i<res.length; i++){
        let gen = res[i];        
        strOption += `<option value="${gen.id}">${gen.name}</option>`
    }
    document.getElementById("generos").innerHTML = strOption;

}
function buscarSeries(){
    let idGenero = document.getElementById("generos").value;
    console.log(idGenero);
    fetch("http://localhost:8080/miniseries/genero/"+idGenero)
        .then(res => res.json())
        .then(res => exibeSeries(res))
        .catch(err => {alert("Erro ao recuperar series"); console.log(err)});
}

function exibeSeries(res){
    let strSerie="";
    for (i=0;i<res.length; i++){
        ser = res[i];
        strSerie += `<h4>${ser.name}</h4>
                    <strong>Rating:</strong> ${ser.rating} <br>
                    <strong>Awards:</strong> ${ser.amountOfAwards}<br><br>`;
    }
    document.getElementById("result").innerHTML = strSerie;
}