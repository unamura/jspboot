package com.example.jspboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
//import java.util.logging.Logger;

public class BookRepository {
	//private static Logger log = Logger.getLogger(BookRepository.class.getName());
	static private List<Book> bookList = new ArrayList<Book> ();
	
	public void save(Book bk) {
		bk.setId(bookList.size() + 1);
		insert(bk);
	}
	
	private void insert(Book bk) {
		bookList.add(bk);
	}
	
	public List<Book> load() {
		return bookList;
	}
	
	public Book loadLast() {
		Book result = new Book();
		for(Book bk : bookList) {
			result = bk;
		}
		return result;
	}
	
	public void delete(int id) {

		List<Book> copyList = new ArrayList<Book> ();
		for(Book bk : bookList) {
			if(bk.getId() == id) {
				
			}
			else {
				Book bkn = bk;
				bkn.setId(copyList.size() + 1);
				copyList.add(bkn);
			}
		}
		bookList.clear();
		bookList.addAll(copyList);
	}
	
	public String loadBook(List<Book> list) {
		return listToString(list);
	}
	
	public List<Book> find(String txt) {
		if(!isNumeric(txt)) {
			System.out.println("Non numerico: " + txt);
			return findStringList(txt);
		}
		else if(isNumeric(txt)) {
			System.out.println("Numerico: " + txt);
			double d = Double.parseDouble(txt);
			return findIntList( (int) d );
		}
		else return new ArrayList<Book> ();
	}
	
	static public List<Book> findIntList(int id) {
		List<Book> bkList = new ArrayList<Book> ();
		for(Book bk : bookList) {
			if( bk.getId()==id )
				bkList.add(bk);
		}
		return bkList;
	}
	
	static public List<Book> findStringList(String txt) {
		List<Book> bkList = new ArrayList<Book> ();
		for(Book bk : bookList) {
			if( bk.getTitle().toLowerCase().equals(txt.toLowerCase()) ||
					bk.getAuthor().toLowerCase().equals(txt.toLowerCase()) )
				bkList.add(bk);
		}
		return bkList;
	}
	
	public Book bookMod(int id) {
		//List<Book> bkList = new ArrayList<Book> ();
		Book result = new Book();
		for(Book bk : bookList) {
			if(bk.getId() == id)
				result = bk;
		}
		return result;
	}
	
	static public String listToString(List<Book> list) {
		String result = "";
		for(Book bk : list) {
			result += bk.toString();
		}
		return result;
	}
	
	public Boolean findDuplicate(int id) {
		
		for(Book bk : bookList) {
			if( bk.getId() == id )
				return false;
		}
		return true;
	}
	
	public boolean isNumeric(String value) {
		if (value == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(value);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
		return true;
	}
	
	public boolean checkField(Book book, Model model) {
		if(isNumeric(book.getGenre()) ) {
			model.addAttribute("msggenre", "Non inserire numeri");
			return true;
		}
		return false;
	}
	
	public Book substitute(Book book) {
		//int curId = 0;
		int indexBook = 0;
		Book bkRepo = new Book();
		for(Book bk : bookList) {
			if(book.getId() == bk.getId()) {
				indexBook = bookList.indexOf(bk);
				//curId = bk.getId();
				bkRepo = bk;
			}
		}
		bookList.set(indexBook, book);
		return bkRepo;
	}
	
	public Boolean checkISBN(Book book) {
		System.out.println("ISBN inserted: " + book.getIsbn());
		if(book.getIsbn() > 0) {
			System.out.println("isbn > 0");
			if(!intLength(book.getIsbn())) {
				System.out.println("isbn 13");
				book.setIsbn(0);
				return false;
			}
			//else book.setIsbn(0);
				
		}
		System.out.println("isbn <= 0");
		return true;	
	}
	
	/*public Boolean checkISBN(Book book) {
		System.out.println("ISBN inserted: " + book.getIsbn());
		if(book.getIsbn() > 0) {
			System.out.println("isbn > 0");
			if(intLength(book.getIsbn())) {
				System.out.println("isbn 13");
				for(Book bk : bookList) {
					if(book.getId() == bk.getId()) {
						bk.setIsbn(book.getIsbn());
						return true;
					}
				}
			}
			else {
				System.out.println("isbn else");
				for(Book bk : bookList) {
					if(book.getId() == bk.getId()) {
						bk.setIsbn(0);
						return false;
					}
				}
			}
				
		}
		System.out.println("isbn <= 0");
		return false;	
	}*/
	
	private static Boolean intLength(int number) {
		int length = 0;
		while(number > 0 ) {
			number /= 10;
			length ++;
		}
		if(length == 13)
			return true;
		return false;
	}
	
	public void clear() {
		bookList.clear();
	}
	
	public int size(List<Book> tempList) {
		int s = tempList.size();
		return s;
	}
	
	public static void main(String[] args) {
		System.out.println("Here");
		int n = 1553794651;
	}
}
