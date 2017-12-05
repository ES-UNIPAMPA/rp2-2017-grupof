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
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Matheus Montanha
 */
public class GUIMusica extends GUIMidia implements IMenu {

    final String camArquivoTxT = "src/Arquivos/musica.txt";
    dominio.GerenciadorMidia gerenciador;
    static String caminho = new java.io.File(".").getAbsolutePath();

    /**
     * Método construtor do menu musica contendo o caminho do arquivo txt da
     * musica
     *
     */
    public GUIMusica() {
        gerenciador = new GerenciadorMidia(camArquivoTxT);
        gerenciador.carregar();
    }

    /**
     * Método que mostra as opções disponíveis do software
     */
    public void MenuMusica() {
        Scanner e = new Scanner(System.in);
        int opcao = Integer.MIN_VALUE;
        do {
            System.out.println("1 - Criar musica.");
            System.out.println("2 - Excluir musica.");
            System.out.println("3 - Consultar musica.");
            System.out.println("4 - Editar musica.");
            System.out.println("5 - Voltar ao menu principal");
            System.out.println("6 - Exibir todas as mídias.");
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
                case 6:
                    exibir();
                    break;
                default:
                    System.out.println("Opção inválida. Digite o número da opção desejada.");
                    break;
            }
        } while (opcao != 5);
    }

    /**
     * Método que recebe as informações da musica e o cria.
     */
    @Override
    public void criarMidia() {
        Scanner e = new Scanner(System.in);
        String anoCriar = null, interpretes = null, duracao = null, tituloCriar = null, descricaoCriar = null,
                generoCriar = null, autoresCriar = null, idiomaCriar = null;
        System.out.println("Digite o título: ");
        tituloCriar = ValidarEntradaDeDados.nextLine(tituloCriar);
        System.out.println("Digite o gênero:");
        generoCriar = ValidarEntradaDeDados.nextLine(generoCriar);
        System.out.println("Digite a descrição: ");
        descricaoCriar = ValidarEntradaDeDados.nextLine(descricaoCriar);
        System.out.println("Digite autores: ");
        autoresCriar = ValidarEntradaDeDados.nextLine(autoresCriar);
        System.out.println("Digite o idioma: ");
        idiomaCriar = ValidarEntradaDeDados.nextLine(idiomaCriar);
        System.out.println("Digite o ano da musica: ");
        anoCriar = ValidarEntradaDeDados.nextInt(anoCriar);
        System.out.println("Digite os interpretes da musica: ");
        interpretes = ValidarEntradaDeDados.nextLine(interpretes);
        System.out.println("Digite a duração da sua musica: ");
        duracao = ValidarEntradaDeDados.nextDouble(duracao);
        Musica musica = new Musica(caminho, tituloCriar, generoCriar, idiomaCriar, descricaoCriar, autoresCriar, anoCriar, interpretes, duracao);
        if (gerenciador.adicionarMidia(musica)) {
            System.out.println("Registrado com sucesos.");
        }
    }

    /**
     * Método que edita a música desejada.
     *
     * @return True caso editado. Caso contrário, retorna False.
     */
    @Override
    public boolean editarMidia() {
        List<Midia> listaRetorno;
        Scanner e = new Scanner(System.in);
        boolean ficar;
        int id;
        String tituloEditar = null, generoEditar = null, idiomaEditar = null, descricaoEditar = null, autoresEditar = null, interpretesEditar = null, duracaoEditar = null, anoEditar = null;
        System.out.println("Digite o título da musica que deseja editar: ");
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
            System.out.println("ESSAS SÃO AS MUSICAS COM O TÍTULO INFORMADO.");
            System.out.println("Idêntifique o ID da musica que deseja editar e informe-o: ");
            idTemp = ValidarEntradaDeDados.nextInt(idTemp);
            id = Integer.parseInt(idTemp);
            if (id <= listaRetorno.size() - 1) {
                Musica musica = (Musica) listaRetorno.get(id);
                System.out.println("Digite o novo titulo da musica: ");
                System.out.println("[TECLE ENTER PARA IGNORAR]");
                tituloEditar = ValidarEntradaDeDados.entradaEnterTexto(tituloEditar);
                if (tituloEditar.equals("")); else {
                    musica.setTitulo(tituloEditar);
                }
                System.out.println("Digite o novo genero da musica: ");
                System.out.println("[TECLE ENTER PARA IGNORAR]");
                generoEditar = ValidarEntradaDeDados.entradaEnterTexto(generoEditar);
                if (generoEditar.equals("")); else {
                    musica.setGenero(generoEditar);
                }
                System.out.println("Digite o novo idioma da musica: ");
                System.out.println("[TECLE ENTER PARA IGNORAR]");
                idiomaEditar = ValidarEntradaDeDados.entradaEnterTexto(idiomaEditar);
                if (idiomaEditar.equals("")); else {
                    musica.setIdioma(idiomaEditar);
                }
                System.out.println("Digite a nova descrição da musica: ");
                System.out.println("[TECLE ENTER PARA IGNORAR]");
                descricaoEditar = ValidarEntradaDeDados.entradaEnterTexto(descricaoEditar);
                if (descricaoEditar.equals("")); else {
                    musica.setDescricao(descricaoEditar);
                }
                System.out.println("Digite a nova duração da musica: ");
                System.out.println("[TECLE ENTER PARA IGNORAR]");
                duracaoEditar = ValidarEntradaDeDados.entradaEnterNumero(duracaoEditar);
                if (duracaoEditar.equals("")); else {
                    musica.setDuracao(duracaoEditar);
                }
                System.out.println("Digite os novos autores da musica: ");
                System.out.println("[TECLE ENTER PARA IGNORAR]");
                autoresEditar = ValidarEntradaDeDados.entradaEnterTexto(autoresEditar);
                if (autoresEditar.equals("")); else {
                    musica.setAutores(autoresEditar);
                }
                System.out.println("Digite o novo interprete: ");
                System.out.println("[TECLE ENTER PARA IGNORAR]");
                interpretesEditar = ValidarEntradaDeDados.entradaEnterTexto(interpretesEditar);
                if (interpretesEditar.equals("")); else {
                    musica.setInterpretes(interpretesEditar);
                }
                System.out.println("Digite o novo ano: ");
                System.out.println("[TECLE ENTER PARA IGNORAR]");
                anoEditar = ValidarEntradaDeDados.entradaEnterNumero(anoEditar);
                if (anoEditar.equals("")); else {
                    musica.setAno(anoEditar);
                }
                if (gerenciador.editarMidia(musica)) {
                    System.out.println("Editado com sucesso.");
                    return true;
                } else {
                    System.out.println("Não foi possivel editar sua musica.");
                    return false;
                }
            } else {
                System.out.println("ID infomado inexistente.");
            }
        } else {
            System.out.println("Musica inexistente.");
            return false;
        }
        return false;
    }

    /**
     * Método que remove a musica desejada
     */
    public void removerMidia() {
        List<Midia> listaPegaRetorno;
        Scanner e = new Scanner(System.in);
        String tituloRemover = null;
        int id;
        System.out.println("Digite o título da musica que deseja remover: ");
        tituloRemover = Validação.ValidarEntradaDeDados.nextLine(tituloRemover);
        listaPegaRetorno = gerenciador.consultarMidia(tituloRemover);
        int contador = 0;
        if (!listaPegaRetorno.isEmpty()) {
            for (Midia midia : listaPegaRetorno) {
                System.out.println("ID: " + contador + "\n" + midia.toString());
                contador++;
            }
            String idTemp = null;
            System.out.println("ESSAS SÃO AS MUSICAS COM O TÍTULO INFORMADO.");
            System.out.println("Idêntifique o ID da musica que deseja remover e informe-o: ");
            idTemp = ValidarEntradaDeDados.nextInt(idTemp);
            id = Integer.parseInt(idTemp);
            if (id <= listaPegaRetorno.size() - 1) {
                Midia musicaRemover = listaPegaRetorno.get(id);
                if (gerenciador.remover(musicaRemover)) {
                    System.out.println("Removido com sucesso.");
                } else {
                    System.out.println("Não foi possivel remover.");
                }
            } else {
                System.out.println("ID inexistente. Tente novamente.");
            }
        } else {
            System.out.println("Musica inexistente.");
        }
    }

    /**
     * Método que consulta as músicas desejadas
     */
    public void consultarMidia() {
        Scanner e = new Scanner(System.in);
        List<Midia> listaPegaRetorno;
        String tituloConsulta = null;
        System.out.println("Digite o título da midia que deseja consultar: ");
        tituloConsulta = Validação.ValidarEntradaDeDados.nextLine(tituloConsulta);
        listaPegaRetorno = gerenciador.consultarMidia(tituloConsulta);
        if (!listaPegaRetorno.isEmpty()) {
            gerenciador.ordenadorMusica(listaPegaRetorno);
            for (Midia midia : listaPegaRetorno) {
                System.out.println(midia.toString());
            }
        } else {
            System.out.println("Musica inexistente.");
        }
    }

    /**
     * Método que exibi todas as músicas.
     */
    public void exibir() {
        List<Midia> listaRetorno;
        listaRetorno = gerenciador.exibir();
        gerenciador.ordenadorMusica(listaRetorno);
        for (Midia midia : listaRetorno) {
            System.out.println(midia.toString());
        }
    }
}
