package ProducAcademica;

import java.util.ArrayList;

public class Publicacao {
    private ArrayList autor = new ArrayList<>();
    private String titulo;
    private String Conferencia;
    private int anoPubli;
    private String projAss;

    public void Publicacao(String titulo, String conferencia, int anoPubli, String projAss) {
        this.titulo = titulo;
        this.Conferencia = conferencia;
        this.anoPubli = anoPubli;
        this.projAss = projAss;
    }

    @Override
    public String toString() {
        return "Publicacao:" +
                "\nTitulo = " + titulo +
                "\nConferencia = " + Conferencia +
                "\nAno da Publicação = " + anoPubli +
                "\nProjeto Associado = " + projAss ;
    }

    public int getAnoPubli() {
        return anoPubli;
    }

}
