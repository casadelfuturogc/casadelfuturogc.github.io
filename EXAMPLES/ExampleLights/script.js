var estado = 0;
function encenderON(){
    estado = 1;
    document.getElementById("LIGHTState").innerHTML = "ON";
    // document.getElementById("LightImage").src="https://i.ibb.co/wg8vTFF/prendido-foco.png";
    document.getElementById("LightImage").src="https://i.pinimg.com/originals/05/f8/ae/05f8ae9d4c2fb5239bac4cec0d313b80.png";
}
function apagarOFF(){
    estado = 0;
    document.getElementById("LIGHTState").innerHTML = "OFF";
    document.getElementById("LightImage").src="https://i.ibb.co/YPfdrLw/apagado-foco.png";
}

// setInterval(function() {
//     // Call a function repetatively with 15 Second interval
//     getThingSpeakLightState();
// }, 10);

// function getThingSpeakLightState() {
//     if(estado == 0){
//     }else{
//     }
// }