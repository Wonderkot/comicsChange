/**
 * 
 */
package ru.wonderkot.comicsChange.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import ru.wonderkot.comicsChange.model.Publisher;

/**
 * @author Wonderkot
 *
 */
public interface PublisherDao {
	public void addNewPublisher(@Param("publisher") Publisher publisher);

	public void deletePublisher(@Param("publisher") Publisher publisher);

	public ArrayList<Publisher> findPublisher(
			@Param("publisher") Publisher publisher);

	public ArrayList<Publisher> getAllPublishers();

	public void updatePublisher(@Param("publisher") Publisher publisher);
}
