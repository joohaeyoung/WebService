package koreatech.cse.repository;

import koreatech.cse.domain.Food;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceModelStoreServiceMapper {

    @Select("SELECT * FROM PriceModelStoreService")
    List<Food> foodList();

    @Insert("INSERT INTO PriceModelStoreService (SH_NAME, SH_INFO, SH_PRIDE, SH_ADDR) VALUES (#{shname}, #{shinfo}, #{shpride}, #{shaddr})")
    void insert(Food food);

}
