package br.edu.utfpr.pb.pw25s.serverproject.repository;

import br.edu.utfpr.pb.pw25s.serverproject.model.Account;
import br.edu.utfpr.pb.pw25s.serverproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAccountsByUser(User user);
}
