package br.edu.utfpr.pb.pw25s.serverproject.dto;

import br.edu.utfpr.pb.pw25s.serverproject.model.User;
import lombok.Data;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
public class AccountDto {
    private Long id;

    private User user;

    @NotNull
    @Size(min = 1, max = 254)
    private String name;

    @NotNull
    private String type;

    private Integer number;

    private String agence;

    private String description;

}
