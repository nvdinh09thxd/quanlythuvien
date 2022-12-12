package Model.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Bean.News;
import Model.DAO.NewsDao;

@WebServlet("/index")
public class PublicIndexNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicIndexNewsController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<News> listNews = NewsDao.getItems();
		request.setAttribute("listNews", listNews);
		RequestDispatcher rd = request.getRequestDispatcher("/bnews/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}