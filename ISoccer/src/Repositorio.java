import java.util.HashMap;

public class Repositorio {
    HashMap<String,Motorista> motoristaBD = new HashMap<>();
    HashMap<String,Medico> medicoBD = new HashMap<>();
    HashMap<String,Jogador> jogBD = new HashMap<>();
    HashMap<String,Pessoa> cozBD = new HashMap<>();
    HashMap<String,Pessoa> advBD = new HashMap<>();
    HashMap<String,Pessoa> prepBD = new HashMap<>();
    HashMap<String,Pessoa> tecBD = new HashMap<>();
    HashMap<String,Pessoa> presBD = new HashMap<>();
    HashMap<String,Socio> socBD = new HashMap<>();
    HashMap<String,Onibus> oniBD = new HashMap<>();
    Estadio estadio;
    CT centro;

    public boolean salvarMot(String chave, Motorista m) {
        try{
            motoristaBD.put(chave,m);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public HashMap listaM() {
        return motoristaBD;
    }

    public boolean salvarMedico(String chave, Medico m) {
        try{
            medicoBD.put(chave,m);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public HashMap listaMed() {
        return medicoBD;
    }

    public boolean salvarJog(String chave, Jogador j) {
        try{
            jogBD.put(chave,j);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public HashMap listaJog() {
        return jogBD;
    }

    public boolean salvarCoz(String chave, Pessoa p) {
        try{
            cozBD.put(chave,p);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public HashMap listaCoz() {
        return cozBD;
    }

    public boolean salvarAdv(String chave, Pessoa p) {
        try{
            advBD.put(chave,p);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public HashMap listaAdv() {
        return advBD;
    }

    public boolean salvarPrep(String chave, Pessoa p) {
        try{
            prepBD.put(chave,p);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public HashMap listaPrep() {
        return prepBD;
    }

    public boolean salvarTec(String chave, Pessoa p) {
        try{
            tecBD.put(chave,p);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public HashMap listaTec() {
        return tecBD;
    }

    public boolean salvarPres(String chave, Pessoa p) {
        try{
            presBD.put(chave,p);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public HashMap listaPres() {
        return presBD;
    }

    public boolean salvarSocio(String chave, Socio s) {
        try{
            socBD.put(chave,s);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public HashMap listaSoc() {
        return socBD;
    }

    public boolean salvarOnibus(String chave, Onibus o) {
        try{
            oniBD.put(chave,o);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public HashMap listaOnibus() {
        return oniBD;
    }

    public boolean salvarEstadio(Estadio est) {
        try{
            this.estadio = est;
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public Estadio verEstadio() {
        return estadio;
    }

    public boolean salvarCT(CT ct) {
        try{
            this.centro = ct;
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public CT verCT() {
        return centro;
    }

}
