package dev.emir.e_commerce.business.concretes;

import dev.emir.e_commerce.business.abstracts.ICategoryService;
import dev.emir.e_commerce.dao.CategoryRepo;
import dev.emir.e_commerce.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager implements ICategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryManager(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }
}
