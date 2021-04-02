var json;
var jsonInfo;
var map;
var footer;
var antalFall;

$.ajax({
    type: 'GET',
    url: 'https://services5.arcgis.com/fsYDFeRKu1hELJJs/arcgis/rest/services/FOHM_Covid_19_FME_1/FeatureServer/0/query?f=geojson&where=Region%20%3C%3E%20%27dummy%27&returnGeometry=false&outFields=*',
    dataType: 'json',
    success: function(data) {
        json = JSON.parse(JSON.stringify(data));
        if (map) styleMap();
    }
});

$.ajax({
    type: 'GET',
    url: 'https://api.apify.com/v2/key-value-stores/8mRFdwyukavRNCr42/records/LATEST?disableRedirect=true',
    dataType: 'json',
    success: function(data) {
    jsonInfo = JSON.parse(JSON.stringify(data));
        console.log("Cases: " + jsonInfo.infected);
        setFooter();
        //document.querySelector('footer').innerHTML = "Totalt antal fall: " + jsonInfo[jsonInfo.length - 1].Cases;
    }
});

$(document).ready(function(){
    $("button").click(function(){
      $(".item").toggleClass("hide stats");
      });
  });

function styleMap() {
    map.data.setStyle(function(feature){
        return{
        fillColor: getColor(feature.getProperty('lan_namn')),
        strokeWeight: 1,
        fillOpacity: 0.7
        };
     });
}

function setFooter() {
    document.getElementsByClassName("confirmed")[0].innerHTML += " " + jsonInfo.infected;
    console.log(jsonInfo.infected);
    document.getElementsByClassName("deceased")[0].innerHTML += " " + jsonInfo.deceased;
    console.log(jsonInfo.deceased);
    document.getElementsByClassName("hospitalized")[0].innerHTML += " " + jsonInfo.intensiveCare;
    console.log(jsonInfo.intensiveCare);
}

function initMap(){
    const sweden = {
    lat: 60.187, lng: 15.047 };
    map = new google.maps.Map(document.getElementById("map"), {
    zoom: 4.5,
    center: sweden,
    });

    map.data.loadGeoJson("sverige-lan.geojson.json");
    styleMap();
    let infoWindow = null;

    map.data.addListener('mouseover', function(event) {
        map.data.revertStyle();
        map.data.overrideStyle(event.feature, {
        strokeWeight: 4
        });

        if(infoWindow!==null){
            infoWindow.close();
          }

        infoWindow = new google.maps.InfoWindow({
            position: event.latLng,
        });

        infoWindow.setContent(event.feature.getProperty('lan_namn'));

        infoWindow.open(map);
    });

    map.data.addListener('mouseout', function(event) {
        infoWindow.close();
        map.data.overrideStyle(event.feature, {
        strokeWeight: 1
        });
    });

    // <!--när man klickar på en region ska info dyka upp i inforutan-->
    map.data.addListener("click", (event) => {
        infoWindow.setContent(
        JSON.stringify(event.latLng.toJSON(), null, 2)
      );
    });
    }

function getColor(lan) {
    let antal;

    if (json) {
       for (let i = 0; i < json.features.length; i++){
           if(json.features[i].properties.Region == lan){
             antal = json.features[i].properties.Totalt_antal_fall;
            }
          }
    }

  return antal > 70000 ? "#A10100" :
         antal > 30000 ? "#DA1F05" :
         antal > 15000 ? "#F33C04" :
         antal > 6000 ? "#FE650D" :
         antal > 3000 ? "#FFC11F" :
         antal > 1000 ? "#FFF75D" :
         antal > 100 ? "#FFFBB2" :
                        "#FFF";
}







