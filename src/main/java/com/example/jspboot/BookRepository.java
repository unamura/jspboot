package com.example.jspboot;

import java.util.ArrayList;
//import java.util.Comparator;
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
	        //double d = Double.parseDouble(value);
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
	
	public Book substitute(Book bkMod) {
		//int curId = 0;
		//int indexBook = 0;
		Book bk = new Book();
		for(Book bkOld : bookList) {
			if(bkMod.getId() == bkOld.getId()) {
				//indexBook = bookList.indexOf(bk);
				compare(bkMod, bkOld);
				//curId = bk.getId();
				bk = bkOld;
				System.out.println("Old: " + bkOld.toString());
			}
		}
		// Check to validate the modifications
	
		//bookList.set(indexBook, bkMod);
		System.out.println("Mod: " + bkMod);
	
		return bk;
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
	
	public void compare(Book bkMod, Book bkRepo) {
		
		if(bkMod.getTitle().equalsIgnoreCase(bkRepo.getTitle())==false 
				&& bkMod.getTitle().equals("")==false )
			bkRepo.setTitle(bkMod.getTitle());
		
		if(bkMod.getAuthor().equalsIgnoreCase(bkRepo.getAuthor())==false 
				&& bkMod.getAuthor().equals("")==false )
			bkRepo.setAuthor(bkMod.getAuthor());
		
		if( bkMod.getGenre().equalsIgnoreCase(bkRepo.getGenre())==false 
				&& bkMod.getGenre().equals("")==false )
			bkRepo.setGenre(bkMod.getGenre());
		
		if( bkMod.getYear() != bkRepo.getYear() && bkMod.getYear() != 0 )
			bkRepo.setYear(bkMod.getYear());
		
		if( bkMod.getPages() != bkRepo.getPages() && bkMod.getPages() != 0 )
			bkRepo.setPages(bkMod.getPages());
		
		if( bkMod.getPrice() != bkRepo.getPrice() && bkMod.getPrice() != 0.0 )
			bkRepo.setPrice(bkMod.getPrice());
		
		if( bkMod.getIsbn() != bkRepo.getIsbn() && bkMod.getIsbn() != 0 )
			bkRepo.setIsbn(bkMod.getIsbn());
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
		//int n = 1553794651;
	}
}
