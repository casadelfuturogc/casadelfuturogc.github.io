const input = document.querySelector('input');
// const log = document.getElementById('valores');

input.addEventListener('input', updateValue);

function updateValue(e) {
//   log.textContent = e.srcElement.value;
  console.log("Boton presionado");
  var estado = input.checked;
  console.log("Estado: "+estado);
  if (estado){ // está presionado
    document.getElementById("imagen").innerHTML = "<use id='logo' xlink:href='#lightOn' />";
    document.getElementById("imagen").style = "height: 190px;width: 190px;";

    document.getElementById("logo").style = "fill: rgb(249, 191, 22);";
    document.getElementById("fondo").style = "background-color: white;";
    document.getElementById("text").style = "color: #1e1e1e;";

  }else{ // NO está presionado
    document.getElementById("imagen").innerHTML = "<use id='logo' xlink:href='#lightOff' />";
    document.getElementById("imagen").style = "height: 200px;width: 200px;";

    document.getElementById("fondo").style = "background-color: #1e1e1e;";
    document.getElementById("text").style = "color: white;";
  }
}