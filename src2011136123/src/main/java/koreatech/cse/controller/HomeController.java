package koreatech.cse.controller;

import koreatech.cse.domain.Concert;
import koreatech.cse.domain.Deli;
import koreatech.cse.domain.Food;

import koreatech.cse.domain.Weather;
import koreatech.cse.repository.*;

import koreatech.cse.repository.BookMapper;
import koreatech.cse.repository.ConcertPeriodServiceMapper;
import koreatech.cse.repository.DeliciousStoreServiceMapper;
import koreatech.cse.repository.PriceModelStoreServiceMapper;

import koreatech.cse.service.Culture;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import javax.inject.Inject;

@Controller
@RequestMapping("/")
public class HomeController {

    @Inject
    private ConcertPeriodServiceMapper concertPeriodServiceMapper;

    @Inject
    private PriceModelStoreServiceMapper priceModelStoreServiceMapper;

    @Inject
    private DeliciousStoreServiceMapper deliciousStoreServiceMapper;


    @Inject
    private WeatherMapper weatherMapper;

    Concert concert;
    Food food;
    Deli deli;
   Weather fcast;
    @RequestMapping
    public String home(Model model) {
        return "hello";
    }
    /*
        @RequestMapping("/searchValue")
        public String searchValueControll(Model model, @RequestParam("month") String month,  @RequestParam("day") String day) throws IOException{

            String monthAndDay = "2017"+"-"+month+"-"+day;


            System.out.println(monthAndDay);
            concert = Concert.getInstance();

            concertPeriodServiceMapper.delete();
            getCultureDataBaseInsert();
            model.addAttribute("concert",concertPeriodServiceMapper.concertList2(monthAndDay));
            return "concertList";
        }
    */
    @RequestMapping("/searchValue")
    public String searchValueControll(Model model, @RequestParam("month") String month,  @RequestParam("day") String day) throws IOException{

        String monthAndDay = "2017"+"-"+month+"-"+day;

        System.out.println(monthAndDay);

        model.addAttribute("concert",concertPeriodServiceMapper.concertStartDateList(monthAndDay));
        return "concertList";
    }

    private void getCultureDataBaseInsert() {
        System.out.println("Testing GET METHOD (1)----------");
        RestTemplate restTemplate = new RestTemplate();
        try {
            String culture= restTemplate.getForObject("http://openAPI.seoul.go.kr:8088/43794c63576a696e38334255747573/json/SearchConcertPeriodService/1/200/", String.class);

            try{
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject1 = (JSONObject) jsonParser.parse(culture);
                JSONObject jsonObject2 = (JSONObject) jsonObject1.get("SearchConcertPeriodService");
                JSONArray array = (JSONArray) jsonObject2.get("row");

                for( int i = 0 ; i < array.size() ; i++ ){

                    JSONObject entitiy = (JSONObject)array.get(i);
                    concert.setTitle((String)entitiy.get("TITLE"))
                            .setStartdate((String)entitiy.get("STRTDATE"))
                            .setEnddate((String)entitiy.get("END_DATE"))
                            .setPlace((String)entitiy.get("PLACE"));

                    concertPeriodServiceMapper.insert(concert);
                }
            }catch (ParseException e){
                e.printStackTrace();
            }
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
        }
    }

    @RequestMapping("/foodList")
    public String foodListControll(Model model) throws IOException{

        food = Food.getInstance();

        getFoodDataBaseInsert();
        model.addAttribute("food",priceModelStoreServiceMapper.foodList());

        List<Food> test =priceModelStoreServiceMapper.foodList();

        System.out.println( test.get(0));

        return "foodList";
    }

    public void getFoodDataBaseInsert() {
        System.out.println("Testing GET METHOD (2)--------from SONG--");
        RestTemplate restTemplate = new RestTemplate();
        try {
            String price= restTemplate.getForObject("http://openapi.seoul.go.kr:8088/65434e42436a696e3130324972455743/json/ListPriceModelStoreService/1/50/", String.class);
            try{
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject1 = (JSONObject) jsonParser.parse(price);
                JSONObject jsonObject2 = (JSONObject) jsonObject1.get("ListPriceModelStoreService");
                JSONArray array = (JSONArray) jsonObject2.get("row");

                for( int i = 0 ; i < array.size() ; i++ ){

                    JSONObject entitiy = (JSONObject)array.get(i);
                    food.setShname((String)entitiy.get("SH_NAME"))
                            .setShinfo((String)entitiy.get("SH_INFO"))
                            .setShpride((String)entitiy.get("SH_PRIDE"))
                            .setShaddr((String)entitiy.get("SH_ADDR"));

                    priceModelStoreServiceMapper.insert(food);
                }

            }catch (ParseException e){
                e.printStackTrace();
            }
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
        }
    }

