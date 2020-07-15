import ProducAcademica.Orientação;
import ProducAcademica.Publicacao;
import Projeto.Projeto;

import java.util.*;

public class Controle {
    static Repositorio rp = new Repositorio();
    private static int colab = 0;
    private static int pAnd = 0;
    private static int pElab = 0;
    private static int pConc = 0;
    private static int pTotal = 0;
    private static int pTipoP = 0;
    private static int pTipoO = 0;

//===============================Sucesso===============================
    public static void sucesso(boolean valor) {
        if (valor){
            System.out.println("####################################");
            System.out.println("\t\t\tSucesso!");
            System.out.println("####################################");
        }else {
            System.out.println("####################################");
            System.out.println("\tNão foi possível salvar!!");
            System.out.println("####################################");
        }
    }
//======================================================================

//=====================Tipo de Colaborador=====================
    public static void tipoC() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("###########################");
        System.out.println("\tTipo do Colaborador");
        System.out.println("###########################");
        System.out.println("(1)- Professor\n(2)- Aluno ");
        int op = entrada.nextInt();
        String leia = entrada.nextLine(); //buffer teclado
        boolean salvo = false;
        if (op == 1) {
            salvo = cadProf();
        }else if (op == 2) {
            salvo = cadAluno();
        }
        if (salvo) {
            colab++;
        }
        System.out.println("ENTER para voltar ao Menu...");
        leia = entrada.nextLine();
    }
//=============================================================

//=====================Tipo de Produção=========================
    public static void tipoProd() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("###########################");
        System.out.println("\tTipo da Produção");
        System.out.println("###########################");
        System.out.println("(1)- Publicação\n(2)- Orientação");
        int op = entrada.nextInt();
        String leia = entrada.nextLine();
        switch (op) {
            case 1:
                adPublicacao();
                break;
            case 2:
                adOrientacao();
            default:
                System.out.println("Operação inválida\n");
        }
        System.out.println("ENTER para voltar ao Menu...");
        leia = entrada.nextLine();
    }
//=============================================================

//======================Editar Projeto======================

    public static void editProj() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Edição de Projeto");
        System.out.println("(1)- Alocar colaboradores\n(2)- Alterar status");
        int op = entrada.nextInt();
        String leia = entrada.nextLine();//buffer
        switch (op) {
            case 1:
                aloc();
                break;
            case 2:
                alterarStatus();
                break;
            default:
                System.out.println("Erro");
        }
    }

//==========================================================

//=====================Alocar Parti=========================

    public static void aloc() {
        List<Projeto> lista = rp.listar();
        List<Professor> listProf;
        List<Aluno> aluno;
        Scanner entrada = new Scanner(System.in);
        System.out.println("======================");
        System.out.println("\t\tAlocação");
        System.out.println("======================");
        if (lista.isEmpty()) {
            System.out.println("Sem projetos cadastrados");
            return;
        }
        String leia;
        boolean verif;
        listProf = rp.listarProf();
        aluno = rp.listarA();
        System.out.println("Título do projeto:");
        String nome = entrada.nextLine();
        for (Projeto p : lista) {
            if (p.getTitulo().equals(nome) && p.getStatus().equals("Em elaboração")) {
                System.out.println("Quantos colaboradores:");
                int qtd = entrada.nextInt();
                leia = entrada.nextLine();//buffer
                for (int i = 0; i < qtd; i++) {
                    System.out.println("(A)- Aluno\n(P)- Professor");
                    leia = entrada.nextLine();
                    System.out.println("Nome:");
                    String colab = entrada.nextLine();
                    if (leia.equals("A")) {
                        for (Aluno a : aluno) {
                            if (a.getNome().equals(colab) && a.getFormacao().equals("Graduação") && a.getQtdProjeto() < 2) {
                                int atualiza = a.getQtdProjeto() + 1;
                                a.setQtdProjeto(atualiza);
                                verif = p.Colabaluno(colab);
                                a.alunoProj(p);
                                sucesso(verif);
                                break;
                            }
                            if (a.getNome().equals(colab) && (a.getFormacao().equals("Mestrado") || a.getFormacao().equals("Doutorado"))) {
                                verif = p.Colabaluno(colab);
                                a.alunoProj(p);
                                sucesso(verif);
                                break;
                            }
                        }
                    }else if (leia.equals("P")) {
                        for (Professor prof : listProf) {
                            if (prof.getNome().equals(colab)) {
                                verif = p.Colabprof(colab);
                                prof.profProj(p);
                                sucesso(verif);
                                break;
                            }
                        }
                    }
                }
            }else {
                System.out.println("Não é possível alocar colaboradores para esse projeto!");
            }
        }
        System.out.println("ENTER para voltar ao Menu...");
        leia = entrada.nextLine();
    }

//==========================================================

