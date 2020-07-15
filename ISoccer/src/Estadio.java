public class Estadio {
    private boolean disp = false;
    private String nome;
    private int totTorc, banheiro, lanche;

    public Estadio(String nome, int totTorc, int banheiro, int lanche) {
        this.nome = nome;
        this.totTorc = totTorc;
        this.banheiro = banheiro;
        this.lanche = lanche;
    }

    @Override
    public String toString() {
        String dispo;
        if (disp) {
            dispo = "Disponível";
        } else {
            dispo = "Indisponível";
        }
        return "Estadio:\n" +
                "Nome = " + nome + '\n' +
                "Status = " + dispo + '\n' +
                "Total de Torcedores = " + totTorc + '\n' +
                "Total de banheiros = " + banheiro + '\n' +
                "Total de lanchonetes = " + lanche;
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

    public int getTotTorc() {
        return totTorc;
    }

    public void setTotTorc(int totTorc) {
        this.totTorc = totTorc;
    }

    public int getBanheiro() {
        return banheiro;
    }

    public void setBanheiro(int banheiro) {
        this.banheiro = banheiro;
    }

    public int getLanche() {
        return lanche;
    }

    public void setLanche(int lanche) {
        this.lanche = lanche;
    }
}
