package br.edu.utfpr.pb.pw25s.serverproject.utils.impl;

import br.edu.utfpr.pb.pw25s.serverproject.model.Category;
import br.edu.utfpr.pb.pw25s.serverproject.model.User;
import br.edu.utfpr.pb.pw25s.serverproject.repository.CategoryRepository;
import br.edu.utfpr.pb.pw25s.serverproject.repository.UserRepository;
import br.edu.utfpr.pb.pw25s.serverproject.service.CategoryService;
import br.edu.utfpr.pb.pw25s.serverproject.utils.UtilsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilServiceImpl implements UtilsService {
    private final UserRepository userRepository;

    public UtilServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