//======================Alterar Status======================

    public static void alterarStatus() {
        List<Projeto> lista = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        System.out.println("\n==================================");
        System.out.println("\t\t\tAlterar Status");
        System.out.println("==================================");
        System.out.println("Nome do Projeto que deseja alterar:");
        String nome = entrada.nextLine();
        System.out.println("\t\tOpções:");
        System.out.println("(1)- Em elaboração -> Em andamento");
        System.out.println("(2)- Em andamento -> Concluído");
        int op = entrada.nextInt();
        String leia = entrada.nextLine(); //limpar buffer
        String teste;
        for (Projeto p : lista) {
            teste = p.getTitulo();
            if ((op == 1) && (p.getStatus().equals("Em elaboração")) && (teste.equals(nome))){
                if (p.profpart().size() != 0 || p.alunospart().size() != 0) {
                    p.setStatus("Em andamento");
                    pAnd++;
                    pElab--;
                    System.out.println("Alteração feita com sucesso");
                    break;
                }else {
                    System.out.println("Não têm colaboradores alocados!\n" +
                            "Não foi possível alterar status!");
                }
            }else if ((op == 2) && (p.getStatus().equals("Em andamento")) && (teste.equals(nome))){
                if (!p.listarPubAss().isEmpty()) {
                    p.setStatus("Concluído");
                    pConc++;
                    pAnd--;
                    System.out.println("Alteração feita com sucesso");
                    break;
                }else {
                    System.out.println("Não têm publicações associadas ao projeto!\n" +
                            "Não foi possível alterar status!");
                }
            }
        }
        System.out.println("ENTER para voltar ao Menu...");
        leia = entrada.nextLine();
    }

//==========================================================

//==========================Aluno==========================

    public static boolean cadAluno() {
        Aluno aluno = new Aluno();
        Scanner entrada = new Scanner(System.in);
        System.out.println("###########################");
        System.out.println("\tCadastrar Aluno");
        System.out.println("###########################\n");
        System.out.println("Nome do Aluno: ");
        String nome = entrada.nextLine();
        System.out.println("E-mail do Aluno: ");
        String email = entrada.nextLine();
        System.out.println("Formação do Aluno: ");
        String form = entrada.nextLine();
        aluno.Aluno(nome,email,form);
        boolean salvar = rp.salvarAluno(aluno);
        sucesso(salvar);
        return salvar;
    }

//=========================================================

//==========================Professor==========================

    public static boolean cadProf() {
        Professor prof = new Professor();
        Scanner entrada = new Scanner(System.in);
        System.out.println("###########################");
        System.out.println("\tCadastrar Professor");
        System.out.println("###########################\n");
        System.out.println("Nome do Professor: ");
        String nome = entrada.nextLine();
        prof.setNome(nome);
        boolean salvar = rp.salvarProf(prof);
        sucesso(salvar);
        return salvar;
    }

//=============================================================

//======================Criar Projeto==========================
    public static void criarProjeto() {
        Projeto projeto = new Projeto();
        Scanner entrada = new Scanner(System.in);
        String leia;
        System.out.println("###########################");
        System.out.println("\tCadastrar Projeto");
        System.out.println("###########################\n");
        System.out.println("Qual o título do projeto: ");
        String titulo = entrada.nextLine();
        System.out.println("Quem é o professor responsável: ");
        String prof = entrada.nextLine();
        System.out.println("Ano do início do projeto: ");
        int anoIn = entrada.nextInt();
        System.out.println("Ano do final do projeto: ");
        int anoFim = entrada.nextInt();
        leia = entrada.nextLine(); /*limpar o buffer do teclado*/
        System.out.println("Agente financiador do projeto");
        String agFin = entrada.nextLine();
        System.out.println("Valor do projeto: ");
        double valor = entrada.nextDouble();
        leia = entrada.nextLine(); /*limpar o buffer do teclado*/
        System.out.println("Descrição do projeto");
        String desc = entrada.nextLine();
        System.out.println("Objetivo do projeto");
        String obj = entrada.nextLine();
        projeto.Projeto(titulo,prof,anoIn,anoFim,agFin,valor,desc,obj);
        boolean salvar = rp.salvar(projeto);
        sucesso(salvar);
        pElab++;
        pTotal++;
    }
//=============================================================

