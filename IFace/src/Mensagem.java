public class Mensagem {
    String remetente;
    String texto;

    public void Mensagem(String remetente, String texto) {
        this.remetente = remetente;
        this.texto = texto;
    }

    public String getRemetente() {
        return remetente;
    }

    public String getTexto() {
        return texto;
    }
}
