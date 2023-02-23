package com.masai.service;

import java.util.List;

import com.masai.exception.StudentException;
import com.masai.model.Student;

public interface StudentService {
	
	public Student saveStudent(Student student);
	
	public Student getStudentByRoll(Integer roll) throws StudentException;
	
	public List<Student> getAllStudents()throws StudentException;
	
	public Student deleteStudentByRoll(Integer roll)throws StudentException;
	
	public Student updateStudent(Student student)throws StudentException;
	
	public Student updateStudentMarks(Integer roll, Integer graceMarks)throws StudentException;

}
