/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/*
import Validação.ValidarEntradaDeDados;
import dominio.GerenciadorMidia;
import Midias.Midia;
import Midias.Ebook;
import java.util.Scanner;

/**
 *
 * @author roliv
 */
 /*
public class GUIEbook extends GUIMidia implements IMenu {

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
        super.criarMidia();
        Scanner e = new Scanner(System.in);
        String editora = null, local = null, numPaginas = null;

        System.out.println("Digite o número de páginas: ");
        numPaginas = ValidarEntradaDeDados.nextInt(numPaginas);
        System.out.println("Digite o nome da editora: ");
        editora = ValidarEntradaDeDados.nextLine(editora);
        System.out.println("Digite o local/país:");
        local = ValidarEntradaDeDados.nextLine(local);

        Midia ebook = new Ebook(caminhoArquivo, titulo, descricao, genero, autores, idioma, ano, numPaginas, editora, local);
        gerenciador.adicionarMidia(ebook);
        System.out.println("Ebook adicionado com sucesso!");
    }

    public boolean editarMidia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removerMidia() {
        Scanner e = new Scanner(System.in);
        String tituloRemover = null;
        System.out.println("Digite o título da musica que deseja remover: ");
        tituloRemover = Validação.ValidarEntradaDeDados.nextLine(tituloRemover);
        if (gerenciador.remover(tituloRemover)) {
            System.out.println("Removido com sucesso.");
        }
    }

    public void consultarMidia() {
        Scanner e = new Scanner(System.in);
        String tituloConsulta = null;
        System.out.println("Digite o título da midia que deseja consultar: ");
        tituloConsulta = Validação.ValidarEntradaDeDados.nextLine(tituloConsulta);
        Midia dados = gerenciador.consultarMidia(tituloConsulta);
        if (dados == null) {
            System.out.println("Musica inexistente.");
        } else {
            System.out.println(dados.toString());
        }
    }

}
 */
