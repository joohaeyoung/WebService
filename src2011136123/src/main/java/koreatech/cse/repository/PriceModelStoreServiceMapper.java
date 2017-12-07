package koreatech.cse.repository;

import koreatech.cse.domain.Food;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
@Repository
public interface PriceModelStoreServiceMapper {

    @Select("SELECT * FROM PriceModelStoreService")
    List<Food> foodList();

    @Insert("INSERT INTO PriceModelStoreService (SH_NAME, SH_INFO, SH_PRIDE, SH_ADDR) VALUES (#{shname}, #{shinfo}, #{shpride}, #{shaddr})")
    void insert(Food food);

}*/



import koreatech.cse.domain.Food;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceModelStoreServiceMapper {

    @Select("SELECT * FROM PriceModelStoreService")
    List<Food> foodList();

    @Select("SELECT * FROM PriceModelStoreService WHERE SH_NAME={#name}")
    Food foodByName(@Param("name") String name);

    @Update("UPDATE SET PriceModelStoreService SH_NAME={#shname}, SH_INFO={#shinfo}, SH_PRIDE={#shpride}, SH_ADDR={#shaddr} WHERE ID={#id}")
    void update(Food food);

    @Delete("DELETE FROM PriceModelStoreService WHERE SH_NAME={#name}")
    void delete(@Param("name") String name);

    @Insert("INSERT INTO PriceModelStoreService (SH_NAME, SH_INFO, SH_PRIDE, SH_ADDR) VALUES (#{shname}, #{shinfo}, #{shpride}, #{shaddr})")
    void insert(Food food);

}