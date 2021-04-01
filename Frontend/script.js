var json;
var map;
$.ajax({
    type: 'GET',
    url: 'https://services5.arcgis.com/fsYDFeRKu1hELJJs/arcgis/rest/services/FOHM_Covid_19_FME_1/FeatureServer/0/query?f=geojson&where=Region%20%3C%3E%20%27dummy%27&returnGeometry=false&outFields=*',
    dataType: 'json',
    success: function(data) {
        json = JSON.parse(JSON.stringify(data));
        if (map) styleMap();
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
        console.log(json);
       for (let i = 0; i < json.features.length; i++){
       //console.log(json.features[i].properties.Region);
           if(json.features[i].properties.Region == lan){
           console.log(json.features[i].properties.Region + ": " + json.features[i].properties.Totalt_antal_fall);
             antal = json.features[i].properties.Totalt_antal_fall;
            }
          }
    }

  return antal > 70000 ? "#be64ac" :
         antal > 30000 ? "#8c62aa" :
         antal > 15000 ? "#3b4994" :
         antal > 6000 ? "#dfb0d6" :
         antal > 3000 ? "#a5add3" :
         antal > 1000 ? "#5698b9" :
         antal > 100 ? "#e8e8e8" :
                        "#5ac8c8";
}






