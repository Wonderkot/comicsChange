/**
 * 
 */
package ru.wonderkot.comicsChange.dao.impl;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.wonderkot.comicsChange.dao.PublisherDao;
import ru.wonderkot.comicsChange.model.Book;
import ru.wonderkot.comicsChange.model.Publisher;

/**
 * @author Wonderkot
 *
 */
@Service
public class PublisherDaoImpl implements PublisherDao {

	private static Logger logger = LogManager.getLogger(PublisherDaoImpl.class);
	@Autowired
	private PublisherDao publisherDao;

	@Override
	public void addNewPublisher(Publisher publisher) {
		if (publisher == null) {
			logger.error("empty publisher entity");
			return;
		}
		publisherDao.addNewPublisher(publisher);
		logger.info("new publisher added");
	}

	@Override
	public void deletePublisher(Integer id) {
		if (id <= 0 ) {
			logger.error("not valid publisher id ");
			return;
		}
		publisherDao.deletePublisher(id);
		logger.warn("one publisher was deleted");
	}

	@Override
	public ArrayList<Publisher> findPublisher(Publisher publisher) {
		if (publisher == null) {
			logger.error("publisher entity is null");
			return null;
		}
		ArrayList<Publisher> publishers = new ArrayList<>();
		publishers =  publisherDao.findPublisher(publisher);
		logger.info("publishers found:" + publishers.size());
		return publishers;
	}

	@Override
	public ArrayList<Publisher> getAllPublishers() {
		ArrayList<Publisher> publishers = new ArrayList<>();
		publishers =  publisherDao.getAllPublishers();
		logger.info("total publishers:" + publishers.size());
		return publishers;
	}

	@Override
	public void updatePublisher(Publisher publisher) {
		if (publisher == null) {
			logger.error("publisher entity is null");
			return;
		}
		publisherDao.updatePublisher(publisher);
		logger.info(publisher.getId() +  "publisher was updated");
	}

	@Override
	public ArrayList<Book> getAllPublisherBooks(Integer id) {
		// TODO Auto-generated method stub
		logger.warn("not realized");
		return null;
	}

	@Override
	public Publisher getPublisher(Integer id) {
		if (id <= 0 ) {
			logger.error("not valid publisher id ");
			return null;
		}
		Publisher publisher =  publisherDao.getPublisher(id);
		logger.info("get publisher with id " + id);
		if (publisher == null) {
			logger.error("publisher not found");
		}
		return publisher;
	}

}
