package br.com.estudosjava.apirest.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Getter // Cria todos os Getters;
// @Setter // Cria todos os Setters;
// @EqualsAndHashCode // Gera o Equals e Rashcode;

@Data // Com o @Data ele gera todas as demais anotations acima em uma unica anotation;

@AllArgsConstructor // Cria um constructor com todos os valores da classe;
@NoArgsConstructor // Cria um constructor sem parametros;
@Entity(name="tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;
}
