package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Student;
import com.masai.repository.StudentDao;
import com.masai.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService sService;
	
	
	
	
	@PostMapping("/students")
	public ResponseEntity<Student> saveStudentHandler(@RequestBody Student student){
		
		Student savedStudent= sService.saveStudent(student);
	
		
		return new ResponseEntity<Student>(savedStudent,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/students/{roll}")
	public Student getStudentByRollNumber(@PathVariable("roll") Integer roll) {
		
		return sService.getStudentByRoll(roll);
		
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentsDetails(){
		
		
		List<Student> students= sService.getAllStudents();
		
		
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/students/{roll}")
	public Student deleteStudentHandler(@PathVariable("roll") Integer roll){
		
		return sService.deleteStudentByRoll(roll);
		
		
	}
	
	
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudentHandler(@RequestBody Student student){
		
		Student updatedStudent= sService.updateStudent(student);
		
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.ACCEPTED);
		
		
	}
	
	
	@PutMapping("/students/{roll}")
	public ResponseEntity<Student> updateStudentMarks(@PathVariable("roll") Integer roll,@RequestParam("marks") Integer marks) {
		
		Student updatedStudent = sService.updateStudentMarks(roll, marks);
		
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	
}
