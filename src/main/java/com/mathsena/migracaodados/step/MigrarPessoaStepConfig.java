package com.mathsena.migracaodados.step;

import com.mathsena.migracaodados.dominio.Pessoa;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MigrarPessoaStepConfig {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;


    public Step migrarPessoaStep(
            ItemReader<Pessoa> arquivoPessoaReader,
            ItemWriter<Pessoa> bancoPessoaWriter    ){

        return stepBuilderFactory
                .get("migrarPessoaStep")
                .<Pessoa, Pessoa> chunk(1)
                .reader(arquivoPessoaReader)
                .writer(bancoPessoaWriter)
                .build();

    }
}
