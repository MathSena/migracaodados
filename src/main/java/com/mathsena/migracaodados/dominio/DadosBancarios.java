package com.mathsena.migracaodados.dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DadosBancarios {

    private int id;
    private int pessoaIs;
    private int agencia;
    private int conta;
    private int banco;

}
