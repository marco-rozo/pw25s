package br.edu.utfpr.pb.pw25s.serverproject.controller;

import br.edu.utfpr.pb.pw25s.serverproject.model.Count;
import br.edu.utfpr.pb.pw25s.serverproject.model.User;
import br.edu.utfpr.pb.pw25s.serverproject.service.CountService;
import br.edu.utfpr.pb.pw25s.serverproject.service.UserService;
import br.edu.utfpr.pb.pw25s.serverproject.utils.GenericResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("count")
public class CountController {
    private final CountService countService;

    public CountController(CountService countService) {
        this.countService = countService;
    }

    @PostMapping
    GenericResponse createCount(@RequestBody @Valid Count c) {
        countService.save(c);
        return new GenericResponse("Registro salvo");
    }

}
