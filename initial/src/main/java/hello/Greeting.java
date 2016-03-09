package hello;

import java.util.Comparator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.CascadeType;

@Entity
@Table(name = "GREETINGS")
public class Greeting implements Comparator<Greeting>{

	
	public enum Type 
	{
		GREAT,OK,OKOK;
	}
    private long id;
    private String content;
    private long priority;
   	int[] userId=new int[10];
   	private List<Address> address;		//one greeting can be posted to miltiple addresses
	private Type type;
	private GCategory category;			//multiple greeting can belong to one category
	
	public Greeting() {
		
	}
    
	public Greeting(long id, String content,long priority, Type type,List<Address> address,GCategory category) {
        this.id = id;
        this.content = content;
        this.priority=priority;
        this.type=type;
       this.address=address;
       this.category=category;
      
    }

	
	

	@Id
    @Column(name = "GREETING_ID")
	@NotNull
//	@Size(min=0,max=99999999)
    public long getId() {
        return id;
    }

    @Column(name = "CONTENT")
    @NotNull
	//@Size(min=0,max=99999999)
    public String getContent() {
        return content;
        
    }
//    @Column(name ="USERID")
//    public int[] getUserId() {
//		return userId;
//	}

    
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    @NotNull
    public Type getType() {
		return type;
	}
    
    
    @Column(name = "PRIORITY")
    @NotNull
//	@Size(min=0,max=99999999)
    public long getPriority() {
		return priority;
	}
    
    @OneToMany(cascade=CascadeType.ALL)
    public List<Address> getAddress() {
		return address;
	}
    @ManyToOne(cascade=CascadeType.ALL)
	public GCategory getCategory() {
		return category;
	}

	public void setCategory(GCategory category) {
		this.category = category;
	}


	public void setId(long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void setPriority(long priority) {
		this.priority = priority;
	}
	
	public void setType(Type type) {
		this.type = type;
	}

	public int compare(Greeting g1, Greeting g2) {
		// TODO Auto-generated method stub
		return (int) (g2.id-g1.id);
	}
	
	public void setAddress(List<Address> address) {
		this.address = address;
	}


	 

@Override
public boolean equals(Object arg) {
	if  (arg instanceof Greeting) {
		Greeting g1=(Greeting)arg;
		if((this.content==g1.content) && (this.id==g1.id) && (this.priority==g1.priority)&&(this.type==g1.type))
		{return true;	
		}
		return false;
	}
	else return false;
	
}


@Override
public int hashCode() {
	return super.hashCode();
}

}