package br.edu.utfpr.pb.pw25s.serverproject.repository;

import br.edu.utfpr.pb.pw25s.serverproject.model.Count;
import br.edu.utfpr.pb.pw25s.serverproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountRepository extends JpaRepository<Count, Long> {
}
