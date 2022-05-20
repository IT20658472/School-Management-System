package net.java.schoolmanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.java.schoolmanagement.db.PrincipalDBUtill;
import net.java.schoolmanagement.model.Principal;



/**
 * Servlet implementation class StudentServlet
 */

public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrincipalDBUtill  principalDBUtill;
       
   
    public PrincipalServlet() {
    	this.principalDBUtill = new PrincipalDBUtill();
     
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.doGet(request, response);
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String action = request.getPathInfo();
		 	System.out.println(action);
	      
	            switch (action) {
	                case "/new":
	                    showNewForm(request, response);
	                    break;
	                case "/insert":
					try {
						insertPrincipal(request, response);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                    break;
	                case "/delete":
					try {
						deletePrincipal(request, response);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                    break;
	                case "/edit":
					try {
						showEditForm(request, response);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                    break;
	                case "/update":
					try {
						updatePrincipal(request, response);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                    break;
	                case "/list":
	                	//handle list
					try {
						listPrincipal(request, response);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                    break;
	            }
	            
	 }  

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("../principal-form.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void insertPrincipal(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        String name = request.getParameter("name");
		        String address = request.getParameter("address");
		        String birthday = request.getParameter("birthday");
		        String gender = request.getParameter("gender");
		        String phone = request.getParameter("phone");
		        String email = request.getParameter("email");
		        Principal newPrincipal = new Principal(name, address, birthday, gender, phone, email);
		        principalDBUtill.insertPrincipal(newPrincipal);
		        response.sendRedirect("list");
		    }
	    
	private void deletePrincipal(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        principalDBUtill.deletePrincipal(id);
		        response.sendRedirect("list");

		    }
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Principal existingPrincipal = principalDBUtill.selectPrincipal(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("../principal-form.jsp");
		        request.setAttribute("principal", existingPrincipal);
		        dispatcher.forward(request, response);

		    }
	
	private void updatePrincipal(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        String name = request.getParameter("name");
		        String address = request.getParameter("address");
		        String birthday = request.getParameter("birthday");
		        String gender = request.getParameter("gender");
		        String phone = request.getParameter("phone");
		        String email = request.getParameter("email");
		        Principal book = new Principal(id, name, address, birthday, gender, phone, email);
		        principalDBUtill.updatePrincipal(book);
		        response.sendRedirect("list");
		    }
	
	private void listPrincipal(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Principal > listPrincipal = principalDBUtill.selectAllPrincipals();
		        request.setAttribute("listPrincipal", listPrincipal);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("../principal-list.jsp");
		        dispatcher.forward(request, response);
		    }
	
	
}

