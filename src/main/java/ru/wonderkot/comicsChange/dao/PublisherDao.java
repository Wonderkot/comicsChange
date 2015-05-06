/**
 * 
 */
package ru.wonderkot.comicsChange.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import ru.wonderkot.comicsChange.model.Book;
import ru.wonderkot.comicsChange.model.Publisher;

/**
 * @author Wonderkot
 *
 */
public interface PublisherDao {
	public void addNewPublisher(@Param("publisher") Publisher publisher);

	public void deletePublisher(@Param("id") Integer id);

	public ArrayList<Publisher> findPublisher(
			@Param("publisher") Publisher publisher);

	public ArrayList<Publisher> getAllPublishers();

	public void updatePublisher(@Param("publisher") Publisher publisher);

	public Publisher getPublisher(@Param("id") Integer id);

	/**
	 * Возвращает все книги издательства
	 * 
	 * @param id
	 *            идентификатор издательства
	 * @return
	 */
	public ArrayList<Book> getAllPublisherBooks(@Param("id") Integer id);
}
