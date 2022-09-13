package br.edu.utfpr.pb.pw25s.serverproject.repository;

import br.edu.utfpr.pb.pw25s.serverproject.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {
}
