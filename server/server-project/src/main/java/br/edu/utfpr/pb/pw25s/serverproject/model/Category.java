package br.edu.utfpr.pb.pw25s.serverproject.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Data
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

    @NotNull
    private String description;

}
