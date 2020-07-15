package ProducAcademica;

import java.util.ArrayList;
import java.util.List;

public class Orientação {
    static List<String> alunos = new ArrayList<>();

    public List<String> getAlunos() {
        return alunos;
    }

    public boolean adAlunos(String nomes) {
        alunos = new ArrayList<>();
        try{
            alunos.add(nomes);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
