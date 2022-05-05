let basketData = {
    getAllButtons: function() {
        let deleteIcon = document.querySelectorAll(".delete-icon");
        for (let i = 0; i < deleteIcon.length; i++) {
            deleteIcon[i].addEventListener("click", removeProduct);
        }
    },
    showBasketPrice: function() {
        let basketPrice = document.querySelector(".total-amount");
        basketPrice.innerHTML = initAmount() + " USD";
    }
}

let initAmount = function() {
    let totalAmount = 0.0;
    let subAmount = document.querySelectorAll(".subtotal-amount");
    for (let i = 0; i < subAmount.length; i++) {
        totalAmount += parseFloat(subAmount[i].innerHTML);
    }
    return totalAmount.toFixed(2);
}

let removeProduct = async function(clickEvent) {
    let productId = clickEvent.target.dataset.productId;
    console.log(productId);
    let closeModal = document.getElementById("product-modal");
    let span = document.getElementsByClassName("close")[0];
    let modalText = document.querySelector(".modal-text");
    span.onclick = function() {
        closeModal.style.display = "none";
    }
    window.onclick = function(clickEvent) {
        if (clickEvent.target === closeModal) {
            closeModal.style.display = "none";
        }
    }
    modalText.innerHTML = await dataHandler.deleteProductFromBasket(productId);
    let parent = clickEvent.target.parentNode;
    let grandParent = parent.parentNode;
    closeModal.style.display = "block";
    grandParent.remove();
    basketData.showBasketPrice();
}
