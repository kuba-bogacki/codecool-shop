let dataHandler = {
    addNewProduct: async function (productId) {
        const response = await apiGet(`/show-basket/add/${productId}`);
        return response;
    },
};

async function apiGet(url) {
    let response = await fetch(url, {
        method: "GET",
    });
    let data = await response.text();
    return data;
}

async function apiPost(url, payload) {
    let response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(payload),
        headers: {"Content-type": "application/json; charset=UTF-8"}
    });
    if (response.status === 200) {
        let data = await response.json();
        return data;
    }
}