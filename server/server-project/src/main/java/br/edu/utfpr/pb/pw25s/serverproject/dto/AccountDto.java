package br.edu.utfpr.pb.pw25s.serverproject.dto;

import br.edu.utfpr.pb.pw25s.serverproject.model.User;
import lombok.Data;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class AccountDto {
    @NotNull
    private long userId;

    @Null
    private User user;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private Integer number;

    @NotNull
    private String agence;

    private String description;

}
