package com.junior.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter // gera todos os metodo getters dos atributos.
@Setter // gera todos os metodo setters dos atributos.
@AllArgsConstructor // um construtor com todos os argumentos/atributos.
@NoArgsConstructor // um construtor sem argumentos/atributos.
@Entity // para aponta ao spring que essa clase é uma tabela do banco de dados.
@Table(name = "usuario") // indica o nome da tabela utilizando o atributo name,
// caso não utilize ele sempre utiliza-rá o nome da clase, porém é ideal que utilize um nome.
public class Usuario implements UserDetails {

    @Id //diz que é um id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera automaticamente o id
    private Long id;
    @Column(name = "nome", length = 100) // identifica o nome da coluna entre outras coisas.
    // como se ele é unico(unique) e seu tamanho(lenght)
    private String nome;
    @Column(name = "email", length = 200)
    private String email;
    @Column(name = "senha")
    private String senha;

    @OneToMany(cascade = CascadeType.ALL) // relacionamento de 1 para muitos, e toda vez que o dado é apagado
    // com o relacionamento o dado é apagdo evitando erro ao tentar apagar
    @JoinColumn(name = "usuario_id", referencedColumnName = "id") // definir a coluna de chave estrangeira
    private List<Endereco> enderecos;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Telefone> telefones;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of();
    }

    @Override
    public @Nullable String getPassword() {

        return senha;
    }

    @Override
    public String getUsername() {

        return email;
    }
}
