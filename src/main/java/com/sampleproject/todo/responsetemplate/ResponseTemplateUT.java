package com.sampleproject.todo.responsetemplate;

import com.sampleproject.todo.models.ToDoList;
import com.sampleproject.todo.models.User;

import lombok.Data;

@Data
public class ResponseTemplateUT {
	private User user;
	private ToDoList list;	
}
