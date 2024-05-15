package com.in.blog.Blogg_Api;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BloggApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloggApiApplication.class, args);

	}
	@Bean
	public ModelMapper modelMapper()
	{
		return  new ModelMapper();

	}

}
