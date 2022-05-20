package net.java.schoolmanagement.db;

	import java.sql.Connection;
	import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;
	import java.util.List;

import net.java.schoolmanagement.model.Teacher;



	public class TeacherDBUtill {
	    		
	    		 //create database connection
	   		 String url  = "jdbc:mysql://Localhost:3306/school?useSSL=false" ;
	   		 String user ="root";
	   		 String pass = "Dilini123";
	   		 
	   		private static final String INSERT_TEACHERS_SQL = "INSERT INTO teachers"+" (name, address, birthday, gender, phone, email)VALUES" +
	   		        " (?, ?, ?,? ,?,?);";

	   		    private static final String SELECT_TEACHER_BY_ID = "select id,name,address,birthday,gender,phone,email from teachers where id =?";
	   		    private static final String SELECT_ALL_TEACHERS = "select * from teachers";
	   		    private static final String DELETE_TEACHERS_SQL = "delete from teachers where id = ?";
	   		    private static final String UPDATE_TEACHERS_SQL = "update teachers set name = ?, address= ?, birthday = ?, gender = ?, phone = ?, email = ? where id = ?";
 
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
	   		 
	   		    //Create or insert teacher
	   		 public void insertTeacher(Teacher teacher) throws SQLException {
	   	        
	   	        // try-with-resource statement will auto close the connection.
	   	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEACHERS_SQL)) {
	   	            preparedStatement.setString(1, teacher.getName());
	   	            preparedStatement.setString(2, teacher.getAddress());
	   	            preparedStatement.setString(3, teacher.getBirthday());
	   	            preparedStatement.setString(4, teacher.getGender());
	   	            preparedStatement.setString(5, teacher.getPhone());
	   	            preparedStatement.setString(6, teacher.getEmail());
	   	            preparedStatement.executeUpdate();
	   	        } catch (SQLException e) {
	   	            e.printStackTrace();
	   	        }
	   	    }
	   		    
	   		    //update teacher
	   		public boolean updateTeacher(Teacher teacher) throws SQLException {
	   	        boolean rowUpdated;
	   	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_TEACHERS_SQL);) {
	   	            statement.setString(1, teacher.getName());
	   	            statement.setString(2, teacher.getAddress());
	   	            statement.setString(3, teacher.getBirthday());
	   	            statement.setString(4, teacher.getGender());
	   	            statement.setString(5, teacher.getPhone());
	   	            statement.setString(6, teacher.getEmail());
	   	            statement.setInt(7, teacher.getId());
                    
	   	            rowUpdated = statement.executeUpdate() > 0;
	   	        }
	   	        return rowUpdated;
	   	    }
	   		 
	   		    //select teacher by id
	   	 public Teacher selectTeacher(int id) {
	         Teacher teacher = null;
	         // Step 1: Establishing a Connection
	         try (Connection connection = getConnection();
	             // Step 2:Create a statement using connection object
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TEACHER_BY_ID);) {
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
	                 String phone = rs.getString("phone");
	                 String email = rs.getString("email");
	                 teacher = new Teacher(id, name, address, birthday, gender, phone, email);
	             }
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
	         return teacher;
	     }
	   		    //select teachers
	   	public List < Teacher > selectAllTeachers() {

	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < Teacher > teachers = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TEACHERS); ) {
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
	                String phone = rs.getString("phone");
	                String email = rs.getString("email");
	                
	                teachers.add(new Teacher(id, name, address, birthday, gender, phone, email));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();;
	        }
	        return teachers;
	    }
	   		    //delete teacher
	   	public boolean deleteTeacher(int id) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_TEACHERS_SQL);) {
	            statement.setInt(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }
	   		 
	   		 

}