    @RequestMapping("/delihouseList")
    public String deliListControll(Model model) throws IOException{

        deli = Deli.getInstance();

        getDeliDataBaseInsert();
        model.addAttribute("deli",deliciousStoreServiceMapper.deliList());

        List<Deli> test =deliciousStoreServiceMapper.deliList();

        System.out.println( test.get(0));

        return "delihouseList";
    }

    public void getDeliDataBaseInsert() {
        System.out.println("Testing GET METHOD (3)-------from SONG---");
        RestTemplate restTemplate = new RestTemplate();
        try {
            String price= restTemplate.getForObject("http://openapi.seoul.go.kr:8088/73736d66676a696e3935476d626861/json/SebcVisitKor/1/200/", String.class);
            try{
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject1 = (JSONObject) jsonParser.parse(price);
                JSONObject jsonObject2 = (JSONObject) jsonObject1.get("SebcVisitKor");
                JSONArray array = (JSONArray) jsonObject2.get("row");

                for( int i = 0 ; i < array.size() ; i++ ){

                    JSONObject entitiy = (JSONObject)array.get(i);
                    deli.setCate2name((String)entitiy.get("CATE2_NAME"))
                            .setNamekor((String)entitiy.get("NAME_KOR"))
                            .setHkorgu((String)entitiy.get("H_KOR_GU"))
                            .setHkordong((String)entitiy.get("H_KOR_DONG"));

                    deliciousStoreServiceMapper.insert(deli);
                }

            }catch (ParseException e){
                e.printStackTrace();
            }
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
        }
    }


    @RequestMapping("/weatherValue")
    public String searchValueControll(Model model) throws IOException{

        fcast = new Weather();

        getWeatherData();
        model.addAttribute("fcastmodel",weatherMapper.weatherList());
        return "weatherList";
    }

    private void getWeatherData() {
        System.out.println("Testing GET METHOD (2)----------");
        RestTemplate restTemplate = new RestTemplate();
        try {
            String weather = restTemplate.getForObject("http://api.wunderground.com/api/1a0597f9ceaf824a/forecast/lang:KR/q/KR/Seoul.json", String.class);
            JSONParser jsonParser = new JSONParser();
            Object object;

            try{
                object = jsonParser.parse(weather);
                JSONObject jsonObject = (JSONObject) object;

                JSONObject forecast = (JSONObject) jsonObject.get("forecast");
                JSONObject txt_forecast = (JSONObject) forecast.get("txt_forecast");
                JSONArray forecastday = (JSONArray) txt_forecast.get("forecastday");

                weatherMapper.flushWeather();

                for( int j = 0 ; j < forecastday.size() ; j++ ){
                    JSONObject entitiy = (JSONObject)forecastday.get(j);
                    System.out.println("Period : "+ entitiy.get("period") +
                            ", Title : " + entitiy.get("title") +
                            ", Fcttext_Metric : " + entitiy.get("fcttext_metric") +
                            ", Icon_Url : " + entitiy.get("icon_url" ));

                    fcast.setId(j);
                    fcast.setTitle((String)entitiy.get("title"));
                    fcast.setFcttext((String)entitiy.get("fcttext_metric"));
                    fcast.setIcon((String)entitiy.get("icon_url"));

                    weatherMapper.insert(fcast);
                }

            }catch (ParseException e){
                e.printStackTrace();
            }
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
        }
    }






    @RequestMapping("/requestParamTest")
    public String requestParamTest(@RequestParam(name = "a", required=false, defaultValue = "0") int a,
                                   @RequestParam("b") String b,
                                   @RequestParam(value= "c", defaultValue = "true") boolean c) {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        return "hello";
    }

    @RequestMapping("/pathVariableTest/{a}/{b}/{c}")
    public String pathVariableTest(@PathVariable(value="a") String a, @PathVariable String b, @PathVariable int c) {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        return "hello";
    }

    @RequestMapping("/requestParamMapTest")
    public String requestParamMapTest(@RequestParam Map<String, String> map) {
        for(Map.Entry entry: map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        return "hello";
    }

    @RequestMapping(value = "/requestMappingGetTest",
            method = RequestMethod.GET,
            params ="test=true")
    public String requestMappingGetTest(Model model) {
        model.addAttribute("textFromController", "World");
        return "hello";
    }

    @RequestMapping(value = "/requestMappingPostTest",
            method = RequestMethod.POST)
    @ResponseBody
    public String requestMappingPostTest() {
        return "hello";
    }
}
