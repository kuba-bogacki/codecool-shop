function showBasketPrice() {
    let basketPrice = document.querySelector(".total-amount");
    basketPrice.innerHTML = this.initAmount() + " USD";
}

function initAmount() {
    let totalAmount = 0.0;
    let subAmount = document.querySelectorAll(".subtotal-amount");
    for (let i = 0; i < subAmount.length; i++) {
        totalAmount += parseFloat(subAmount[i].innerHTML);
    }
    return totalAmount;
}

showBasketPrice();