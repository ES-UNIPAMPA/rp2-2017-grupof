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
import java.util.ArrayList;
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
    List<Musica> listaRetorno = new ArrayList<>();

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
        /*
        listaRetorno.add(musica);
        if (listaRetorno.size() > 2) {
            gerenciador.ordenadorMusica(listaRetorno);
            System.out.println(listaRetorno.toString());
        }
         */

    }

    @Override
    public boolean editarMidia() {
        Scanner e = new Scanner(System.in);
        boolean ficar;
        String tituloEditar = null, generoEditar = null, idiomaEditar = null, descricaoEditar = null, autoresEditar = null, interpretesEditar = null, duracaoEditar = null, anoEditar = null;
        System.out.println("Digite o título da musica que deseja editar: ");
        String tituloConsultaEditar = null;
        tituloConsultaEditar = ValidarEntradaDeDados.nextLine(tituloConsultaEditar);
        Musica musica = (Musica) gerenciador.consultarMidia(tituloConsultaEditar);
        if (gerenciador.verificarMidia(tituloConsultaEditar)) {
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
        }
        if (gerenciador.editarMidia(tituloConsultaEditar, musica)) {
            System.out.println("Editado com sucesso.");
            return true;
        }
        return false;
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
