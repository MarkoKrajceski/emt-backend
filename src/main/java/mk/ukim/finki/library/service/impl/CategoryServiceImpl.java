package mk.ukim.finki.library.service.impl;

import mk.ukim.finki.library.model.Category;
import mk.ukim.finki.library.repository.CategoryRepository;
import mk.ukim.finki.library.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }
}
