/**
 * 
 */
package ru.wonderkot.comicsChange.model;

/**
 * @author Wonderkot
 *
 */
public class Book {
	private Long id;
	private String title;
	private Publisher publisher;
	private Author author;
	private String coverMain;
	private String coverBackup;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getCoverMain() {
		return coverMain;
	}
	public void setCoverMain(String coverMain) {
		this.coverMain = coverMain;
	}
	public String getCoverBackup() {
		return coverBackup;
	}
	public void setCoverBackup(String coverBackup) {
		this.coverBackup = coverBackup;
	}
}
