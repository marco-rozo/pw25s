package br.edu.utfpr.pb.pw25s.serverproject.dto;

import br.edu.utfpr.pb.pw25s.serverproject.model.Account;
import br.edu.utfpr.pb.pw25s.serverproject.model.Category;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class MovementDto {

    private Long id;

    private Account account;

    private Category category;

    @NotNull
    private Long accountId;

    @NotNull
    private Long categoryId;

    @NotNull
    private Double value;

    @NotNull
    private Double amountPaid;

    private String description;

    @NotNull
    private String type;

    private LocalDateTime dtPayment;

    private LocalDateTime dtDue;

}
