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
	public ResponseEntity<Student> saveStudentHandler(@RequestBody Student student) {

		Student savedStudent = sService.saveStudent(student);

		return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);

	}

	/*
	 * @RestController: This annotation indicates that the class is a Spring MVC
	 * controller that handles RESTful API requests. It's a specialized version
	 * of @Controller that combines @Controller and @ResponseBody. The methods in
	 * this class return data directly as the response body.
	 * 
	 * public class StudentController {: This line defines the StudentController
	 * class. This class is responsible for handling HTTP requests related to
	 * student data.
	 * 
	 * @Autowired: This annotation is used to automatically inject dependencies. In
	 * this case, it injects an instance of StudentService into the controller.
	 * 
	 * @PostMapping("/students"): This annotation defines an HTTP POST mapping. When
	 * a POST request is made to the "/students" endpoint, the method
	 * saveStudentHandler will be invoked.
	 * 
	 * public ResponseEntity<Student> saveStudentHandler(@RequestBody Student
	 * student) {: This line defines the saveStudentHandler method, which handles
	 * the POST request. The @RequestBody annotation indicates that the incoming
	 * JSON request body should be mapped to the student parameter.
	 * 
	 * Student savedStudent = sService.saveStudent(student);: This line calls the
	 * saveStudent method of the injected StudentService instance to save the
	 * student data.
	 * 
	 * return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);: This
	 * line creates a ResponseEntity with the saved student object and a
	 * HttpStatus.CREATED status code. The ResponseEntity allows you to customize
	 * the response, including headers and the response body.
	 */

	// ===================================================================================================

	@GetMapping("/students/{roll}")
	public Student getStudentByRollNumber(@PathVariable("roll") Integer roll) {

		return sService.getStudentByRoll(roll);

	}

	/*
	 * @GetMapping("/students/{roll}"): This annotation defines an HTTP GET mapping.
	 * When a GET request is made to a URL like "/students/{roll}", where {roll} is
	 * a placeholder for the roll number, the getStudentByRollNumber method will be
	 * invoked.
	 * 
	 * public Student getStudentByRollNumber(@PathVariable("roll") Integer roll) {:
	 * This line defines the getStudentByRollNumber method, which handles the GET
	 * request. The @PathVariable annotation indicates that the value from the URL
	 *  {roll} should be mapped to the roll parameter.
	 * 
	 * return sService.getStudentByRoll(roll);: This line calls the getStudentByRoll
	 * method of the injected StudentService instance to retrieve the student with
	 * the specified roll number.
	 */

	// ===========================================================================================

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentsDetails() {

		List<Student> students = sService.getAllStudents();

		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);

	}

	/*
	 * @GetMapping("/students"): This annotation defines an HTTP GET mapping. When a
	 * GET request is made to the "/students" URL, the getAllStudentsDetails method
	 * will be invoked.
	 * 
	 * public ResponseEntity<List<Student>> getAllStudentsDetails() {: This line
	 * defines the getAllStudentsDetails method, which handles the GET request. The
	 * return type ResponseEntity<List<Student>> indicates that this method will
	 * return a response entity containing a list of students.
	 * 
	 * List<Student> students = sService.getAllStudents();: This line calls the
	 * getAllStudents method of the injected StudentService instance to retrieve a
	 * list of all students.
	 * 
	 * return new ResponseEntity<List<Student>>(students, HttpStatus.OK);: This line
	 * creates a ResponseEntity with the list of students and an HTTP status code
	 * indicating success (HTTP 200 OK). The ResponseEntity allows you to customize
	 * the response, including headers and the response body.
	 */

	// ===============================================================================================

	@DeleteMapping("/students/{roll}")
	public Student deleteStudentHandler(@PathVariable("roll") Integer roll) {

		return sService.deleteStudentByRoll(roll);

	}

	/*
	 * @DeleteMapping("/students/{roll}"): This annotation defines an HTTP DELETE
	 * mapping. When a DELETE request is made to a URL like "/students/{roll}",
	 * where {roll} is a placeholder for the roll number, the deleteStudentHandler
	 * method will be invoked.
	 * 
	 * public Student deleteStudentHandler(@PathVariable("roll") Integer roll) {:
	 * This line defines the deleteStudentHandler method, which handles the DELETE
	 * request. The @PathVariable annotation indicates that the value from the URL
	 * placeholder {roll} should be mapped to the roll parameter.
	 * 
	 * return sService.deleteStudentByRoll(roll);: This line calls the
	 * deleteStudentByRoll method of the injected StudentService instance to delete
	 * the student with the specified roll number.
	 */

	// ================================================================================================

	@PutMapping("/students")
	public ResponseEntity<Student> updateStudentHandler(@RequestBody Student student) {

		Student updatedStudent = sService.updateStudent(student);

		return new ResponseEntity<Student>(updatedStudent, HttpStatus.ACCEPTED);

	}

	/*
	 * @PutMapping("/students"): This annotation defines an HTTP PUT mapping. When a
	 * PUT request is made to the "/students" URL, the updateStudentHandler method
	 * will be invoked.
	 * 
	 * public ResponseEntity<Student> updateStudentHandler(@RequestBody Student
	 * student) {: This line defines the updateStudentHandler method, which handles
	 * the PUT request. The @RequestBody annotation indicates that the incoming JSON
	 * request body should be mapped to the student parameter.
	 * 
	 * Student updatedStudent = sService.updateStudent(student);: This line calls
	 * the updateStudent method of the injected StudentService instance to update
	 * the student's details.
	 * 
	 * return new ResponseEntity<Student>(updatedStudent, HttpStatus.ACCEPTED);:
	 * This line creates a ResponseEntity with the updated student object and an
	 * HTTP status code indicating that the update was accepted (HTTP 202 ACCEPTED).
	 * The ResponseEntity allows you to customize the response, including headers
	 * and the response body.
	 */

	// =================================================================================================

	@PutMapping("/students/{roll}")
	public ResponseEntity<Student> updateStudentMarks(@PathVariable("roll") Integer roll,
			@RequestParam("marks") Integer marks) {

		Student updatedStudent = sService.updateStudentMarks(roll, marks);

		return new ResponseEntity<Student>(updatedStudent, HttpStatus.ACCEPTED);

	}

}

/*
 * @PutMapping("/students/{roll}"): This annotation defines an HTTP PUT mapping.
 * When a PUT request is made to a URL like "/students/{roll}", where {roll} is
 * a placeholder for the roll number, the updateStudentMarks method will be
 * invoked.
 * 
 * public ResponseEntity<Student> updateStudentMarks(: This line defines the
 * updateStudentMarks method, which handles the PUT request. The method takes
 * two parameters: roll from the URL path and marks from the request parameter.
 * 
 * @PathVariable("roll") Integer roll: This annotation maps the value from the
 * URL placeholder {roll} to the roll parameter.
 * 
 * @RequestParam("marks") Integer marks: This annotation maps the marks request
 * parameter to the marks parameter of the method.
 * 
 * Student updatedStudent = sService.updateStudentMarks(roll, marks);: This line
 * calls the updateStudentMarks method of the injected StudentService instance
 * to update the student's marks.
 * 
 * return new ResponseEntity<Student>(updatedStudent, HttpStatus.ACCEPTED);:
 * This line creates a ResponseEntity with the updated student object and an
 * HTTP status code indicating that the update was accepted (HTTP 202 ACCEPTED).
 * The ResponseEntity allows you to customize the response, including headers
 * and the response body.
 */
