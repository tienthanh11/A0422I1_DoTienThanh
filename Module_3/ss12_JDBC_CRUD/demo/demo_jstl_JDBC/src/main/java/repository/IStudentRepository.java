package repository;

import model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    boolean add(Student student);

    boolean delete(int id);
}
