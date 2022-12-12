package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Bean.News;
import util.ConnectDBNews;

public class NewsDao {
	private static Connection conn;
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;

	public static ArrayList<News> getItems() {
		ArrayList<News> listItems = new ArrayList<>();
		conn = ConnectDBNews.getConnection();
		try {
			String sql = "SELECT * FROM news";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String detail = rs.getString("detail");
				int id_cat = rs.getInt("id_cat");
				News objItem = new News(id, name, description, detail, id_cat);
				listItems.add(objItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBNews.close(rs, st, conn);
		}
		return listItems;
	}

	public static ArrayList<News> getItemsByIdCat(int idCat) {
		ArrayList<News> listItems = new ArrayList<>();
		conn = ConnectDBNews.getConnection();
		try {
			String sql = "SELECT * FROM news WHERE id_cat = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idCat);
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String detail = rs.getString("detail");
				int id_cat = rs.getInt("id_cat");
				News objItem = new News(id, name, description, detail, id_cat);
				listItems.add(objItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBNews.close(rs, pst, conn);
		}
		return listItems;
	}

	public static News getItem(int idNews) {
		News item = null;
		conn = ConnectDBNews.getConnection();
		try {
			String sql = "SELECT * FROM news WHERE id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idNews);
			rs = pst.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String detail = rs.getString("detail");
				int id_cat = rs.getInt("id_cat");
				item = new News(id, name, description, detail, id_cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBNews.close(rs, pst, conn);
		}
		return item;
	}
}
