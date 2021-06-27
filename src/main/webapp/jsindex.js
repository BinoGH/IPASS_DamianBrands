const productList = document.querySelector(".productList");

fetch("restservices/product", {method: "GET"})
    .then(response => response.json())
    .then(function(myJson){
        let alleProducten = myJson;
        for(let product of alleProducten){
            let productHouder = document.createElement("div");
            productHouder.className="product"
            let productName = document.createElement("div");
            productName.textContent=product.name
            productName.className="productName";
            let productPrijs = document.createElement("div");
            productPrijs.textContent=product.prijs
            productPrijs.className="productPrijs";

            productHouder.appendChild(productName);
            productHouder.appendChild(productPrijs);
            productList.appendChild(productHouder);
        }
    })

fetch("restservices/authentication", {method: "GET"})