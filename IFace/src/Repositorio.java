import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Repositorio {
    List<Usuario> usuario = new ArrayList<>();
    List<Comunidade> comunidade = new ArrayList<>();

//====================Usuário====================
    public boolean salvar(Usuario u) {
        try{
            usuario.add(u);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Usuario> listar() {
        return usuario;
    }

    public void removeU(String nome, String login, String senha) {
        Iterator rem = usuario.iterator();
        while (rem.hasNext()) {
            Usuario x = (Usuario) rem.next();
            if (x.getNome().equals(nome) && x.getUsuario().equals(login) && x.getSenha().equals(senha)) {
                System.out.println(x.getNome() + " excluído");
                rem.remove();
            }
        }
    }
//===============================================

//====================Comunidade====================
    public boolean salvarcom(Comunidade u) {
        try{
            comunidade.add(u);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Comunidade> listarCom() {
        return comunidade;
    }

    public void removeC(String nome) {
        Iterator rem = comunidade.iterator();
        while (rem.hasNext()) {
            Comunidade x = (Comunidade) rem.next();
            ArrayList membros = x.getMembros();
            Iterator rmembros = membros.iterator();
            while (rmembros.hasNext()) {
                String n = (String) rmembros.next();
                if (n.equals(nome)) {
                    rmembros.remove();
                }
            }
        }
    }
//==================================================

}
