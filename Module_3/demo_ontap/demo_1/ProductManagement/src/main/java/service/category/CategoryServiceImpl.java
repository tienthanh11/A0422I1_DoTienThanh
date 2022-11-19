package service.category;

import model.Category;
import repository.category.CategoryRepositoryImpl;
import repository.category.ICategoryRepository;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    ICategoryRepository categoryRepository = new CategoryRepositoryImpl();

    @Override
    public List<Category> selectAllCategory() {
        return categoryRepository.selectAllCategory();
    }
}
