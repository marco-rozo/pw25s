package br.edu.utfpr.pb.pw25s.serverproject.controller;

import br.edu.utfpr.pb.pw25s.serverproject.dto.AccountDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.CategoryDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.Response.AccountResponseDto;
import br.edu.utfpr.pb.pw25s.serverproject.model.Category;
import br.edu.utfpr.pb.pw25s.serverproject.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody @Valid CategoryDto categoryDto) {
        CategoryDto category = categoryService.save(categoryDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(location).body(category);
    }


    @GetMapping("{id}") // http://localhost:8080/categories/1
    public ResponseEntity<CategoryDto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findOne(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        return ResponseEntity.ok(
                categoryService.findAll()
        );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }

    @PutMapping
    public ResponseEntity<CategoryDto> update(@RequestBody @Valid CategoryDto accountDto) {
        CategoryDto category = categoryService.save(accountDto);

        return ResponseEntity.ok(category);
    }
}
