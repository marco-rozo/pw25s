package br.edu.utfpr.pb.pw25s.serverproject.model;

import br.edu.utfpr.pb.pw25s.serverproject.validation.UniqueUserEmail;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity(name = "tb_user")
public class User {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String firtName;

    @NotNull
    private String lastName;

    @NotNull
    @UniqueUserEmail
    @NotNull(message = "{br.edu.utfpr.pb.pw25s.useremail}")
    private String email;

    @NotNull
    @Size(min = 4, max = 255)
    private String password;

    @NotNull
    private String individualRegistration;

    @NotNull
    private String phone;

}
