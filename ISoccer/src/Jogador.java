public class Jogador extends Pessoa {
    private String tipo;
    private boolean apto;
    private boolean dMedico;
    public Jogador(String nomeComp, String email, String cpf, String telefone, double salario, String tipo) {
        super(nomeComp, email, cpf, telefone, salario);
        this.tipo = tipo;
        this.apto = true;
        this.dMedico = false;
    }

    @Override
    public String toString() {
        String apt, med;
        if (apto) {
            apt = "Sim";
        } else {
            apt = "Não";
        }
        if (dMedico) {
            med = "Sim";
        } else {
            med = "Não";
        }
        return "Jogador:" +
                "Nome = " + getNomeComp() + '\n' +
                "CPF = " + getCpf() + '\n' +
                "Email = " + getEmail() + '\n' +
                "Telefone = " + getTelefone() + '\n' +
                "Salário = " + getSalario() + '\n' +
                "Posição = " + tipo + '\n' +
                "Apto = " + apt + '\n' +
                "Departamento Medico = " + med + '\n';
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isApto() {
        return apto;
    }

    public void setApto(boolean apto) {
        this.apto = apto;
    }

    public boolean isdMedico() {
        return dMedico;
    }

    public void setdMedico(boolean dMedico) {
        this.dMedico = dMedico;
    }
}
