package br.edu.utfpr.pb.pw25s.serverproject.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotNull
    @ManyToOne()
    @JoinColumn(name = "user_id")
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
