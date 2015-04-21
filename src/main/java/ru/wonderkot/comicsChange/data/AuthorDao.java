/**
 * 
 */
package ru.wonderkot.comicsChange.data;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import ru.wonderkot.comicsChange.model.Author;

/**
 * @author Wonderkot
 *
 */

public interface AuthorDao {
	public void addNewAuthor(@Param("author") Author author);
	public void deleteAuthor(Author author);
	public void updateAuthor(Author author);
	public ArrayList<Author> findAuthor(Author author);
	public ArrayList<Author> getAllAuthors();
}
