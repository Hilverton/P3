public class Socio extends Pessoa {
    private String tipo;
    private boolean adimp;
    public Socio(String nomeComp, String email, String cpf, String telefone, double salario, String tipo) {
        super(nomeComp, email, cpf, telefone, salario);
        this.tipo = tipo;
        this.adimp = true;
        FuncControle.setQtdAdimp(FuncControle.getQtdAdimp()+1);
    }

    @Override
    public String toString() {
        String pag;
        if (adimp) {
            pag = "Adimplente";
        }else {
            pag = "Inadimplente";
        }
        return "Socio:\n" +
                "Nome = " + getNomeComp() + '\n' +
                "CPF = " + getCpf() + '\n' +
                "Email = " + getEmail() + '\n' +
                "Telefone = " + getTelefone() + '\n' +
                "Salário =" + getSalario() + '\n' +
                "Tipo = " + getTipo() + '\n' +
                 "Status = " + pag + '\n';
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isAdimp() {
        return adimp;
    }

    public void setAdimp(boolean adimp) {
        this.adimp = adimp;
    }
}
