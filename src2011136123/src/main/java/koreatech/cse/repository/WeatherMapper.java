package koreatech.cse.repository;

import koreatech.cse.domain.Weather;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherMapper {

    @Select("SELECT * FROM WeatherForecast")
    List<Weather> weatherList();

    @Insert("INSERT INTO WeatherForecast (ID, TITLE, FCTTEXT, ICON) VALUES (#{id}, #{title}, #{fcttext}, #{icon})")
    void insert(Weather weather);

    @Delete("DELETE FROM WeatherForecast")
    void flushWeather();
}
