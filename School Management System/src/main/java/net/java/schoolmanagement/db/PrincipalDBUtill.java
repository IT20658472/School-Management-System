package net.java.schoolmanagement.db;

	import java.sql.Connection;
	import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;
	import java.util.List;

import net.java.schoolmanagement.model.Principal;





	public class PrincipalDBUtill {
	    		
	    		 //create database connection
	   		 String url  = "jdbc:mysql://Localhost:3306/school?useSSL=false" ;
	   		 String user ="root";
	   		 String pass = "Dilini123";
	   		 
	   		private static final String INSERT_PRINCIPALS_SQL = "INSERT INTO principals"+" (name, address, birthday, gender, phone, email)VALUES" +
	   		        " (?, ?, ?,? ,?,?);";

	   		    private static final String SELECT_PRINCIPAL_BY_ID = "select id,name,address,birthday,gender,phone,email from principals where id =?";
	   		    private static final String SELECT_ALL_PRINCIPALS = "select * from principals";
	   		    private static final String DELETE_PRINCIPALS_SQL = "delete from principals where id = ?";
	   		    private static final String UPDATE_PRINCIPALS_SQL = "update principals set name = ?, address= ?, birthday = ?, gender = ?, phone = ?, email = ? where id = ?";
 
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
	   		 
	   		    //Create or insert principal
	   		 public void insertPrincipal(Principal principal) throws SQLException {
	   	        
	   	        // try-with-resource statement will auto close the connection.
	   	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRINCIPALS_SQL)) {
	   	            preparedStatement.setString(1, principal.getName());
	   	            preparedStatement.setString(2, principal.getAddress());
	   	            preparedStatement.setString(3, principal.getBirthday());
	   	            preparedStatement.setString(4, principal.getGender());
	   	            preparedStatement.setString(5, principal.getPhone());
	   	            preparedStatement.setString(6, principal.getEmail());
	   	            preparedStatement.executeUpdate();
	   	        } catch (SQLException e) {
	   	            e.printStackTrace();
	   	        }
	   	    }
	   		    
	   		    //update principal
	   		public boolean updatePrincipal(Principal principal) throws SQLException {
	   	        boolean rowUpdated;
	   	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PRINCIPALS_SQL);) {
	   	            statement.setString(1, principal.getName());
	   	            statement.setString(2, principal.getAddress());
	   	            statement.setString(3, principal.getBirthday());
	   	            statement.setString(4, principal.getGender());
	   	            statement.setString(5, principal.getPhone());
	   	            statement.setString(6, principal.getEmail());
	   	            statement.setInt(7, principal.getId());

	   	            rowUpdated = statement.executeUpdate() > 0;
	   	        }
	   	        return rowUpdated;
	   	    }
	   		 
	   		    //select principal by id
	   	 public Principal selectPrincipal(int id) {
	   		Principal principal = null;
	         // Step 1: Establishing a Connection
	         try (Connection connection = getConnection();
	             // Step 2:Create a statement using connection object
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRINCIPAL_BY_ID);) {
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
	                 principal = new Principal(id, name, address, birthday, gender, phone, email);
	             }
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
	         return principal;
	     }
	   		    //select principals
	   	public List < Principal > selectAllPrincipals() {

	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < Principal > principals = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRINCIPALS); ) {
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
	                
	                principals.add(new Principal(id, name, address, birthday, gender, phone, email));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();;
	        }
	        return principals;
	    }
	   		    //delete principal
	   	public boolean deletePrincipal(int id) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRINCIPALS_SQL);) {
	            statement.setInt(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }
	   		 
	   		 

}
