public class Onibus {
    private String ident;
    private boolean disp = false;
    private int totPass;

    public Onibus(String ident, int totPass) {
        this.ident = ident;
        this.totPass = totPass;
    }

    @Override
    public String toString() {
        String dispo;
        if (disp) {
            dispo = "Disponível";
        } else {
            dispo = "Indisponível";
        }
        return "Onibus:\n" +
                "Identificação = " + ident + '\n' +
                "Status = " + dispo + '\n' +
                "Total de Passageiros = " + totPass +
                '\n';
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public boolean isDisp() {
        return disp;
    }

    public void setDisp(boolean disp) {
        this.disp = disp;
    }

    public int getTotPass() {
        return totPass;
    }

    public void setTotPass(int totPass) {
        this.totPass = totPass;
    }
}
