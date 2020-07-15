import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controle {
    static Repositorio rp = new Repositorio();
    public static void sucesso(boolean valor) {
        if (valor){
            System.out.println("####################################");
            System.out.println("\t\t\tSucesso!");
            System.out.println("####################################");
        }else {
            System.out.println("####################################");
            System.out.println("\tOcorreu um erro!!");
            System.out.println("####################################");
        }
    }
//######################Conta######################

    public static void criarConta() {
        Usuario cadastro = new Usuario();
        Scanner entrada = new Scanner(System.in);
        String leia;
        System.out.println("########################");
        System.out.println("\tCriar Conta:");
        System.out.println("########################");
        System.out.println("Informe o nome:");
        String nome = entrada.nextLine();
        System.out.println("Informe o nome do usuario (login):");
        String login = entrada.nextLine();
        System.out.println("Informe a sua senha:");
        String senha = entrada.nextLine();
        cadastro.Usuario(nome,login,senha);
        boolean salvo = rp.salvar(cadastro);
        sucesso(salvo);
        System.out.println("ENTER para voltar ao Menu...");
        leia = entrada.nextLine();
    }

    public static void lista_Usuario() {
        List<Usuario> lista = rp.listar();
        Scanner entrada = new Scanner(System.in);
        System.out.println("####################");
        System.out.println("Usuarios cadastrados:");
        System.out.println("####################\n");
        for (Usuario u : lista) {
            System.out.println(u.getNome());
        }
        System.out.println("ENTER para voltar ao Menu...");
        String leia = entrada.nextLine();
    }

    public static void remover_Conta() {
        List<Usuario> lista = rp.listar();
        System.out.println("Remoção de conta:");
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o nome:");
        String nome = entrada.nextLine();
        System.out.println("Informe o nome do usuario (login):");
        String login = entrada.nextLine();
        System.out.println("Informe a sua senha:");
        String senha = entrada.nextLine();
        rp.removeU(nome,login,senha);
        System.out.println("Apagando dados do usuário!");
        rp.removeC(nome);
        for (Usuario u : lista) {
            u.removA(nome);
        }
        Usuario.removA(nome);
        System.out.println("ENTER para voltar ao Menu...");
        String leia = entrada.nextLine();
    }
//#################################################

//#######################Entrar#######################

    public static void entrar() {
        List<Usuario> lista = rp.listar();
        Scanner entrada = new Scanner(System.in);
        System.out.println("##############");
        System.out.println("\tEntrar");
        System.out.println("##############");
        System.out.println("Informe o nome do usuario (login):");
        String login = entrada.nextLine();
        System.out.println("Informe a sua senha:");
        String senha = entrada.nextLine();
        int verif = 0;
        for (Usuario u : lista) {
            if (u.getUsuario().equals(login) && u.getSenha().equals(senha)) {
                System.out.println("Login efetuado!");
                logar(u);
                verif = 1;
                break;
            }
        }
        if (verif == 0) {
            System.out.println("Usuário não encontrado!");
        }
        System.out.println("ENTER para voltar ao Menu...");
        String leia = entrada.nextLine();
    }

//####################################################

//###########################################################
    public static void logar(Usuario logado) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("#####################");
        System.out.println("Bem-vindo " + logado.getNome());
        System.out.println("#####################");
        String leia;
        int op = -1;
        while (op != 0) {
            System.out.println("(0)- Sair\n(1)- Editar perfil\n(2)- Adicionar amigo\n(3)- Enviar mensagem\n(4)- Solicitações de amizade (" + logado.getQtdSolic() + ")\n" +
                    "(5)- Ver perfil\n(6)- Ver mensagens (" + logado.getQtdM() + ")\n(7)- Criar comunidade\n(8)- Entrar em uma comunidade\n" +
                    "(9)- Ver amigos (" + logado.getQtd_Amigos() + ")\n(10)- Ver comunidades\n(11)- Solicitações comunidade (" + logado.getPedidoqtd() + ")");
            op = entrada.nextInt();
            leia = entrada.nextLine();//buffer
            switch (op) {
                case 0:
                    System.out.println("saindo...");
                    break;
                case 1:
                    editarP(logado);
                    break;
                case 2:
                    Amizade(logado.getNome());
                    break;
                case 3:
                    enviarM(logado);
                    break;
                case 4:
                    aceitar(logado);
                    break;
                case 5:
                    System.out.println("##################");
                    System.out.println("\tPerfil");
                    System.out.println("##################");
                    System.out.println(logado.toString());
                    System.out.println("ENTER para voltar ao Menu...");
                    leia = entrada.nextLine();
                    break;
                case 6:
                    logado.listaM();
                    logado.setQtdM(0);
                    System.out.println("ENTER para voltar ao Menu...");
                    leia = entrada.nextLine();
                    break;
                case 7:
                    criarCom(logado.getNome());
                    break;
                case 8:
                    entrarCom(logado.getNome());
                    break;
                case 9:
                    System.out.println("############");
                    System.out.println("\tAmigos");
                    System.out.println("############");
                    logado.listaAmigos();
                    System.out.println("ENTER para voltar ao Menu...");
                    leia = entrada.nextLine();
                    break;
                case 10:
                    verCom();
                    break;
                case 11:
                    aceitarCom(logado);
                    break;
                default:
                    System.out.println("Operação inválida");
                    break;
            }
        }
    }
