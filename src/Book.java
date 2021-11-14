import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JLabel;

public class Book {
	
	int isbn;
	String type;
	String title;
	String lang;
	String genre;
	String date;
	double price;
	int quantity;
	double info1;
	String info2;
	
	Book(int isbn, String type, String title, String lang, String genre,
		String date, double price, int quantity, double info1, String info2) throws FileNotFoundException{
		this.isbn = isbn;
		this.type = type;
		this.title = title;
		this.lang = lang;
		this.genre = genre;
		this.date = date;
		this.price = price;
		this.quantity = quantity;
		this.info1 = info1;
		this.info2 = info2;
		
	}
	
	Panel2 panel2;
	
	void showBook() throws FileNotFoundException {

	}
}
