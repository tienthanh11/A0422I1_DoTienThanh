package model.repository.impl.employee;

import model.bean.Position;
import model.repository.BaseRepository;
import model.repository.iemployee.IPositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository implements IPositionRepository {
    private static final String SELECT_ALL_POSITION = "select * from `position`;";

    @Override
    public List<Position> selectAllPosition() {
        List<Position> positionList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSITION)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("position_id");
                String name = resultSet.getString("position_name");
                positionList.add(new Position(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return positionList;
    }
}
