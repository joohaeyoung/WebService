package koreatech.cse.controller.rest;

import koreatech.cse.domain.Food;
import koreatech.cse.repository.PriceModelStoreServiceMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/FoodService")
public class FoodRestController {

    @Inject
    private PriceModelStoreServiceMapper priceModelStoreServiceMapper;

    /* 전체 콘서트 보내주기 */
    @Transactional
    @RequestMapping(value="/food", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Food>> food() {
        List<Food> foodList = priceModelStoreServiceMapper.foodList();
        if (foodList == null) {
            System.out.println("Food all with food (" +foodList + ") is not found");
            return new ResponseEntity<List<Food>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Food>>(foodList, HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value="/xml/food", method= RequestMethod.GET, produces="application/xml")
    public ResponseEntity<List<Food>> foodtXml() {
        List<Food> foodList = priceModelStoreServiceMapper.foodList();
        if (foodList == null) {
            System.out.println("Food all with food " + foodList + " is not found");
            return new ResponseEntity<List<Food>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Food>>(foodList, HttpStatus.OK);
    }

    /* 이름 별 착한 업소*/
    @Transactional
    @RequestMapping(value="/food/{name}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Food> concert(@PathVariable("name") String name) {
        Food food= priceModelStoreServiceMapper.foodByName(name);
        if (food == null) {
            System.out.println("Food food with food (" + name+ ") is not found");
            return new ResponseEntity<Food>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Food>(food, HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value="/xml/food/{name}", method= RequestMethod.GET, produces="application/xml")
    public ResponseEntity<Food> concertXml(@PathVariable("name") String name) {
        Food food = priceModelStoreServiceMapper.foodByName(name);
        if (food == null) {
            System.out.println("Food food with food" + name+ " is not found");
            return new ResponseEntity<Food>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Food>(food, HttpStatus.OK);
    }

    /* POST 서비스*/
    @Transactional
    @RequestMapping(value = "/food/", method = RequestMethod.POST)
    public ResponseEntity<Void> createFood(@RequestBody Food food, UriComponentsBuilder ucBuilder) {
        if (priceModelStoreServiceMapper.foodByName(food.getShname()) != null) {
            System.out.println("A Food food with name(" +
                    food.getShname() + ") already exists");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        priceModelStoreServiceMapper.insert(food);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(
                ucBuilder.path("/food/{name}").buildAndExpand(food.getShname()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /* PUT 서비스 */
    @Transactional
    @RequestMapping(value = "/food/{name}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateFood(@PathVariable("name") String name, @RequestBody Food food) {
        Food storedFood= priceModelStoreServiceMapper.foodByName(name);

        if (storedFood == null) {
            System.out.println("No Food food with name (" + name+ " not found");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        storedFood.setId(food.getId());
        storedFood.setShname(food.getShname());
        storedFood.setShinfo(food.getShinfo());
        storedFood.setShaddr(food.getShaddr());
        storedFood.setShpride(food.getShpride());

        priceModelStoreServiceMapper.update(storedFood);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    /*DELETE 서비스 */
    @Transactional
    @RequestMapping(value = "/food/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<Food> deleteFood(@PathVariable("name") String name) {
        Food storedFood = priceModelStoreServiceMapper.foodByName(name);

        if (storedFood == null) {
            System.out.println("No Food title with food (" + storedFood.getShname() + " not found");
            return new ResponseEntity<Food>(HttpStatus.NOT_FOUND);
        }
        priceModelStoreServiceMapper.delete(storedFood.getShname());

        return new ResponseEntity<Food>(HttpStatus.NO_CONTENT);

    }

}