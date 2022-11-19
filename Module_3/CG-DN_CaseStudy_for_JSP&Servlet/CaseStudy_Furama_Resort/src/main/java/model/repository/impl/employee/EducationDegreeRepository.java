package model.repository.impl.employee;

import model.bean.EducationDegree;
import model.repository.BaseRepository;
import model.repository.iemployee.IEducationDegreeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository implements IEducationDegreeRepository {
    private static final String SELECT_ALL_EDUCATION_DEGREE = "select * from education_degree;";

    @Override
    public List<EducationDegree> selectAllEducationDegree() {
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EDUCATION_DEGREE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("education_degree_id");
                String name = resultSet.getString("education_degree_name");
                educationDegreeList.add(new EducationDegree(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return educationDegreeList;
    }
}
