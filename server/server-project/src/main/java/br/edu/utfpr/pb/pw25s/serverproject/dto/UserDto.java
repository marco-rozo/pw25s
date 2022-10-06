package br.edu.utfpr.pb.pw25s.serverproject.dto;

import br.edu.utfpr.pb.pw25s.serverproject.model.User;
import br.edu.utfpr.pb.pw25s.serverproject.validation.UniqueEmail;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserDto {
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    @Size(min = 4, max = 254)
    private String password;

    @NotNull
    private String individualRegistration;

    @NotNull
    private String phone;

}
