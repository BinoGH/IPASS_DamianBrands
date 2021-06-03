var form = document.getElementById('form')

form.addEventListener('submit', function (event){
    event.preventDefault()
    var naam = document.getElementById('productName').value;
    var prijs = document.getElementById('prijs').value;

    console.log(naam);
    console.log(prijs);
})

// const submit = document.querySelector('button');
// const logo = document.querySelector('logo');
//
// const init = function (){
//     document.getElementById('button-opslaan').addEventListener('click', opslaan)
// }
//
// submit.addEventListener('click', function (){
//     logo.classList.add('test');
// })
//
//
// document.querySelector("")
// fetch("restservices/product", {method: 'POST', body: encData})
//     .then(response => response.json)
//     .then()
//
// document.addEventListener('DOMContentLoaded', init);
//
// document.getElementById("form").submit();