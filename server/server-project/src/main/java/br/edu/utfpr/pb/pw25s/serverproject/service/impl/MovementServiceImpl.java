package br.edu.utfpr.pb.pw25s.serverproject.service.impl;

import br.edu.utfpr.pb.pw25s.serverproject.dto.MovementDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.Response.MovementResponseDto;
import br.edu.utfpr.pb.pw25s.serverproject.model.Account;
import br.edu.utfpr.pb.pw25s.serverproject.model.Category;
import br.edu.utfpr.pb.pw25s.serverproject.model.Movement;
import br.edu.utfpr.pb.pw25s.serverproject.repository.AccountRepository;
import br.edu.utfpr.pb.pw25s.serverproject.repository.CategoryRepository;
import br.edu.utfpr.pb.pw25s.serverproject.repository.MovementRepository;
import br.edu.utfpr.pb.pw25s.serverproject.service.MovementService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovementServiceImpl implements MovementService {
    private final MovementRepository movementRepository;
    private final AccountRepository accountRepository;
    private final CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    public MovementServiceImpl(MovementRepository movementRepository, CategoryRepository categoryRepository, AccountRepository accountRepository, ModelMapper modelMapper) {
        this.movementRepository = movementRepository;
        this.categoryRepository = categoryRepository;
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MovementResponseDto save(MovementDto movementDto) {

        Account account = accountRepository.findById(movementDto.getAccountId()).orElse(null);
        Category category = categoryRepository.findById(movementDto.getCategoryId()).orElse(null);

        movementDto.setAccount(account);
        movementDto.setCategory(category);
        movementDto.setDtDue(LocalDateTime.now());

        Movement Movement = convertDtoToEntity(movementDto);

        return convertEntityToDto(movementRepository.save(Movement));
    }

    @Override
    public MovementResponseDto findOne(Long id) {
        return convertEntityToDto(movementRepository.findById(id).orElse(null));
    }

    @Override
    public List<MovementResponseDto> findAll() {
        return movementRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Page<Movement> findAll(Pageable pageable) {
        return movementRepository.findAll(pageable);
    }

    @Override
    public Long count() {
        return movementRepository.count();
    }

    @Override
    public Boolean exists(Long id) {
        return movementRepository.existsById(id);
    }

    @Override
    public void delete(Long id) {
        movementRepository.deleteById(id);
    }

    private Movement convertDtoToEntity(MovementDto MovementDto) {
        return modelMapper.map(MovementDto, Movement.class);
    }

    private MovementResponseDto convertEntityToDto(Movement Movement) {

        return modelMapper.map(Movement, MovementResponseDto.class);
    }

}
