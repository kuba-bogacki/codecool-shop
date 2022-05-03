let basketList = [];

let collectProductsButtons = {
    getAllButtons: function () {
        let productButtons = document.querySelectorAll(".btn-success");
        for (let i = 0; i < productButtons.length; i++) {
            let button = productButtons[i];
            button.addEventListener("click", this.saveProductIdToLocalStorage);
        }
    },
    saveProductIdToLocalStorage: async function(clickEvent) {
        let productId = clickEvent.target.dataset.productId;
        basketList.push(productId);
        localStorage.setItem('productInBasket', JSON.stringify(basketList));
    }
}

