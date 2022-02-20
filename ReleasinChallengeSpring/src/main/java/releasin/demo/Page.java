package releasin.demo;

import javax.persistence.Entity;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Page {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    @ManyToOne
    private Book book;
    // @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // // @JoinColumn(name = "book_id", nullable = false)
    // private Book book;
    // @ManyToOne
    // @JsonbTransient 
    // public Commune commune; 


    // standard constructors
    public Page(){

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