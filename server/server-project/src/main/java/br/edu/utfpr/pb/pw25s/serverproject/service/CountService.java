package br.edu.utfpr.pb.pw25s.serverproject.service;

import br.edu.utfpr.pb.pw25s.serverproject.model.Count;
import br.edu.utfpr.pb.pw25s.serverproject.model.User;
import br.edu.utfpr.pb.pw25s.serverproject.repository.CountRepository;
import br.edu.utfpr.pb.pw25s.serverproject.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CountService {
    private final CountRepository countRepository;

    public CountService(CountRepository countRepository) {

        this.countRepository = countRepository;
    }

    public Count save(Count user) {
        return countRepository.save(user);
    }

}
