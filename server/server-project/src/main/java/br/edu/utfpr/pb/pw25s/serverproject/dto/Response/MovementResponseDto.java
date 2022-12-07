package br.edu.utfpr.pb.pw25s.serverproject.dto.Response;

import br.edu.utfpr.pb.pw25s.serverproject.dto.CategoryDto;
import br.edu.utfpr.pb.pw25s.serverproject.model.Account;
import br.edu.utfpr.pb.pw25s.serverproject.model.Category;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class MovementResponseDto {
    private Long id;

    @NotNull
    private Long accountId;

    @NotNull
    private Double value;

    @NotNull
    private Double amountPaid;

    private String description;

    @NotNull
    private String type;

    private LocalDateTime dtPayment;

    private LocalDateTime dtDue;

    private CategoryDto category;

    private AccountResponseDto account;

}
