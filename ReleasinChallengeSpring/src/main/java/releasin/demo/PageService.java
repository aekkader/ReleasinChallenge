package releasin.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageService {

    @Autowired
    private PageRepository pageRepository;

    public List<Page> list() {
        return pageRepository.findAll();
    }

    public Page addPage(Page page) {    
        return pageRepository.save(page);    
    }    

}
