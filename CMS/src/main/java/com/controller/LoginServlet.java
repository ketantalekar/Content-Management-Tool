package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.util.MyHibernate;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userName = req.getParameter("uname");
		String pass = req.getParameter("password");
		
		if (authenticateUser(userName, pass)) {
            // User is authenticated
            res.sendRedirect("welcome.jsp"); // Redirect to a welcome page
        } else {
            // Authentication failed, redirect to login page with an error message
            req.setAttribute("errorMessage", "Invalid username or password");
            req.getRequestDispatcher("signin.jsp").forward(req, res);
        }
    }

    private boolean authenticateUser(String username, String password) {
    	SessionFactory sf = MyHibernate.mySessionFactory();
        try (Session session = sf.openSession()) {
            Query query = session.createQuery("FROM User WHERE username = :username AND password = :password");
            query.setParameter("username", username);
            query.setParameter("password", password);

            // If a user with the provided username and password exists, return true
            return query.uniqueResult() != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
