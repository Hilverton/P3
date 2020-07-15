public class Pessoa {
    private String nomeComp, email, cpf, telefone;
    private double salario;

    public Pessoa(String nomeComp, String email, String cpf, String telefone, double salario) {
        this.nomeComp = nomeComp;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Pessoa:\n" +
                "Nome = " + getNomeComp() + '\n' +
                "CPF = " + getCpf() + '\n' +
                "Email = " + getEmail() + '\n' +
                "Telefone = " + getTelefone() + '\n' +
                "Salário =" + getSalario() + '\n';
    }

    public String getNomeComp() {
        return nomeComp;
    }

    public void setNomeComp(String nomeComp) {
        this.nomeComp = nomeComp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
