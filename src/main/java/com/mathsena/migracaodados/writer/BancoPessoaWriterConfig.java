package com.mathsena.migracaodados.writer;

import com.mathsena.migracaodados.dominio.Pessoa;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Configuration
public class BancoPessoaWriterConfig {

    @Bean
    public JdbcBatchItemWriter<Pessoa> bancoPessoaWriter(
            @Qualifier("appDataSource")DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<Pessoa>()
                .dataSource(dataSource)
                .sql("INSERT INTO pessoa(id, nome, email, data_nascimento, idade) values (?,?,?,?,?)")
                .itemPreparedStatementSetter(itemPreparedStatementSetter())
                .build();
    }

    private ItemPreparedStatementSetter<Pessoa> itemPreparedStatementSetter() {
        return new ItemPreparedStatementSetter<Pessoa>() {
            @Override
            public void setValues(Pessoa pessoa, PreparedStatement ps) throws SQLException {
                ps.setInt(1, pessoa.getId());
                ps.setString(2, pessoa.getNome());
                ps.setString(3, pessoa.getEmail());
                ps.setDate(4, new Date(pessoa.getDataNascimento().getTime()));
                ps.setInt(5, pessoa.getIdade());
            }
        };
    }


}
