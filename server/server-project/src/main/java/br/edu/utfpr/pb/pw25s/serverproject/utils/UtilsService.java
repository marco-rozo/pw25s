package br.edu.utfpr.pb.pw25s.serverproject.utils;

import br.edu.utfpr.pb.pw25s.serverproject.model.User;
import br.edu.utfpr.pb.pw25s.serverproject.repository.UserRepository;

import java.util.Optional;

public interface UtilsService {

    public User findUserById(Long userId);
}
