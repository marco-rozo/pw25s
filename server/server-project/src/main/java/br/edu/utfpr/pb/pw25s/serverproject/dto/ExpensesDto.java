package br.edu.utfpr.pb.pw25s.serverproject.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ExpensesDto {

    @NotNull
    private Double valueExpenses;

    @NotNull
    private Double valuePaid;

    @NotNull
    private Integer numExpenses;

}
