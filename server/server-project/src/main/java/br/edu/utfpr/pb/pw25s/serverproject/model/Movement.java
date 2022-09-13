package br.edu.utfpr.pb.pw25s.serverproject.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class Movement {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @OneToOne()
    @JoinColumn(name = "count_id")
    private Count count;

//    @NotNull
//    @OneToOne()
//    @JoinColumn(name = "category_id")
//    private Category category;

    @NotNull
    private Double value;

    @NotNull
    private Double amountPaid;

    @NotNull
    private String description;

    @NotNull
    private String type;

    @NotNull
    private LocalDateTime dtPayment;

    @NotNull
    private LocalDateTime dtDue;

}
