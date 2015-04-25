/**
 * 
 */
package ru.wonderkot.comicsChange.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import ru.wonderkot.comicsChange.model.Author;

/**
 * @author Wonderkot
 *
 */
public interface AuthorDao {
	public void addNewAuthor(@Param("author") Author author);

	public void deleteAuthor(@Param("id") Integer id);

	public void updateAuthor(@Param("author") Author author);

	public ArrayList<Author> findAuthor(@Param("author") Author author);

	public ArrayList<Author> getAllAuthors();
	
	public Author getAuthor(@Param("id") Integer id);
}
