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
import ru.wonderkot.comicsChange.utils.LogMessages;

/**
 * @author Wonderkot
 *
 */

@Service
public class AuthorDaoImpl implements AuthorDao {
	private static Logger logger = LogManager.getLogger(AuthorDaoImpl.class);
	@Autowired
	private AuthorDao authorDao;

	public void addNewAuthor(Author author) {
		if (author == null) {
			logger.error(LogMessages.MODEL_IS_NULL.getMesssage(),
					Author.class.getSimpleName());
			return;
		}		
		logger.info(LogMessages.INSERT_NEW_OBJECT.getMesssage(),
				Author.class.getSimpleName());
		authorDao.addNewAuthor(author);
	}

	public void deleteAuthor(Integer id) {
		if (id <= 0) {
			logger.error(LogMessages.MODEL_IS_NULL.getMesssage(),
					Author.class.getSimpleName());
			return;
		}
		logger.warn(LogMessages.DELETE_OBJECT.getMesssage(),
				Author.class.getSimpleName(), id);
		authorDao.deleteAuthor(id);

	}

	public ArrayList<Author> findAuthor(Author author) {
		if (author == null) {
			logger.error(LogMessages.MODEL_IS_NULL.getMesssage(),
					Author.class.getSimpleName());
			return null;
		}
		logger.info(LogMessages.FIND.getMesssage(),
				Author.class.getSimpleName());
		return authorDao.findAuthor(author);
	}

	public ArrayList<Author> getAllAuthors() {
		ArrayList<Author> authors = new ArrayList<Author>();
		authors = authorDao.getAllAuthors();
		logger.info(LogMessages.TOTAL_RECORDS.getMesssage(),
				Author.class.getSimpleName(), authors.size());
		return authors;
	}

	public void updateAuthor(Author author) {
		if (author == null) {
			logger.error(LogMessages.MODEL_IS_NULL.getMesssage(),
					Author.class.getSimpleName());
			return;
		}
		authorDao.updateAuthor(author);
		logger.info(LogMessages.UPDATE_OBJECT.getMesssage(),
				Author.class.getSimpleName(), author.getId());
	}

	public Author getAuthor(Integer id) {
		if (id <= 0) {
			logger.error(LogMessages.NOT_VALID_ID.getMesssage(), id);
			return null;
		}
		logger.info(LogMessages.GET_OBJECT.getMesssage(),
				Author.class.getSimpleName(), id);
		return authorDao.getAuthor(id);
	}

	public ArrayList<Book> getAuthorBooks(Integer id) {
		if (id <= 0) {
			logger.error(LogMessages.NOT_VALID_ID.getMesssage(), id);
			return null;
		}
		return null;
	}

}
