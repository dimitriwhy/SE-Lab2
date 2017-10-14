package lab2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
public class Author {
	private int authorID;
	private String name;
	private int age;
	private String country;
	public Map<Integer, String> authorInfo = new HashMap<Integer, String>();
	public Map<String, String> booksInfo = new HashMap<String, String>();
	
	public String queryAuthorInfos() {
		String ret = "error";
		Connection conn = null;
		try {
			String URL = "jdbc:mysql://localhost/BookDB";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "123qweasd");
			String sql = "SELECT * FROM Author";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			authorInfo = new HashMap<Integer, String>();
			//System.out.println("get rs");
			while (rs.next()) {
				int id = rs.getInt(1);
				String info = rs.getString(2) +", " + rs.getString(3) + ", "+rs.getString(4);
				authorInfo.put(id, info);
				ret = "success";
			}
		} catch (Exception e) {
			ret = "error";
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {					
				}
			}
		}		
		return ret;
	}
	public String addAuthor() {
		String ret = "error";
		Connection conn = null;
		try {
			String URL = "jdbc:mysql://localhost/BookDB?useUnicode=true&characterEncoding=utf8";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "123qweasd");
			String sql = "INSERT INTO Author (Name, Age, Country) ";
			sql += "VALUES (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, country);
			System.out.println(sql+  name + " " + age + " " + country);
			int count = ps.executeUpdate();
			if (count == 1) ret = "success";
			else ret = "error";
		} catch (Exception e) {
			ret = "error";
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {					
				}
			}
		}
		return ret;
	}
	private int selectedAuthor;

	public String queryAuthorBooks() {
		String ret = "error";
		Connection conn = null;
		try {
			String URL = "jdbc:mysql://localhost/BookDB";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "123qweasd");
			String sql = "SELECT ISBN, Title FROM Book";
			sql += " WHERE AuthorID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, selectedAuthor);
			ResultSet rs = ps.executeQuery();
			booksInfo = new HashMap<String, String>();
			//System.out.println("get rs");
			while (rs.next()) {
				String id = rs.getString(1);
				String info = rs.getString(2);
				booksInfo.put(id, info);
				ret = "success";
			}
		} catch (Exception e) {
			ret = "error";
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {					
				}
			}
		}		
		return ret;		
	}
	public String queryBookAuthorInfos() {
		String ret = "error";
		Connection conn = null;
		try {
			String URL = "jdbc:mysql://localhost/BookDB";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "123qweasd");
			String sql = "SELECT * FROM Author";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			authorInfo = new HashMap<Integer, String>();
			//System.out.println("get rs");
			while (rs.next()) {
				int id = rs.getInt(1);
				String info =rs.getString(2) +", " + rs.getString(3) + ", "+rs.getString(4);
				authorInfo.put(id, info);
				ret = "success";
			}
		} catch (Exception e) {
			ret = "error";
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {					
				}
			}
		}		
		return ret;
	}

	
	public void setBooksInfo(Map<String, String> booksInfo) {
		this.booksInfo = booksInfo;
	}
	public Map<String, String> getBooksInfo(){
		return booksInfo;
	}
	
	public int getSelectedAuthor() {
		return selectedAuthor;
	}
	public void setSelectedAuthor(int selectedAuthor) {
		this.selectedAuthor = selectedAuthor;
	}		
	public void setAuthorInfo(Map<Integer, String> authorInfo) {
		this.authorInfo = authorInfo;
	}
	public Map<Integer, String> getAuthorInfo(){
		return authorInfo;
	}
	
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
