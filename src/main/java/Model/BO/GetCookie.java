package Model.BO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Bean.User;

public class GetCookie {
	
	// Lưu thông tin ngư�?i dùng vào Cookie.
	private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";
	public static void storeUserCookie(HttpServletResponse response, User user) {
		System.out.println("Store user cookie");
		Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, user.getUsername());
		// 1 ngày (�?ã đổi ra giây)
		cookieUserName.setMaxAge(24 * 60 * 60);
		response.addCookie(cookieUserName);
	}

	public static String getUserNameInCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	// Xóa Cookie của ngư�?i dùng
	public static void deleteUserCookie(HttpServletResponse response) {
		Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
		// 0 giây. (Cookie này sẽ hết hiệu lực ngay lập tức)
		cookieUserName.setMaxAge(0);
		response.addCookie(cookieUserName);
	}
}
