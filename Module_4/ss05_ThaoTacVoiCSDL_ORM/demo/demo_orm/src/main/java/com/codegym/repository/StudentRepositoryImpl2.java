package com.codegym.repository;

import com.codegym.bean.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentRepositoryImpl2 implements StudentRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void createOrUpdate(Student s) {
        entityManager.persist(s);
    }

    @Override
    public void create(Student s) {
        entityManager.persist(s);
    }

    @Override
    public void update(Student s) {
        entityManager.merge(s);
    }

    @Override
    public Student findById(String id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Nếu muốn dùng sql thuần thì dùng như bên dưới
//        entityManager.createNativeQuery("Câu lện sql");
        // Dùng HQL
        return entityManager.createQuery("select s from Student s").getResultList();
    }

    @Override
    public List<Student> findByName(String name) {
        return entityManager.createNamedQuery("findName")
                .setParameter("name", "%" + name + "%").getResultList();
    }

    public List<Student> findByAddress(String address) {
        // truyền param theo thứ tự ?
//        return entityManager.createQuery("select s from Student s where s.address like ?1")
//                .setParameter(1, address).getResultList();
        // viết câu hql và truyền param vào câu lệnh theo tên param
        return entityManager.createQuery("select s from Student s where s.address like :address")
                .setParameter("address", address).getResultList();
    }

    @Override
    public void deleteById(String id) {
        Student s = findById(id);
        entityManager.remove(s);
    }
}