//###########################################################

//#######################Editar Perfil#######################
    public static void editarP(Usuario logado) {
        Scanner entrada = new Scanner(System.in);
        String alterar = entrada.nextLine();
        System.out.println("===============");
        System.out.println("Editar perfil:");
        System.out.println("===============");
        System.out.println("Deseja alterar a sua data de nascimento:\n(S)\n(N)");
        alterar = entrada.nextLine();
        if (alterar.equals("S")) {
            System.out.println("Informe a data de nascimento:");
            String data = entrada.nextLine();
            logado.setData_nasc(data);
        }
        System.out.println("Deseja alterar a sua idade:\n(S)\n(N)");
        alterar = entrada.nextLine();
        if (alterar.equals("S")) {
            System.out.println("Informe a sua idade:");
            int idade = entrada.nextInt();
            alterar = entrada.nextLine();//buffer
            logado.setIdade(idade);
        }
        System.out.println("Deseja alterar a senha?\n(S)\n(N)");
        alterar = entrada.nextLine();
        if (alterar.equals("S")) {
            System.out.println("Informe a nova senha:");
            String senha = entrada.nextLine();
            logado.setSenha(senha);
        }
        System.out.println("Deseja alterar o login?\n(S)\n(N)");
        alterar = entrada.nextLine();
        if (alterar.equals("S")) {
            System.out.println("Informe o novo login:");
            String login = entrada.nextLine();
            logado.setUsuario(login);
        }
        System.out.println("Deseja alterar nome?\n(S)\n(N)");
        alterar = entrada.nextLine();
        if (alterar.equals("S")) {
            System.out.println("Informe o novo nome:");
            String nome = entrada.nextLine();
            logado.setNome(nome);
        }
        System.out.println("Deseja alterar email?\n(S)\n(N)");
        alterar = entrada.nextLine();
        if (alterar.equals("S")) {
            System.out.println("Informe o email:");
            String email = entrada.nextLine();
            logado.setEmail(email);
        }
        System.out.println("ENTER para voltar ao Menu...");
        alterar = entrada.nextLine();
    }
//###########################################################

//##########################Amizade##########################

    public static void Amizade(String pedindo) {
        Scanner entrada = new Scanner(System.in);
        List<Usuario> lista = rp.listar();
        System.out.println("################################");
        System.out.println("Enviar solicitação de Amizade");
        System.out.println("################################");
        System.out.println("Para quem deseja enviar a solicitação:");
        String nome = entrada.nextLine();
        int enviado = 0;
        for (Usuario u : lista) {
            if (u.getNome().equals(nome)) {
                u.setAmizade(pedindo);
                System.out.println("Pedido enviado!");
                enviado = 1;
                u.setQtdSolic(u.getQtdSolic() + 1);
                break;
            }
        }
        if (enviado == 0) {
            System.out.println("Usuário não encontrado! Tente novamente!");
        }
        System.out.println("ENTER para voltar ao Menu...");
        String leia = entrada.nextLine();
    }
//###########################################################

    public static void resposta(String nome, String nome2, boolean valor) {
        List<Usuario> lista = rp.listar();
        for (Usuario u : lista) {
            if (u.getNome().equals(nome)) {
                u.setPedido(valor);
                if (valor) {
                    boolean verif = u.adicionar(nome2);
                    sucesso(verif);
                    if (verif) {
                        u.setQtd_Amigos(u.getQtd_Amigos() + 1);
                    }
                    return;
                }
            }
        }
    }

//##########################Aceitar##########################
    public static void aceitar(Usuario logado) {
        Scanner entrada = new Scanner(System.in);
        String leia;
        if (logado.getAmizade() == null || logado.getAmizade().isEmpty()) {
            System.out.println("Sem pedidos");
        }else {
            System.out.println("Aceitar pedido de amizade de " + logado.getAmizade() + "?\n(S)\n(N)");
            leia = entrada.nextLine();
            if (leia.equals("S")) {
                String nome1 = logado.getAmizade();
                String nome2 = logado.getNome();
                resposta(nome1, nome2,true);
            }else if (leia.equals("N")) {
                resposta(logado.getAmizade(), logado.getNome(),false);
            }
            logado.setQtdSolic(0);
        }
        logado.setAmizade("");
        System.out.println("ENTER para voltar ao Menu...");
        leia = entrada.nextLine();
    }
