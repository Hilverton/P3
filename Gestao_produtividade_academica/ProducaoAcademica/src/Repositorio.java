import Projeto.Projeto;
import ProducAcademica.Publicacao;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    static List<Projeto> listaProjeto = new ArrayList<>();
    static List<Aluno> listaAluno = new ArrayList<>();
    static List<Professor> listaProf = new ArrayList<>();
    static List<Publicacao> listaPub = new ArrayList<>();

//========================Projeto========================
    public boolean salvar (Projeto p) {
        try{
            listaProjeto.add(p);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public List<Projeto> listar() {
        return listaProjeto;
    }
//========================================================

//========================Aluno========================
    public boolean salvarAluno (Aluno a) {
        try{
            listaAluno.add(a);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public List<Aluno> listarA() {
        return listaAluno;
    }
//======================================================

//========================Professor=======================

    public boolean salvarProf (Professor p) {
        try{
            listaProf.add(p);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public List<Professor> listarProf() {
        return listaProf;
    }

//=========================================================

    public boolean salvarPub (Publicacao p) {
        try{
            listaPub.add(p);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public List<Publicacao> listarPub() {
        return listaPub;
    }
}
