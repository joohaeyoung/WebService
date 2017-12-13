
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

    @Select("SELECT * FROM ConcertPeriodService WHERE TITLE=#{title}")
    Concert findOneByTitle(@Param("title") String title);


    @Select("SELECT * FROM ConcertPeriodService WHERE START_DATE=#{date} OR END_DATE=#{date}")
    List<Concert> concertStartDateList(@Param("date") String date);


    @Select("SELECT * FROM ConcertPeriodService")
    List<Concert> concertList();


    @Insert("INSERT INTO ConcertPeriodService (TITLE, START_DATE, END_DATE, PLACE) VALUES (#{title}, #{startdate}, #{enddate}, #{place})")
    void insert(Concert concert);

    @Update("UPDATE SET ConcertPeriodService TITLE = {#title}, START_DATE = {#startdate}, END_DATE = {#enddate}, PLACE = {#place} WHERE ID = {#id}")
    void update(Concert concert);


    @Delete("DELETE FROM ConcertPeriodService WHERE ID = {#id}")
    void deleteById(@Param("id") int id);


    @Delete("DELETE FROM ConcertPeriodService")
    void delete();


}