//###########################################################

//##########################Mensagem##########################

    public static void enviarM(Usuario logado) {
        ArrayList listaAm = logado.getAmigos();//talvez não precise disso
        List<Usuario> lista = rp.listar();
        Mensagem mens = new Mensagem();
        Scanner entrada = new Scanner(System.in);
        String leia;
        System.out.println("################");
        System.out.println("\tMensagem");
        System.out.println("################");
        System.out.println("Enviar mensagem para:");
        String receptor = entrada.nextLine();
        int teste = 0;
        for (Usuario u : lista) {
            if (u.getNome().equals(receptor)) {
                System.out.println("Digite a mensagem:");
                String texto = entrada.nextLine();
                mens.Mensagem(logado.getNome(),texto);
                boolean verif = u.aMen(mens);
                sucesso(verif);
                u.setQtdM(u.getQtdM() + 1);
                teste = 1;
                break;
            }
        }
        if (teste == 0) {
            System.out.println("Usuário não encontrado");
        }
        System.out.println("ENTER para voltar ao Menu...");
        leia = entrada.nextLine();
    }
//############################################################

//##########################Comunidade##########################

    public static void criarCom(String adm) {
        Comunidade nova = new Comunidade();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Nome da comunidade:");
        String nome = entrada.nextLine();
        System.out.println("Descrição:");
        String desc = entrada.nextLine();
        nova.Comunidade(adm,nome,desc);
        boolean verif = rp.salvarcom(nova);
        sucesso(verif);
        System.out.println("ENTER para voltar ao Menu...");
        nome = entrada.nextLine();
    }

    public static void verCom() {
        List<Comunidade> lista = rp.listarCom();
        Scanner entrada = new Scanner(System.in);
        System.out.println("######################");
        System.out.println("\tComunidades");
        System.out.println("######################");
        if (lista.isEmpty()) {
            System.out.println("Nenhuma comunidade foi criada!");
        }else {
            for (Comunidade c : lista) {
                System.out.println("Nome: " + c.getNomeCom());
                System.out.println("Descrição: " + c.getDescricao());
                System.out.println("Adm: " + c.getAdmin() + "\n");
                System.out.println("Membros:");
                for (int i = 0; i < c.membros.size(); i++) {
                    System.out.println("\t" + c.membros.get(i));
                }
            }
        }
        System.out.println("ENTER para voltar ao Menu...");
        String leia = entrada.nextLine();
    }

    public static void entrarCom(String pedindo) {
        List<Comunidade> lista = rp.listarCom();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Nome da comunidade que você quer entrar: ");
        String nome = entrada.nextLine();
        int enviado = 0;
        for (Comunidade c : lista) {
            if (c.getNomeCom().equals(nome)) {
                for (Usuario u : rp.listar()) {
                    if (u.getNome().equals(c.getAdmin())) {
                        u.setEntCom(pedindo);
                        System.out.println("Pedido enviado!");
                        enviado = 1;
                        u.setPedidoqtd(u.getPedidoqtd() + 1);
                    }
                }
            }
        }
        if (enviado == 0) {
            System.out.println("Comunidade não encontrada! Tente novamente!");
        }
        System.out.println("ENTER para voltar ao Menu...");
        String leia = entrada.nextLine();
    }

    public static void respCom(String nome, String adm, boolean valor) {
        List<Comunidade> lista = rp.listarCom();
        for (Comunidade c : lista) {
            if (c.getAdmin().equals(adm)) {
                if (valor) {
                    boolean verif = c.adcom(nome);
                    sucesso(verif);
                }
                return;
            }
        }
    }

    public static void aceitarCom(Usuario logado) {
        Scanner entrada = new Scanner(System.in);
        String leia;
        if (logado.getEntCom() == null || logado.getEntCom().isEmpty()) {
            System.out.println("Sem pedidos");
        }else {
            System.out.println("Aceitar pedido de " + logado.getEntCom() + " para entrar na comunidade?\n(S)\n(N)");
            leia = entrada.nextLine();
            if (leia.equals("S")) {
                String nome1 = logado.getEntCom();
                String nomeAdm = logado.getNome();
                respCom(nome1, nomeAdm,true);
            }else if (leia.equals("N")) {
                respCom(logado.getEntCom(), logado.getNome(),false);
            }
            logado.setPedidoqtd(0);
        }

        logado.setEntCom("");
        System.out.println("ENTER para voltar ao Menu...");
        leia = entrada.nextLine();
    }
//##############################################################
}
