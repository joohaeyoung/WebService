package koreatech.cse.controller.rest;

import koreatech.cse.domain.Concert;
import koreatech.cse.repository.ConcertPeriodServiceMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/concertService")
public class ConcertRestController {

    @Inject
    private ConcertPeriodServiceMapper concertPeriodServiceMapper;

    /* 전체 콘서트 보내주기 */
    @Transactional
    @RequestMapping(value="/concert", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Concert>> concert() {
        List<Concert> concertList = concertPeriodServiceMapper.concertList();
        if (concertList == null) {
            System.out.println("Concert all with date (" +concertList + ") is not found");
            return new ResponseEntity<List<Concert>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Concert>>(concertList, HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value="/xml/concert", method= RequestMethod.GET, produces="application/xml")
    public ResponseEntity<List<Concert>> concertXml() {
        List<Concert> concertList = concertPeriodServiceMapper.concertList();
        if (concertList == null) {
            System.out.println("Concert all with date " + concertList + " is not found");
            return new ResponseEntity<List<Concert>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Concert>>(concertList, HttpStatus.OK);
    }

    /* 날짜 별 콘서트 보내주기 */
    @Transactional
    @RequestMapping(value="/concert/{date}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Concert>> concert(@PathVariable("date") String date) {
        List<Concert> concertList = concertPeriodServiceMapper.concertStartDateList(date);
        if (concertList == null) {
            System.out.println("Concert date with date (" + date+ ") is not found");
            return new ResponseEntity<List<Concert>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Concert>>(concertList, HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value="/xml/concert/{date}", method= RequestMethod.GET, produces="application/xml")
    public ResponseEntity<List<Concert>> concertXml(@PathVariable("date") String date) {
        List<Concert> concertList = concertPeriodServiceMapper.concertStartDateList(date);
        if (concertList == null) {
            System.out.println("Concert date with date " + date + " is not found");
            return new ResponseEntity<List<Concert>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Concert>>(concertList, HttpStatus.OK);
    }

    /* POST 서비스*/
    @Transactional
    @RequestMapping(value = "/concert/", method = RequestMethod.POST)
    public ResponseEntity<Void> createTemperature(@RequestBody Concert concert, UriComponentsBuilder ucBuilder) {
        if (concertPeriodServiceMapper.findOneByTitle(concert.getTitle()) != null) {
            System.out.println("A temperature sensor with id (" +
                    concert.getTitle() + ") already exists");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        concertPeriodServiceMapper.insert(concert);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(
                ucBuilder.path("/concert/{date}").buildAndExpand(concert.getStartdate()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /* PUT 서비스 */
    @Transactional
    @RequestMapping(value = "/concert/{title}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateTemperature(@PathVariable("title") String title, @RequestBody Concert concert) {
        Concert storedConcert= concertPeriodServiceMapper.findOneByTitle(title);

        if (storedConcert == null) {
            System.out.println("No Concert concert with title (" + title + " not found");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        storedConcert.setId(concert.getId());
        storedConcert.setTitle(concert.getTitle());
        storedConcert.setStartdate(concert.getStartdate());
        storedConcert.setEnddate(concert.getEnddate());
        storedConcert.setPlace(concert.getPlace());
        concertPeriodServiceMapper.update(storedConcert);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    /*DELETE 서비스 */
    @Transactional
    @RequestMapping(value = "/concert/{title}", method = RequestMethod.DELETE)
    public ResponseEntity<Concert> deleteTemperature(@PathVariable("title") String title) {
        Concert storedConcert = concertPeriodServiceMapper.findOneByTitle(title);

        if (storedConcert == null) {
            System.out.println("No Concert title with title (" + title + " not found");
            return new ResponseEntity<Concert>(HttpStatus.NOT_FOUND);
        }
        concertPeriodServiceMapper.deleteById(storedConcert.getId());
        return new ResponseEntity<Concert>(HttpStatus.NO_CONTENT);
    }

}
