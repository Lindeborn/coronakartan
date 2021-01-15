$(document).ready(function(){
    $("button").click(function(){
      $(".item").toggleClass("hide stats");
      });
  });

function initMap(){
    const sweden = {
    lat: 60.187, lng: 15.047 };
    const map = new google.maps.Map(document.getElementById("map"), {
    zoom: 4.5,
    center: sweden,
    });

    map.data.loadGeoJson("sverige-lan.geojson.json");
    map.data.setStyle(function(feature){
       return{
       fillColor: getColor(feature.getProperty('lan_namn')),
       strokeWeight: 1,
       fillOpacity: 0.7
       };
    });

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

    <!--när man klickar på en region ska info dyka upp i inforutan-->
    map.data.addListener("click", (event) => {
        infoWindow.setContent(
        JSON.stringify(event.latLng.toJSON(), null, 2)
      );
    });
    }

function getColor(lan) {
   $.ajax({
    type: 'GET',
    url: 'coronastatistik-lan.json',
    dataType: 'json',
    success: function(data) {
       var json = JSON.parse(JSON.stringify(data));

       for (let i = 0; i < json.features.length; i++){
           if(json.features[i].properties.Region == lan){
             var antal = json.features[i].properties.Totalt_antal_fall;

             return antal > 70000 ? "red" :
                  antal > 20000  ? "darkOrange" :
                  antal > 10000  ? "orange" :
                  antal > 6000  ? "yellow" :
                  antal > 3000   ? "greenYellow" :
                  antal > 1000   ? "limeGreen" :
                  antal > 100   ? "lightGreen" :
                             "skyBlue";
            }
         }
      }
  });
}






