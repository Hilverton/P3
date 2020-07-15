import java.util.ArrayList;

public class Comunidade {
    public String admin;
    public String nomeCom;
    public String descricao;
    ArrayList membros = new ArrayList();

    public void Comunidade(String admin, String nomeCom, String descricao) {
        this.admin = admin;
        this.nomeCom = nomeCom;
        this.descricao = descricao;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getNomeCom() {
        return nomeCom;
    }

    public void setNomeCom(String nomeCom) {
        this.nomeCom = nomeCom;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList getMembros() {
        return membros;
    }

    public boolean adcom(String n) {
        try{
            membros.add(n);
        }catch (Exception e) {
            return false;
        }
        return true;
    }


}
