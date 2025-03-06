package entidade;
public class Medico {
    private int id;
    private String nome;
    private int matricula;
    private String especialidade;
    private float salario;

    public Medico(int id, String nome, int matricula, String especialidade, float salario) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.especialidade = especialidade;
        this.salario = salario;
    }
    public Medico() {
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

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
