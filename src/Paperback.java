import java.io.FileNotFoundException;

public class Paperback extends Book {
	
	String type;
	
	Paperback(int isbn, String type, String title, String lang, String genre, String date, double price,
			int quantity, double info1, String info2) throws FileNotFoundException {
		super(isbn, type, title, lang, genre, date, price, quantity, info1, info2);
		
		this.type = "paperback";
	}

}


