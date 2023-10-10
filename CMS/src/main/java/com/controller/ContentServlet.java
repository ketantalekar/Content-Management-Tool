package com.controller;

import java.io.*;
import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.dao.ContentDao;
import com.model.Content;
import com.model.User;
import com.util.MyHibernate;

@WebServlet("/ContentServlet")
@MultipartConfig(maxFileSize = 999999999, maxRequestSize = 999999999)
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		SessionFactory sf = MyHibernate.mySessionFactory();
		Session session = sf.openSession();
		if (req.getParameter("b1").equalsIgnoreCase("Add Content")) {
			Content c = new Content();
			InputStream imageStream = req.getPart("image").getInputStream();
			Blob imageBlob = Hibernate.getLobCreator(session).createBlob(imageStream, -1);
			c.setImage(imageBlob);
			c.setCtitle(req.getParameter("title"));
			c.setCdescription(req.getParameter("description"));
			 
			if (new ContentDao().insertContent(c) > 0) {
				res.sendRedirect("welcome.jsp");
			}
		}else {
			

		// Create an instance of ContentDao (assuming you have a ContentDao class)
		ContentDao contentDao = new ContentDao();

		// Call the displayAll method to retrieve all content records
		List<Content> contentList = contentDao.displayAll();

		// Set the contentList as an attribute in the request to pass it to the JSP
		req.setAttribute("contentList", contentList);

		// Forward the request to your welcome.jsp for displaying the content
		req.getRequestDispatcher("welcome.jsp").forward(req, res);
		}

	}
}
