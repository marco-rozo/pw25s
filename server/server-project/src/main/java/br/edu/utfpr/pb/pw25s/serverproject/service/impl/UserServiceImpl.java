package br.edu.utfpr.pb.pw25s.serverproject.service.impl;

import br.edu.utfpr.pb.pw25s.serverproject.dto.CategoryDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.Response.UserResponseDto;
import br.edu.utfpr.pb.pw25s.serverproject.dto.UserDto;
import br.edu.utfpr.pb.pw25s.serverproject.model.Category;
import br.edu.utfpr.pb.pw25s.serverproject.model.User;
import br.edu.utfpr.pb.pw25s.serverproject.repository.UserRepository;
import br.edu.utfpr.pb.pw25s.serverproject.service.AccountService;
import br.edu.utfpr.pb.pw25s.serverproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {

        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserResponseDto save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return convertEntityToDto(userRepository.save(user));
    }


    @Override
    public Boolean exists(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }

    private User convertDtoToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    private UserResponseDto convertEntityToDto(User user) {
        return modelMapper.map(user, UserResponseDto.class);
    }

}
