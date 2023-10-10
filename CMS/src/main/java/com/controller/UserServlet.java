package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.User;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(req.getParameter("b1").equalsIgnoreCase("register")) {
			User u = new User();
			u.setUserName(req.getParameter("uname"));
			u.setEmail(req.getParameter("email"));
			u.setPassword(req.getParameter("password"));
			
			if(new UserDao().insertUser(u)>0) {
				res.sendRedirect("signin.jsp");
			}
			
		}
	}

}
