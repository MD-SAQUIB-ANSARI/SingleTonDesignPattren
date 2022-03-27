package com.mypack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypack.bean.EmpBean;
import com.mypack.dao.EmpDao;

@WebServlet("/addservlet")
public class AddServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		Integer empno= Integer.parseInt(req.getParameter("empNo"));
		String empName= req.getParameter("empName");
		Float empSalary= Float.parseFloat(req.getParameter("empSalary"));
		try{
		EmpBean emp = new EmpBean();
		emp.setEmpno(empno);
		emp.setEmpname(empName);
		emp.setEmpsal(empSalary);
		
		EmpDao empDao = new EmpDao();
		int count = empDao.addRecord(emp);
		out.println(count+"Row is added..");
		}catch (SQLException e) {
			out.println(e);
		}catch (ClassNotFoundException e) {
			out.println(e);
		}
		out.println("<br><br><a href='index.html'>Back</a>");
		
	}

}
