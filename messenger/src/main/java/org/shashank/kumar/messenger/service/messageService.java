package org.shashank.kumar.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.shashank.kumar.messenger.database.DatabaseClass;
import org.shashank.kumar.messenger.model.Message;

public class messageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public messageService() {

	}

	public List<Message> getAllMessages() {

		List<Message> list = Collections.list(Collections.enumeration(messages.values()));
		
		return list;
	}
	
	public List<Message> getAllMessagesByYear(int year) {
		
		List<Message> messagesByYear = new ArrayList<>();
		List<Message> list = Collections.list(Collections.enumeration(messages.values()));
		Calendar cal = Calendar.getInstance();
		
		for (Message m:list) 
        { 
            cal.setTime(m.getCreated());
            if(cal.get(Calendar.YEAR) == year) {
            	messagesByYear.add(m);
            }
        }

		return messagesByYear;
	}

	public Object getMessage(long id) {

		return messages.get(id);

	}

	public Message addMessage(Message message) {

		message.setId(messages.size() + 1);
		message.setCreated(new Date());
		messages.put(message.getId(), message);

		return message;
	}

	public Message deleteMessage(long id) {

		messages.remove(id);
		return null;
	}

	public Message updateMessage(Message message) {

		messages.put(message.getId(), message);
		System.out.println(messages.get(message.getId()).getMessage());
		return message;
	}
}
