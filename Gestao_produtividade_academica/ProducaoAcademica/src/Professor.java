import ProducAcademica.Publicacao;
import Projeto.Projeto;

import java.util.ArrayList;

public class Professor {
    private String nome;
    private ArrayList lista = new ArrayList();
    private ArrayList publicacao = new ArrayList();
    ArrayList projeto = new ArrayList();


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean Orient(String nome) {
        try{
            lista.add(nome);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void listarOrientando() {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
    public boolean Publica(Publicacao p) {
        try {
            publicacao.add(p);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public ArrayList listarPubAss() {
        return publicacao;
    }

    public boolean profProj(Projeto p) {
        try {
            projeto.add(p);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public ArrayList listarProProf() {
        return projeto;
    }
}
