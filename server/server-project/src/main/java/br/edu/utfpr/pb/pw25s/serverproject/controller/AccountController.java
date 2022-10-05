package br.edu.utfpr.pb.pw25s.serverproject.controller;

import br.edu.utfpr.pb.pw25s.serverproject.dto.AccountDto;
import br.edu.utfpr.pb.pw25s.serverproject.model.Account;
import br.edu.utfpr.pb.pw25s.serverproject.service.AccountService;
import br.edu.utfpr.pb.pw25s.serverproject.utils.GenericResponse;
import br.edu.utfpr.pb.pw25s.serverproject.utils.UtilsService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("accounts")
public class AccountController {
    private final AccountService accountService;
    private final ModelMapper modelMapper;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
        this.modelMapper = new ModelMapper();
    }

    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody @Valid AccountDto accountDto) {
        Account account = accountService.save(accountDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId()).toUri();

        return ResponseEntity.created(location).body(convertEntityToDto(account));
    }

    private Account convertDtoToEntity(AccountDto accountDto) {

        return modelMapper.map(accountDto, Account.class);
    }

    private AccountDto convertEntityToDto(Account account) {
        return modelMapper.map(account, AccountDto.class);
    }


}
