var estado = 0;
function encenderON(){
    estado = 1;
}
function apagarOFF(){
    estado = 0;
}

setInterval(function() {
    // Call a function repetatively with 10 ms interval
    updateLightImages();
}, 10);

function updateLightImages() {
    if(estado == 0){
        document.getElementById("LIGHTState").innerHTML = "OFF";
        document.getElementById("LightImage").src="https://i.ibb.co/YPfdrLw/apagado-foco.png";
    }else{
        document.getElementById("LIGHTState").innerHTML = "ON";
        document.getElementById("LightImage").src="https://i.ibb.co/wg8vTFF/prendido-foco.png";
    }
}