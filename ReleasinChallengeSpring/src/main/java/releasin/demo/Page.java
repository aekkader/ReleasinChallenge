package releasin.demo;

import javax.persistence.Entity;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
// import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
// import com.fasterxml.jackson.annotation.JsonProperty;
// import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.springframework.data.annotation.Transient;

@Entity
public class Page {

    @Id
    @GeneratedValue
    public Long id;

    public String name;


    @ManyToOne
    // @Transient
    // @Transient
    // @JsonProperty 
    // @JsonSerialize
    @JsonBackReference // pour regler le pb de recursion
    public Book book;
    // @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // // @JoinColumn(name = "book_id", nullable = false)
    // private Book book;
    // @ManyToOne
    // @JsonbTransient 
    // public Commune commune; 


    // // standard constructors
    // public Page(){

    // }

    // public Long getId()   
    // {    
    // return id;    
    // }    
    // public void setId(Long id)   
    // {    
    // this.id = id;    
    // }    
    // public String getName()   
    // {    
    // return name;    
    // }    
    // public void setName(String name)   
    // {    
    // this.name = name;    
    // }  
    

    public PageClaire toClaire(){
        PageClaire laPageClaire = new PageClaire();
        laPageClaire.id = id;
        laPageClaire.name = name;
        laPageClaire.book = book.name;

        return laPageClaire;
    }


}