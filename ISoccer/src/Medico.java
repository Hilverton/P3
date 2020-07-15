public class Medico extends Pessoa {
    private String crm;
    public Medico(String nomeComp, String email, String cpf, String telefone, double salario, String crm) {
        super(nomeComp, email, cpf, telefone, salario);
        this.crm = crm;
    }

    @Override
    public String toString() {
        return "Medico:\n" +
                "Nome = " + getNomeComp() + '\n' +
                "CPF = " + getCpf() + '\n' +
                "Email = " + getEmail() + '\n' +
                "Telefone = " + getTelefone() + '\n' +
                "Salário =" + getSalario() + '\n' +
                "CRM = " + getCrm() + '\n';
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}
