let formLogin = document.querySelector("#loginItems");
let loginButton = document.querySelector("#login");

loginButton.addEventListener("click", function (){
    console.log(formLogin);
    var formData = new FormData(formLogin);
    var encData = new URLSearchParams(formData.entries());

    fetch("restservices/authentication", {method: 'POST', body: encData})
        .then(function (response){
            if(response.ok) return response.json();
            else throw "Wrong username/password";
        })
        .then(myJson => window.sessionStorage.setItem("myJWT", myJson.JWT))
        .catch(
            error => console.log(error)

        )
})

