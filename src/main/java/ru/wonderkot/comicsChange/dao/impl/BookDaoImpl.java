/**
 * 
 */
package ru.wonderkot.comicsChange.dao.impl;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.wonderkot.comicsChange.dao.BookDao;
import ru.wonderkot.comicsChange.model.Book;
import ru.wonderkot.comicsChange.utils.LogMessages;

/**
 * @author Wonderkot
 *
 */
@Service
public class BookDaoImpl implements BookDao {

	private static Logger logger = LogManager.getLogger(BookDaoImpl.class);
	@Autowired
	private BookDao bookDao;
	
	@Transactional
	public void addNewBook(Book book) {
		if (book == null) {
			logger.error(LogMessages.MODEL_IS_NULL.getMesssage(),
					Book.class.getSimpleName());
			return;
		}
		bookDao.addNewBook(book);
		logger.info(LogMessages.INSERT_NEW_OBJECT.getMesssage(),
				Book.class.getSimpleName());
	}

	@Transactional
	public void deleteBook(Integer id) {
		if (id <= 0) {
			logger.error(LogMessages.MODEL_IS_NULL.getMesssage(),
					Book.class.getSimpleName());
			return;
		}
		bookDao.deleteBook(id);
		logger.warn(LogMessages.DELETE_OBJECT.getMesssage(),
				Book.class.getSimpleName(), id);
	}

	@Transactional
	public ArrayList<Book> findBooks(Book book) {
		if (book == null) {
			logger.error(LogMessages.MODEL_IS_NULL.getMesssage(),
					Book.class.getSimpleName());
			return null;
		}
		ArrayList<Book> books = new ArrayList<>();
		books = bookDao.findBooks(book);
		if (books != null && !books.isEmpty())
			logger.info(LogMessages.TOTAL_FOUND.getMesssage(),
					Book.class.getSimpleName(), books.size());
		else {
			logger.info(LogMessages.NOT_FOUND.getMesssage(),
					Book.class.getSimpleName());
		}
		return books;
	}
	
	@Transactional
	public void updateBook(Book book) {
		if (book == null) {
			logger.error(LogMessages.MODEL_IS_NULL.getMesssage(),
					Book.class.getSimpleName());
			return;
		}
		bookDao.updateBook(book);
		logger.info(LogMessages.UPDATE_OBJECT.getMesssage(),
				Book.class.getSimpleName(), book.getId());
	}
	
	@Transactional
	public ArrayList<Book> getAllBooks() {
		ArrayList<Book> books = new ArrayList<>();
		books = bookDao.getAllBooks();
		logger.info(LogMessages.TOTAL_RECORDS.getMesssage(),
				Book.class.getSimpleName(), books.size());
		for (Book book : books) {
			System.out.println(book.getCoverMain());
		}
		return books;
	}
	
	@Transactional
	public Book getBook(Integer id) {
		if (id <= 0) {
			logger.error(LogMessages.NOT_VALID_ID.getMesssage(), id);
			return null;
		}
		Book book = bookDao.getBook(id);
		logger.info(LogMessages.GET_OBJECT.getMesssage(),
				Book.class.getSimpleName(), id);
		return book;
	}

}
