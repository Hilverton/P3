import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("#########################################");
        System.out.println("\tGestão de Produtividade Acadêmico");
        System.out.println("#########################################");
        System.out.println();
        int op = -1;
        while (op != 0) {
            System.out.println("\t\t\t\tMenu\n(0)- Encerrar Sistema\n(1)- Editar Projeto\n" +
                    "(2)- Consultas\n(3)- Relatório do Laboratório de Pesquisa\n(4)- Cadastrar colaborador\n" +
                    "(5)- Cadastrar Projeto\n(6)- Listar Projetos\n(7)- Produções acadêmicas");
            op = leitura.nextInt();
            switch (op) {
                case 0:
                    System.out.println("Saindo");
                    break;
                case 1:
                    Controle.editProj();
                    break;
                case 2:
                    Controle.consultas();
                    break;
                case 3:
                    Controle.relatorio();
                    break;
                case 4:
                    Controle.tipoC();
                    break;
                case 5:
                    Controle.criarProjeto();
                    break;
                case 6:
                    Controle.listarP();
                    break;
                case 7:
                    Controle.tipoProd();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
