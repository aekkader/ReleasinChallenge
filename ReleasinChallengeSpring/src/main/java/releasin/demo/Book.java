package releasin.demo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    // @OneToMany(mappedBy = "book", fetch = FetchType.LAZY,
    //         cascade = CascadeType.ALL)
    // private Set<Page> pages;
    // @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER) 
    // @JsonbTransient
    // @Transient 
    // public Set<PlanDeplacementClient> planDeplacementClientList = new HashSet<PlanDeplacementClient>() ;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER) 
    // @JsonbTransient
    // @Transient 
    public Set<Page> pageList = new HashSet<Page>() ;


    // standard constructors
    public Book(){

    }

    public Long getId()   
    {    
    return id;    
    }    
    public void setId(Long id)   
    {    
    this.id = id;    
    }    
    public String getName()   
    {    
    return name;    
    }    
    public void setName(String name)   
    {    
    this.name = name;    
    }  
    

}