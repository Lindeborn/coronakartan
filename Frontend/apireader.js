var getJSON = function(url) {
  return new Promise(function(resolve, reject) {
    var xhr = new XMLHttpRequest();
    xhr.open('get', url, true);
    xhr.responseType = 'json';
    xhr.onload = function() {
      var status = xhr.status;
     if (status == 200) {
        resolve(xhr.response);
      } else {
        reject(status);
      }
    };
    xhr.send();
  });
};

getJSON("https://api.covid19api.com/dayone/country/south-africa/status/confirmed/live").then(function(data) { // Replace <URL> With your URL
    var jsondata = data.result; //store result in variable
    var date = jsondata[0].Date;
    var cases = jsondata[0].Cases;
    var country = jsondata[0].Country;
    // Your code here....///
    ///  Now you can access the json's data using jsondata variable:  //
    // jsondata[0].year will have the value of year key, jsondata[0].month will have month key and so on.... //

    consol.

}, function(status) { //error detection....
  alert('Something went wrong.');
});