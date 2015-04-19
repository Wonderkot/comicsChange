package ru.wonderkot.comicsChange.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ru.wonderkot.comicsChange.data.impl.AuthorDaoImpl;
import ru.wonderkot.comicsChange.model.Author;

@Controller
public class HomeController {
	@Autowired
	AuthorDaoImpl daoImpl = new AuthorDaoImpl();

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		
		/*Author author = new Author();
		author.setName("test");
		author.setPatronymic("sss");
		author.setSurname("ssssss");
	    daoImpl.addNewAuthor(author);
	    System.out.println(author.getId());*/
		ArrayList<Author>authors =   daoImpl.getAllAuthors();
		for (Author authorTemp : authors) {
			System.out.println(authorTemp.getName());
		}
		return new ModelAndView("home");
	}
}
