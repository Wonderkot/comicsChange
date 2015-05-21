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

import ru.wonderkot.comicsChange.dao.PublisherDao;
import ru.wonderkot.comicsChange.model.Book;
import ru.wonderkot.comicsChange.model.Publisher;
import ru.wonderkot.comicsChange.utils.LogMessages;

/**
 * @author Wonderkot
 *
 */
@Service
public class PublisherDaoImpl implements PublisherDao {

	private static Logger logger = LogManager.getLogger(PublisherDaoImpl.class);
	@Autowired
	private PublisherDao publisherDao;
	
	@Transactional
	public void addNewPublisher(Publisher publisher) {
		if (publisher == null) {
			logger.error(LogMessages.MODEL_IS_NULL.getMesssage(),
					Publisher.class.getSimpleName());
			return;
		}
		publisherDao.addNewPublisher(publisher);
		logger.info(LogMessages.INSERT_NEW_OBJECT.getMesssage(),
				Publisher.class.getSimpleName());
	}
	
	@Transactional
	public void deletePublisher(Integer id) {
		if (id <= 0) {
			logger.error(LogMessages.NOT_VALID_ID.getMesssage(), id);
			return;
		}
		publisherDao.deletePublisher(id);
		logger.warn(LogMessages.DELETE_OBJECT.getMesssage(),
				Publisher.class.getSimpleName(), id);
	}
	
	@Transactional
	public ArrayList<Publisher> findPublisher(Publisher publisher) {
		if (publisher == null) {
			logger.error(LogMessages.FIND.getMesssage(),
					Publisher.class.getSimpleName());
			return null;
		}
		ArrayList<Publisher> publishers = new ArrayList<>();
		publishers = publisherDao.findPublisher(publisher);
		if (publishers != null && !publishers.isEmpty())
			logger.info(LogMessages.TOTAL_FOUND.getMesssage(),
					Publisher.class.getSimpleName(), publishers.size());
		else {
			logger.info(LogMessages.NOT_FOUND.getMesssage(),
					Publisher.class.getSimpleName());
		}
		return publishers;
	}
	
	@Transactional
	public ArrayList<Publisher> getAllPublishers() {
		ArrayList<Publisher> publishers = new ArrayList<>();		
		publishers = publisherDao.getAllPublishers();		
		logger.info(LogMessages.TOTAL_RECORDS.getMesssage(),
				Publisher.class.getSimpleName(), publishers.size());
		return publishers;
	}
	
	@Transactional
	public void updatePublisher(Publisher publisher) {
		if (publisher == null) {
			logger.error(LogMessages.MODEL_IS_NULL.getMesssage(),
					Publisher.class.getSimpleName());
			return;
		}
		publisherDao.updatePublisher(publisher);
		logger.info(LogMessages.UPDATE_OBJECT.getMesssage(),
				Publisher.class.getSimpleName(), publisher.getId());
	}
	
	@Transactional
	public ArrayList<Book> getAllPublisherBooks(Integer id) {
		// TODO Auto-generated method stub
		logger.warn("not realized");
		return null;
	}
	
	@Transactional
	public Publisher getPublisher(Integer id) {
		if (id <= 0) {
			logger.error(LogMessages.NOT_VALID_ID.getMesssage(), id);
			return null;
		}
		Publisher publisher = publisherDao.getPublisher(id);
		logger.info(LogMessages.GET_OBJECT.getMesssage(),
				Publisher.class.getSimpleName(), id);
		if (publisher == null) {
			logger.error(LogMessages.OBJECT_NOT_FOUND.getMesssage(),
					Publisher.class.getSimpleName());
		}
		return publisher;
	}

}
