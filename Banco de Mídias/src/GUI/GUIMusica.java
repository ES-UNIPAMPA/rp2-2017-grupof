/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Validação.ValidarEntradaDeDados;
import dominio.GerenciadorMidia;
import Midias.Musica;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Matheus Montanha
 */
public class GUIMusica implements IMenu {

    dominio.GerenciadorMidia gerenciador = new GerenciadorMidia(new ArrayList(), "musica.txt");
    static String caminho = new java.io.File(".").getAbsolutePath();

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
                    String musica = consultarMidia();
                    if (musica == null) {
                        System.out.println("Musica inexistente.");
                    } else {
                        System.out.println(musica);
                    }
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
    public boolean criarMidia() {
        Scanner e = new Scanner(System.in);
        boolean ficar;
        String titulo = null, genero = null, idioma = null, descricao = null, autores = null, interpretes = null;
        //double duracao = Double.MIN_VALUE;
        int ano = Integer.MIN_VALUE;
        String ano1 = null;
        String duracao1 = null;
        System.out.println("Digite o título da música: ");
        titulo = ValidarEntradaDeDados.nextLine(titulo);
        System.out.println("Digite o gênero da musica:");
        genero = ValidarEntradaDeDados.nextLine(genero);
        System.out.println("Digite a descrição da musica: ");
        descricao = ValidarEntradaDeDados.nextLine(descricao);
        System.out.println("Digite autores da musica: ");
        autores = ValidarEntradaDeDados.nextLine(autores);
        System.out.println("Digite o ano da musica: ");
        ano1 = ValidarEntradaDeDados.nextInt(ano1);
        System.out.println("Digite o interprete da musica: ");
        interpretes = ValidarEntradaDeDados.nextLine(interpretes);
        System.out.println("Digite a duração da masica: ");
        duracao1 = ValidarEntradaDeDados.nextDouble(duracao1);
        System.out.println("Digite o idioma: ");
        idioma = ValidarEntradaDeDados.nextLine(idioma);
        Musica musica = new Musica(caminho, titulo, genero, idioma, descricao, autores, ano1, interpretes, duracao1);
        if (gerenciador.adicionarMidia(musica)) {
            System.out.println("Registrado com sucesos.");
            gerenciador.carregar(musica);
            return true;

        }
        return false;
    }

    @Override
    public boolean removerMidia() {
        Scanner e = new Scanner(System.in);
        System.out.println("Digite o título da midia que deseja remover: ");
        String titulo = null;
        String caminho = "";
        titulo = ValidarEntradaDeDados.nextLine(titulo);
        if (gerenciador.remover(titulo)) {
            System.out.println("Removido com sucesso!");
            return true;
        }
        return false;
    }

    @Override
    public String consultarMidia() {
        Scanner e = new Scanner(System.in);
        String titulo = null;
        titulo = ValidarEntradaDeDados.nextLine(titulo);
        String dados = gerenciador.consultarMidia(titulo);
        return dados;
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
        Musica musicaEditar = new Musica(caminho, titulo, genero, idioma, descricao, autores, genero, interpretes, descricao);
        if (gerenciador.editarMidia(tituloEditar, musicaEditar)) {
            System.out.println("Editado com sucesso.");
            return true;
        }
        return false;
    }
}