//======================Listar======================
    public static void listarP() {
        List<Projeto> lista;
        lista = rp.listar();
        ArrayList listpub;
        Scanner entrada = new Scanner(System.in);
        String voltar;
        System.out.println("\n============================");
        System.out.println("\tProjetos cadastrados:");
        System.out.println("============================\n");
        if (lista.isEmpty()) {
            System.out.println("Sem projetos cadastrados!");
            System.out.println("ENTER para voltar ao Menu!");
            voltar = entrada.nextLine();
            return;
        }
        for (Projeto p : lista) {
            String mostrar = p.toString();
            System.out.println(mostrar);
            System.out.println("Professores:");
            p.listarColabprof();
            System.out.println("\nAlunos:");
            p.listarColabaluno();
            System.out.println();
            listpub = p.listarPubAss();
            listpub.sort(new Comparator() {
                public int compare(Object o1, Object o2) {
                    Publicacao p1 = (Publicacao) o1;
                    Publicacao p2 = (Publicacao) o2;
                    return Integer.compare(p1.getAnoPubli(), p2.getAnoPubli());
                }
            });
            for (int i = listpub.size() - 1; i >= 0; i--) {
                System.out.println("\t" + listpub.get(i));
            }
        }
        System.out.println("ENTER para voltar ao Menu!");
        voltar = entrada.nextLine();
    }
//==================================================

//======================Listar======================
    public static void listarA() {
        List<Aluno> lista;
        lista = rp.listarA();
        ArrayList list_alun_pub;
        Scanner entrada = new Scanner(System.in);
        String leia;
        boolean verif = lista.isEmpty();
        if (verif) {
            System.out.println("Não tem aluno cadastrado!");
            System.out.println("\nENTER para voltar ao Menu...");
            leia = entrada.nextLine();
            return;
        }
        System.out.println("Nome do aluno:");
        String nome = entrada.nextLine();
        for (Aluno a: lista) {
            if (a.getNome().equals(nome)) {
                leia = a.toString();
                System.out.println(leia);
                list_alun_pub = a.Alunpub();
                list_alun_pub.sort(new Comparator() {
                    public int compare(Object o1, Object o2) {
                        Publicacao p1 = (Publicacao) o1;
                        Publicacao p2 = (Publicacao) o2;
                        return Integer.compare(p1.getAnoPubli(), p2.getAnoPubli());
                    }
                });
                for (int i = list_alun_pub.size() - 1; i >= 0; i--) {
                    System.out.println("\t" + list_alun_pub.get(i));
                }
            }
        }
        System.out.println("ENTER para voltar ao Menu!");
        String voltar = entrada.nextLine();
    }
//==================================================

//=======================Listar Professor=======================

    public static void ListarProf() {
        List<Professor> listProf;
        ArrayList listpub;
        listProf = rp.listarProf();
        Scanner entrada = new Scanner(System.in);
        boolean verif = listProf.isEmpty();
        String leia;
        if (verif) {
            System.out.println("Não tem professor cadastrado!");
            System.out.println("\nENTER para voltar ao Menu...");
            leia = entrada.nextLine();
            return;
        }
        System.out.println("Nome do professor:");
        String nome = entrada.nextLine();
        for (Professor p : listProf) {
            if (p.getNome().equals(nome)) {
                System.out.println("Nome = " + p.getNome());
                System.out.println("Orientando:");
                p.listarOrientando();
                System.out.println("\nPublicações:");
                listpub = p.listarPubAss();
                listpub.sort(new Comparator() {
                    public int compare(Object o1, Object o2) {
                        Publicacao p1 = (Publicacao) o1;
                        Publicacao p2 = (Publicacao) o2;
                        return Integer.compare(p1.getAnoPubli(), p2.getAnoPubli());
                    }
                });
                for (int i = listpub.size() - 1; i >= 0; i--) {
                    System.out.println("\t" + listpub.get(i));
                }
            }
        }
        System.out.println("\nENTER para voltar ao Menu...");
        leia = entrada.nextLine();
    }
//==============================================================

    //===================Consultas===================
    public static void consultas() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\n============================");
        System.out.println("\t\tConsultas:");
        System.out.println("============================\n");
        System.out.println("Consultar por:\n(1)- Colaborador\n(2)- Projeto");
        int op = entrada.nextInt();
        String leia = entrada.nextLine(); //limpar o buffer
        if(op == 1) {
            System.out.println("============================");
            System.out.println("(1)- Professor\n(2)- Aluno");
            op = entrada.nextInt();
            leia = entrada.nextLine(); //limpar o buffer
            if (op == 1) {
                ListarProf();
            }else if (op == 2) {
                listarA();
            }else{
                System.out.println("Opção inválida");
            }
        }else if(op == 2) {
            Cproj();
        }else {
            System.out.println("Opção inválida");
        }
        /*System.out.println("ENTER para voltar ao Menu...");
        leia = entrada.nextLine();*/
    }
//===============================================

