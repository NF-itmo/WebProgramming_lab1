const sendAJAXGETRequest = (url, data, callback)  => {
    // encode url
    const query = [];
    for (const key in data) {
        query.push(String(key) + '=' + String(data[key]));
    }

    // creating AJAX req object
    const xhr = new XMLHttpRequest();
    // enable CORS support
    xhr.withCredentials = true;

    xhr.open("GET", url+(query.length ? '?' + query.join('&') : ''));

    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4) { // status of finished request
            callback(xhr.responseText)
        }
    };

    xhr.send(data)
};