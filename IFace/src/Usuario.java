import java.util.ArrayList;
import java.util.Iterator;

public class Usuario {
    public String nome;
    public String data_nasc;
    public String usuario;
    public String senha;
    public String email;
    public int idade;
    public int qtdM;
    public int qtdSolic;
    public String amizade;
    public String entCom;
    public static int qtd_Amigos;
    boolean pedido;
    int pedidoqtd;

    ArrayList<Mensagem> mensagens = new ArrayList<>();
    public static ArrayList amigos;



    @Override
    public String toString() {
        return "Usuário:\n" +
                "\nNome = " + nome +
                "\nData de nascimento = " + data_nasc +
                "\nUsuario = " + usuario +
                "\nEmail = " + email +
                "\nIdade = " + idade +
                "\n";
    }

    public void Usuario(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.qtd_Amigos = 0;
        this.qtdM = 0;
        this.qtdSolic = 0;
        this.pedidoqtd = 0;
        this.amigos = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getAmizade() {
        return amizade;
    }

    public void setAmizade(String amizade) {
        this.amizade = amizade;
    }

    public int getQtd_Amigos() {
        return qtd_Amigos;
    }

    public void setQtd_Amigos(int qtd_Amigos) {
        this.qtd_Amigos = qtd_Amigos;
    }

    public void setPedido(boolean pedido) {
        this.pedido = pedido;
    }

    public boolean adicionar(String nome) {
        try{
            amigos.add(nome);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public void listaAmigos() {
        if (amigos.size() != 0) {
            for (int i = 0; i < amigos.size(); i++){
                System.out.println(amigos.get(i));
            }
        }else {
            System.out.println("Sem amigos");
        }
    }

    public ArrayList getAmigos() {
        return amigos;
    }

    public static void removA(String nome) {
        Iterator rem = amigos.iterator();
        while (rem.hasNext()) {
            String amg = (String) rem.next();
            if (amg.equals(nome)) {
                rem.remove();
                qtd_Amigos = qtd_Amigos-1;
            }
        }
    }

    public boolean aMen(Mensagem m) {
        try{
            mensagens.add(m);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    public void listaM() {
        if (mensagens.size() != 0) {
            for (Mensagem m : mensagens) {
                System.out.println("\nRemetente: " + m.getRemetente());
                System.out.println("Mensagem:\n\t" + m.getTexto());
            }
        }else {
            System.out.println("Sem mensagens!");
        }
    }

    public int getQtdM() {
        return qtdM;
    }

    public void setQtdM(int qtdM) {
        this.qtdM = qtdM;
    }

    public int getQtdSolic() {
        return qtdSolic;
    }

    public void setQtdSolic(int qtdSolic) {
        this.qtdSolic = qtdSolic;
    }

    public String getEntCom() {
        return entCom;
    }

    public void setEntCom(String entCom) {
        this.entCom = entCom;
    }

    public int getPedidoqtd() {
        return pedidoqtd;
    }

    public void setPedidoqtd(int pedidoqtd) {
        this.pedidoqtd = pedidoqtd;
    }
}
