public class CT {
    private boolean disp = false;
    private String nome;
    private int quartos, banheiros;

    public CT(String nome, int quartos, int banheiros) {
        this.nome = nome;
        this.quartos = quartos;
        this.banheiros = banheiros;
    }

    @Override
    public String toString() {
        String dispo;
        if (disp) {
            dispo = "Disponível";
        } else {
            dispo = "Indisponível";
        }
        return "CT\n" +
                "Nome = " + nome + '\n' +
                "Status = " + dispo + '\n' +
                "Dormitórios = " + quartos + '\n' +
                "Banheiros = " + banheiros + '\n';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isDisp() {
        return disp;
    }

    public void setDisp(boolean disp) {
        this.disp = disp;
    }

    public int getQuartos() {
        return quartos;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public int getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(int banheiros) {
        this.banheiros = banheiros;
    }
}
