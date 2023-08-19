package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

}

/*
 * @Repository: This annotation is used to indicate that the interface is a
 * Spring Data repository. Spring Data repositories provide a way to interact
 * with a data source (usually a database) using a high-level, abstracted API.
 * This annotation also enables Spring's component scanning to automatically
 * detect and register this interface as a Spring bean.
 * 
 * public interface StudentDao extends JpaRepository<Student, Integer> {: This
 * line defines the StudentDao interface, which extends the JpaRepository
 * interface. The JpaRepository is part of the Spring Data JPA framework and
 * provides various CRUD (Create, Read, Update, Delete) operations and
 * additional querying capabilities.
 * 
 * Student: This is the entity class that this repository is associated with. In
 * this case, it seems that the Student class is an entity class representing
 * student data in a database.
 * 
 * Integer: This is the type of the primary key of the Student entity. In most
 * cases, it indicates that the primary key is of type Integer.
 */