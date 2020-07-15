import ProducAcademica.Publicacao;
import Projeto.Projeto;

import java.util.ArrayList;

public class Aluno {
    private String nome;
    private String formacao;
    private String email;
    private int qtdProjeto = 0;
    ArrayList publicacao = new ArrayList();
    ArrayList projeto = new ArrayList();

    public void  Aluno(String nome, String email, String formacao) {
        this.nome = nome;
        this.email = email;
        this.formacao = formacao;
    }

    @Override
    public String toString() {
        return "Aluno:" +
                "\nNome = " + nome +
                "\nFormação = " + formacao + "\n";
    }

    public String getNome() {
        return nome;
    }

    public String getFormacao() {
        return formacao;
    }

    public int getQtdProjeto() {
        return qtdProjeto;
    }

    public void setQtdProjeto(int qtdProjeto) {
        this.qtdProjeto = qtdProjeto;
    }

    public boolean Pub(Publicacao p) {
        try{
            publicacao.add(p);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public ArrayList Alunpub() {
        return publicacao;
    }

    public boolean alunoProj(Projeto p) {
        try {
            projeto.add(p);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public ArrayList listarProAlu() {
        return projeto;
    }
}
