/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Validação.ValidarEntradaDeDados;
import dominio.GerenciadorMidia;
import Midias.Midia;
import Midias.Ebook;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author roliv
 */
public class GUIEbook implements IMenu {

    dominio.GerenciadorMidia gerenciador = new GerenciadorMidia(new ArrayList());
    ValidarEntradaDeDados validacao = new ValidarEntradaDeDados();

    public void MenuEbook() {
        Scanner e = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("1 - Adicionar ebook.");
            System.out.println("2 - Excluir ebook.");
            System.out.println("3 - Consultar ebook.");
            System.out.println("4 - Editar ebook.");
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
                    Ebook ebook = (Ebook) consultarMidia();
                    if (ebook == null) {
                        System.out.println("Ebook inexistente.");
                    } else {
                        System.out.println(ebook.toString());
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
        String titulo, descricao, genero, autores, idioma, numPaginas, editora, local, ano;
        
        do {
            ficar = false;
            System.out.println("Digite o título do ebook: ");
            titulo = e.nextLine();
            if (validacao.validarTextos(titulo)); else {
                System.out.println("Titulo incorreto. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        
        do {
            ficar = false;
            System.out.println("Digite uma descrição para o ebook: ");
            descricao = e.nextLine();
            if (validacao.validarTextos(descricao)); else {
                System.out.println("Descrição inválida. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        
        do {
            ficar = false;
            System.out.println("Digite o gênero do ebook: ");
            genero = e.nextLine();
            if (validacao.validarTextos(genero)); else {
                System.out.println("Gênero incorreto. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        
        do {
            ficar = false;
            System.out.println("Digite os autores do ebook: ");
            autores = e.nextLine();
            if (validacao.validarTextos(autores)); else {
                System.out.println("Forma inválida. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        
        do {
            ficar = false;
            System.out.println("Digite o idioma do ebook: ");
            idioma = e.nextLine();
            if (validacao.validarTextos(idioma)); else {
                System.out.println("Idioma inválido. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        
        do {
            ficar = false;
            System.out.println("Digite o número de páginas do ebook: ");
            numPaginas = e.nextLine();
            if (validacao.validarTextos(numPaginas)) {
                System.out.println("Formato incorreto. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        
        do {
            ficar = false;
            System.out.println("Digite qual a editora do ebook: ");
            editora = e.nextLine();
            if (validacao.validarTextos(editora)); else {
                System.out.println("Formato incorreto. Digite novamente.");
                ficar = true;
            }
        } while (ficar);

        do {
            ficar = false;
            System.out.println("Digite o local do ebook: ");
            local = e.nextLine();
            if (validacao.validarTextos(local)); else {
                System.out.println("local incorreto. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        
        do {
            ficar = false;
            System.out.println("Digite o ano do ebook: ");
            ano = e.nextLine();
            if (validacao.validarTextos(ano)) {
                System.out.println("Ano incorreto. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        
        String caminho = new java.io.File(".").getAbsolutePath();
        Ebook ebook = new Ebook(caminho, titulo, descricao, genero, autores, idioma, numPaginas, editora, local, ano);
        if (gerenciador.adicionarMidia(ebook)) {
            System.out.println("Ebook criado com sucesso.");
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
            System.out.println("Digite o título do ebook que deseja remover: ");
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
            System.out.println("Digite o título do ebook que deseja consultar: ");
            String tituloConsulta = e.nextLine();
            if (validacao.validarTextos(tituloConsulta)) {
                Ebook ebook = (Ebook) gerenciador.consultarMidia(tituloConsulta);
                return ebook;
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
        String titulo, descricao, genero, autores, idioma, numPaginas, editora, local, ano;
        System.out.println("Digite o título do ebook que deseja editar: ");
        String tituloEditar = e.nextLine();
        Ebook ebook = (Ebook) gerenciador.consultarMidia(tituloEditar);
        if (gerenciador.verificarMidia(tituloEditar)) {
            
            do {
                ficar = false;
                System.out.println("Novo titulo do ebook: ");
                System.out.println("[Tecla ENTER para ignorar]");
                titulo = e.nextLine();
                if (titulo.equals("")); else if (validacao.validarTextos(titulo)) {
                    ebook.setTitulo(titulo);
                } else {
                    System.out.println("Titulo incorreto. Digite novamente.");
                    ficar = true;
                }
            } while (ficar);
            
            do {
                ficar = false;
                System.out.println("Nova descrição do ebook: ");
                System.out.println("[tecle ENTER para ignorar]");
                descricao = e.nextLine();
                if (descricao.equals("")); else if (validacao.validarTextos(descricao)) {
                    ebook.setDescricao(descricao);
                } else {
                    System.out.println("Descrição incorreta. Digite novamente.");
                    ficar = true;
                }

            } while (ficar);

            do {
                ficar = false;
                System.out.println("Novo genero do ebook: ");
                System.out.println("[Tecla ENTER para ignorar]");
                genero = e.nextLine();
                if (genero.equals("")); else if (validacao.validarTextos(genero)) {
                    ebook.setGenero(genero);
                } else {
                    System.out.println("Genero incorreto. Digite novamente.");
                    ficar = true;
                }
            } while (ficar);

            do {
                ficar = false;
                System.out.println("Novos autores do ebook: ");
                System.out.println("[Tecle ENTER para ignorar]");
                autores = e.nextLine();
                if (autores.equals("")); else if (validacao.validarTextos(autores)) {
                    ebook.setAutores(autores);
                } else {
                    System.out.println("Formato incorreto. Digite novamente.");
                    ficar = true;
                }
            } while (ficar);

            do {
                ficar = false;
                System.out.println("Novo idioma do ebook: ");
                System.out.println("[Tecla ENTER para ignorar]");
                idioma = e.nextLine();
                if (idioma.equals("")); else if (validacao.validarTextos(idioma)) {
                    ebook.setIdioma(idioma);
                } else {
                    System.out.println("Idioma incorreto. Digite novamente.");
                    ficar = true;
                }

            } while (ficar);

            do {
                ficar = false;
                System.out.println("Novo número de páginas do ebook: ");
                System.out.println("[Tecle ENTER para ignorar]");
                numPaginas = e.nextLine();
                if (numPaginas.equals("")); else if (validacao.validarTextos(numPaginas)) {
                    ebook.setNumPaginas(numPaginas);
                } else {
                    System.out.println("Formato incorreto. Digite novamnete.");
                    ficar = true;
                }
            } while (ficar);

            do {
                ficar = false;
                System.out.println("Nova editora do ebook: ");
                System.out.println("[Tecle ENTER para ignorar]");
                editora = e.nextLine();
                if (editora.equals("")); else if (validacao.validarTextos(editora)) {
                    ebook.setEditora(editora);
                } else {
                    System.out.println("Formato incorreto. Digite novamnete.");
                    ficar = true;
                }
            } while (ficar);

            do {
                ficar = false;
                System.out.println("Novo local do ebook: ");
                System.out.println("[Tecle ENTER para ignorar]");
                local = e.nextLine();
                if (local.equals("")); else if (validacao.validarTextos(local)) {
                    ebook.setLocal(local);
                } else {
                    System.out.println("Formato incorreto. Digite novamnete.");
                    ficar = true;
                }
            } while (ficar);

            do {
                ficar = false;
                System.out.println("Novo ano do ebook: ");
                System.out.println("[Tecle ENTER para ignorar]");
                ano = e.nextLine();
                if (ano.equals("")); else if (validacao.validarTextos(ano)) {
                    ebook.setAno(ano);
                } else {
                    System.out.println("Formato incorreto. Digite novamente.");
                    ficar = true;
                }
            } while (ficar);

            return gerenciador.editarMidia(tituloEditar, ebook);
        } else {
            System.out.println("Ebook inexistente.");
        }
        return false;
    }

}
