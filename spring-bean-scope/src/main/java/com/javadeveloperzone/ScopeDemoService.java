package com.javadeveloperzone;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//Remove comment on annotation to use annotation based config
/*@Service
@Scope(value= BeanDefinition.SCOPE_PROTOTYPE)*/
public class ScopeDemoService
{
	String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
