import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("===================");
        System.out.println("Bem-vindo ao IFace!");
        System.out.println("===================\n");
        int op = -1;
        while (op != 0) {
            System.out.println("\t\tMenu:\n(0)- Sair\n(1)- Entrar\n(2)- Criar conta\n(3)- listar usuario\n(4)- Remover conta");
            op = entrada.nextInt();
            String leia = entrada.nextLine();//buffer
            switch (op) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    Controle.entrar();
                    break;
                case 2:
                    Controle.criarConta();
                    break;
                case 3:
                    Controle.lista_Usuario();
                    break;
                case 4:
                    Controle.remover_Conta();
                    break;
                default:
                    System.out.println("Operação inválida");
                    break;
            }
        }
    }
}
