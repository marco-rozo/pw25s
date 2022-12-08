package br.edu.utfpr.pb.pw25s.serverproject.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ReceiptsDto {
    
    @NotNull
    private Double valueReceipts;

    @NotNull
    private Double valueReceived;

    @NotNull
    private Integer numReceipts;

}
