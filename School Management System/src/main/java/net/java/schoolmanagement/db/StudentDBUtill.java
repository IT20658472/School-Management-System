	package net.java.schoolmanagement.db;

	import java.sql.Connection;
	import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;
	import java.util.List;

import net.java.schoolmanagement.model.Student;



	public class StudentDBUtill {
	    		
	    		 //create database connection
	   		 String url  = "jdbc:mysql://Localhost:3306/school?useSSL=false" ;
	   		 String user ="root";
	   		 String pass = "Dilini123";
	   		 
	   		private static final String INSERT_STUDENTS_SQL = "INSERT INTO students"+" (name, address, birthday, gender, grade, phone)VALUES" +
	   		        " (?, ?, ?,? ,?,?);";

	   		    private static final String SELECT_STUDENT_BY_ID = "select id,name,address,birthday,gender,grade,phone from students where id =?";
	   		    private static final String SELECT_ALL_STUDENTS = "select * from students";
	   		    private static final String DELETE_STUDENTS_SQL = "delete from students where id = ?";
	   		    private static final String UPDATE_STUDENTS_SQL = "update students set name = ?, address= ?, birthday = ?, gender = ?, grade = ?, phone = ? where id = ?";
 
	   		 protected Connection getConnection() {
	   	        Connection connection = null;
	   	        try {
	   	            Class.forName("com.mysql.jdbc.Driver");
	   	            connection = DriverManager.getConnection(url, user, pass);
	   	        } catch (SQLException e) {
	   	            // TODO Auto-generated catch block
	   	            e.printStackTrace();
	   	        } catch (ClassNotFoundException e) {
	   	            // TODO Auto-generated catch block
	   	            e.printStackTrace();
	   	        }
	   	        return connection;
	   	    }
	   		 
	   		    //Create or insert student
	   		 public void insertStudent(Student student) throws SQLException {
	   	        
	   	        // try-with-resource statement will auto close the connection.
	   	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTS_SQL)) {
	   	            preparedStatement.setString(1, student.getName());
	   	            preparedStatement.setString(2, student.getAddress());
	   	            preparedStatement.setString(3, student.getBirthday());
	   	            preparedStatement.setString(4, student.getGender());
	   	            preparedStatement.setString(5, student.getGrade());
	   	            preparedStatement.setString(6, student.getPhone());
	   	            preparedStatement.executeUpdate();
	   	        } catch (SQLException e) {
	   	            e.printStackTrace();
	   	        }
	   	    }
	   		    
	   		    //update student
	   		public boolean updateStudent(Student student) throws SQLException {
	   	        boolean rowUpdated;
	   	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENTS_SQL);) {
	   	            statement.setString(1, student.getName());
	   	            statement.setString(2, student.getAddress());
	   	            statement.setString(3, student.getBirthday());
	   	            statement.setString(4, student.getGender());
	   	            statement.setString(5, student.getGrade());
	   	            statement.setString(6, student.getPhone());
	   	            statement.setInt(7, student.getId());

	   	            rowUpdated = statement.executeUpdate() > 0;
	   	        }
	   	        return rowUpdated;
	   	    }
	   		 
	   		    //select student by id
	   	 public Student selectStudent(int id) {
	         Student student = null;
	         // Step 1: Establishing a Connection
	         try (Connection connection = getConnection();
	             // Step 2:Create a statement using connection object
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);) {
	             preparedStatement.setInt(1, id);
	             System.out.println(preparedStatement);
	             // Step 3: Execute the query or update query
	             ResultSet rs = preparedStatement.executeQuery();

	             // Step 4: Process the ResultSet object.
	             while (rs.next()) {
	                 String name = rs.getString("name");
	                 String address = rs.getString("address");
	                 String birthday = rs.getString("birthday");
	                 String gender = rs.getString("gender");
	                 String grade = rs.getString("grade");
	                 String phone = rs.getString("phone");
	                 student = new Student(id, name, address, birthday, gender, grade, phone);
	             }
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
	         return student;
	     }
	   		    //select students
	   	public List < Student > selectAllStudents() {

	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < Student > students = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS); ) {
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String address = rs.getString("address");
	                String birthday = rs.getString("birthday");
	                String gender = rs.getString("gender");
	                String grade = rs.getString("grade");
	                String phone = rs.getString("phone");
	                
	                students.add(new Student(id, name, address, birthday, gender, grade, phone));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();;
	        }
	        return students;
	    }
	   		    //delete student
	   	public boolean deleteStudent(int id) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_STUDENTS_SQL);) {
	            statement.setInt(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }
	   		 
	   		 

}
