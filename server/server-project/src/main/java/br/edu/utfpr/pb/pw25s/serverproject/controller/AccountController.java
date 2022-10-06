package br.edu.utfpr.pb.pw25s.serverproject.controller;

import br.edu.utfpr.pb.pw25s.serverproject.dto.AccountDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.CategoryDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.Response.AccountResponseDto;
import br.edu.utfpr.pb.pw25s.serverproject.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountResponseDto> save(@RequestBody @Valid AccountDto accountDto) {
        AccountResponseDto account = accountService.save(accountDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId()).toUri();

        return ResponseEntity.created(location).body(account);
    }

    @GetMapping("{id}") // http://localhost:8080/accounts/1
    public ResponseEntity<AccountResponseDto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.findOne(id));
    }

    @GetMapping
    public ResponseEntity<List<AccountResponseDto>> findAll() {
        return ResponseEntity.ok(
                accountService.findAll()
        );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        accountService.delete(id);
    }

    @PutMapping
    public ResponseEntity<AccountResponseDto> update(@RequestBody @Valid AccountDto accountDto) {
        AccountResponseDto account = accountService.save(accountDto);

        return ResponseEntity.ok(account);
    }

}
