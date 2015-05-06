/**
 * 
 */
package ru.wonderkot.comicsChange.dao.impl;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.wonderkot.comicsChange.dao.AuthorDao;
import ru.wonderkot.comicsChange.model.Author;
import ru.wonderkot.comicsChange.model.Book;

/**
 * @author Wonderkot
 *
 */

@Service
public class AuthorDaoImpl implements AuthorDao {
	private static Logger logger = LogManager.getLogger(AuthorDaoImpl.class);
	@Autowired
	private AuthorDao authorDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.wonderkot.comicsChange.data.AuthorDao#addNewAuthor(ru.wonderkot.
	 * comicsChange.model.Author)
	 */
	@Override
	public void addNewAuthor(Author author) {
		if (author == null) {
			logger.error("author model is null");
			return;
		}
		logger.info("insert author");
		authorDao.addNewAuthor(author);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.wonderkot.comicsChange.data.AuthorDao#deleteAuthor(ru.wonderkot.
	 * comicsChange.model.Author)
	 */
	@Override
	public void deleteAuthor(Integer id) {
		if (id == null || id <=0) {
			logger.error("not valid id for delete author");
			return;
		}
		logger.info("DELETE AUTHOR");
		authorDao.deleteAuthor(id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ru.wonderkot.comicsChange.data.AuthorDao#findAuthor(ru.wonderkot.comicsChange
	 * .model.Author)
	 */
	@Override
	public ArrayList<Author> findAuthor(Author author) {
		if (author == null) {
			logger.error("author model is null");
			return null;
		}
		logger.info("FIND author");
		return authorDao.findAuthor(author);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.wonderkot.comicsChange.data.AuthorDao#getAllAuthors()
	 */
	@Override
	public ArrayList<Author> getAllAuthors() {
		ArrayList<Author> authors = new ArrayList<Author>();
		authors = authorDao.getAllAuthors();
		return authors;
	}

	@Override
	public void updateAuthor(Author author) {
		if (author == null) {
			logger.error("author model is null");
			return;
		}
		authorDao.updateAuthor(author);
		logger.info("author record successful updated");
	}

	@Override
	public Author getAuthor(Integer id) {
		return authorDao.getAuthor(id);
	}

	@Override
	public ArrayList<Book> getAuthorBooks(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
