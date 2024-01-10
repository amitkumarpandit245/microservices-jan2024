package com.bvr;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseServiceApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(DatabaseServiceApplication.class);
	
	@Autowired
	private BookRepository repository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		repository.save(new Book("PySpark"));
		repository.save(new Book("GoLang"));
		repository.save(new Book("Python"));
		repository.save(new Book("Javascript"));
		repository.save(new Book("Scala"));
		repository.save(new Book("Ruby"));
		repository.save(new Book("Java"));
		repository.save(new Book("C#"));
		
		log.info("Created Primary records");
		
		
		
		System.out.println("\n find all records");
		
		repository.findAll().forEach(x -> System.out.println(x));
		
		
		System.out.println("\n find by id record");
		
		repository.findById(3L).ifPresent(x -> System.out.println(x));
		
		
		System.out.println("\n find by name records");
		
		repository.findByName("Java").forEach(x -> System.out.println(x));
		
		/*
		System.out.println("\n delete record by id");
		
		Book bookToDelete = repository.findById(157L).get();
		System.out.println("Deleting Book : " + bookToDelete.getName());
		
		repository.delete(bookToDelete);
	
		
		
		
		System.out.println("\n delete record by title");
		
		repository.findByName("GoLang").forEach(book -> {
			System.out.println("Deleting Book : " + book.getName());
			repository.delete(book);
		});
		
		
		System.out.println("\n delete by ID");
		
		repository.deleteById(158L);
		
		
		
		System.out.println("\n delete all by ID");
		
		repository.deleteAllById(Arrays.asList(7L, 208L, 258L, 308L));
		
		

		
		System.out.println("\n delete BY Name ");
		
		repository.deleteAll(repository.findByName("Java"));
		
		*/
		
		System.out.println("\n Update Records ");
		
		repository.findById(3L).ifPresent(x -> {
			System.out.println(x);
			x.setName(" Python - FastAPI and Databricks");
			repository.save(x);
		});
		
	}

}
