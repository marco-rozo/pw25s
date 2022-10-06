package br.edu.utfpr.pb.pw25s.serverproject.service;

import br.edu.utfpr.pb.pw25s.serverproject.dto.MovementDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.Response.MovementResponseDto;
import br.edu.utfpr.pb.pw25s.serverproject.model.Movement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovementService {

    MovementResponseDto save(MovementDto movementDto);

    Movement findOne(Long id);

    List<Movement> findAll();

    Page<Movement> findAll(Pageable pageable);

    Long count();

    Boolean exists(Long id);

    void delete(Long id);
}
