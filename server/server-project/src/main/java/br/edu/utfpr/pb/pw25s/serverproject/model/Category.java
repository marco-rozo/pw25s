package br.edu.utfpr.pb.pw25s.serverproject.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    private String name;

    private String description;

}
