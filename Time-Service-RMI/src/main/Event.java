package main;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {

	public Date date;
	public String eventName;

	public Event(Date date, String eventName) {
		this.date = date;
		this.eventName = eventName;
	}

	public Date getDate() {
		return date;
	}

	public String getEventName() {
		return eventName;
	}

}
