package member;
//자바 Bean
public class PersonVO {
	private String id;
	private String name;
	private String email;
	
	public PersonVO() {
		this(null,null,null);
	}
	
	
	public PersonVO(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
}
