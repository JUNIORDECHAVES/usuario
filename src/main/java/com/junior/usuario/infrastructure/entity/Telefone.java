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
@Table(name = "telefone ") // indica o nome da tabela utilizando o atributo name,
// caso não utilize ele sempre utiliza-rá o nome da clase, porém é ideal que utilize um nome.
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero", length = 10)
    private String numero;
    @Column(name = "ddd", length = 3)
    private String ddd;
}
