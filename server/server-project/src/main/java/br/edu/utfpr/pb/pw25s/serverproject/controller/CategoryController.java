package br.edu.utfpr.pb.pw25s.serverproject.controller;

import br.edu.utfpr.pb.pw25s.serverproject.dto.CategoryDto;
import br.edu.utfpr.pb.pw25s.serverproject.model.Category;
import br.edu.utfpr.pb.pw25s.serverproject.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
        this.modelMapper = new ModelMapper();
    }

    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody @Valid CategoryDto categoryDto) {
        Category category = categoryService.save(
                convertDtoToEntity(categoryDto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(location).body(convertEntityToDto(category));
    }

    private Category convertDtoToEntity(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }

    private CategoryDto convertEntityToDto(Category Category) {
        return modelMapper.map(Category, CategoryDto.class);
    }


}
