package koreatech.cse.controller;

import koreatech.cse.domain.Concert;
import koreatech.cse.repository.BookMapper;
import koreatech.cse.repository.ConcertPeriodServiceMapper;
import koreatech.cse.service.Culture;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.inject.Inject;

@Controller
@RequestMapping("/")
public class HomeController {

    @Inject
    private ConcertPeriodServiceMapper concertPeriodServiceMapper;

    Concert concert;

    @RequestMapping
    public String home(Model model) {
        return "hello";
    }

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
    
    private void getWeatherData() {
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
                //System.out.println("\tForecastday: " + forecastday);

                // take the elements of the json array
                //for(int i=0; i<forecastday.size(); i++){
                //    System.out.println("The " + i + " element of the array: "+forecastday.get(i));
                //}
                Iterator i = forecastday.iterator();

                while (i.hasNext()) {
                    JSONObject innerObj = (JSONObject) i.next();
                    System.out.println("Period : "+ innerObj.get("period") +
                            ", 예보일 : " + innerObj.get("title") +
                            ", 날씨 예보 : " + innerObj.get("fcttext_metric") +
                            ", 날씨 아이콘 URL : " + innerObj.get("icon_url" ));
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
