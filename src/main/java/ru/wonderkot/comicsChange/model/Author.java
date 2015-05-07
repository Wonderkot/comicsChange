/**
 * 
 */
package ru.wonderkot.comicsChange.model;

import org.apache.ibatis.type.Alias;


/**
 * @author Wonderkot
 *
 */
@Alias("Authors")
public class Author {
	private Integer id;
	private String name;
	private String surname;
	private String patronymic;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
