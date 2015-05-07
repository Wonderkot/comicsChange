/**
 * 
 */
package ru.wonderkot.comicsChange.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.wonderkot.comicsChange.dao.impl.BookDaoImpl;
import ru.wonderkot.comicsChange.model.Book;

/**
 * @book pd199717
 *
 */
public class BookController {
	@Autowired
	BookDaoImpl daoImpl;
	

	@RequestMapping(value = "rest/getAllBooks", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Book> getBooks() {
		return daoImpl.getAllBooks();
	}

	@RequestMapping(value = "rest/addNewBook", method = RequestMethod.POST)
	public void addBook(@RequestBody Book book) {
		daoImpl.addNewBook(book);
	}

	@RequestMapping(value = "rest/deleteBook", method = RequestMethod.DELETE)
	public void deleteBook(@RequestParam() Integer id) {
		daoImpl.deleteBook(id);
	}

	@RequestMapping(value = "rest/updateBook", method = RequestMethod.POST)
	public void updateBook(@RequestBody Book book) {
		daoImpl.updateBook(book);
	}

	@RequestMapping(value = "rest/findBook", method = RequestMethod.GET)
	public ArrayList<Book> find(@RequestBody Book book) {
		return daoImpl.findBooks(book);
	}

	@RequestMapping(value = "rest/getBook", method = RequestMethod.GET)
	public Book getBook(@RequestBody Integer id) {
		return daoImpl.getBook(id);
	}
}
