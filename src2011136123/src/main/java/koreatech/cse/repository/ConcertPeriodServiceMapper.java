
package koreatech.cse.repository;

import koreatech.cse.domain.Book;
import koreatech.cse.domain.Concert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
@Repository
public interface ConcertPeriodServiceMapper {

    @Select("SELECT * from ConcertPeriodService WHERE START_DATE=#{date} OR END_DATE=#{date}")
    List<Concert> concertList2(@Param("date") String date);

    @Select("SELECT * FROM ConcertPeriodService")
    List<Concert> concertList();

    @Insert("INSERT INTO ConcertPeriodService (TITLE, START_DATE, END_DATE, PLACE) VALUES (#{title}, #{startdate}, #{enddate}, #{place})")
    void insert(Concert concert);

    @Delete("delete from ConcertPeriodService")
    void delete();


}
*/

import koreatech.cse.domain.Book;
import koreatech.cse.domain.Concert;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcertPeriodServiceMapper {

   


}
