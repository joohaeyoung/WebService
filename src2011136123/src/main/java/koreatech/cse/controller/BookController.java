package koreatech.cse.controller;

import koreatech.cse.domain.Authority;
import koreatech.cse.domain.Searchable;
import koreatech.cse.domain.User;
import koreatech.cse.domain.Book;
import koreatech.cse.repository.AuthorityMapper;
import koreatech.cse.repository.BookMapper;
import koreatech.cse.repository.UserMapper;
import koreatech.cse.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Inject
    private AuthorityMapper authorityMapper;

    @Inject
    private BookMapper bookMapper;

    @Inject
    private UserMapper userMapper;

    @Inject
    private UserService userService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping("/register")
    public String register(Model model) {

        Book book = new Book();
        model.addAttribute("book", book);
        return "register";
    }

    @Transactional
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value="/register", method= RequestMethod.POST)
    public String register(@ModelAttribute Book book) {

        User loginUser = User.current();

        int userid = loginUser.getId();
        book.setUserid(userid);
        bookMapper.insert(book);

        return "redirect:/book/list";
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {


        model.addAttribute("books", bookMapper.listBook());
        return "bookList";
    }

    @RequestMapping(value="/delete", method= RequestMethod.GET)
    public String delete(@RequestParam int userid, @RequestParam int bookid) {

        System.out.println(userid);

        User loginUser = User.current();
        int id = loginUser.getId();

        System.out.println(id);

        List<Authority> authorities = authorityMapper.findByUserId(id);

        int count = 0 ;
        for( Authority authority : authorities){
            System.out.println( authority.getAuthority() );

            if( authority.getAuthority().equals("ROLE_ADMIN"))
                count ++;
        }

        System.out.println(count);
        if( count >=1  ||  userid == id )
            bookMapper.delete(userid,bookid);

        return "redirect:/book/list";
    }
}
