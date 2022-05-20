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

import net.java.schoolmanagement.db.StudentDBUtill;
import net.java.schoolmanagement.model.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDBUtill  studentDBUtill;
       
   
    public StudentServlet() {
    	this.studentDBUtill = new StudentDBUtill();
     
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
						insertStudent(request, response);
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
						deleteStudent(request, response);
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
						updateStudent(request, response);
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
						listStudent(request, response);
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
		        RequestDispatcher dispatcher = request.getRequestDispatcher("../student-form.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void insertStudent(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        String name = request.getParameter("name");
		        String address = request.getParameter("address");
		        String birthday = request.getParameter("birthday");
		        String gender = request.getParameter("gender");
		        String grade = request.getParameter("grade");
		        String phone = request.getParameter("phone");
		        Student newStudent = new Student(name, address, birthday, gender, grade, phone);
		        studentDBUtill.insertStudent(newStudent);
		        response.sendRedirect("list");
		    }
	    
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        studentDBUtill.deleteStudent(id);
		        response.sendRedirect("list");

		    }
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Student existingStudent = studentDBUtill.selectStudent(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("../student-form.jsp");
		        request.setAttribute("student", existingStudent);
		        dispatcher.forward(request, response);

		    }
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        String name = request.getParameter("name");
		        String address = request.getParameter("address");
		        String birthday = request.getParameter("birthday");
		        String gender = request.getParameter("gender");
		        String grade = request.getParameter("grade");
		        String phone = request.getParameter("phone");
                Student book = new Student(id, name, address, birthday, gender, grade, phone);
		        studentDBUtill.updateStudent(book);
		        response.sendRedirect("list");
		    }
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Student > listStudent = studentDBUtill.selectAllStudents();
		        request.setAttribute("listStudent", listStudent);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("../student-list.jsp");
		        dispatcher.forward(request, response);
		    }
	
	
}

