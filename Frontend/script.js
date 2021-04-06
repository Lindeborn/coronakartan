var json;
var jsonInfo;
var jsonVacc;
var vaccTotal;
var map;
var footer;
var antalFall;
var colorClicked = false;
var detailsClicked = false;
const nbrOfCitizens = 10379295; //Sveriges befolkning under årsskiftet 2020-2021

/*
hämtar regional data om COVID-19 i JSON-form
datakälla: folkhälsomyndigheten
*/
$.ajax({
    type: 'GET',
    url: 'https://api.apify.com/v2/key-value-stores/8mRFdwyukavRNCr42/records/LATEST?disableRedirect=true',
    dataType: 'json',
    success: function(data) {
        jsonInfo = JSON.parse(JSON.stringify(data));
        if (map) styleMap();
        setFooter();
    }
});

/*
hämtar vaccinationsdata i JSON-form
datakälla: folkhälsomyndigheten via Our World in Data
*/
$.ajax({
    type: 'GET',
    url: 'https://covid.ourworldindata.org/data/vaccinations/vaccinations.json',
    dataType: 'json',
    success: function(data) {
    jsonVacc = JSON.parse(JSON.stringify(data));
    getSweden();
    $(".progress-bar-value").html(Math.round(Math.round((vaccTotal/nbrOfCitizens)*100)) + "%");
    $(".progress-bar-fill").css('width', (vaccTotal/nbrOfCitizens)*100 + "%");
    }
});


$(document).ready(function(){
    $("color-definition").click(function(){
      $(".item").toggleClass("hide stats");
      });
  });

//hämtar antal vaccinerade i Sverige från Our World in Data
function getSweden() {
    for(let i = 0; i < jsonVacc.length; i++){
        if(jsonVacc[i].country == 'Sweden'){
            vaccTotal = jsonVacc[i].data[jsonVacc[i].data.length - 1].people_vaccinated;
        }
    }
}

//färglägger regionerna utifrån villkoren i getColor
function styleMap() {
    map.data.setStyle(function(feature){
        return{
        fillColor: getColor(feature.getProperty('lan_namn')),
        strokeWeight: 1,
        fillOpacity: 0.7
        };
     });
}

//uppdaterar innehållet av hemsidans footer
function setFooter() {
    document.getElementsByClassName("confirmed")[0].innerHTML += " " + jsonInfo.infected;
    document.getElementsByClassName("deceased")[0].innerHTML += " " + jsonInfo.deceased;
    document.getElementsByClassName("hospitalized")[0].innerHTML += " " + jsonInfo.intensiveCare;
}

//initialiserar världskarta från Google Maps API och ställer in läge och inzoomning
function initMap(){
    const sweden = {
    lat: 60.187, lng: 15.047 };
    map = new google.maps.Map(document.getElementById("map"), {
    zoom: 4.5,
    center: sweden,
    });

    map.setOptions({ minZoom: 5, maxZoom: 20 });
    map.data.loadGeoJson("sverige-lan.geojson.json"); //GeoJSON: Sveriges regioner och deras geografiska data
    styleMap();
    let infoWindow = null;

    //en informationsruta med regionnamn dyker upp när muspekaren vilar på regionen
    map.data.addListener('mouseover', function(event) {
        map.data.revertStyle();
        map.data.overrideStyle(event.feature, {
        strokeWeight: 3
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

    //informationsrutan stängs när muspekaren lämnar regionen
    map.data.addListener('mouseout', function(event) {
        infoWindow.close();
        map.data.overrideStyle(event.feature, {
        strokeWeight: 1
        });
    });

    //när man klickar på en region dyker regional information upp i informationsrutan
    map.data.addListener("click", (event) => {
        infoWindow.setContent(getRegionData(event.feature.getProperty('lan_namn')));
    });
    }

//returnerar färgen som stämmer överens med villkoren
function getColor(lan) {
    let antal;

    if (jsonInfo) {
       for (let i = 0; i < jsonInfo.infectedByRegion.length; i++){
           if(jsonInfo.infectedByRegion[i].region == lan){
             antal = jsonInfo.infectedByRegion[i].infectedCount;
            }
          }
    }

  return antal > 80000 ? "#A10100" :
         antal > 50000 ? "#DA1F05" :
         antal > 30000 ? "#F33C04" :
         antal > 20000 ? "#FE7D0D" :
         antal > 10000 ? "#FFC11F" :
         antal > 2000 ? "#FFF75D" :
         antal > 500 ? "#FFFBB2" :
                        "#FFF";
}

//hämtar regional information från FHM för den region som användaren har klickat på
function getRegionData(lan) {
    for (let i = 0; i < jsonInfo.infectedByRegion.length; i++){
       if(jsonInfo.infectedByRegion[i].region == lan){
         antalFall = jsonInfo.infectedByRegion[i].infectedCount;
         antalAvlidna = jsonInfo.infectedByRegion[i].deathCount;
         antalIntensiv = jsonInfo.infectedByRegion[i].intensiveCareCount;
        }
      }
      return "Bekräftade fall: " + antalFall.toString()
             + "<br>Avlidna: " + antalAvlidna.toString()
             + "<br>Intensivvårdade: " + antalIntensiv.toString();
}

function toggleBtnColor() {
  if (colorClicked) {
    document.getElementById("sidePanelID").style.width = "0";
    colorClicked = false;
  } else {
    document.getElementById("sidePanelID").style.width = "400px";
    document.getElementById("detailsPnl").style.display = "none";
    document.getElementById("colorsPnl").style.display = "block";
    colorClicked = true;
    detailsClicked = false;
  }
}

function toggleBtnDetails() {
  if (detailsClicked) {
    document.getElementById("sidePanelID").style.width = "0";
    detailsClicked = false;
  } else {
    document.getElementById("sidePanelID").style.width = "400px";
    document.getElementById("detailsPnl").style.display = "block";
    document.getElementById("colorsPnl").style.display = "none";
    detailsClicked = true;
    colorClicked = false;
  }
}

function goToAPI() {
    alert("hej");
}








