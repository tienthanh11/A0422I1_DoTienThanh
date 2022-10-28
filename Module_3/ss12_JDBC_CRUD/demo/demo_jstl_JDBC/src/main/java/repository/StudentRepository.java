package repository;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

//    private static List<Student> studentList = new ArrayList<>();
    private final String SELECT_ALL = "select* from student;";
    private final String INSERT_STUDENT ="insert into student(name,birthday, gender,`point`,`account`,class_id,email)" +
            "values (?,?,?,?,?,?,?);";


    @Override
    public List<Student> findAll() {
        // kết nối db để lấy dữ liệu
        List<Student> studentList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");  // columnLabel: tên trường trong database
                                                            // get theo kiểu dữ liệu của java
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                String birthday = resultSet.getString("birthday");
                int point = resultSet.getInt("point");
                String account = resultSet.getString("account");
                int classId = resultSet.getInt("class_id");
                String email = resultSet.getString("email");
                Student student = new Student(id, name, gender, birthday, point, account, classId, email);
                studentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public boolean add(Student student) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_STUDENT);
            ps.setString(1, student.getName()); // set theo kiểu dữ liệu của DB
            ps.setDate(2, Date.valueOf(student.getBirthday()));
            ps.setBoolean(3, student.isGender());
            ps.setInt(4, student.getPoint());
            ps.setString(5, student.getAccount());
            ps.setInt(6, student.getClassId());
            ps.setString(7, student.getEmail());
            int effectRow = ps.executeUpdate(); // trả về số hàng bị thay đổi
            if(effectRow > 0) {
                return true;
            }
//            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
