package com.algaworks.algafood.domain.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class VendaDiaria {

    private Date date;
    private Long totalVendas;
    private BigDecimal totalFaturado;

    public VendaDiaria(java.sql.Date date, Long totalVendas, BigDecimal totalFaturado) {
        this.date = new Date(date.getTime());
        this.totalVendas = totalVendas;
        this.totalFaturado = totalFaturado;
    }
}
