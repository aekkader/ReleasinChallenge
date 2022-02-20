package releasin.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/book")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController {

    @Autowired
    private BookService bookService;

    // @RequestMapping("/")    
    @RequestMapping(path = "/list-books")
    public List<Book> getAllBooks() {    
        return bookService.list();    
    }   

    @RequestMapping(value="/add-book", method=RequestMethod.POST)    
    public void addBook(@RequestBody Book book) {    
        bookService.addBook(book);    
    }       

    // public List<Book> list() {
    //     return bookRepository.findAll();
    // }
}
