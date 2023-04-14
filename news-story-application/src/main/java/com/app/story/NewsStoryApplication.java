package com.app.story;

import com.app.story.domain.Story;
import com.app.story.service.StoryService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class NewsStoryApplication {

	public static void main(String[] args) {
	 SpringApplication.run(NewsStoryApplication.class, args);
	}

}
