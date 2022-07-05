let collectProductsButtons = {
    getAllButtons: function () {
        let productButtons = document.querySelectorAll(".btn-success");
        for (let i = 0; i < productButtons.length; i++) {
            productButtons[i].addEventListener("click", this.putProductInBasket)
        }
    },
    putProductInBasket: async function(clickEvent) {
        let modal = document.getElementById("product-modal");
        let span = document.getElementsByClassName("close")[0];
        let modalText = document.querySelector(".modal-text");
        span.onclick = function() {
            modal.style.display = "none";
        }
        window.onclick = function(clickEvent) {
            if (clickEvent.target === modal) {
                modal.style.display = "none";
            }
        }
        let productId = clickEvent.target.dataset.productId;
        console.log(productId);
        console.log(clickEvent.target.dataset.productId);
        modalText.innerHTML = await dataHandler.addNewProduct(productId);
        modal.style.display = "block";
    }
}

