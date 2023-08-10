package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Employee;
import com.test.SaveObject;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	// ctrl+shift+o for packages
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// get the printwriter
		PrintWriter pw = res.getWriter();

		// Set Content Type
		res.setContentType("text/html");

		// read the form data
		String name = req.getParameter("name");// ctrl+alt+down
		String dob = req.getParameter("dob");
		String gender = req.getParameter("gender");
		String city = req.getParameter("city");

		System.out.println("Name:" + name);
		System.out.println("Date of Birth:" + dob);
		System.out.println("city:" + city);
		System.out.println("gender:" + gender);

		/*
		 * pw.println("<h2>Name:"+name+"</h2>");
		 * pw.println("<h2>Date of Birth:"+dob+"</h2>");
		 * pw.println("<h2>city:"+city+"</h2>");
		 * pw.println("<h2>gender:"+gender+"</h2>");
		 * 
		 * // Success message pw.println("<h1>Form Register Successfully</h1>");
		 */
		// close the stream
		
		Employee emp= new Employee();
		emp.setCity(city);
		emp.setDob(dob);
		emp.setEname(name);
		emp.setGender(gender);
		
		int count=SaveObject.save(emp);
		
		if(count==0){
			pw.println("<h2>Employee not registered</h2>");
			pw.println("<a href='form.html'>Home</a>");
		}else {
			pw.println("<h2>Employee registered Successfully</h2>");
			pw.println("<a href='form.html'>Home</a>");
		}
		pw.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
