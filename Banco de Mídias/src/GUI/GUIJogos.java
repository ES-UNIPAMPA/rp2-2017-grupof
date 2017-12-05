/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Validação.ValidarEntradaDeDados;
import dominio.GerenciadorMidia;
import Midias.Midia;
import Midias.Jogos;
import java.util.List;

/**
 *
 * @author roliv
 */
public class GUIJogos extends GUIMidia implements IMenu {

    GerenciadorMidia gerenciador;
    final String caminho = "src/Arquivos/jogos.txt";

    /**
     * Método que cria o gerenciador contendo o caminho do arquivo txt
     */
    public GUIJogos() {
        gerenciador = new GerenciadorMidia(caminho);
        gerenciador.carregar();
    }

    /**
     * Método contendo as opções disponíveis no menu Jogos
     */
    public void MenuJogos() {

        int opcao = -1;
        do {
            System.out.println("1 - Adicionar jogo.");
            System.out.println("2 - Excluir jogo.");
            System.out.println("3 - Consultar jogo.");
            System.out.println("4 - Editar jogo.");
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
                    //ordenarMidia();
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

    /**
     * Método que recebe e cria um Ebook
     */
    @Override
    public void criarMidia() {
        super.criarMidia();
        String numJogadores = null, suporteRede = null, empresa = null;

        System.out.println("Digite o número de páginas: ");
        numJogadores = ValidarEntradaDeDados.nextInt(numJogadores);
        System.out.println("Digite o nome da editora: ");
        suporteRede = ValidarEntradaDeDados.nextLine(suporteRede);
        System.out.println("Digite o local/país:");
        empresa = ValidarEntradaDeDados.nextLine(empresa);

        Midia jogo = new Jogos(caminhoArquivo, titulo, descricao, genero, autores, idioma, ano, numJogadores, suporteRede, empresa);
        gerenciador.adicionarMidia(jogo);
        System.out.println("Jogo adicionado com sucesso!");
    }

    /**
     * Método que edita o jogo
     *
     * @return True caso editado. Caso contrário, retorna False
     */
    public boolean editarMidia() {
        List<Midia> listaRetorno;
        int id;
        String tituloEditar = null, generoEditar = null, idiomaEditar = null, descricaoEditar = null,
                autoresEditar = null, numJogadoresEditar = null, suporteRedeEditar = null, empresaEditar = null,
                anoEditar = null;
        System.out.println("Digite o título do Jogo que deseja editar: ");
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
            System.out.println("ESSES SÃO OS JOGOS COM O TÍTULO INFORMADO.");
            System.out.println("Idêntifique o ID do jogo que deseja editar e informe-o: ");
            idTemp = ValidarEntradaDeDados.nextInt(idTemp);
            id = Integer.parseInt(idTemp);
            if (id <= listaRetorno.size() - 1) {
                Jogos jogo = (Jogos) listaRetorno.get(id);
                if (gerenciador.verificarMidia(tituloConsultaEditar)) {
                    System.out.println("Digite o novo titulo do jogo: ");
                    System.out.println("[TECLE ENTER PARA IGNORAR]");
                    tituloEditar = ValidarEntradaDeDados.enterTexto(tituloEditar);
                    if (tituloEditar.equals("")); else {
                        jogo.setTitulo(tituloEditar);
                    }
                    System.out.println("Digite o novo genero do jogo: ");
                    System.out.println("[TECLE ENTER PARA IGNORAR]");
                    generoEditar = ValidarEntradaDeDados.enterTexto(generoEditar);
                    if (generoEditar.equals("")); else {
                        jogo.setGenero(generoEditar);
                    }
                    System.out.println("Digite o novo idioma do jogo: ");
                    System.out.println("[TECLE ENTER PARA IGNORAR]");
                    idiomaEditar = ValidarEntradaDeDados.enterTexto(idiomaEditar);
                    if (idiomaEditar.equals("")); else {
                        jogo.setIdioma(idiomaEditar);
                    }
                    System.out.println("Digite a nova descrição do jogo: ");
                    System.out.println("[TECLE ENTER PARA IGNORAR]");
                    descricaoEditar = ValidarEntradaDeDados.enterTexto(descricaoEditar);
                    if (descricaoEditar.equals("")); else {
                        jogo.setDescricao(descricaoEditar);
                    }
                    System.out.println("Digite o novo número de páginas do jogo: ");
                    System.out.println("[TECLE ENTER PARA IGNORAR]");
                    numJogadoresEditar = ValidarEntradaDeDados.enterNumero(numJogadoresEditar);
                    if (numJogadoresEditar.equals("")); else {
                        jogo.setNumJogadores(numJogadoresEditar);
                    }
                    System.out.println("Digite a nova editora do jogo: ");
                    System.out.println("[TECLE ENTER PARA IGNORAR]");
                    suporteRedeEditar = ValidarEntradaDeDados.enterNumero(suporteRedeEditar);
                    if (suporteRedeEditar.equals("")); else {
                        jogo.setSuporteRede(suporteRedeEditar);
                    }
                    System.out.println("Digite os novos autores do jogo: ");
                    System.out.println("[TECLE ENTER PARA IGNORAR]");
                    autoresEditar = ValidarEntradaDeDados.enterTexto(autoresEditar);
                    if (autoresEditar.equals("")); else {
                        jogo.setAutores(autoresEditar);
                    }
                    System.out.println("Digite o novo local: ");
                    System.out.println("[TECLE ENTER PARA IGNORAR]");
                    empresaEditar = ValidarEntradaDeDados.enterTexto(empresaEditar);
                    if (empresaEditar.equals("")); else {
                        jogo.setEmpresa(empresaEditar);
                    }
                    System.out.println("Digite o novo ano: ");
                    System.out.println("[TECLE ENTER PARA IGNORAR]");
                    anoEditar = ValidarEntradaDeDados.enterNumero(anoEditar);
                    if (anoEditar.equals("")); else {
                        jogo.setAno(anoEditar);
                    }
                }
                if (gerenciador.editarMidia(jogo)) {
                    System.out.println("Editado com sucesso.");
                    return true;
                } else {
                    System.out.println("Não foi possivel editar seu jogo.");
                    return false;
                }
            } else {
                System.out.println("ID infomado inexistente.");
            }
        } else {
            System.out.println("Jogo inexistente.");
            return false;
        }
        return false;
    }

    /**
     * Método que remove o Jogo desejado
     */
    public void removerMidia() {
        List<Midia> listaPegaRetorno;
        String tituloRemover = null;
        int id;
        System.out.println("Digite o título do jogo que deseja remover: ");
        tituloRemover = Validação.ValidarEntradaDeDados.nextLine(tituloRemover);
        listaPegaRetorno = gerenciador.consultarMidia(tituloRemover);
        int contador = 0;
        if (!listaPegaRetorno.isEmpty()) {
            for (Midia midia : listaPegaRetorno) {
                System.out.println("ID: " + contador + "\n" + midia.toString());
                contador++;
            }
            String idTemp = null;
            System.out.println("ESSAS SÃO OS JOGOS COM O TÍTULO INFORMADO.");
            System.out.println("Idêntifique o ID do jogo que deseja remover e informe-o: ");
            idTemp = ValidarEntradaDeDados.nextInt(idTemp);
            id = Integer.parseInt(idTemp);
            if (id <= listaPegaRetorno.size() - 1) {
                Midia jogoRemover = listaPegaRetorno.get(id);
                if (gerenciador.remover(jogoRemover)) {
                    System.out.println("Removido com sucesso.");
                } else {
                    System.out.println("Não foi possivel remover.");
                }
            } else {
                System.out.println("ID inexistente. Tente novamente.");
            }
        } else {
            System.out.println("Jogo inexistente.");
        }
    }

    /**
     * Método que consulta o Jogo desejado
     */
    public void consultarMidia() {
        List<Midia> listaPegaRetorno;
        String tituloConsulta = null;
        System.out.println("Digite o título da midia que deseja consultar: ");
        tituloConsulta = Validação.ValidarEntradaDeDados.nextLine(tituloConsulta);
        listaPegaRetorno = gerenciador.consultarMidia(tituloConsulta);
        if (!listaPegaRetorno.isEmpty()) {
            gerenciador.ordenadorEbook(listaPegaRetorno);
            for (Midia midia : listaPegaRetorno) {
                System.out.println(midia.toString());
            }
        } else {
            System.out.println("Jogo inexistente.");
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
