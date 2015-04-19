/**
 * 
 */
package ru.wonderkot.comicsChange.data;

import java.util.ArrayList;

import ru.wonderkot.comicsChange.model.Publisher;

/**
 * @author Wonderkot
 *
 */
public interface PublisherDao {
	public void addNewPublisher(Publisher publisher);
	public void deletePublisher(Publisher publisher);
	public ArrayList<Publisher> findPublisher(Publisher publisher);
	public ArrayList<Publisher> getAllPublishers();
}
