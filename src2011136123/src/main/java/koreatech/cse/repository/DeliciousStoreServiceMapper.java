package koreatech.cse.repository;

import koreatech.cse.domain.Deli;
import koreatech.cse.domain.Food;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliciousStoreServiceMapper {

    @Select("SELECT * FROM DeliciousStoreService")
    List<Deli> deliList();

    @Insert("INSERT INTO DeliciousStoreService (CATE2_NAME, NAME_KOR, H_KOR_GU, H_KOR_DONG) VALUES (#{cate2name}, #{namekor}, #{hkorgu}, #{hkordong})")
    void insert(Deli deli);

}
