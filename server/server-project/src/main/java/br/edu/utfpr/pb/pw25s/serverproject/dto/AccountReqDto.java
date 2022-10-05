package br.edu.utfpr.pb.pw25s.serverproject.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
public class AccountReqDto {

    @NotNull
    private long user;

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
