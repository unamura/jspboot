package com.example.jspboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JspController {
	private BookRepository  bkRepo = new BookRepository();
	
	@RequestMapping("/")
	public String home() {
		//System.out.println("Ehy it's a jsp!!");
		return "welcome";
	}
	
	@GetMapping("/index")
	public String welcome(Model model) {
		model.addAttribute("book", new Book());
		return "index";
	}
	
	@PostMapping(value="/insert", params="suband")
	public String bookSubmit(@ModelAttribute Book book, Model model) {
		System.out.println(book.getGenre());
		if(!book.getGenre().equals("") && bkRepo.checkField(book, model) ) {
			return "index";
		}
		if(book.getTitle().equals("") || book.getAuthor().equals("")) {
			model.addAttribute("message", "Must insert Title and Author");
			return "index";
		}
		if(!bkRepo.checkISBN(book)) {
			model.addAttribute("msgisbn", "ISBN code must have 13 characters");
			System.out.println("isbn" + book.getIsbn());
			return "index";
		}
		bkRepo.save(book);
		model.addAttribute("book", bkRepo.loadLast());
		return "result";
	}

	@PostMapping(value="/insert", params="sub")
	public String bookSubmitJust(@ModelAttribute Book book, Model model) {
		if(!book.getGenre().equals("") && bkRepo.checkField(book, model) ) {
			return "index";
		}
		if(book.getTitle().equals("") || book.getAuthor().equals("")) {
			model.addAttribute("message", "Must insert Title and Author");
			return "index";
		}
		bkRepo.save(book);
		model.addAttribute("book", bkRepo.loadLast());
		model.addAttribute("message", "Book inserted");
		return "index";
	}

	@GetMapping("/repo")
	public String bookRepo(Model model) {
		//Boolean empty = false;
		if( bkRepo.size( bkRepo.load()) == 0 ) {
			//model.addAttribute("empty", "true");
			model.addAttribute("msgrepo", "Book repository empty !");
		}
		model.addAttribute("bookList", bkRepo.load());
		return "repo";
	}
	
	@PostMapping("/repo")
	public String delete(@RequestParam(value = "id", 
										required = true, 
										defaultValue = "-1") int id, 
							Model model) {
		bkRepo.delete(id);
		model.addAttribute("bookList", bkRepo.load());
		return "repo";
	}
	
	@PostMapping("/{result}")
	public String search(@RequestParam(value = "valueofbook", 
									required = false) String valueofbook,
							Model model) {
		//System.out.println("size: " + );

		model.addAttribute("searchList", bkRepo.find(valueofbook));
		System.out.println("size: " + bkRepo.size( bkRepo.find(valueofbook)) );
		if( bkRepo.size( bkRepo.find(valueofbook)) == 0 ) {
			String result = "index";
			System.out.println("size index: " + result);
			model.addAttribute("msgsearch", "No book found..");
			return result;
		}
		else {
			System.out.println("" + bkRepo.find(valueofbook));
			String result = "search";
			return result;
		}
	}
	
	@PostMapping(value="/modify", params="newbook")
	public String newField(@ModelAttribute Book book, Model model) {
		System.out.println("newField(..)");
		System.out.println("Book: " + book.toString());
		System.out.println("BookRepo: " + bkRepo.substitute(book).toString());
		return "modify";
	}
	
	@PostMapping(value="/modify", params="modify")
	public String modify(@RequestParam int id, Model model) {
		System.out.println("modify(..)");
		model.addAttribute("book", bkRepo.bookMod(id));
		return "modify";
	}
	
}
