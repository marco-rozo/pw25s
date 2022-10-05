package br.edu.utfpr.pb.pw25s.serverproject.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "account_id")
    private Account account;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @NotNull
    private Double value;

    @NotNull
    private Double amountPaid;

    @NotNull
    private String description;

    @NotNull
    private String type;

    private LocalDateTime dtPayment;

    @NotNull
    private LocalDateTime dtDue;

}
