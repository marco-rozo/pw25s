package br.edu.utfpr.pb.pw25s.serverproject.service.impl;

import br.edu.utfpr.pb.pw25s.serverproject.dto.AccountDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.Response.AccountResponseDto;
import br.edu.utfpr.pb.pw25s.serverproject.model.Account;
import br.edu.utfpr.pb.pw25s.serverproject.model.User;
import br.edu.utfpr.pb.pw25s.serverproject.repository.AccountRepository;
import br.edu.utfpr.pb.pw25s.serverproject.repository.UserRepository;
import br.edu.utfpr.pb.pw25s.serverproject.service.AccountService;
import br.edu.utfpr.pb.pw25s.serverproject.shared.SecurityContextShared;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    private final SecurityContextShared securityContextShared;
    private ModelMapper modelMapper;

    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository, SecurityContextShared securityContextShared) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.securityContextShared = securityContextShared;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public AccountResponseDto save(AccountDto accountDto) {
        Object principal = securityContextShared.getPincipal();

        User u = userRepository.findByEmail(principal.toString());
        accountDto.setUser(u);
        Account account = convertDtoToEntity(accountDto);

        return convertEntityToDto(accountRepository.save(account));
    }

    @Override
    public AccountResponseDto findOne(Long id) {
        return convertEntityToDto(accountRepository.findById(id).orElse(null));
    }

    @Override
    public List<AccountResponseDto> findAll() {
        return accountRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Boolean exists(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }


    private Account convertDtoToEntity(AccountDto accountDto) {
        return modelMapper.map(accountDto, Account.class);
    }

    private AccountResponseDto convertEntityToDto(Account account) {
        return modelMapper.map(account, AccountResponseDto.class);
    }
}
