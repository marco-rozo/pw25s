package br.edu.utfpr.pb.pw25s.serverproject.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class DashboardDto {

    @NotNull
    private Double valueTotalReceipts;

    @NotNull
    private Double valueTotalReceived;

    @NotNull
    private Double valueRemainingReceipts;

    @NotNull
    private Integer numReceipts;


    @NotNull
    private Double valueTotalExpenses;

    @NotNull
    private Double valueTotalExpensesPaid;

    @NotNull
    private Double valueRemainingExpenses;

    @NotNull
    private Integer numExpenses;


    @NotNull
    private Double balance;

}
