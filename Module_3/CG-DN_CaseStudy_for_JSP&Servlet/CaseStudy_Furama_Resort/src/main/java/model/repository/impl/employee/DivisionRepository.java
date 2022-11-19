package model.repository.impl.employee;

import model.bean.Division;
import model.repository.BaseRepository;
import model.repository.iemployee.IDivisionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements IDivisionRepository {
    private static final String SELECT_ALL_DIVISION = "select * from division;";

    @Override
    public List<Division> selectAllDivision() {
        List<Division> divisionList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DIVISION)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("division_id");
                String name = resultSet.getString("division_name");
                divisionList.add(new Division(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return divisionList;
    }
}
