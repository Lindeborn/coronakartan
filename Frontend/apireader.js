var getJSON = function(url, callback) {

    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.responseType = 'json';

    xhr.onload = function() {

        var status = xhr.status;

        if (status == 200) {
            callback(null, xhr.response);
        } else {
            callback(status);
        }
    };

    xhr.send();
};

getJSON('https://api.covid19api.com/dayone/country/sweden/status/confirmed/live
',  function(err, data) {

    if (err != null) {
        console.error(err);
    } else {

        var text = `Date: ${data.date}
        Cases: ${data.Cases}
        Country: ${data.Country}`

        console.log(text);
    }
});