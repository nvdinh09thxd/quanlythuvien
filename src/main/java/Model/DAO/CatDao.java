package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Bean.Category2;
import util.ConnectDBNews;

public class CatDao {
	private static Connection conn;
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;

	public static ArrayList<Category2> getItems() {
		ArrayList<Category2> listItems = new ArrayList<>();
		conn = ConnectDBNews.getConnection();
		try {
			String sql = "SELECT * FROM category";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Category2 objItem = new Category2(id, name);
				listItems.add(objItem);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBNews.close(rs, st, conn);
		}
		return listItems;
	}

	public static Category2 getItem(int idCat) {
		Category2 item = null;
		conn = ConnectDBNews.getConnection();
		try {
			String sql = "SELECT * FROM category WHERE id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idCat);
			rs = pst.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				item = new Category2(id, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBNews.close(rs, pst, conn);
		}
		return item;
	}

}
