public class Motorista extends Pessoa {
    private static String hab;
    public Motorista(String nomeComp, String email, String cpf, String telefone, double salario, String hab) {
        super(nomeComp, email, cpf, telefone, salario);
        this.hab = hab;
    }

    @Override
    public String toString() {
        return "Motorista:\n" +
                "Nome = " + getNomeComp() + '\n' +
                "CPF = " + getCpf() + '\n' +
                "Email = " + getEmail() + '\n' +
                "Telefone = " + getTelefone() + '\n' +
                "Salário =" + getSalario() + '\n' +
                "Habilitação = " + getHab() + '\n';
    }

    public String getHab() {
        return hab;
    }

    public void setHab(String hab) {
        this.hab = hab;
    }
}
