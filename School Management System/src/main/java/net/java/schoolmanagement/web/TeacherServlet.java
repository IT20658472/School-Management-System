package net.java.schoolmanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.java.schoolmanagement.db.TeacherDBUtill;
import net.java.schoolmanagement.model.Teacher;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDBUtill  teacherDBUtill;
       
   
    public TeacherServlet() {
    	this.teacherDBUtill = new TeacherDBUtill();
     
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
						insertTeacher(request, response);
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
						deleteTeacher(request, response);
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
						updateTeacher(request, response);
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
						listTeacher(request, response);
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
		        RequestDispatcher dispatcher = request.getRequestDispatcher("../teacher-form.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void insertTeacher(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        String name = request.getParameter("name");
		        String address = request.getParameter("address");
		        String birthday = request.getParameter("birthday");
		        String gender = request.getParameter("gender");
		        String phone = request.getParameter("phone");
		        String email = request.getParameter("email");
		        Teacher newTeacher = new Teacher(name, address, birthday, gender, phone, email);
		        teacherDBUtill.insertTeacher(newTeacher);
		        response.sendRedirect("list");
		    }
	    
	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        teacherDBUtill.deleteTeacher(id);
		        response.sendRedirect("list");

		    }
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Teacher existingTeacher = teacherDBUtill.selectTeacher(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("../teacher-form.jsp");
		        request.setAttribute("teacher", existingTeacher);
		        dispatcher.forward(request, response);
		 
		    }
	
	private void updateTeacher(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        String name = request.getParameter("name");
		        String address = request.getParameter("address");
		        String birthday = request.getParameter("birthday");
		        String gender = request.getParameter("gender");
		        String phone = request.getParameter("phone");
		        String email = request.getParameter("email");
                Teacher book = new Teacher(id, name, address, birthday, gender, phone, email);
		        teacherDBUtill.updateTeacher(book);
		        response.sendRedirect("list");
		    }
	
	private void listTeacher(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Teacher > listTeacher = teacherDBUtill.selectAllTeachers();
		        request.setAttribute("listTeacher", listTeacher);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("../teacher-list.jsp");
		        dispatcher.forward(request, response);
		    }
	
	
}

