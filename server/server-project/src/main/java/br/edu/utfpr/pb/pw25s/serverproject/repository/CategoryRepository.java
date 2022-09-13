package br.edu.utfpr.pb.pw25s.serverproject.repository;

import br.edu.utfpr.pb.pw25s.serverproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
