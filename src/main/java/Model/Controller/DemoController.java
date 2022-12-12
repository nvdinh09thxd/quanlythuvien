package Model.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo")
public class DemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DemoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		// Khai báo các tham số
		String username = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/tintuc?useUnicode=yes&characterEncoding=UTF-8";
		Connection conn = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			String sql = "SELECT * FROM danhmuctin";
			String sqlInsert = "INSERT INTO danhmuctin (tendanhmuctin) VALUES (?)";
			String sqlUpdate = "UPDATE danhmuctin SET tendanhmuctin = ? WHERE tendanhmuctin = ?";
			ArrayList<String> arData = new ArrayList<>();
			arData.add("Tin thời sự");
			arData.add("Tin thế giới");
			arData.add("Tin Việt Nam");
			// Thêm danh mục tin
			pst = conn.prepareStatement(sqlInsert);
			int n = insertData(pst, arData);
			if (n > 0)
				System.out.println("Đã thêm vào thành công " + n + " tin!");

			// Sửa danh mục tin
			pst = conn.prepareStatement(sqlUpdate);
			int m = updateData(pst, "123", "456");
			if (m > 0)
				System.out.println("Đã sửa vào thành công " + m + " tin!");

			// Select dữ liệu
			st = conn.createStatement();
			rs = selectData(st, sql);
			// Hiển thị dữ liệu
			displayData(rs, out);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// Đóng các kết nối
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/*
	 * Hàm này để thêm mới dữ liệu vào csdl 
	 * Biến vào là một mảng dữ liệu vào 
	 * Biến ra là số bản ghi thêm thành công
	 */
	public int insertData(PreparedStatement pst, ArrayList<String> arData) {
		int results = 0;
		for (String obj : arData) {
			try {
				pst.setString(1, obj);
				pst.executeUpdate();
				results++;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return results;
	}

	/*
	 * Hàm này để cập nhật dữ liệu trong csdl 
	 * Biến vào là tên mới và tên cũ muốn thay đổi 
	 * Biến ra là số bản ghi cập nhật thành công
	 */
	public int updateData(PreparedStatement pst, String newData, String oldData) {
		int results = 0;
		try {
			pst.setString(1, newData);
			pst.setString(2, oldData);
			results = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	/*
	 * Hàm này để select dữ liệu từ csdl
	 */
	public ResultSet selectData(Statement st, String sql) {
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}

	/*
	 * Hàm này để hiển thị dữ liệu đã select được ra trình duyệt
	 */
	public void displayData(ResultSet rs, PrintWriter out) {
		try {
			while (rs.next()) {
				int idDanhMuc = rs.getInt("iddanhmuctin");
				String tenDanhMuc = rs.getString("tendanhmuctin");
				out.println("ID danh muc: " + idDanhMuc + "<br />");
				out.println("Tên danh muc: " + tenDanhMuc + "<br />");
				out.println("----------------------------<br />");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
