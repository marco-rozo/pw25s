package br.edu.utfpr.pb.pw25s.serverproject.service.impl;

import br.edu.utfpr.pb.pw25s.serverproject.dto.MovementDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.Response.MovementResponseDto;
import br.edu.utfpr.pb.pw25s.serverproject.model.Account;
import br.edu.utfpr.pb.pw25s.serverproject.model.Category;
import br.edu.utfpr.pb.pw25s.serverproject.model.Movement;
import br.edu.utfpr.pb.pw25s.serverproject.model.User;
import br.edu.utfpr.pb.pw25s.serverproject.repository.AccountRepository;
import br.edu.utfpr.pb.pw25s.serverproject.repository.CategoryRepository;
import br.edu.utfpr.pb.pw25s.serverproject.repository.MovementRepository;
import br.edu.utfpr.pb.pw25s.serverproject.repository.UserRepository;
import br.edu.utfpr.pb.pw25s.serverproject.service.MovementService;
import br.edu.utfpr.pb.pw25s.serverproject.shared.SecurityContextShared;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovementServiceImpl implements MovementService {
    private final MovementRepository movementRepository;
    private final AccountRepository accountRepository;
    private final CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    private final UserRepository userRepository;
    private final SecurityContextShared securityContextShared;


    public MovementServiceImpl(MovementRepository movementRepository, CategoryRepository categoryRepository,
                               AccountRepository accountRepository, ModelMapper modelMapper, SecurityContextShared securityContextShared, UserRepository userRepository) {
        this.movementRepository = movementRepository;
        this.categoryRepository = categoryRepository;
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
        this.securityContextShared = securityContextShared;
        this.userRepository = userRepository;
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
        Object principal = securityContextShared.getPincipal();

        User u = userRepository.findByEmail(principal.toString());

        List<Account> accounts = accountRepository.findAccountsByUser(u);
        List<Movement> movements = new ArrayList<Movement>();

        if (accounts.size() > 0){
            for(Account account : accounts){
                System.out.println(account.getName());
                System.out.println(account.getName());
                List<Movement> m = movementRepository.findAllByAccount(account);
                movements.addAll(m);
            }
        }
        System.out.println(movements);

        return movements.stream()
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
