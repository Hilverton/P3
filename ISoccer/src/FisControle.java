import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class FisControle {

    static int qtdOnibus = 0;

    public static int getQtdOnibus() {
        return qtdOnibus;
    }

    public static void setQtdOnibus(int qtdOnibus) {
        FisControle.qtdOnibus = qtdOnibus;
    }

    public static String tratEntrada() {
        Scanner entrada = new Scanner(System.in);
        String novo;
        novo = entrada.nextLine();
        while (true) {
            if (novo.equals("")){
                System.out.println("Entrada inválida!\nNão é permitida entrada em branco!\n");
                novo = entrada.nextLine();
            } else {
                return novo;
            }
        }
    }

    public static int tratInt(String texto) {
        Scanner entrada = new Scanner(System.in);
        String ler;
        int op = -1, novo;
        while(true) {
            try{
                System.out.println(texto);
                novo = entrada.nextInt();
                ler = entrada.nextLine();
                return novo;
            } catch (InputMismatchException e) {
                ler = entrada.nextLine();//buffer
                System.out.println("Tente novamente!");
                System.out.println("ENTER para continuar...");
                ler = entrada.nextLine();
            }
        }
    }

    public static void addOni() {
        Scanner entrada = new Scanner(System.in);
        String ler;
        System.out.println("Adicionar Ônibus");
        System.out.println("Número de identificação: ");
        String ident = tratEntrada();
        int qtd = tratInt("Quantidade de passageiros: ");
        Onibus oni = new Onibus(ident,qtd);
        boolean salvo = Controle.rp.salvarOnibus(ident,oni);
        Controle.sucesso(salvo);
        if (salvo) {
            setQtdOnibus(getQtdOnibus()+1);
        }
    }

    public static void addEstadio() {
        Scanner entrada = new Scanner(System.in);
        String ler;
        System.out.println("Adicionar Estádio");
        System.out.println("Nome do Estádio: ");
        String nome = tratEntrada();
        System.out.println("Quantidade de torcedores: ");
        int qtdT = tratInt("Quantidade de torcedores: ");
        int qtdB = tratInt("Quantidade de banheiros: ");
        int qtdL = tratInt("Quantidade de lanchonetes: ");
        Estadio est = new Estadio(nome,qtdT,qtdB,qtdL);
        boolean salvo = Controle.rp.salvarEstadio(est);
        Controle.sucesso(salvo);
    }

    public static void addCT() {
        Scanner entrada = new Scanner(System.in);
        String ler;
        System.out.println("Adicionar Centro de Treinamento");
        System.out.println("Nome do CT: ");
        String nome = tratEntrada();
        int qtdD = tratInt("Quantidade de dormitórios: ");
        int qtdB = tratInt("Quantidade de banheiros: ");
        CT cen = new CT(nome,qtdD,qtdB);
        boolean salvo = Controle.rp.salvarCT(cen);
        Controle.sucesso(salvo);
        System.out.println("ENTER para continuar...");
        ler = entrada.nextLine();
    }

    public static void vOnibus() {
        Scanner entrada = new Scanner(System.in);
        String ler;
        HashMap<String,Onibus> onList = Controle.rp.listaOnibus();
        System.out.println("============");
        System.out.println("   Ônibus");
        System.out.println("============");
        if (!onList.isEmpty()) {
            for (Map.Entry<String,Onibus> func: onList.entrySet()) {
                System.out.println(func.getValue().toString());
            }
        } else {
            System.out.println("Indisponível! Não há ônibus cadastrado!");
        }
    }

    public static void vEstadio() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("=============");
        System.out.println("   Estádio");
        System.out.println("=============");
        Estadio e = Controle.rp.verEstadio();
        try{
            System.out.println(e.toString());
        }catch(NullPointerException npe){
            System.out.println("Indiponível! Não há estadio cadastrado!");
        }
    }

    public static void vCT() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("===========================");
        System.out.println("   Centro de Treinamento");
        System.out.println("===========================");
        CT c = Controle.rp.verCT();
        try{
            System.out.println(c.toString());
        }catch(NullPointerException npe){
            System.out.println("Indiponível! Não há CT cadastrado!");
        }
    }
}