//=======================Consulta Projeto=======================

    public static void Cproj() {
        List<Projeto> lista = new ArrayList<>();
        ArrayList publ;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o nome do Projeto:");
        String nome = entrada.nextLine();
        String teste;
        for (Projeto p : lista = rp.listar()) {
            teste = p.getTitulo();
            if (nome.equals(teste)) {
                String mostrar = p.toString();
                System.out.println(mostrar);
                System.out.println("\nProfessores:");
                p.listarColabprof();
                System.out.println("\nAlunos:");
                p.listarColabaluno();
                publ = p.listarPubAss();
                publ.sort(new Comparator() {
                    public int compare(Object o1, Object o2) {
                        Publicacao p1 = (Publicacao) o1;
                        Publicacao p2 = (Publicacao) o2;
                        return Integer.compare(p1.getAnoPubli(), p2.getAnoPubli());
                    }
                });
                for (int i = publ.size() - 1; i >= 0; i--) {
                    System.out.println("\t" + publ.get(i));
                }
                return;
            }
        }
        System.out.println("Projeto não foi encontrado");
    }
//==============================================================

//========================Relatório========================

    public static void relatorio() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\n=================");
        System.out.println("\tRelatório");
        System.out.println("=================");
        System.out.println("Total de colaboradores: " + colab);
        System.out.println("Quantidade de projetos em elaboração: " + pElab);
        System.out.println("Quantidade de projetos em andamento: " + pAnd);
        System.out.println("Quantidade de projetos concluídos: " + pConc);
        System.out.println("Quantidade total de projetos: " + pTotal);
        System.out.println("Produção Acadêmica:");
        System.out.println("Quantidade de publicações: " + pTipoP);
        System.out.println("Quantidade de orientações: " + pTipoO);
        System.out.println("\nENTER para voltar ao Menu...");
        String leia = entrada.nextLine();
        Professor prof = new Professor();
    }
//=========================================================

//=======================Orientação=======================
    public static void adOrientacao() {
        List<Professor> listProf;
        Orientação orient = new Orientação();
        Scanner entrada = new Scanner(System.in);
        String leia;
        listProf = rp.listarProf();
        boolean verif = listProf.isEmpty();
        if (verif) {
            System.out.println("Não tem professor cadastrado!");
            System.out.println("\nENTER para voltar ao Menu...");
            leia = entrada.nextLine();
            return;
        }

        System.out.println("Nome do professor orientador: ");
        String prof = entrada.nextLine();
        for (Professor p: listProf) {
            if (p.getNome().equals(prof)) {
                System.out.println("Nome do aluno: ");
                String aluno = entrada.nextLine();
                verif = p.Orient(aluno);
                sucesso(verif);
                pTipoO++;
                return;
            }
        }
        System.out.println("Professor não cadastrado");
        System.out.println("\nENTER para voltar ao Menu...");
        leia = entrada.nextLine();
    }
//==========================================================

//=======================Publicação=======================
    public static void adPublicacao() {
        List<Professor> listProf;
        List<Aluno> aluno;
        Publicacao pub = new Publicacao();
        Scanner entrada = new Scanner(System.in);
        String leia;
        listProf = rp.listarProf();
        aluno = rp.listarA();
        boolean verif = listProf.isEmpty();
        boolean verif2 = aluno.isEmpty();
        if (verif && verif2) {
            System.out.println("Não tem colaborador cadastrado!");
            System.out.println("\nENTER para voltar ao Menu...");
            leia = entrada.nextLine();
            return;
        }
        System.out.println("Título da publicação:");
        String titulo = entrada.nextLine();
        System.out.println("Conferência em que foi publicada:");
        String conf = entrada.nextLine();
        System.out.println("Ano da publicação:");
        int ano = entrada.nextInt();
        leia = entrada.nextLine();//buffer
        System.out.println("Projeto relacionado:");
        String proj = entrada.nextLine();
        pub.Publicacao(titulo,conf,ano,proj);
        verif = rp.salvarPub(pub);
        List<Projeto> lista;
        lista = rp.listar();
        for (Projeto p : lista) {
            if (p.getTitulo().equals(proj)) {
                p.pubAss(pub);
            }
        }
        System.out.println("Quantos autores:");
        int qtd = entrada.nextInt();
        leia = entrada.nextLine();//buffer teclado
        for(int i = 0; i < qtd; i++){
            System.out.println("(A)- Aluno\n(P)- Professor");
            leia = entrada.nextLine();
            if (leia.equals("A")) {
                System.out.println("Nome:");
                leia = entrada.nextLine();
                for (Aluno a: aluno) {
                    if (a.getNome().equals(leia)) {
                        verif2 = a.Pub(pub);
                        sucesso(verif2);
                        if (verif2) {
                            pTipoP++;
                        }
                    }
                }
            }else if (leia.equals("P")) {
                System.out.println("Nome:");
                leia = entrada.nextLine();
                for (Professor prof : listProf) {
                    if (prof.getNome().equals(leia)) {
                        verif2 = prof.Publica(pub);
                        sucesso(verif2);
                        if (verif2) {
                            pTipoP++;
                        }
                        break;
                    }
                }
            }
        }
    }
//==========================================================
}