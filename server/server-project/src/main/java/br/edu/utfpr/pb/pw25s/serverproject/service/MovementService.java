package br.edu.utfpr.pb.pw25s.serverproject.service;

import br.edu.utfpr.pb.pw25s.serverproject.model.Movement;
import br.edu.utfpr.pb.pw25s.serverproject.repository.MovementRepository;
import org.springframework.stereotype.Service;

@Service
public class MovementService {
    private final MovementRepository movementRepository;

    public MovementService(MovementRepository movementRepository) {

        this.movementRepository = movementRepository;
    }

    public Movement save(Movement movement) {
        return movementRepository.save(movement);
    }

}
