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
import org.springframework.web.bind.annotation.RestController;

import ru.wonderkot.comicsChange.dao.impl.AuthorDaoImpl;
import ru.wonderkot.comicsChange.model.Author;

/**
 * @author Wonderkot
 *
 */
@RestController
@RequestMapping("/authors")
public class AuthorController {
	@Autowired
	AuthorDaoImpl daoImpl;

	@RequestMapping(value = "/getAllAuthors", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Author> getAuthors() {
		return daoImpl.getAllAuthors();
	}

	@RequestMapping(value = "/addNewAuthor", method = RequestMethod.POST)
	public void addAuthor(@RequestBody Author author) {
		daoImpl.addNewAuthor(author);
	}

	@RequestMapping(value = "/deleteAuthor", method = RequestMethod.DELETE)
	public void deleteAuthor(@RequestParam() Integer id) {
		daoImpl.deleteAuthor(id);
	}

	@RequestMapping(value = "/updateAuthor", method = RequestMethod.POST)
	public void updateAuthor(@RequestBody Author author) {
		daoImpl.updateAuthor(author);
	}

	@RequestMapping(value = "/findAuthor", method = RequestMethod.GET)
	public ArrayList<Author> find(@RequestBody Author author) {
		return daoImpl.findAuthor(author);
	}

	@RequestMapping(value = "/getAuthor", method = RequestMethod.GET)
	public Author getAuthor(@RequestBody Integer id) {
		return daoImpl.getAuthor(id);
	}

}
