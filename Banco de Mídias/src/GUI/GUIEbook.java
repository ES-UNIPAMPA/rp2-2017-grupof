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
import java.util.List;

/**
 *
 * @author roliv
 */
public class GUIEbook extends GUIMidia implements IMenu {

    GerenciadorMidia gerenciador;
    final String caminho = "src/Arquivos/ebook.txt";

    /**
     * Método que cria o gerenciador contendo o caminho do arquivo txt
     */
    public GUIEbook() {
        gerenciador = new GerenciadorMidia(caminho);
        gerenciador.carregar();
    }

    /**
     * Método contendo as opções disponíveis no menue Ebook
     */
    public void MenuEbook() {

        int opcao = -1;
        do {
            System.out.println("1 - Adicionar ebook.");
            System.out.println("2 - Excluir ebook.");
            System.out.println("3 - Consultar ebook.");
            System.out.println("4 - Editar ebook.");
            System.out.println("5 - Organizar lista por título.");
            System.out.println("0 - Voltar ao menu principal");
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
                    //ordenarMidia();
                    break;
                case 4:
                    editarMidia();
                    break;
                case 5:
                    ordenarMidia();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Digite o número da opção desejada.");
                    break;
            }
        } while (opcao != 0);
    }

    /**
     * Método que recebe e cria um Ebook
     */
    @Override
    public void criarMidia() {
        super.criarMidia();
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

    /**
     * Método que edita o Ebook
     *
     * @return True caso editado. Caso contrário, retorna False
     */
    public boolean editarMidia() {
        List<Midia> listaRetorno;
        int id;
        String tituloEditar = null, generoEditar = null, idiomaEditar = null, descricaoEditar = null,
                autoresEditar = null, numPaginasEditar = null, editoraEditar = null, localEditar = null,
                anoEditar = null;
        System.out.println("Digite o título do Ebook que deseja editar: ");
        String tituloConsultaEditar = null;
        tituloConsultaEditar = ValidarEntradaDeDados.nextLine(tituloConsultaEditar);
        listaRetorno = gerenciador.consultarMidia(tituloConsultaEditar);
        int contador = 0;
        if (!listaRetorno.isEmpty()) {
            for (Midia midia : listaRetorno) {
                System.out.println("ID: " + contador + "\n" + midia.toString());
                contador++;
            }
            String idTemp = null;
            System.out.println("ESSES SÃO OS EBOOKS COM O TÍTULO INFORMADO.");
            System.out.println("Idêntifique o ID do ebook que deseja editar e informe-o: ");
            idTemp = ValidarEntradaDeDados.nextInt(idTemp);
            id = Integer.parseInt(idTemp);
            if (id <= listaRetorno.size() - 1) {
                Ebook ebook = (Ebook) listaRetorno.get(id);
                if (gerenciador.verificarMidia(tituloConsultaEditar)) {
                    System.out.println("Digite o novo titulo do ebook: ");
                    System.out.println("[TECLE ENTER PARA IGNORAR]");
                    tituloEditar = ValidarEntradaDeDados.enterTexto(tituloEditar);
                    if (tituloEditar.equals("")); else {
                        ebook.setTitulo(tituloEditar);
                    }
                    System.out.println("Digite o novo genero do ebook: ");
                    System.out.println("[TECLE ENTER PARA IGNORAR]");
                    generoEditar = ValidarEntradaDeDados.enterTexto(generoEditar);
                    if (generoEditar.equals("")); else {
                        ebook.setGenero(generoEditar);
                    }
                    System.out.println("Digite o novo idioma do ebook: ");
                    System.out.println("[TECLE ENTER PARA IGNORAR]");
                    idiomaEditar = ValidarEntradaDeDados.enterTexto(idiomaEditar);
                    if (idiomaEditar.equals("")); else {
                        ebook.setIdioma(idiomaEditar);
                    }
                    System.out.println("Digite a nova descrição do ebook: ");
                    System.out.println("[TECLE ENTER PARA IGNORAR]");
                    descricaoEditar = ValidarEntradaDeDados.enterTexto(descricaoEditar);
                    if (descricaoEditar.equals("")); else {
                        ebook.setDescricao(descricaoEditar);
                    }
                    System.out.println("Digite o novo número de páginas do ebook: ");
                    System.out.println("[TECLE ENTER PARA IGNORAR]");
                    numPaginasEditar = ValidarEntradaDeDados.enterNumero(numPaginasEditar);
                    if (numPaginasEditar.equals("")); else {
                        ebook.setNumPaginas(numPaginasEditar);
                    }
                    System.out.println("Digite a nova editora do ebook: ");
                    System.out.println("[TECLE ENTER PARA IGNORAR]");
                    editoraEditar = ValidarEntradaDeDados.enterNumero(editoraEditar);
                    if (editoraEditar.equals("")); else {
                        ebook.setEditora(editoraEditar);
                    }
                    System.out.println("Digite os novos autores do Ebook: ");
                    System.out.println("[TECLE ENTER PARA IGNORAR]");
                    autoresEditar = ValidarEntradaDeDados.enterTexto(autoresEditar);
                    if (autoresEditar.equals("")); else {
                        ebook.setAutores(autoresEditar);
                    }
                    System.out.println("Digite o novo local: ");
                    System.out.println("[TECLE ENTER PARA IGNORAR]");
                    localEditar = ValidarEntradaDeDados.enterTexto(localEditar);
                    if (localEditar.equals("")); else {
                        ebook.setLocal(localEditar);
                    }
                    System.out.println("Digite o novo ano: ");
                    System.out.println("[TECLE ENTER PARA IGNORAR]");
                    anoEditar = ValidarEntradaDeDados.enterNumero(anoEditar);
                    if (anoEditar.equals("")); else {
                        ebook.setAno(anoEditar);
                    }
                }
                if (gerenciador.editarMidia(ebook)) {
                    System.out.println("Editado com sucesso.");
                    return true;
                } else {
                    System.out.println("Não foi possivel editar seu ebook.");
                    return false;
                }
            } else {
                System.out.println("ID infomado inexistente.");
            }
        } else {
            System.out.println("Ebook inexistente.");
            return false;
        }
        return false;
    }

    /**
     * Método que remove o Ebook desejado
     */
    public void removerMidia() {
        List<Midia> listaPegaRetorno;
        String tituloRemover = null;
        int id;
        System.out.println("Digite o título do ebook que deseja remover: ");
        tituloRemover = Validação.ValidarEntradaDeDados.nextLine(tituloRemover);
        listaPegaRetorno = gerenciador.consultarMidia(tituloRemover);
        int contador = 0;
        if (!listaPegaRetorno.isEmpty()) {
            for (Midia midia : listaPegaRetorno) {
                System.out.println("ID: " + contador + "\n" + midia.toString());
                contador++;
            }
            String idTemp = null;
            System.out.println("ESSAS SÃO OS EBOOKS COM O TÍTULO INFORMADO.");
            System.out.println("Idêntifique o ID do ebook que deseja remover e informe-o: ");
            idTemp = ValidarEntradaDeDados.nextInt(idTemp);
            id = Integer.parseInt(idTemp);
            if (id <= listaPegaRetorno.size() - 1) {
                Midia ebookRemover = listaPegaRetorno.get(id);
                if (gerenciador.remover(ebookRemover)) {
                    System.out.println("Removido com sucesso.");
                } else {
                    System.out.println("Não foi possivel remover.");
                }
            } else {
                System.out.println("ID inexistente. Tente novamente.");
            }
        } else {
            System.out.println("Ebook inexistente.");
        }
    }

    /**
     * Método que consulta o Ebook desejado
     */
    public void consultarMidia() {
        List<Midia> listaPegaRetorno;
        String tituloConsulta = null;
        System.out.println("Digite o título da midia que deseja consultar: ");
        tituloConsulta = Validação.ValidarEntradaDeDados.nextLine(tituloConsulta);
        listaPegaRetorno = gerenciador.consultarMidia(tituloConsulta);
        if (!listaPegaRetorno.isEmpty()) {
            gerenciador.ordenadorEbook(listaPegaRetorno);
            gerenciador.salvar();
            for (Midia midia : listaPegaRetorno) {
                System.out.println(midia.toString());
            }
        } else {
            System.out.println("Ebook inexistente.");
        }

    }

    /**
     * Método que ordena o ebook
     */
    public void ordenarMidia() {

        // lista = gerenciador.getListaMidia();
        System.out.println("Lista de Ebook ordenada com sucesso" + "\n");
        gerenciador.ordenadorEbook(gerenciador.getListaMidia());
        gerenciador.salvar();
    }

}
