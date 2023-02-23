package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.repository.StudentDao;
@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao sDao;
	
	@Override
	public Student saveStudent(Student student) {
		
		//Student savedStudent= sDao.save(student);
		//return savedStudent;
		
		return sDao.save(student);
	}

	@Override
	public Student getStudentByRoll(Integer roll) throws StudentException {
		
		
//		Optional<Student> opt= sDao.findById(roll);
//		
//		if(opt.isPresent()) {
//			
//			Student student= opt.get();
//			return student;
//			
//		}else
//			throw new StudentException("Student does not exist with Roll "+roll);
//		
		
	return sDao.findById(roll).orElseThrow(() -> new StudentException("Student does not exist with Roll :"+roll));
		
		
		
		
	}

	@Override
	public List<Student> getAllStudents() throws StudentException {
		
		
		List<Student> students= sDao.findAll();
		
		if(students.size() > 0)
			return students;
		else
			throw new StudentException("No Student found...");
		
		
	}

	@Override
	public Student deleteStudentByRoll(Integer roll) throws StudentException {
		
		Student existingStudent= sDao.findById(roll).orElseThrow( () -> new StudentException("Student does not exist with Roll :"+roll) );
		
		sDao.delete(existingStudent);
		
		return existingStudent;
		
	}

	@Override
	public Student updateStudent(Student student) throws StudentException {
		
		Optional<Student> opt= sDao.findById(student.getRoll());
		
		if(opt.isPresent()) {
			
			Student existingStudent= opt.get();
			
			return sDao.save(student);
			
			
			
		}
		else
			throw new StudentException("Invalid Student Details..");
		
		
		
	}

	@Override
	public Student updateStudentMarks(Integer roll, Integer graceMarks) throws StudentException {
		
		Optional<Student> opt= sDao.findById(roll);
		
		if(opt.isPresent()) {
			
			Student existingStudent= opt.get();
			
			
			existingStudent.setMarks(existingStudent.getMarks()+graceMarks);
			
			return sDao.save(existingStudent);
			
			
		}else
			throw new StudentException("Student does not exist with Roll :"+roll);
		
		
	}
	
	

}
