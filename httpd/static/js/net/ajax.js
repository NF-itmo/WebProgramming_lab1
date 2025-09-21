const sendAJAXRequest = (method, url, data) => {
    return new Promise((resolve, reject) => {
        // encode url
        const query = [];
        for (const key in data) {
            query.push(String(key) + '=' + String(data[key]));
        }

        // creating AJAX req object
        const xhr = new XMLHttpRequest();
        // enable CORS support
        xhr.withCredentials = true;

        xhr.open(method, url + (query.length ? '?' + query.join('&') : ''));

        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4) {
                if (xhr.status >= 200 && xhr.status < 300) {
                    resolve({
                        status: xhr.status,
                        response: xhr.responseText
                    });
                } else {
                    reject({
                        status: xhr.status,
                        response: xhr.responseText
                    });
                }
            }
        };

        xhr.send();
    });
};