package koreatech.cse.repository;


import koreatech.cse.domain.Authority;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityMapper {
    @Insert("INSERT INTO authorities (USER_ID, ROLE) VALUES (#{userId}, #{role})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
    void insert(Authority authority);

    @Update("UPDATE authorities SET USER_ID = #{userId}, ROLE = #{role} WHERE ID = #{id}")
    void update(Authority authority);

    @Select("SELECT * FROM authorities WHERE USER_ID = #{userId}")
    List<Authority> findByUserId(@Param("userId") int userId);

    @Delete("DELETE FROM authorities WHERE ID = #{id}")
    void delete(Authority authority);

}
