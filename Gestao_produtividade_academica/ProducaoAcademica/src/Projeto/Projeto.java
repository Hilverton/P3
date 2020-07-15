package Projeto;

import ProducAcademica.Publicacao;
import java.util.ArrayList;

public class Projeto {
    private String titulo;
    private String profResp;
    private int anoInicio;
    private int anoTermino;
    private String agFinan;
    private String Objetivo;
    private String Descricao;
    private double valor;
    private String status;
    private ArrayList colabprof = new ArrayList();
    private ArrayList colabaluno = new ArrayList();
    private ArrayList pub = new ArrayList();

    @Override
    public String toString() {
        return "Projeto:\n" +
                "Titulo = " + titulo +
                "\nProfessor Responsável = " + profResp +
                "\nData de inicio = " + anoInicio +
                "\nData de termino = " + anoTermino +
                "\nAgência Financiadora = " + agFinan +
                "\nValor = " + valor + "\nStatus = " + status +
                "\nDescrição = " + Descricao +
                "\nObjetivo = " + Objetivo + "\n";
    }

    public void Projeto(String titulo, String profResp,int anoInicio, int anoTermino, String agFinan, double valor, String Descricao, String Objetivo) {
        this.titulo = titulo;
        this.profResp = profResp;
        this.anoInicio = anoInicio;
        this.anoTermino = anoTermino;
        this.agFinan = agFinan;
        this.valor = valor;
        this.status = "Em elaboração";
        this.Descricao = Descricao;
        this.Objetivo = Objetivo;
    }

    public String getTitulo() {
        return titulo;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean Colabprof(String p) {
        try{
            colabprof.add(p);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void listarColabprof() {
        for (int i = 0; i < colabprof.size(); i++) {
            System.out.println(colabprof.get(i));
        }
    }

    public ArrayList profpart() {
        return colabprof;
    }

    public boolean Colabaluno(String p) {
        try{
            colabaluno.add(p);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void listarColabaluno() {
        for (int i = 0; i < colabaluno.size(); i++) {
            System.out.println(colabaluno.get(i));
        }
    }

    public ArrayList alunospart() {
        return colabaluno;
    }

    public boolean pubAss(Publicacao p) {
        try{
            pub.add(p);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public ArrayList listarPubAss() {
        return pub;
    }
}

