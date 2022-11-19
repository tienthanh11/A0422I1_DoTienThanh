package repository.category;

import model.Category;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements ICategoryRepository {
    private static final String SELECT_ALL_CATEGORY = "select * from category;";

    @Override
    public List<Category> selectAllCategory() {
        List<Category> categoryList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("category_id");
                String name = resultSet.getString("category_name");
                categoryList.add(new Category(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoryList;
    }
}
