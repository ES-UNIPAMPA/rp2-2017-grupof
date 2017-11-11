/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Validação.ValidarEntradaDeDados;
import dominio.GerenciadorMidia;
import Midias.Midia;
import Midias.Podcast;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author AllissonChervenski
 */
public class GUIPodtest implements IMenu {

    dominio.GerenciadorMidia gerenciador = new GerenciadorMidia(new ArrayList());
    ValidarEntradaDeDados validacao = new ValidarEntradaDeDados();

    public void MenuPodcast() {
        Scanner e = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("1 - Criar Podcast.");
            System.out.println("2 - Excluir podcast.");
            System.out.println("3 - Consultar podcast.");
            System.out.println("4 - Editar podcast.");
            System.out.println("5 - Voltar ao menu principal");
            System.out.println("O que deseja fazer?");
            opcao = e.nextInt();
            switch (opcao) {
                case 1:
                    criarMidia();
                    break;
                case 2:
                    removerMidia();
                    break;
                case 3:
                    Podcast podcast = (Podcast) consultarMidia();
                    if (podcast == null) {
                        System.out.println("Podcast inexistente.");
                    } else {
                        System.out.println(podcast.toString());
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
        String titulo, genero, idioma, descricao, autores, ano, interpretes, duracao;
        do {
            ficar = false;
            System.out.println("Digite o título do podcast: ");
            titulo = e.nextLine();
            if (validacao.validarTextos(titulo)); else {
                System.out.println("Titulo incorreto. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        do {
            ficar = false;
            System.out.println("Digite o genero do podcast: ");
            genero = e.nextLine();
            if (validacao.validarTextos(genero)); else {
                System.out.println("Genero incorreto. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        do {
            ficar = false;
            System.out.println("Digite o idioma do podcast: ");
            idioma = e.nextLine();
            if (validacao.validarTextos(idioma)); else {
                System.out.println("Idioma incorreto. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        do {
            ficar = false;
            System.out.println("Digite uma descrição para o podcast: ");
            descricao = e.nextLine();
            if (validacao.validarTextos(descricao)); else {
                System.out.println("Descrição inválida. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        do {
            ficar = false;
            System.out.println("Digite os autores do podcast: ");
            autores = e.nextLine();
            if (validacao.validarTextos(autores)); else {
                System.out.println("Forma inválida. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        do {
            ficar = false;
            System.out.println("Digite o ano do podcast: ");
            ano = e.nextLine();
            if (validacao.validarTextos(ano)) {
                System.out.println("Ano incorreto. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        String caminho = new java.io.File(".").getAbsolutePath();
        Podcast podcast = new Podcast(caminho, titulo, genero, idioma, descricao, autores, ano);
        if (gerenciador.adicionarMidia(podcast)) {
            System.out.println("Podcast criado com sucesso.");
            return true;
        }
        return false;
    }

    @Override
    public boolean removerMidia() {
        Scanner e = new Scanner(System.in);
        boolean ficar;
        do {
            ficar = false;
            System.out.println("Digite o título do podcast que deseja remover: ");
            String tituloRemover = e.nextLine();
            if (validacao.validarTextos(tituloRemover)) {
                if (gerenciador.excluirMidia(tituloRemover)) {
                    System.out.println("Removido com sucesso.");
                } else {
                    System.out.println("Não foi possivel remover.");
                    return true;
                }
            } else {
                System.out.println("Título incorreto.");
            }
        } while (ficar);
        return false;
    }

    @Override
    public Midia consultarMidia() {
        Scanner e = new Scanner(System.in);
        boolean ficar;
        do {
            ficar = false;
            System.out.println("Digite o título do podcast que deseja consultar: ");
            String tituloConsulta = e.nextLine();
            if (validacao.validarTextos(tituloConsulta)) {
                Podcast podcast  = (Podcast) gerenciador.consultarMidia(tituloConsulta);
                return podcast;
            } else {
                System.out.println("Titulo inexistente.");
            }
        } while (ficar);
        return null;
    }

    @Override
    public boolean editarMidia() {
        Scanner e = new Scanner(System.in);
        boolean ficar;
        String titulo, genero, idioma, descricao, autores, ano, resposta;
        System.out.println("Digite o título do podcast que deseja editar: ");
        String tituloEditar = e.nextLine();
        Podcast podcast = (Podcast) gerenciador.consultarMidia(tituloEditar);
        if (gerenciador.verificarMidia(tituloEditar)) {
            do {
                ficar = false;
                System.out.println("Novo titulo do podcast: ");
                System.out.println("[Tecla ENTER para ignorar]");
                titulo = e.nextLine();
                if (titulo.equals("")); else if (validacao.validarTextos(titulo)) {
                    podcast.setTitulo(titulo);
                } else {
                    System.out.println("Titulo incorreto. Digite novamente.");
                    ficar = true;
                }
            } while (ficar);
            do {
                ficar = false;
                System.out.println("Novo genero do podcast: ");
                System.out.println("[Tecla ENTER para ignorar]");
                genero = e.nextLine();
                if (genero.equals("")); else if (validacao.validarTextos(genero)) {
                    podcast.setGenero(genero);
                } else {
                    System.out.println("Genero incorreto. Digite novamente.");
                    ficar = true;
                }
            } while (ficar);
            do {
                ficar = false;
                System.out.println("Novo idioma do podcast: ");
                System.out.println("[Tecla ENTER para ignorar]");
                idioma = e.nextLine();
                if (idioma.equals("")); else if (validacao.validarTextos(idioma)) {
                    podcast.setIdioma(idioma);
                } else {
                    System.out.println("Idioma incorreto. Digite novamente.");
                    ficar = true;
                }

            } while (ficar);
            do {
                ficar = false;
                System.out.println("Nova descrição do podcast: ");
                System.out.println("[tecle ENTER para ignorar]");
                descricao = e.nextLine();
                if (descricao.equals("")); else if (validacao.validarTextos(descricao)) {
                    podcast.setDescricao(descricao);
                } else {
                    System.out.println("Descrição incorreta. Digite novamente.");
                    ficar = true;
                }

            } while (ficar);
            do {
                ficar = false;
                System.out.println("Novos autores do podcast: ");
                System.out.println("[Tecle ENTER para ignorar]");
                autores = e.nextLine();
                if (autores.equals("")); else if (validacao.validarTextos(autores)) {
                    podcast.setAutores(autores);
                } else {
                    System.out.println("Formato incorreto. Digite novamente.");
                    ficar = true;
                }
            } while (ficar);
            do {
                ficar = false;
                System.out.println("Novo ano do podcast: ");
                System.out.println("[Tecle ENTER para ignorar]");
                ano = e.nextLine();
                if (ano.equals("")); else if (validacao.validarTextos(ano)) {
                    podcast.setAutores(ano);
                } else {
                    System.out.println("Formato incorreto. Digite novamente.");
                    ficar = true;
                }
            } while (ficar);
            return gerenciador.editarMidia(tituloEditar, podcast);
        } else {
            System.out.println("Podcast inexistente.");
        }
        return false;
    }
}
