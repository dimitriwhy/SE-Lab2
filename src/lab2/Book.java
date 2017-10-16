package lab2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

public class Book {
	private String isbn;
	private String title;
	private int authorID;
	private String publisher;
	private String publishDate;
	private float price;
	private int selectedAuthor;
	private String name;
	private int age;
	private String country;
	
	public String authorDetail() {
      /*blablabla*/
		String ret = "error";
		Connection conn = null;
		try {
			String URL = "jdbc:mysql://localhost/BookDB";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "123qweasd");
			String sql = "SELECT Name, Age, Country FROM Author ";
			sql += "WHERE AuthorID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, authorID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				name = rs.getString(1);
				age = rs.getInt(2);
				country = rs.getString(3);
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
	public String bookDetail() {
		String ret = "error";
		Connection conn = null;
		try {
			String URL = "jdbc:mysql://localhost/BookDB";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "123qweasd");
			String sql = "SELECT Title, AuthorID, Publisher, PublishDate, Price FROM Book ";
			sql += "WHERE ISBN=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, isbn);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				title = rs.getString(1);
				authorID = rs.getInt(2);
				publisher = rs.getString(3);
				publishDate = rs.getString(4);
				price = rs.getFloat(5);
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
		if (ret == "success")
			ret = authorDetail();
		return ret;

	}
	public String addBookAuthor() {
		String ret = "error";
		System.out.println(Integer.toString(selectedAuthor));
		ret = "success";
		return ret;
	}
	public String addAuthor() {
		String ret = "error";
		System.out.println(Integer.toString(selectedAuthor));
		ret = "success";
		return ret;
	}
	
	public String addBook() {
		String ret = "error";
		Connection conn = null;
		System.out.print(isbn+title+authorID+publisher+publishDate+price);
		try {
			String URL = "jdbc:mysql://localhost/BookDB?useUnicode=true&characterEncoding=utf8";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "123qweasd");
			String sql = "INSERT INTO Book (ISBN, Title, AuthorID, Publisher, PublishDate, Price) ";
			sql += "VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, isbn);
			ps.setString(2, title);
			ps.setInt(3, authorID);
			ps.setString(4, publisher);
			ps.setString(5, publishDate);
			ps.setFloat(6, price);
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

	public String editBook() {
		String ret = "error";
		Connection conn = null;
		System.out.print(isbn+title+authorID+publisher+publishDate+price);
		try {
			String URL = "jdbc:mysql://localhost/BookDB?useUnicode=true&characterEncoding=utf8";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "123qweasd");
			String sql = "UPDATE Book ";
			sql += "SET Title=?, AuthorID=?, Publisher=?, PublishDate=?, Price=? WHERE ISBN=? ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, title);
			ps.setInt(2, authorID);
			ps.setString(3, publisher);
			ps.setString(4, publishDate);
			ps.setFloat(5, price);
			ps.setString(6, isbn);
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

	public String deleteBook() {
		String ret = "error";
		Connection conn = null;
		System.out.print(isbn+title+authorID+publisher+publishDate+price);
		try {
			String URL = "jdbc:mysql://localhost/BookDB";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "123qweasd");
			String sql = "DELETE FROM Book ";
			sql += "WHERE ISBN=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, isbn);
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
	
	public int getSelectedAuthor() {
		return selectedAuthor;
	}
	public void setSelectedAuthor(int selectedAuthor) {
		this.selectedAuthor = selectedAuthor;
	}	
	public void setPrice(String price) {
		this.price = Float.valueOf(price);
	}
	public String getPrice() {
		return new DecimalFormat("#.00").format(price);
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public int getAuthorID() {
		return authorID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
