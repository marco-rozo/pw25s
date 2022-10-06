package br.edu.utfpr.pb.pw25s.serverproject.dto.Response;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class UserResponseDto {
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String individualRegistration;

    @NotNull
    private String phone;

}
