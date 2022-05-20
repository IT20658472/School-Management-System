package net.java.schoolmanagement.model;
     
	public class Teacher {
	    protected int id;
	    protected String name;
	    protected String address;
	    protected String birthday;
	    protected String gender;
	    protected String phone;
	    protected String email;

	    
	    public Teacher(String name, String address,  String birthday,  String gender, String phone, String email) {
	        super();
	        this.name = name;
	        this.address = address;
	        this.birthday = birthday;
	        this.gender = gender;
	        this.phone = phone;
	        this.email = email;
	       
	    }

	    public Teacher(int id, String name,  String address, String birthday,  String gender, String phone, String email) {
	        super();
	        this.id = id;
	        this.name = name;
	        this.address = address;
	        this.birthday = birthday;
	        this.gender = gender;
	        this.phone = phone;
	        this.email = email;
	    }

		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getBirthday() {
			return birthday;
		}

		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}


	
	}
 