package businessLogic;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import businessLogic.validators.EmailValidator;
import businessLogic.validators.StudentAgeValidator;
import businessLogic.validators.Validator;
import dao.StudentDAO;
import model.Student;

public class StudentBLL {

    private List<Validator<Student>> validators;
    private StudentDAO studentDAO;

    public StudentBLL() {
        validators = new ArrayList<Validator<Student>>();
        validators.add(new EmailValidator());
        validators.add(new StudentAgeValidator());

        studentDAO = new StudentDAO();
    }

    public Student findStudentById(int id) {
        Student st = studentDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The student with id =" + id + " was not found!");
        }
        return st;
    }

    public Student insertStudent(Student student) {
        for (Validator<Student> v : validators) {
            v.validate(student);
        }
        return studentDAO.insert(student);
    }

    public Student updateStudent(Student student) {
        for (Validator<Student> v : validators) {
            v.validate(student);
        }
        return studentDAO.update(student);
    }

    public Student deleteStudent(Student student) {
        for (Validator<Student> v : validators) {
            v.validate(student);
        }
        return studentDAO.delete(student);
    }

    public ResultSet connectToTable(){
        return studentDAO.setTable();
    }
}
