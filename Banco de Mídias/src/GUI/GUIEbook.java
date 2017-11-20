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
import java.util.Scanner;

/**
 *
 * @author roliv
 */
public class GUIEbook extends GUIMidia {

   
    GerenciadorMidia gerenciador;  
    final String caminho = "src/Arquivos/ebook.txt";

    public GUIEbook() {
        gerenciador = new GerenciadorMidia(caminho);
        gerenciador.carregar();
    }

    public void MenuEbook() {
        
        int opcao = -1;
        do {
            System.out.println("1 - Adicionar ebook.");
            System.out.println("2 - Excluir ebook.");
            System.out.println("3 - Consultar ebook.");
            System.out.println("4 - Editar ebook.");
            System.out.println("5 - Voltar ao menu principal");
            System.out.println("O que deseja fazer?");
            opcao = Validação.ValidarEntradaDeDados.validarInteiro(opcao);
            switch (opcao) {
                case 1:
                    criarMidia();
                    break;
                case 2:
                    removerMidia();
                    break;
                case 3:
                    String ebook = consultarMidia();
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
    public void criarMidia() {
        super.criarMidia();
        Scanner e = new Scanner(System.in);
        String editora = null, local = null, numPaginas = null;

        System.out.println("Digite o número de páginas: ");
        numPaginas = ValidarEntradaDeDados.nextInt();
        System.out.println("Digite o nome da editora: ");
        editora = ValidarEntradaDeDados.nextLine();
        System.out.println("Digite o local/país:");
        local = ValidarEntradaDeDados.nextLine();

        Midia ebook = new Ebook(caminhoArquivo, titulo, descricao, genero, autores, idioma, ano, numPaginas, editora, local);
        gerenciador.adicionarMidia(ebook);
        System.out.println("Ebook adicionado com sucesso!");
    }


    public boolean removerMidia() {
        Scanner e = new Scanner(System.in);
        System.out.println("Digite o título da midia que deseja remover: ");
        String titulo = null;
        titulo = ValidarEntradaDeDados.nextLine();
        if (gerenciador.remover(titulo)) {
            System.out.println("Removido com sucesso!");
            return true;
        }
        return false;
    }

    public String consultarMidia() {
        String titulo = null;
        titulo = ValidarEntradaDeDados.nextLine();
        String dados = gerenciador.consultarMidia(titulo);
        return dados;
    }

    public boolean editarMidia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
