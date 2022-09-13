package br.edu.utfpr.pb.pw25s.serverproject.service;

import br.edu.utfpr.pb.pw25s.serverproject.model.Category;
import br.edu.utfpr.pb.pw25s.serverproject.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

}
