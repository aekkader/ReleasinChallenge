package releasin.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> list() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {    
        return bookRepository.save(book);    
    }    

    public Optional<Book> findByID(Long bookID) {    
        return bookRepository.findById(bookID);    
    }    

}
