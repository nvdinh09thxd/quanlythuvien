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

@WebServlet("/cat")
public class PublicCatNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicCatNewsController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idCat = 0;
		try {
			idCat = Integer.parseInt(request.getParameter("cid"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/bnews/PageNotFound.jsp");
			rd.forward(request, response);
			return;
		}
		ArrayList<News> listNewsByIdCat = NewsDao.getItemsByIdCat(idCat);
		request.setAttribute("listNewsByIdCat", listNewsByIdCat);
		RequestDispatcher rd = request.getRequestDispatcher("/bnews/cat.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}