let formLogin = document.querySelector("#formLoginItems");
let loginButton = document.querySelector("#loginButton");

loginButton.addEventListener("click", function (){
    var formData = new FormData(form);
    var encData = new URLSearchParams(formData.entries());

    fetch("restservices/gebruiker")
})