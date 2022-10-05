package br.edu.utfpr.pb.pw25s.serverproject.service.impl;

import br.edu.utfpr.pb.pw25s.serverproject.dto.AccountDto;
import br.edu.utfpr.pb.pw25s.serverproject.model.Account;
import br.edu.utfpr.pb.pw25s.serverproject.repository.AccountRepository;
import br.edu.utfpr.pb.pw25s.serverproject.repository.CategoryRepository;
import br.edu.utfpr.pb.pw25s.serverproject.service.AccountService;
import br.edu.utfpr.pb.pw25s.serverproject.utils.UtilsService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UtilsService utilsService;
    private ModelMapper modelMapper;

    public AccountServiceImpl(AccountRepository accountRepository, UtilsService utilsService) {
        this.accountRepository = accountRepository;
        this.utilsService = utilsService;
        this.modelMapper =  new ModelMapper();
    }
    @Override
    public Account save(AccountDto accountDto) {
        Account account = convertDtoToEntity(accountDto);
        account.setUser(utilsService.findUserById(accountDto.getUserId()));

        accountRepository.save(account);

        return null;
    }

    @Override
    public Account findOne(Long id) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return null;
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

    }


    private Account convertDtoToEntity(AccountDto accountDto) {
        return modelMapper.map(accountDto, Account.class);
    }

    private AccountDto convertEntityToDto(Account account) {
        return modelMapper.map(account, AccountDto.class);
    }
}
