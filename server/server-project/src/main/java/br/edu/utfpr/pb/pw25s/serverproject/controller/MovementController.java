package br.edu.utfpr.pb.pw25s.serverproject.controller;

import br.edu.utfpr.pb.pw25s.serverproject.dto.AccountDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.MovementDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.Response.AccountResponseDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.Response.MovementResponseDto;
import br.edu.utfpr.pb.pw25s.serverproject.service.AccountService;
import br.edu.utfpr.pb.pw25s.serverproject.service.MovementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

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


}
