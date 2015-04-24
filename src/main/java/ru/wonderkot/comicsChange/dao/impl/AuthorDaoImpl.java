/**
 * 
 */
package ru.wonderkot.comicsChange.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.wonderkot.comicsChange.dao.AuthorDao;
import ru.wonderkot.comicsChange.model.Author;

/**
 * @author Wonderkot
 *
 */

@Service
public class AuthorDaoImpl implements AuthorDao {

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
			return;
		}
		System.out.println("INSERT AUTHOR");
		authorDao.addNewAuthor(author);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.wonderkot.comicsChange.data.AuthorDao#deleteAuthor(ru.wonderkot.
	 * comicsChange.model.Author)
	 */
	@Override
	public void deleteAuthor(Author author) {
		if (author == null) {
			return;
		}
		System.out.println("DELETE AUTHOR");
		authorDao.deleteAuthor(author);

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
			return null;
		}
		System.out.println("FIND");
		return authorDao.findAuthor(author);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.wonderkot.comicsChange.data.AuthorDao#getAllAuthors()
	 */
	@Override
	public ArrayList<Author> getAllAuthors() {
		System.out.println("GET ALL");
		ArrayList<Author> authors = new ArrayList<Author>();
		authors = authorDao.getAllAuthors();
		return authors;
	}

	@Override
	public void updateAuthor(Author author) {
		if (author == null) {
			return;
		}
		System.out.println("UPDATE");
		authorDao.updateAuthor(author);
	}

}
