package net.java.schoolmanagement.model;
     
	public class Student {
	    protected int id;
	    protected String name;
	    protected String address;
	    protected String birthday;
	    protected String gender;
	    protected String grade;
	    protected String phone;

	    
	    public Student(String name, String address,  String birthday,  String gender, String grade, String phone) {
	        super();
	        this.name = name;
	        this.address = address;
	        this.birthday = birthday;
	        this.gender = gender;
	        this.grade = grade;
	        this.phone = phone;
	       
	    }

	    public Student(int id, String name,  String address, String birthday,  String gender, String grade, String phone) {
	        super();
	        this.id = id;
	        this.name = name;
	        this.address = address;
	        this.birthday = birthday;
	        this.gender = gender;
	        this.grade = grade;
	        this.phone = phone;
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

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

	
	}
 

