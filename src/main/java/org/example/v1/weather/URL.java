package org.example.v1.weather;

public enum URL {
    WEATHER(
            "https://api.openweathermap.org/data/2.5/weather?lat=41.327953&lon=19.819025&appid=dda8ab5bdf18c9a25c05908d805773cd");

//https://api.openweathermap.org/data/2.5/weather?lat=10&lon=10&appid=e49f331f3776254ee0574482b2783a49

//    {"coord":
//    {"lon":10,"lat":10},
//    "weather":[{"id":803,"main":"Clouds",
//    "description":"broken clouds","icon":"04d"}],
//    "base":"stations",
//    "main":{"temp":301.45,"feels_like":300.1,
//    "temp_min":301.45,
//    "temp_max":301.45,
//    "pressure":1011,
//    "humidity":20,
//    "sea_level":1011,"grnd_level":954},
//    "visibility":10000,"wind":{"speed":3.37,"deg":33,"gust":3.3},
//    "clouds":{"all":70},"dt":1671895489,"sys":{"country":"NG",
//    "sunrise":1671859995,"sunset":1671901535},"timezone":3600,"id":2347078,"name":"Birim","cod":200}
    private final String url;


    URL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
