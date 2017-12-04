package koreatech.cse.repository;

import koreatech.cse.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BookMapper {

    @Select("SELECT * FROM BOOKS")
    List<Book> listBook();


    @Insert("INSERT INTO BOOKS ( TITLE, AUTHOR, PAGE, USERID ) VALUES (#{title}, #{author}, #{page}, #{userid})")
    void insert(Book book);

    @Delete("DELETE FROM BOOKS WHERE USERID = #{userid} AND ID = #{bookid}")
    void delete(@Param("userid") int userid, @Param("bookid") int bookid);

}
