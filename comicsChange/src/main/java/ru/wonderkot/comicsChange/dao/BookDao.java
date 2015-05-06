/**
 * 
 */
package ru.wonderkot.comicsChange.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import ru.wonderkot.comicsChange.model.Book;

/**
 * @author Wonderkot
 *
 */
public interface BookDao {
	public void addNewBook(@Param("book") Book book);

	public void deleteBook(@Param("book") Book book);

	public void updateBook(@Param("book") Book book);

	public ArrayList<Book> findBooks(@Param("book") Book book);

	public ArrayList<Book> getAll();

	public Book getBook(@Param("id") Integer id);
}
