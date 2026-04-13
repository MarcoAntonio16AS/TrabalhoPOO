package br.edu.agendacrudmysql.model;

/**
 * MODEL: representa a entidade do domínio (tabela contatos). Encapsulamento:
 * atributos privados + getters/setters.
 */
public class Contato {

    private Integer id; // Integer permite null antes de inserir no BD
    private String nome;
    private String email;
    private String telefone;

    public Contato() {
    }

    public Contato(Integer id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Contato(String nome, String email, String telefone) {
        this(null, nome, email, telefone);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Contato{"
                + "id=" + id
                + ", nome='" + nome + '\''
                + ", email='" + email + '\''
                + ", telefone='" + telefone + '\''
                + '}';
    }
}
