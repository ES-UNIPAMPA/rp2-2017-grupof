/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Midias.Midia;
import Validação.ValidarEntradaDeDados;
import dominio.GerenciadorMidia;
import Midias.Musica;
import java.util.Scanner;

/**
 *
 * @author Matheus Montanha
 */
public class GUIMusica extends GUIMidia implements IMenu {

    final String camArquivoTxT = "src/Arquivos/musica.txt";
    dominio.GerenciadorMidia gerenciador;
    static String caminho = new java.io.File(".").getAbsolutePath();

    public GUIMusica() {
        gerenciador = new GerenciadorMidia(camArquivoTxT);
        gerenciador.carregar();
    }

    public void MenuMusica() {
        Scanner e = new Scanner(System.in);
        int opcao = Integer.MIN_VALUE;
        do {
            System.out.println("1 - Criar musica.");
            System.out.println("2 - Excluir musica.");
            System.out.println("3 - Consultar musica.");
            System.out.println("4 - Editar musica.");
            System.out.println("5 - Voltar ao menu principal");
            System.out.println("O que deseja fazer?");
            opcao = ValidarEntradaDeDados.validarInteiro(opcao);
            switch (opcao) {
                case 1:
                    criarMidia();
                    break;
                case 2:
                    removerMidia();
                    break;
                case 3:
                    consultarMidia();
                    break;
                case 4:
                    editarMidia();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida. Digite o número da opção desejada.");
                    break;
            }
        } while (opcao != 5);
    }

    @Override
    public void criarMidia() {
        Scanner e = new Scanner(System.in);
        String ano = null, interpretes = null, duracao = null, caminhoArquivo = null, titulo = null, descricao = null,
                genero = null, autores = null, idioma = null;
        System.out.println("Digite o título: ");
        titulo = ValidarEntradaDeDados.nextLine(titulo);
        System.out.println("Digite o gênero:");
        genero = ValidarEntradaDeDados.nextLine(genero);
        System.out.println("Digite a descrição: ");
        descricao = ValidarEntradaDeDados.nextLine(descricao);
        System.out.println("Digite autores: ");
        autores = ValidarEntradaDeDados.nextLine(autores);
        System.out.println("Digite o idioma: ");
        idioma = ValidarEntradaDeDados.nextLine(idioma);
        System.out.println("Digite o ano da musica: ");
        ano = ValidarEntradaDeDados.nextInt(ano);
        System.out.println("Digite os interpretes da musica: ");
        interpretes = ValidarEntradaDeDados.nextLine(interpretes);
        System.out.println("Digite a duração da sua musica: ");
        duracao = ValidarEntradaDeDados.nextDouble(duracao);
        Musica musica = new Musica(caminho, titulo, genero, idioma, descricao, autores, ano, interpretes, duracao);
        if (gerenciador.adicionarMidia(musica)) {
            System.out.println("Registrado com sucesos.");

        }
    }

    @Override
    public boolean editarMidia() {
        Scanner e = new Scanner(System.in);
        boolean ficar;
        String titulo = null, genero = null, idioma = null, descricao = null, autores = null, interpretes = null;
        Musica musica = new Musica(caminho, titulo, genero, idioma, descricao, autores, genero, interpretes, descricao);
        double duracao = Double.MIN_VALUE;
        int ano = Integer.MIN_VALUE;
        System.out.println("Digite o título da musica que deseja editar: ");
        String tituloEditar = null;
        tituloEditar = ValidarEntradaDeDados.nextLine(tituloEditar);
        if (gerenciador.verificarMidia(tituloEditar)) {
            System.out.println("Digite o novo titulo da musica: ");
            System.out.println("[TECLE ENTER PARA IGNORAR]");
            titulo = e.nextLine();
            if (titulo.equals("")); else {
                musica.setTitulo(titulo);
            }
            System.out.println("Digite o novo genero da musica: ");
            System.out.println("[TECLE ENTER PARA IGNORAR]");
            genero = e.nextLine();
            if (genero.equals("")); else {
                musica.setGenero(genero);
            }
            System.out.println("Digite o novo idioma da musica: ");
            System.out.println("[TECLE ENTER PARA IGNORAR]");
            idioma = e.nextLine();
            if (idioma.equals("")); else {
                musica.setIdioma(idioma);
            }
            System.out.println("Digite a nova descrição da musica: ");
            System.out.println("[TECLE ENTER PARA IGNORAR]");
            descricao = e.nextLine();
            if (descricao.equals("")); else {
                musica.setDescricao(descricao);
            }
            System.out.println("Digite a nova duração da musica: ");
            System.out.println("[TECLE ENTER PARA IGNORAR]");
            //duracao = e.nextDouble();
            String duracao1 = e.nextLine();
            if (duracao1.equals("")); else {
                musica.setDuracao(duracao1);
            }
            System.out.println("Digite os novos autores da musica: ");
            System.out.println("[TECLE ENTER PARA IGNORAR]");
            autores = e.nextLine();
            if (autores.equals("")); else {
                musica.setAutores(autores);
            }
            System.out.println("Digite o novo interprete: ");
            System.out.println("[TECLE ENTER PARA IGNORAR]");
            interpretes = e.nextLine();
            if (interpretes.equals("")); else {
                musica.setInterpretes(interpretes);
            }
            System.out.println("Digite o novo ano: ");
            System.out.println("[TECLE ENTER PARA IGNORAR]");
            //ano = e.next();
            String ano1 = e.nextLine();
            if (ano1.equals("")); else {
                musica.setAno(ano1);
            }
        }
        if (gerenciador.editarMidia(tituloEditar, musica)) {
            System.out.println("Editado com sucesso.");
            return true;
        }
        return false;
    }

    public void removerMidia() {
        Scanner e = new Scanner(System.in);
        String titulo = null;
        System.out.println("Digite o título da musica que deseja remover: ");
        titulo = Validação.ValidarEntradaDeDados.nextLine(titulo);
        if (gerenciador.remover(titulo)) {
            System.out.println("Removido com sucesso.");
        }
    }

    public void consultarMidia() {
        Scanner e = new Scanner(System.in);
        String titulo = null;
        System.out.println("Digite o título da midia que deseja consultar: ");
        titulo = Validação.ValidarEntradaDeDados.nextLine(titulo);
        Midia dados = gerenciador.consultarMidia(titulo);
        if (dados == null) {
            System.out.println("Musica inexistente.");
        } else {
            System.out.println(dados.toString());
        }
    }
}
