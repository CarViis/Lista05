package entidade;

public class Paciente {
    private int id;
    private String nome;
    private String cpf;
    private String doenca;

    public Paciente(int id, String nome, String cpf, String doenca) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.doenca = doenca;
    }
    public Paciente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }
}
