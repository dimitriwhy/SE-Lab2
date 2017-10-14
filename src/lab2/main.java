package lab2;
import lab2.Author;
import java.text.DecimalFormat;
public class main {
	public static void main(String args[]) {
		Book a = new Book();
		a.setIsbn("111-1-111-11111-1");
		a.setTitle("1");
		a.setPrice("5");
		a.setAuthorID(0);
		a.setPublisher("a");
		a.setPublishDate("1");
		a.editBook();
	}
}
