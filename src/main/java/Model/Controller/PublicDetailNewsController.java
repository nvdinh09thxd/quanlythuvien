package Model.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Bean.News;
import Model.DAO.NewsDao;


public class PublicDetailNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicDetailNewsController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/bnews/PageNotFound.jsp");
			rd.forward(request, response);
			return;
		}
		News itemNews = NewsDao.getItem(id);
		request.setAttribute("itemNews", itemNews);
		RequestDispatcher rd = request.getRequestDispatcher("/bnews/detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
