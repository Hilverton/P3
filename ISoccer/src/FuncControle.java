import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class FuncControle {

    private static Pessoa padrao;
    static int qtdSocio = 0, qtdMed = 0, qtdAdimp = 0, qtdInadimp = 0
            , qtdAdv = 0, qtdMot = 0, qtdCoz = 0, qtdPrep = 0, qtdTec = 0, qtdJog = 0;

    public static Pessoa infoPadrao() {
        Scanner entrada = new Scanner(System.in);
        String ler;
        System.out.println("Nome:");
        String nome = entrada.nextLine();
        System.out.println("Email:");
        String email = entrada.nextLine();
        System.out.println("CPF:");
        String cpf = entrada.nextLine();
        System.out.println("Telefone:");
        String telef = entrada.nextLine();
        System.out.println("Salário:");
        double sal = entrada.nextDouble();
        ler = entrada.nextLine();//buffer
        Pessoa p = new Pessoa(nome,email,cpf,telef,sal);
        return p;
    }

//===============================Presidente===============================
    public static void addPres() {
        Scanner entrada = new Scanner(System.in);
        String ler;
        System.out.println("==================");
        System.out.println("\tPresidente");
        padrao = infoPadrao();
        boolean salvo = Controle.rp.salvarPres(padrao.getCpf(), padrao);
        Controle.sucesso(salvo);
        System.out.println("ENTER para continuar...");
        ler = entrada.nextLine();
    }

//===============================Medico===============================
    public static void addMed() {
        Scanner entrada = new Scanner(System.in);
        String ler;
        System.out.println("==================");
        System.out.println("\tMédico");
        padrao = infoPadrao();
        System.out.println("CRM:");
        String crm = entrada.nextLine();
        Medico medico = new Medico(padrao.getNomeComp(),padrao.getEmail(),padrao.getCpf(),
                padrao.getTelefone(),padrao.getSalario(),crm);
        boolean salvo = Controle.rp.salvarMedico(crm, medico);
        Controle.sucesso(salvo);
        if (salvo) setQtdMed(getQtdMed()+1);
        System.out.println("ENTER para continuar...");
        ler = entrada.nextLine();
    }

//===============================Técnico===============================
    public static void addTec() {
        Scanner entrada = new Scanner(System.in);
        String ler;
        System.out.println("==================");
        System.out.println("\tTécnico");
        padrao = infoPadrao();
        boolean salvo = Controle.rp.salvarTec(padrao.getCpf(), padrao);
        Controle.sucesso(salvo);
        if (salvo) setQtdTec(getQtdTec()+1);
        System.out.println("ENTER para continuar...");
        ler = entrada.nextLine();
    }

    //===============================Preparador===============================
    public static void addPrep() {
        Scanner entrada = new Scanner(System.in);
        String ler;
        System.out.println("==================");
        System.out.println("\tPreparador Físico");
        padrao = infoPadrao();
        boolean salvo = Controle.rp.salvarPrep(padrao.getCpf(), padrao);
        Controle.sucesso(salvo);
        if (salvo) setQtdPrep(getQtdPrep()+1);
        System.out.println("ENTER para continuar...");
        ler = entrada.nextLine();
    }

//===============================Motorista===============================
    public static void addMot() {
        Scanner entrada = new Scanner(System.in);
        String ler;
        System.out.println("==================");
        System.out.println("\tMotorista");
        padrao = infoPadrao();
        System.out.println("CNH:");
        String cnh = entrada.nextLine();
        Motorista motor = new Motorista(padrao.getNomeComp(),padrao.getEmail(),padrao.getCpf(),
                padrao.getTelefone(),padrao.getSalario(),cnh);
        boolean salvo = Controle.rp.salvarMot(padrao.getCpf(), motor);
        Controle.sucesso(salvo);
        if (salvo) setQtdMot(getQtdMot()+1);
        System.out.println("ENTER para continuar...");
        ler = entrada.nextLine();
    }

//===============================Cozinheiro===============================
    public static void addCoz() {
        Scanner entrada = new Scanner(System.in);
        String ler;
        System.out.println("==================");
        System.out.println("\tMotorista");
        padrao = infoPadrao();
        boolean salvo = Controle.rp.salvarCoz(padrao.getCpf(), padrao);
        Controle.sucesso(salvo);
        if (salvo) setQtdCoz(getQtdCoz()+1);
        System.out.println("ENTER para continuar...");
        ler = entrada.nextLine();
    }

//===============================Advogado===============================
    public static void addAdv() {
        Scanner entrada = new Scanner(System.in);
        String ler;
        System.out.println("==================");
        System.out.println("\tAdvogado");
        padrao = infoPadrao();
        boolean salvo = Controle.rp.salvarAdv(padrao.getCpf(), padrao);
        Controle.sucesso(salvo);
        if (salvo) setQtdAdv(getQtdAdv()+1);
        System.out.println("ENTER para continuar...");
        ler = entrada.nextLine();
    }

//===============================Jogador===============================
    public static void addJog() {
        Scanner entrada = new Scanner(System.in);
        String ler;
        System.out.println("==================");
        System.out.println("\tJogador");
        padrao = infoPadrao();
        System.out.println("Função:");
        String tipo = entrada.nextLine();
        Jogador jog = new Jogador(padrao.getNomeComp(),padrao.getEmail(),padrao.getCpf(),
                padrao.getTelefone(),padrao.getSalario(),tipo);
        boolean salvo = Controle.rp.salvarJog(padrao.getCpf(), jog);
        Controle.sucesso(salvo);
        if (salvo) setQtdJog(getQtdJog()+1);
        System.out.println("ENTER para continuar...");
        ler = entrada.nextLine();
    }

//===============================Torcedor===============================
    public static void addSocio() {
        Scanner entrada = new Scanner(System.in);
        String ler, tipo;
        int op = -1;
        System.out.println("==================");
        System.out.println("\tTorcedor");
        padrao = infoPadrao();
        while (true) {
            System.out.println("Tipo:\nJúnior => R$50\nSênior => R$150\nElite => R$400");
            tipo = entrada.nextLine();
            if (!tipo.equals("Júnior") && !tipo.equals("Sênior") && !tipo.equals("Elite")) {
                System.out.println("Informação errada! Tente novamente!");
            }else if (tipo.equals("Júnior") && padrao.getSalario() > 50) {
                break;
            } else if (tipo.equals("Sênior") && padrao.getSalario() > 150) {
                break;
            }else if (tipo.equals("Elite") && padrao.getSalario() > 400) {
                break;
            } else {
                System.out.println("Salaário incompatível! Tente novamente!");
            }
        }
        Socio socio = new Socio(padrao.getNomeComp(),padrao.getEmail(),padrao.getCpf(),
                padrao.getTelefone(),padrao.getSalario(),tipo);
        boolean salvo = Controle.rp.salvarSocio(padrao.getCpf(),socio);
        Controle.sucesso(salvo);
        if (salvo) {
            setQtdSocio(getQtdSocio()+1);
        }
        System.out.println("ENTER para continuar...");
        ler = entrada.nextLine();
    }

    public static void buscSocio() {
        Scanner entrada = new Scanner(System.in);
        HashMap<String, Socio> socLis = Controle.rp.listaSoc();
        String ler;
        int op = -1;
        System.out.println("===========");
        System.out.println("Busca Sócio");
        System.out.println("===========");
        while (op != 0) {
            System.out.println("\tMenu\n(0)- sair\n(1)- Individual\n(2)- Todos");
            try {
                op = entrada.nextInt();
                ler = entrada.nextLine();//buffer
                switch (op) {
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    case 1:
                        if (!socLis.isEmpty()) {
                            System.out.println("Informe o CPF:");
                            String cpf = entrada.nextLine();
                            if (socLis.containsKey(cpf)) {
                                Socio s = socLis.get(cpf);
                                s.toString();
                            }else {
                                System.out.println("Não encontrado! Tente novamente!");
                            }
                        } else {
                            System.out.println("Não há sócio cadastrado!");
                        }
                        break;
                    case 2:
                        if (!socLis.isEmpty()) {
                            for (Map.Entry<String, Socio> func: socLis.entrySet()) {
                                func.getValue().toString();
                            }
                        } else {
                            System.out.println("Não há sócio cadastrado!");
                        }
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

    public static void altSocio() {
        Scanner entrada = new Scanner(System.in);
        String cpf, ler;
        int op;
        System.out.println("==========================");
        System.out.println("\tAlterar Dados");
        System.out.println("==========================");
        HashMap<String,Socio> listSoc = Controle.rp.listaSoc();
        if (listSoc.isEmpty()) {
            System.out.println("Não há sócios cadastrados!");
            return;
        }
        while (true) {
            System.out.println("Informe o CPF para buscar sócio:");
            cpf = entrada.nextLine();
            if (cpf.equals("")) {
                System.out.println("Entrada inválida! Tente novamente!");
            } else {
                break;
            }
        }
        if (!listSoc.containsKey(cpf)) {
            System.out.println("Sócio não encontrado!");
            return;
        }
        op = Controle.intTrat("Deseja alterar o nome?");
        if (op == 1) {
            ler = Controle.tratString("nome");
            listSoc.get(cpf).setNomeComp(ler);
        }
        op = Controle.intTrat("Deseja alterar o email?");
        if (op == 1) {
            ler = Controle.tratString("email");
            listSoc.get(cpf).setEmail(ler);
        }
        op = Controle.intTrat("Deseja alterar o telefone?");
        if (op == 1) {
            ler = Controle.tratString("telefone");
            listSoc.get(cpf).setTelefone(ler);
        }
        op = Controle.intTrat("Deseja alterar o salário?");
        if (op == 1) {
            System.out.println("Novo(a) salário:");
            try {
                double sal = entrada.nextDouble();
                ler = entrada.nextLine();//buffer
                listSoc.get(cpf).setSalario(sal);
            }catch (InputMismatchException e) {
                ler = entrada.nextLine();//buffer
                System.out.println("Não foi possível alterar!");
            }
        }
        op = Controle.intTrat("Deseja alterar o tipo?");
        if (op == 1) {
            while (true) {
                System.out.println("Novo(a) tipo:\nJúnior => R$50\nSênior => R$150\nElite => R$400");
                ler = entrada.nextLine();
                if (ler.equals("Júnior") && listSoc.get(cpf).getSalario() > 50) {
                    listSoc.get(cpf).setTipo("Júnior");
                    break;
                } else if (ler.equals("Sênior") && listSoc.get(cpf).getSalario() > 150) {
                    listSoc.get(cpf).setTipo("Sênior");
                    break;
                }else if (ler.equals("Elite") && listSoc.get(cpf).getSalario() > 400) {
                    listSoc.get(cpf).setTipo("Elite");
                    break;
                } else {
                    System.out.println("Incompatível com salário! Tente novamente!");
                }
            }
        }
        op = Controle.intTrat("Deseja alterar o cpf?");
        if (op == 1) {
            ler = Controle.tratString("email");
            listSoc.get(cpf).setCpf(ler);
        }
        op = Controle.intTrat("Deseja alterar o status?");
        if (op == 1) {
            if (listSoc.get(cpf).isAdimp() == true) {
                op = Controle.intTrat("Alterar status para inadimplente?");
                if (op == 1) {
                    listSoc.get(cpf).setAdimp(false);
                    setQtdAdimp(getQtdAdimp()-1);
                    setQtdInadimp(getQtdInadimp()+1);
                }
                op = Controle.intTrat("Alterar status para adimplente?");
                if (op == 1) {
                    listSoc.get(cpf).setAdimp(true);
                    setQtdAdimp(getQtdAdimp()+1);
                    setQtdInadimp(getQtdInadimp()-1);
                }
            }
        }
    }

    public static void jogar() {
        Scanner entrada = new Scanner(System.in);
        HashMap<String,Jogador> jog = Controle.rp.listaJog();
        if (!jog.isEmpty()) {
            for (Map.Entry<String,Jogador> func: jog.entrySet()) {
                if (func.getValue().isApto() && !func.getValue().isdMedico()) {
                    System.out.println("Nome: " + func.getValue().getNomeComp());
                    System.out.println("Posição: " + func.getValue().getTipo() + "\n");
                }
            }
        } else {
            System.out.println("Nenhum jogador cadastrado!");
        }
        System.out.println("ENTER para continuar...");
        String ler = entrada.nextLine();
    }

    public static void altJog() {
            Scanner entrada = new Scanner(System.in);
            HashMap<String, Jogador> lista = Controle.rp.listaJog();
            System.out.println("=============");
            System.out.println("Dados Jogador");
            System.out.println("=============");
            if (lista.isEmpty()) {
                System.out.println("Não há jogadores cadastrados!");
                return;
            }
            String cpf, ler;
            int op;
            while (true) {
                System.out.println("Informe o CPF para buscar jogador:");
                cpf = entrada.nextLine();
                if (cpf.equals("")) {
                    System.out.println("Entrada inválida! Tente novamente!");
                } else {
                    break;
                }
            }
            if (!lista.containsKey(cpf)) {
                System.out.println("Jogador não encontrado!");
                return;
            }
            op = Controle.intTrat("Deseja alterar o nome?");
            if (op == 1) {
                ler = Controle.tratString("nome");
                lista.get(cpf).setNomeComp(ler);
            }
            op = Controle.intTrat("Deseja alterar o email?");
            if (op == 1) {
                ler = Controle.tratString("email");
                lista.get(cpf).setEmail(ler);
            }
            op = Controle.intTrat("Deseja alterar o telefone?");
            if (op == 1) {
                ler = Controle.tratString("telefone");
                lista.get(cpf).setTelefone(ler);
            }
            op = Controle.intTrat("Deseja alterar o salário?");
            if (op == 1) {
                System.out.println("Novo(a) salário:");
                try {
                    double sal = entrada.nextDouble();
                    ler = entrada.nextLine();//buffer
                    lista.get(cpf).setSalario(sal);
                }catch (InputMismatchException e) {
                    ler = entrada.nextLine();//buffer
                    System.out.println("Não foi possível alterar!");
                }
            }
            op = Controle.intTrat("Deseja alterar a posição do jogador?");
            if (op == 1) {
                System.out.println("Novo(a) posição:");
                ler = entrada.nextLine();
                lista.get(cpf).setTipo(ler);
            }
            op = Controle.intTrat("Deseja alterar Aptidão e Dpt. Médico?\n(Não é possível alterar apenas uma opção)");
            if (op == 1) {
                lista.get(cpf).setApto(!lista.get(cpf).isApto());
                lista.get(cpf).setdMedico(!lista.get(cpf).isdMedico());
            }

    }

    public static int getQtdSocio() {
        return qtdSocio;
    }

    public static void setQtdSocio(int qtdSocio) {
        FuncControle.qtdSocio = qtdSocio;
    }

    public static int getQtdMed() {
        return qtdMed;
    }

    public static void setQtdMed(int qtdMed) {
        FuncControle.qtdMed = qtdMed;
    }

    public static int getQtdAdimp() {
        return qtdAdimp;
    }

    public static void setQtdAdimp(int qtdAdimp) {
        FuncControle.qtdAdimp = qtdAdimp;
    }

    public static int getQtdInadimp() {
        return qtdInadimp;
    }

    public static void setQtdInadimp(int qtdInadimp) {
        FuncControle.qtdInadimp = qtdInadimp;
    }

    public static int getQtdAdv() {
        return qtdAdv;
    }

    public static void setQtdAdv(int qtdAdv) {
        FuncControle.qtdAdv = qtdAdv;
    }

    public static int getQtdMot() {
        return qtdMot;
    }

    public static void setQtdMot(int qtdMot) {
        FuncControle.qtdMot = qtdMot;
    }

    public static int getQtdCoz() {
        return qtdCoz;
    }

    public static void setQtdCoz(int qtdCoz) {
        FuncControle.qtdCoz = qtdCoz;
    }

    public static int getQtdPrep() {
        return qtdPrep;
    }

    public static void setQtdPrep(int qtdPrep) {
        FuncControle.qtdPrep = qtdPrep;
    }

    public static int getQtdTec() {
        return qtdTec;
    }

    public static void setQtdTec(int qtdTec) {
        FuncControle.qtdTec = qtdTec;
    }

    public static int getQtdJog() {
        return qtdJog;
    }

    public static void setQtdJog(int qtdJog) {
        FuncControle.qtdJog = qtdJog;
    }
}
