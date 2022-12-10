package br.edu.utfpr.pb.pw25s.serverproject.repository;

import br.edu.utfpr.pb.pw25s.serverproject.model.Account;
import br.edu.utfpr.pb.pw25s.serverproject.model.Category;
import br.edu.utfpr.pb.pw25s.serverproject.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {
    void deleteMovementByCategory(Category category);
    List<Movement> findAllByAccount(Account account);
    List<Movement> findAllByCategory(Category Category);
}
