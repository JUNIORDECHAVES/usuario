package com.junior.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // gera todos os metodo getters dos atributos.
@Setter // gera todos os metodo setters dos atributos.
@AllArgsConstructor // um construtor com todos os argumentos/atributos.
@NoArgsConstructor // um construtor sem argumentos/atributos.
@Entity // para aponta ao spring que essa clase é uma tabela do banco de dados.
@Table(name = "endereco") // indica o nome da tabela utilizando o atributo name,
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rua")
    private String rua;
    @Column(name = "numero")
    private long numero;
    @Column(name = "complemento", length = 20)
    private String complemento;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado", length = 2)
    private String estado;
    @Column(name = "cep", length = 9)
    private String cep;

}
