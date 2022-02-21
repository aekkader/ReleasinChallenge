package releasin.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/page")
// @RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
// @CrossOrigin(origins = "http://localhost:8081")
public class PageController {

    @Autowired
    private PageService pageService;
    
    @Autowired
    private BookService bookService;

    // @RequestMapping("/")    
    @RequestMapping(path = "/list-pages")
    public List<Page> getAllPages() {    
        return pageService.list();    
    }   

    @RequestMapping(path = "/list-pages-claire")
    public List<PageClaire> getAllPagesClaire() {    
        
        List<PageClaire> lereteur = new ArrayList<>();

        List<Page> findList = pageService.list();
        for(int i=0; i < findList.size(); i++){
            Page laPage = findList.get(i);

            PageClaire laPageClaire = laPage.toClaire();
            lereteur.add(laPageClaire);
        }

        return lereteur;    
    }   

    

    @RequestMapping(value="/add-page", method=RequestMethod.POST)    
    public void addPage(@RequestBody PageFields item) {

        Book leBook = bookService.findByID(item.book).get();
        Page lapage = new Page();
        lapage.name = item.name;
        lapage.book = leBook;

        pageService.addPage(lapage);    
    }       

    // @CrossOrigin(origins = "http://localhost:8081")
    // @RestController
    // @RequestMapping("/api")
    // public class TutorialController {
    //   @Autowired
    //   TutorialRepository tutorialRepository;
    //   @GetMapping("/tutorials")
    //   public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
    //     List<Tutorial> tutorials = new ArrayList<Tutorial>();
    //     if (title == null)
    //       tutorialRepository.findAll().forEach(tutorials::add);
    //     else
    //       tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
    //     if (tutorials.isEmpty()) {
    //       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //     }
    //     return new ResponseEntity<>(tutorials, HttpStatus.OK);
    //   }
    //   @GetMapping("/tutorials/{id}")
    //   public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
    //     Tutorial tutorial = tutorialRepository.findById(id)
    //         .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
    //     return new ResponseEntity<>(tutorial, HttpStatus.OK);
    //   }
    //   @PostMapping("/tutorials")
    //   public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
    //     Tutorial _tutorial = tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), true));
    //     return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
    //   }
    //   @PutMapping("/tutorials/{id}")
    //   public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
    //     Tutorial _tutorial = tutorialRepository.findById(id)
    //         .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
    //     _tutorial.setTitle(tutorial.getTitle());
    //     _tutorial.setDescription(tutorial.getDescription());
    //     _tutorial.setPublished(tutorial.isPublished());
        
    //     return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
    //   }
    //   @DeleteMapping("/tutorials/{id}")
    //   public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
    //     tutorialRepository.deleteById(id);
        
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //   }
    //   @DeleteMapping("/tutorials")
    //   public ResponseEntity<HttpStatus> deleteAllTutorials() {
    //     tutorialRepository.deleteAll();
        
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //   }
    //   @GetMapping("/tutorials/published")
    //   public ResponseEntity<List<Tutorial>> findByPublished() {
    //     List<Tutorial> tutorials = tutorialRepository.findByPublished(true);
    //     if (tutorials.isEmpty()) {
    //       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //     }
        
    //     return new ResponseEntity<>(tutorials, HttpStatus.OK);
    //   }
    // }

//     @GetMapping("/tutorials/{tutorialId}/comments")
//   public ResponseEntity<List<Comment>> getAllCommentsByTutorialId(@PathVariable(value = "tutorialId") Long tutorialId) {
//     if (!tutorialRepository.existsById(tutorialId)) {
//       throw new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId);
//     }
//     List<Comment> comments = commentRepository.findByTutorialId(tutorialId);
//     return new ResponseEntity<>(comments, HttpStatus.OK);
//   }

}
