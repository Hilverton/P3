import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Controle {
    public static Repositorio rp = new Repositorio();
    static Adm admin = new Adm();

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

    public static void entrarLogin() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("==================");
        System.out.println("\t\tEntrar");
        System.out.println("==================");
        System.out.println("Login:");
        String log = entrada.nextLine();
        System.out.println("Senha:");
        String sen = entrada.nextLine();
        boolean result = (validarL(log, sen));
        if (result) {
            System.out.println("===========================");
            System.out.println("Login efetuado com sucesso!");
            System.out.println("===========================");
            menu();
        }else{
            System.out.println("Login ou senha incorretos!");
            System.out.println("ENTER para continuar...");
            String leia = entrada.nextLine();
        }
    }

    public static boolean validarL(String lo, String se) {
        if (lo.equals(admin.getLogin()) && se.equals(admin.getSenha())) {
            return true;
        }else {
            return false;
        }
    }

    public static void menu() {
        Scanner entrada = new Scanner(System.in);
        String ler;
        int op = -1;
        while (op != 0) {
            System.out.println("\t\tMenu");
            System.out.println("(0)- Sair\n(1)- Alterar login adm\n(2)- Funcionários\n" +
                    "(3)- Sócios\n(4)- Recursos Físicos");
            try {
                op = entrada.nextInt();
                ler = entrada.nextLine();//buffer
                switch (op) {
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    case 1:
                        alterar();
                        break;
                    case 2:
                        gerFunc();
                        break;
                    case 3:
                        gerSoc();
                        break;
                    case 4:
                        recFis();
                        break;
                    default:
                        System.out.println("Operação inválida");
                }
                System.out.println("ENTER para continuar...");
                ler = entrada.nextLine();
            } catch (InputMismatchException e) {
                ler = entrada.nextLine();//buffer
                System.out.println("Tente novamente!");
                System.out.println("ENTER para continuar...");
                ler = entrada.nextLine();
            }
        }
    }

    public static void gerSoc() {
        Scanner entrada = new Scanner(System.in);
        String ler;
        System.out.println("============");
        System.out.println("  Torcedor");
        System.out.println("============");
        int op = -1;
        while (op != 0) {
            System.out.println("\t\tMenu");
            System.out.println("(0)- Sair\n(1)- Adicionar Sócio Torcedor\n(2)- Buscar Sócio Torcedor\n(3)- Alterar dados\n(4)- Relatório");
            try {
                op = entrada.nextInt();
                ler = entrada.nextLine();//buffer
                switch (op) {
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    case 1:
                        FuncControle.addSocio();
                        break;
                    case 2:
                        FuncControle.buscSocio();
                        break;
                    case 3:
                        FuncControle.altSocio();
                        break;
                    case 4:
                        relSocio();
                        break;
                    default:
                        System.out.println("Operação inválida");
                }
                System.out.println("ENTER para continuar...");
                ler = entrada.nextLine();
            }catch (InputMismatchException e) {
                ler = entrada.nextLine();//buffer
                System.out.println("Tente novamente!");
                System.out.println("ENTER para continuar...");
                ler = entrada.nextLine();
            }
        }
    }

    public static void relSocio() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("==================");
        System.out.println("\tRelatório");
        System.out.println("==================");
        System.out.println("Total de Sócios: " + FuncControle.getQtdSocio() + "\nAdimplentes: " + FuncControle.getQtdAdimp()
                + "\nInadimplentes: " + FuncControle.getQtdInadimp());
        System.out.println("ENTER para continuar...");
        String ler = entrada.nextLine();
    }

    public static void gerFunc() {
        Scanner entrada = new Scanner(System.in);
        String ler;
        System.out.println("============");
        System.out.println("Funcionários");
        System.out.println("============");
        int op = -1;
        while (op != 0) {
            System.out.println("\t\tMenu");
            System.out.println("(0)- Sair\n(1)- Adicionar Funcionário\n(2)- Buscar Funcionário\n(3)- Alterar dados Jogador");
            try {
                op = entrada.nextInt();
                switch (op) {
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    case 1:
                        adFunc();
                        break;
                    case 2:
                        listFunc();
                        break;
                    case 3:
                        FuncControle.altJog();
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

    public static void recFis() {
        Scanner entrada = new Scanner(System.in);
        String ler;
        System.out.println("================");
        System.out.println("Recursos Físicos");
        System.out.println("================");
        int op = -1;
        while (op != 0) {
            System.out.println("\t\tMenu");
            System.out.println("(0)- Sair\n(1)- Adicionar Recursos\n(2)- Buscar Recursos");
            try {
                op = entrada.nextInt();
                switch (op) {
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    case 1:
                        adRec();
                        break;
                    case 2:
                        listRec();
                        break;
                    default:
                        System.out.println("Operação inválida");
                }
                System.out.println("ENTER para continuar...");
                ler = entrada.nextLine();
            }catch (InputMismatchException e) {
                ler = entrada.nextLine();//buffer
                System.out.println("Tente novamente!");
                System.out.println("ENTER para continuar...");
                ler = entrada.nextLine();
            }
        }

    }

    public static int intTrat(String texto) {
        Scanner entrada = new Scanner(System.in);
        int op = -1, novo;
        String ler;
        while(true) {
            try{
                System.out.println(texto + "\n(1)- S\n(0)- N");
                novo = entrada.nextInt();
                if (novo == 0 || novo == 1) {
                    return novo;
                } else {
                    System.out.println("Entrada inválida!");
                }
            } catch (InputMismatchException e) {
                ler = entrada.nextLine();//buffer
                System.out.println("Tente novamente!");
                System.out.println("ENTER para continuar...");
                ler = entrada.nextLine();
            }
        }
    }

    public static void alterar(){
        System.out.println("=====================");
        System.out.println("\t\tAlterar");
        System.out.println("=====================");
        int op = intTrat("Alterar login?");
        String novo;
        if (op == 1) {
            novo = tratString("login");
            admin.setLogin(novo);
        }
        op = intTrat("Alterar senha?");
        if (op == 1) {
            novo = tratString("senha");
            admin.setSenha(novo);
        }
    }

    public static String tratString(String tipo) {
        Scanner entrada = new Scanner(System.in);
        String novo;
        System.out.println("Novo(a) " + tipo);
        novo = entrada.nextLine();
        while (true) {
            if (novo.equals("")){
                System.out.println("Entrada inválida!\nNovo(a) " + tipo + ":");
                novo = entrada.nextLine();
            } else {
                return novo;
            }
        }
    }

    public static void adFunc() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("=============");
        System.out.println("  Adicionar");
        System.out.println("=============");
        int op = -1;
        String ler;
        while (op != 0) {
            System.out.println("Menu:\n(0)- Sair\n(1)- Presidente\n(2)- Médico\n(3)- Técnico\n(4)- Preparador Físico" +
                    "\n(5)- Motorista\n(6)- Cozinheiro\n(7)- Advogado\n(8)- Jogador");
            try {
                op = entrada.nextInt();
                switch (op) {
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    case 1:
                        FuncControle.addPres();
                        break;
                    case 2:
                        FuncControle.addMed();
                        break;
                    case 3:
                        FuncControle.addTec();
                        break;
                    case 4:
                        FuncControle.addPrep();
                        break;
                    case 5:
                        FuncControle.addMot();
                        break;
                    case 6:
                        FuncControle.addCoz();
                        break;
                    case 7:
                        FuncControle.addAdv();
                        break;
                    case 8:
                        FuncControle.addJog();
                        break;
                    default:
                        System.out.println("Operação inválida| Faixa de valores de 0 até 8");
                }
                System.out.println("ENTER para continuar...");
                ler = entrada.nextLine();
            } catch (InputMismatchException e) {
                ler = entrada.nextLine();//buffer
                System.out.println("Tente novamente!");
                System.out.println("ENTER para continuar...");
                ler = entrada.nextLine();
            }
        }
    }

    public static void listFunc() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("=========================");
        System.out.println("   Listar Funcionários");
        System.out.println("=========================");
        String ler;
        int op = -1;
        while (op != 0) {
            System.out.println("Menu:\n(0)- Sair\n(1)- Presidente\n(2)- Médico\n(3)- Técnico\n(4)- Preparador Físico" +
                    "\n(5)- Motorista\n(6)- Cozinheiro\n(7)- Advogado\n(8)- Jogador\n(9)- Jogadores Disponíveis");
            try {
                op = entrada.nextInt();
                ler = entrada.nextLine();//buffer
                switch (op) {
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    case 1:
                        System.out.println("Presidente:\n");
                        HashMap<String,Pessoa> pres = rp.listaPres();
                        if (!pres.isEmpty()) {
                            for (Map.Entry<String,Pessoa> func: pres.entrySet()) {
                                System.out.println("CPF: " +  func.getKey());
                                System.out.println("Nome: " +  func.getValue().getNomeComp() + "\n");
                            }
                        } else {
                            System.out.println("Nenhum médico cadastrado!");
                        }
                        break;
                    case 2:
                        System.out.println("Médico:\n");
                        HashMap<String,Medico> med = rp.listaMed();
                        if (!med.isEmpty()) {
                            for (Map.Entry<String,Medico> func: med.entrySet()) {
                                System.out.println(func.getValue().toString());
                            }
                        } else {
                            System.out.println("Nenhum médico cadastrado!");
                        }
                        break;
                    case 3:
                        System.out.println("Técnico:\n");
                        HashMap<String,Pessoa> tec = rp.listaTec();
                        if (!tec.isEmpty()) {
                            for (Map.Entry<String,Pessoa> func: tec.entrySet()) {
                                System.out.println(func.getValue().toString());
                            }
                        } else {
                            System.out.println("Nenhum técnico cadastrado!");
                        }
                        break;
                    case 4:
                        System.out.println("Preparador Físico:\n");
                        HashMap<String,Pessoa> prep = rp.listaPrep();
                        if (!prep.isEmpty()) {
                            for (Map.Entry<String,Pessoa> func: prep.entrySet()) {
                                System.out.println(func.getValue().toString());
                            }
                        } else {
                            System.out.println("Nenhum preparador físico cadastrado!");
                        }
                        break;
                    case 5:
                        System.out.println("Motoristas:\n");
                        HashMap<String,Motorista> motLis = rp.listaM();
                        if (!motLis.isEmpty()) {
                            for (Map.Entry<String,Motorista> func: motLis.entrySet()) {
                                System.out.println(func.getValue().toString());
                            }
                        } else {
                            System.out.println("Nenhum motorista cadastrado!");
                        }
                        break;
                    case 6:
                        System.out.println("Cozinheiro:\n");
                        HashMap<String,Pessoa> coz = rp.listaCoz();
                        if (!coz.isEmpty()) {
                            for (Map.Entry<String,Pessoa> func: coz.entrySet()) {
                                System.out.println(func.getValue().toString());
                            }
                        } else {
                            System.out.println("Nenhum cozinheiro cadastrado!");
                        }
                        break;
                    case 7:
                        System.out.println("Advogado:\n");
                        HashMap<String,Pessoa> adv = rp.listaAdv();
                        if (!adv.isEmpty()) {
                            for (Map.Entry<String,Pessoa> func: adv.entrySet()) {
                                System.out.println(func.getValue().toString());
                            }
                        } else {
                            System.out.println("Nenhum advogado cadastrado!");
                        }
                        break;
                    case 8:
                        System.out.println("Jogador:\n");
                        HashMap<String,Jogador> jog = rp.listaJog();
                        if (!jog.isEmpty()) {
                            for (Map.Entry<String,Jogador> func: jog.entrySet()) {
                                System.out.println(func.getValue().toString());//fazer isso para todos
                            }
                        } else {
                            System.out.println("Nenhum jogador cadastrado!");
                        }
                        break;
                    case 9:
                        jogDisp();
                    default:
                        System.out.println("Operação inválida| Faixa de valores de 0 até 9");
                }
            } catch (InputMismatchException e) {
                ler = entrada.nextLine();//buffer
                System.out.println("Tente novamente!");
                System.out.println("ENTER para continuar...");
                ler = entrada.nextLine();
            }
        }
    }

    public static void adRec() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("=============");
        System.out.println("  Adicionar");
        System.out.println("=============");
        int op = -1;
        String ler;
        while (op != 0) {
            System.out.println("Menu:\n(0)- Sair\n(1)- Ônibus\n(2)- Estádio\n(3)- Centro de Treinamento");
            try {
                op = entrada.nextInt();
                ler = entrada.nextLine();//buffer
                switch (op) {
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    case 1:
                        FisControle.addOni();
                        break;
                    case 2:
                        FisControle.addEstadio();
                        break;
                    case 3:
                        FisControle.addCT();
                        break;
                    default:
                        System.out.println("Operação inválida| Faixa de valores de 0 até 3");
                }
            } catch (InputMismatchException e) {
                ler = entrada.nextLine();//buffer
                System.out.println("Tente novamente!");
                System.out.println("ENTER para continuar...");
                ler = entrada.nextLine();
            }
        }
    }

    public static void jogDisp() {
        System.out.println("=====================");
        System.out.println("Jogadores Disponíveis");
        System.out.println("=====================");
        FuncControle.jogar();
    }

    public static void listRec() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("=====================");
        System.out.println("   Listar Recursos");
        System.out.println("=====================");
        String ler;
        int op = -1;
        while (op != 0) {
            System.out.println("Menu:\n(0)- Sair\n(1)- Ônibus\n(2)- Estádio\n(3)- Centro de Treinamento");
            try {
                op = entrada.nextInt();
                ler = entrada.nextLine();//buffer
                switch (op) {
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    case 1:
                        FisControle.vOnibus();
                        break;
                    case 2:
                        FisControle.vEstadio();
                        break;
                    case 3:
                        FisControle.vCT();
                        break;
                    default:
                        System.out.println("Operação inválida| Faixa de valores de 0 até 3");
                }
                System.out.println("ENTER para continuar...");
                ler = entrada.nextLine();
            } catch (InputMismatchException e) {
                ler = entrada.nextLine();//buffer
                System.out.println("Tente novamente!");
                System.out.println("ENTER para continuar...");
                ler = entrada.nextLine();
            }
        }
    }
}