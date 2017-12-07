package koreatech.cse.controller.initail;

import koreatech.cse.domain.Concert;
import koreatech.cse.repository.ConcertPeriodServiceMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class initalMethod implements ServletContextListener{

    @Inject
    ConcertPeriodServiceMapper concertPeriodServiceMapper;

    Concert concert;

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        concert = Concert.getInstance();
        concertPeriodServiceMapper.delete();
        getCultureDataBaseInsert();

    }
    private void getCultureDataBaseInsert() {
        System.out.println("Testing GET METHOD (1)----------");
        RestTemplate restTemplate = new RestTemplate();
        try {
            String culture= restTemplate.getForObject("http://openAPI.seoul.go.kr:8088/43794c63576a696e38334255747573/json/SearchConcertPeriodService/1/50/", String.class);

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


    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
