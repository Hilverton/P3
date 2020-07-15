import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int op = -1, verif = 0;
        String ler;
        System.out.println("=======================");
        System.out.println("\t\tISoccer");
        System.out.println("=======================");
        while(op != 0) {
            if (verif == 0) {
                System.out.println("Bem vindo Administrador!");
                System.out.println("Seu login é: admin20\nSua senha é: adm123\n" +
                        "Você pode alterar tanto o login como a senha se preferir.");
                System.out.println("ENTER para continuar...");
                ler = entrada.nextLine();
                verif = 1;
            }else{
                System.out.println("====================");
                System.out.println("\t\tMenu\n(0)-Sair\n(1)- Entrar");
                try {
                    op = entrada.nextInt();
                    switch (op) {
                        case 0:
                            System.out.println("Saindo...");
                            break;
                        case 1:
                            Controle.entrarLogin();
                            break;
                        default:
                            System.out.println("Operação inválida");
                    }
                }catch (InputMismatchException e) {
                    ler = entrada.nextLine();//buffer
                    System.out.println("Tente novamente!");
                    System.out.println("ENTER para continuar...");
                    ler = entrada.nextLine();
                }
            }
        }
    }

}
