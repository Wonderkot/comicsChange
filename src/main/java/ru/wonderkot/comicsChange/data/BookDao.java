/**
 * 
 */
package ru.wonderkot.comicsChange.data;

import java.util.ArrayList;

import ru.wonderkot.comicsChange.model.Book;

/**
 * @author Wonderkot
 *
 */
public interface BookDao {
	public void addNewBook(Book book);

	public void deleteBook(Book book);
	
	//TODO updateBook

	public ArrayList<Book> findBooks(Book book);

	public ArrayList<Book> getAll();
}
