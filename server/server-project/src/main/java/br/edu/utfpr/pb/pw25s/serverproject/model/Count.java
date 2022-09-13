package br.edu.utfpr.pb.pw25s.serverproject.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
public class Count {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private Integer number;

    @NotNull
    private String agence;

    @NotNull
    private String description;

    @NotNull
    private String individualRegistration;

    @NotNull
    private String phone;

}
