showLocalStorageList = function() {
    let itemIntegerList = [];
    let parsedBasket = JSON.parse(localStorage.getItem('productInBasket'));
    for (let i = 0; i < parsedBasket.length; i++) {
        itemIntegerList.push(parseInt(parsedBasket[i]));
    }
    console.log(itemIntegerList);
}
showLocalStorageList();
