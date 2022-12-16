package com.mathsena.migracaodados.dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.util.Strings;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Pessoa {

    private int id;
    private String nome;
    private String email;
    private Date dataNascimento;
    private int idade;

    public boolean isValida() {
        return !Strings.isBlank(nome) &&!Strings.isBlank(email) && dataNascimento != null;
    }
}
