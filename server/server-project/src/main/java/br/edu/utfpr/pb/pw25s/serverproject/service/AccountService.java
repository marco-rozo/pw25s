package br.edu.utfpr.pb.pw25s.serverproject.service;

import br.edu.utfpr.pb.pw25s.serverproject.dto.AccountDto;
import br.edu.utfpr.pb.pw25s.serverproject.model.Account;
import br.edu.utfpr.pb.pw25s.serverproject.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountService {

    Account save(AccountDto accountDto);

    Account findOne(Long id);

    List<Account> findAll();

    Page<Account> findAll(Pageable pageable);

    Long count();

    Boolean exists(Long id);

    void delete(Long id);
}
