/**
 * 
 */
package ru.wonderkot.comicsChange.utils;

/**
 * @author pd199717
 *
 */
public enum LogMessages {
	MODEL_IS_NULL("{} model is null"),
	NOT_VALID_ID("{} is not valid id"),
	INSERT_NEW_OBJECT("insert new {}"),
	UPDATE_OBJECT("{} with id {} has been updated"),
	DELETE_OBJECT("{} with id {}  mark as deleted"),
	TOTAL_RECORDS("total {}s:{}"),
	FIND("try find {}"),
	GET_OBJECT("get {} with id {}");
	

	private final String message; // Message string

	LogMessages(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @return
	 */
	public String getMesssage() {
		return message;
	}
}
