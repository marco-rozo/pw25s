package br.edu.utfpr.pb.pw25s.serverproject.controller;

import br.edu.utfpr.pb.pw25s.serverproject.dto.AccountDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.CategoryDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.MovementDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.Response.AccountResponseDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.Response.MovementResponseDto;
import br.edu.utfpr.pb.pw25s.serverproject.service.AccountService;
import br.edu.utfpr.pb.pw25s.serverproject.service.MovementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("movimentation")
public class MovementController {
    private final MovementService movementService;

    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @PostMapping
    public ResponseEntity<MovementResponseDto> save(@RequestBody @Valid MovementDto movementDto) {
        MovementResponseDto mov = movementService.save(movementDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(mov.getId()).toUri();

        return ResponseEntity.created(location).body(mov);
    }

    @PutMapping
    public ResponseEntity<MovementResponseDto> update(@RequestBody @Valid MovementDto movementDto) {
        MovementResponseDto mov = movementService.save(movementDto);

        return ResponseEntity.ok(mov);
    }

    @GetMapping("{id}") // http://localhost:8080/movimentation/1
    public ResponseEntity<MovementResponseDto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(movementService.findOne(id));
    }

    @GetMapping
    public ResponseEntity<List<MovementResponseDto>> findAll() {
        return ResponseEntity.ok(
                movementService.findAll()
        );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        movementService.delete(id);
    }



}
