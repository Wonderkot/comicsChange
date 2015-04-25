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
public class AuthorController {
	@Autowired
	AuthorDaoImpl daoImpl;

	@RequestMapping(value = "rest/getAllAuthors", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Author> getAuthors() {
		return daoImpl.getAllAuthors();
	}

	@RequestMapping(value = "rest/addNewAuthor", method = RequestMethod.POST)
	public void addAuthor(@RequestBody Author author) {
		daoImpl.addNewAuthor(author);
	}

	@RequestMapping(value = "rest/deleteAuthor", method = RequestMethod.DELETE)
	public void deleteAuthor(@RequestParam() Integer id) {
		daoImpl.deleteAuthor(id);
	}

	@RequestMapping(value = "rest/updateAuthor", method = RequestMethod.POST)
	public void updateAuthor(@RequestBody Author author) {
		daoImpl.updateAuthor(author);
	}

	@RequestMapping(value = "rest/find", method = RequestMethod.GET)
	public ArrayList<Author> find(@RequestBody Author author) {
		return daoImpl.findAuthor(author);
	}

	@RequestMapping(value = "rest/getAuthor", method = RequestMethod.GET)
	public Author getAuthor(@RequestBody Integer id) {
		return daoImpl.getAuthor(id);
	}

}
