/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Validação.ValidarEntradaDeDados;
import dominio.GerenciadorMidia;
import Midias.Midia;
import Midias.Musica;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Matheus Montanha
 */
public class GUIMusica implements IMenu {

    dominio.GerenciadorMidia gerenciador = new GerenciadorMidia(new ArrayList());
    ValidarEntradaDeDados validacao = new ValidarEntradaDeDados();

    public void MenuMusica() {
        Scanner e = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("1 - Criar musica.");
            System.out.println("2 - Excluir musica.");
            System.out.println("3 - Consultar musica.");
            System.out.println("4 - Editar musica.");
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
                    Musica musica = (Musica) consultarMidia();
                    if (musica == null) {
                        System.out.println("Musica inexistente.");
                    } else {
                        System.out.println(musica.toString());
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
            System.out.println("Digite o título da musica: ");
            titulo = e.nextLine();
            if (validacao.validarTextos(titulo)); else {
                System.out.println("Titulo incorreto. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        do {
            ficar = false;
            System.out.println("Digite o genero da musica: ");
            genero = e.nextLine();
            if (validacao.validarTextos(genero)); else {
                System.out.println("Genero incorreto. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        do {
            ficar = false;
            System.out.println("Digite o idioma da musica: ");
            idioma = e.nextLine();
            if (validacao.validarTextos(idioma)); else {
                System.out.println("Idioma incorreto. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        do {
            ficar = false;
            System.out.println("Digite uma descrição para a musica: ");
            descricao = e.nextLine();
            if (validacao.validarTextos(descricao)); else {
                System.out.println("Descrição inválida. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        do {
            ficar = false;
            System.out.println("Digite os autores da musica: ");
            autores = e.nextLine();
            if (validacao.validarTextos(autores)); else {
                System.out.println("Forma inválida. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        do {
            ficar = false;
            System.out.println("Digite o ano da sua musica: ");
            ano = e.nextLine();
            if (validacao.validarTextos(ano)) {
                System.out.println("Ano incorreto. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        do {
            ficar = false;
            System.out.println("Digite o interprete da musica: ");
            interpretes = e.nextLine();
            if (validacao.validarTextos(interpretes)); else {
                System.out.println("Formato incorreto. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        do {
            ficar = false;
            System.out.println("Digite a duração da musica: ");
            duracao = e.nextLine();
            if (validacao.validarTextos(duracao)) {
                System.out.println("Formato incorreto. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        String caminho = new java.io.File(".").getAbsolutePath();
        Musica musica = new Musica(caminho, titulo, genero, idioma, descricao, autores, ano, interpretes, duracao);
        if (gerenciador.adicionarMidia(musica)) {
            System.out.println("Musica criada com sucesso.");
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
            System.out.println("Digite o título da musica que deseja remover: ");
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
            System.out.println("Digite o título da musica que deseja consultar: ");
            String tituloConsulta = e.nextLine();
            if (validacao.validarTextos(tituloConsulta)) {
                Musica musica = (Musica) gerenciador.consultarMidia(tituloConsulta);
                return musica;
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
        String titulo, genero, idioma, descricao, autores, ano, interpretes, duracao, resposta;
        System.out.println("Digite o título da musica que deseja editar: ");
        String tituloEditar = e.nextLine();
        Musica musica = (Musica) gerenciador.consultarMidia(tituloEditar);
        if (gerenciador.verificarMidia(tituloEditar)) {
            do {
                ficar = false;
                System.out.println("Novo titulo da música: ");
                System.out.println("[Tecla ENTER para ignorar]");
                titulo = e.nextLine();
                if (titulo.equals("")); else if (validacao.validarTextos(titulo)) {
                    musica.setTitulo(titulo);
                } else {
                    System.out.println("Titulo incorreto. Digite novamente.");
                    ficar = true;
                }
            } while (ficar);
            do {
                ficar = false;
                System.out.println("Novo genero da musica: ");
                System.out.println("[Tecla ENTER para ignorar]");
                genero = e.nextLine();
                if (genero.equals("")); else if (validacao.validarTextos(genero)) {
                    musica.setGenero(genero);
                } else {
                    System.out.println("Genero incorreto. Digite novamente.");
                    ficar = true;
                }
            } while (ficar);
            do {
                ficar = false;
                System.out.println("Novo idioma da musica: ");
                System.out.println("[Tecla ENTER para ignorar]");
                idioma = e.nextLine();
                if (idioma.equals("")); else if (validacao.validarTextos(idioma)) {
                    musica.setIdioma(idioma);
                } else {
                    System.out.println("Idioma incorreto. Digite novamente.");
                    ficar = true;
                }

            } while (ficar);
            do {
                ficar = false;
                System.out.println("Nova descrição da musica: ");
                System.out.println("[tecle ENTER para ignorar]");
                descricao = e.nextLine();
                if (descricao.equals("")); else if (validacao.validarTextos(descricao)) {
                    musica.setDescricao(descricao);
                } else {
                    System.out.println("Descrição incorreta. Digite novamente.");
                    ficar = true;
                }

            } while (ficar);
            do {
                ficar = false;
                System.out.println("Novos autores da musica: ");
                System.out.println("[Tecle ENTER para ignorar]");
                autores = e.nextLine();
                if (autores.equals("")); else if (validacao.validarTextos(autores)) {
                    musica.setAutores(autores);
                } else {
                    System.out.println("Formato incorreto. Digite novamente.");
                    ficar = true;
                }
            } while (ficar);
            do {
                ficar = false;
                System.out.println("Novo ano da musica: ");
                System.out.println("[Tecle ENTER para ignorar]");
                ano = e.nextLine();
                if (ano.equals("")); else if (validacao.validarTextos(ano)) {
                    musica.setAutores(ano);
                } else {
                    System.out.println("Formato incorreto. Digite novamente.");
                    ficar = true;
                }
            } while (ficar);
            do {
                ficar = false;
                System.out.println("Novo interprete da musica: ");
                System.out.println("[Tecle ENTER para ignorar]");
                interpretes = e.nextLine();
                if (interpretes.equals("")); else if (validacao.validarTextos(interpretes)) {
                    musica.setInterpretes(interpretes);
                } else {
                    System.out.println("Formato incorreto. Digite novamnete.");
                    ficar = true;
                }
            } while (ficar);
            do {
                ficar = false;
                System.out.println("Digite a nova duração da musica: ");
                System.out.println("[Tecle ENTER para ignorar]");
                duracao = e.nextLine();
                if (duracao.equals("")); else if (validacao.validarTextos(duracao)) {
                    musica.setDuracao(duracao);
                } else {
                    System.out.println("Formato incorreto. Digite novamente.");
                    ficar = true;
                }
            } while (ficar);
            return gerenciador.editarMidia(tituloEditar, musica);
        } else {
            System.out.println("Musica inexistente.");
        }
        return false;
    }
}
