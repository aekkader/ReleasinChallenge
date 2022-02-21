package releasin.demo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
// import org.springframework.data.annotation.CreatedDate;
// import org.springframework.data.annotation.Transient;

@Entity
public class Book {

    @Id
    @GeneratedValue
    public Long id;

    public String name;


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
    @Transient //javax.persistence.Transient :: ne recupere pas la liste "find"
    public Set<Page> pageList = new HashSet<Page>() ;


    // @Schema(readOnly = true)
    // @Column(nullable = false)
    // @CreationTimestamp
    // @Temporal(TemporalType.TIMESTAMP)
    // public Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    // @Column(name = "created_at", nullable = false, updatable = false)
    @Column(nullable = false, updatable = false)
    // @CreatedDate
    @CreationTimestamp
    public Date created_at;

    // // standard constructors
    // public Book(){

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
    


}