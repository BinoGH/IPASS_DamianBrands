let form = document.querySelector('#formNewProduct')
let submitButton = document.querySelector("#submit")

submitButton.addEventListener('click', function(){
    var formData = new FormData(form);
    var encData = new URLSearchParams(formData.entries());

    fetch("/restservices/product", {method: 'POST', body: encData})
        .then(response => response.json())
        .then(function(myJson) {
            console.log(myJson);
        })
})