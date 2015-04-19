/**
 * 
 */
package ru.wonderkot.comicsChange.model;

/**
 * @author Wonderkot
 *
 */
public class Author {
	private Long id;
	private String name;
	private String surname;
	private String patronymic;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
}
