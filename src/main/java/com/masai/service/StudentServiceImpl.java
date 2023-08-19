package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao sDao;

	@Override
	public Student saveStudent(Student student) {

		// Student savedStudent= sDao.save(student);
		// return savedStudent;

		return sDao.save(student);
	}
	/*
	 * 1. @Autowired: This annotation is used in Spring Framework to automatically
	 * inject (initialize) dependencies into a class.
	 * In this case, it's injecting an instance of the StudentDao class into the
	 * current class.
	 * private StudentDao sDao;: This declares a private instance variable named
	 * sDao of type StudentDao.
	 * The StudentDao class is presumably a data access object that provides methods
	 * to interact with a database
	 * or data source related to students.
	 * 
	 * 2. public Student saveStudent(Student student) {:
	 * 
	 * This line defines a method named saveStudent that takes a
	 * single parameter of type Student and returns an object of type Student. The
	 * method seems to be intended
	 * for saving student information
	 * 
	 * 3. sDao.save(student):
	 * 
	 * This line calls the save method on the sDao instance, which is an instance of
	 * StudentDao.
	 * This method is presumably responsible for saving the provided student object
	 * into a database or data source.
	 * The method returns the saved Student object.
	 * 
	 */

	// ====================================================================================
	@Override
	public Student getStudentByRoll(Integer roll) throws StudentException {

		// Optional<Student> opt= sDao.findById(roll);
		//
		// if(opt.isPresent()) {
		//
		// Student student= opt.get();
		// return student;
		//
		// }else
		// throw new StudentException("Student does not exist with Roll "+roll);
		//

		return sDao.findById(roll).orElseThrow(() -> new StudentException("Student does not exist with Roll :" + roll));

	}

	/*
	 * // Attempt to find a student by their roll number
	 * // Returns an Optional<Student> that may or may not contain a student
	 * 
	 * Optional<Student> opt = sDao.findById(roll);
	 * 
	 * // Check if a student was found in the Optional
	 * 
	 * if (opt.isPresent()) {
	 * 
	 * // If a student was found, get the student object
	 * Student student = opt.get();
	 * 
	 * return student; // Return the found student
	 * } else {
	 * // If no student was found, throw an exception
	 * throw new StudentException("Student does not exist with Roll " + roll);
	 * }
	 * The code tries to find a student in the database based on their roll
	 * number using the findById method of sDao.
	 * 
	 * If a student is found (the Optional contains a student), it retrieves the
	 * student object from
	 * the Optional using get() and returns it.
	 * 
	 */

	// =========================================================================================

	@Override
	public List<Student> getAllStudents() throws StudentException {

		List<Student> students = sDao.findAll();

		if (students.size() > 0)
			return students;
		else
			throw new StudentException("No Student found...");
	}

	/*
	 * // Retrieve a list of all students from the database
	 * 
	 * List<Student> students = sDao.findAll();
	 * 
	 * // Check if any students were retrieved
	 * if (students.size() > 0) {
	 * return students; // Return the list of students
	 * } else {
	 * throw new StudentException("No Student found..."); // Throw an exception if
	 * no students are found
	 * }
	 * The code fetches a list of all students from the database using the findAll
	 * method provided by sDao.
	 * 
	 * It checks whether any students were retrieved by examining the size of the
	 * students list.
	 * 
	 * If there are students in the list (the list size is greater than 0), the code
	 * simply returns the list of students.
	 * 
	 */

	// ========================================================================================================

	@Override
	public Student deleteStudentByRoll(Integer roll) throws StudentException {

		Student existingStudent = sDao.findById(roll)
				.orElseThrow(() -> new StudentException("Student does not exist with Roll :" + roll));

		sDao.delete(existingStudent);

		return existingStudent;

	}

	/*
	 * The code tries to find a student in the database based on their roll number
	 * using the findById method of sDao.
	 * However, it does something different this time. It uses the orElseThrow
	 * method on the Optional<Student> returned
	 * by findById to handle the case when a student is not found. If a student is
	 * not found, it throws a StudentException
	 * with the message "Student does not exist with Roll: " followed by the roll
	 * number.
	 * 
	 * If a student is found (and the exception is not thrown), the existingStudent
	 * variable is assigned the value of the found student.
	 * 
	 * It then calls the delete method of sDao to delete the student from the
	 * database.
	 * 
	 * Finally, it returns the existingStudent object, which is the student that was
	 * just deleted.
	 */

	// ===============================================================================================

	@Override
	public Student updateStudent(Student student) throws StudentException {

		Optional<Student> opt = sDao.findById(student.getRoll());

		if (opt.isPresent()) {

			Student existingStudent = opt.get();

			return sDao.save(student);

		} else
			throw new StudentException("Invalid Student Details..");

	}

	/*
	 * // Attempt to find a student by their roll number
	 * Optional<Student> opt = sDao.findById(student.getRoll());
	 * 
	 * // Check if a student was found
	 * if (opt.isPresent()) {
	 * // Get the existing student from the Optional
	 * Student existingStudent = opt.get();
	 * 
	 * // Update the existing student with the new student's details
	 * // Save the updated student to the database and return it
	 * return sDao.save(student);
	 * } else {
	 * // If no student was found, throw an exception
	 * throw new StudentException("Invalid Student Details..");
	 * }
	 * 
	 * The code attempts to find a student in the database using the findById method
	 * of sDao. It uses
	 * the roll number of the provided student object to search for the student.
	 * 
	 * It checks if a student was found by calling isPresent() on the
	 * Optional<Student>.
	 * 
	 * If a student with the provided roll number is found, the code gets the
	 * existing student object using get() on the Optional.
	 * 
	 * It updates the details of the existingStudent with the information from the
	 * student object passed as a parameter.
	 * 
	 * The updated student is then saved to the database using the
	 * sDao.save(student) method.
	 * The updated student is returned as the result of this method call.
	 * 
	 * If no student with the provided roll number is found, the code throws a
	 * StudentException with
	 * the message "Invalid Student Details.." to indicate that the provided student
	 * details are not valid.
	 */

	// ================================================================================================================

	@Override
	public Student updateStudentMarks(Integer roll, Integer graceMarks) throws StudentException {

		Optional<Student> opt = sDao.findById(roll);

		if (opt.isPresent()) {

			Student existingStudent = opt.get();

			existingStudent.setMarks(existingStudent.getMarks() + graceMarks);

			return sDao.save(existingStudent);

		} else
			throw new StudentException("Student does not exist with Roll :" + roll);

	}

}

/*
 * The code attempts to find a student in the database using the findById method
 * of sDao. It uses the roll parameter to search for the student.
 * 
 * It checks if a student was found by calling isPresent() on the
 * Optional<Student>.
 * 
 * If a student with the provided roll number is found, the code gets the
 * existing student object using get() on the Optional.
 * 
 * The code updates the existing student's marks by adding the graceMarks to the
 * current marks.
 * 
 * The updated student is then saved to the database using the
 * sDao.save(existingStudent) method. The updated student is returned as the
 * result of this method call.
 * 
 * If no student with the provided roll number is found, the code throws a
 * StudentException with the message "Student does not exist with Roll: "
 * followed by the roll number.
 */
