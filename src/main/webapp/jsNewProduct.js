let form = document.querySelector('#formNewProduct')
let submitButton = document.querySelector("#submit")

submitButton.addEventListener('click', function(){
    var formData = new FormData(form);
    var encData = new URLSearchParams(formData.entries());
    console.log(window.sessionStorage.getItem("myJWT"))

    fetch("/restservices/product", {
        method: 'POST',
        // headers: {"Authorization": "Bearer " + window.sessionStorage.getItem("myJWT")},
        body: encData})

        .then(response => response.json())
        .then(function(myJson) {
            console.log(myJson);
        })
})