/**
 * 
 */
package ru.wonderkot.comicsChange.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.wonderkot.comicsChange.dao.impl.PublisherDaoImpl;
import ru.wonderkot.comicsChange.model.Publisher;

/**
 * @Publisher pd199717
 *
 */
@RestController
public class PublisherController {
	@Autowired
	PublisherDaoImpl daoImpl;
	
	@RequestMapping(value = "rest/getAllPublishers", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Publisher> getPublishers() {
		return daoImpl.getAllPublishers();
	}

	@RequestMapping(value = "rest/addNewPublisher", method = RequestMethod.POST)
	public void addPublisher(@RequestBody Publisher publisher) {
		daoImpl.addNewPublisher(publisher);		
	}

	@RequestMapping(value = "rest/deletePublisher", method = RequestMethod.DELETE)
	public void deletePublisher(@RequestParam() Integer id) {
		daoImpl.deletePublisher(id);
	}

	@RequestMapping(value = "rest/updatePublisher", method = RequestMethod.POST)
	public void updatePublisher(@RequestBody Publisher publisher) {
		daoImpl.updatePublisher(publisher);
	}

	@RequestMapping(value = "rest/findPublisher", method = RequestMethod.GET)
	public ArrayList<Publisher> find(@RequestBody Publisher publisher) {
		return daoImpl.findPublisher(publisher);
	}

	@RequestMapping(value = "rest/getPublisher", method = RequestMethod.GET)
	public Publisher getPublisher(@RequestBody Integer id) {
		return daoImpl.getPublisher(id);
	}
}
