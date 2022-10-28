package service;

import model.Student;
import repository.IStudentRepository;
import repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {

    private IStudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean add(Student student) {
        // kiểm tra dữ liệu
        // validate dữ liệu
        return studentRepository.add(student);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
