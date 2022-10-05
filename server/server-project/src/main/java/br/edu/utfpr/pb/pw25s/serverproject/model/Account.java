package br.edu.utfpr.pb.pw25s.serverproject.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue
    private long id;

//    @NotNull
    @ManyToOne()
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

    private String description;

}
