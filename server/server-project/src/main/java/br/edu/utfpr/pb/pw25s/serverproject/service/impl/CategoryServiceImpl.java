package br.edu.utfpr.pb.pw25s.serverproject.service.impl;

import br.edu.utfpr.pb.pw25s.serverproject.dto.CategoryDto;
import br.edu.utfpr.pb.pw25s.serverproject.model.Category;
import br.edu.utfpr.pb.pw25s.serverproject.repository.CategoryRepository;
import br.edu.utfpr.pb.pw25s.serverproject.repository.MovementRepository;
import br.edu.utfpr.pb.pw25s.serverproject.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final MovementRepository movementRepository;
    private ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, MovementRepository movementRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.movementRepository = movementRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {

        Category category = convertDtoToEntity(categoryDto);
        return convertEntityToDto(categoryRepository.save(category));
    }

    @Override
    public CategoryDto findOne(Long id) {
        return convertEntityToDto(categoryRepository.findById(id).orElse(null));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Long count() {
        return categoryRepository.count();
    }

    @Override
    public Boolean exists(Long id) {
        return categoryRepository.existsById(id);
    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);

        movementRepository.deleteMovementByCategory(category);
        categoryRepository.deleteById(id);
    }

    private Category convertDtoToEntity(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }

    private CategoryDto convertEntityToDto(Category Category) {
        return modelMapper.map(Category, CategoryDto.class);
    }

}
