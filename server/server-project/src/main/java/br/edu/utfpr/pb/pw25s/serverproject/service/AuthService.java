package br.edu.utfpr.pb.pw25s.serverproject.service;

import br.edu.utfpr.pb.pw25s.serverproject.model.User;
import br.edu.utfpr.pb.pw25s.serverproject.shared.SecurityContextShared;

import br.edu.utfpr.pb.pw25s.serverproject.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;
    private final SecurityContextShared securityContextShared;


    public AuthService(UserRepository userRepository, SecurityContextShared securityContextShared) {
        this.userRepository = userRepository;
        this.securityContextShared = securityContextShared;
    }

    public boolean indetifyUser() throws UsernameNotFoundException {
        Object principal = securityContextShared.getPincipal();

        if (principal != null) return true;

        throw new UsernameNotFoundException("Token invalido");
    }

    @Override //User nao possui Username, username = email
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
        return user;
    }

}
