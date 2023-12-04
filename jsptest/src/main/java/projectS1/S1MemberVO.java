package projectS1;

public class S1MemberVO {
	private String id;
	private String password;
	private String name;
	private String birthday;
	private String tel;
	private String postcode;
	private String mainAddress;
	private String detailAddress;

	public S1MemberVO() {
		this(null, null, null, null, null, null, null, null);

	}

	public S1MemberVO(String id, String password, String name, String birthday, String tel, String postcode,
			String mainAddress, String detailAddress) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.tel = tel;
		this.postcode = postcode;
		this.mainAddress = mainAddress;
		this.detailAddress = detailAddress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	

}
