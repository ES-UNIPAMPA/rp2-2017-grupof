
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import Midias.Ebook;
import Midias.Midia;
import Midias.Musica;
import Midias.Podcast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Montanha
 */
public class GerenciadorMidia {

    private ArrayList<Midia> listaMidia;
    private final String caminho;

    /**
     * Método construtor para inicializar a list
     *
     * @param caminho
     */
    public GerenciadorMidia(String caminho) {
        this.listaMidia = new ArrayList();
        this.caminho = caminho;
    }

    /**
     * Método para adicionar uma nova midia
     *
     * @param novaMidia midia a ser adicionada na lista
     * @return True caso foi adicionado, caso contrário, retorna False
     */
    public boolean adicionarMidia(Midia novaMidia) {
        if (novaMidia != null) {
            listaMidia.add(novaMidia);
            return salvar();
        }
        return false;
    }

    /**
     * Método para excluir uma mídia.
     *
     * @param midias
     * @return True caso foi removido com sucesso, caso contrário, retorna
     * False;
     */
    public boolean remover(Midia midias) {
        for (Midia midia : listaMidia) {
            if (midia.equals(midias)) {
                listaMidia.remove(midia);
                return salvar();
            }
        }
        return false;
    }

    /**
     * Método para editar uma musica existente
     *
     * @param titulo para saber qual musica que deseja editar
     * @param novaMidia recebe a nova mídia já editada
     * @return True caso foi editado com sucesso, caso contrário, retorna False
     */
    public boolean editarMidia(Midia novaMidia) {
        for (int i = 0; i < listaMidia.size(); i++) {
            if (listaMidia.get(i).equals(novaMidia)) {
                listaMidia.set(i, novaMidia);
            }
        }
        salvar();
        return true;
    }

    /**
     * Método para consultar uma mídia desejada
     *
     * @param midiaTitulo
     * @return retorna uma String com a midia desejada
     */
    public List consultarMidia(String midiaTitulo) {
        ArrayList<Midia> listaRetorno = new ArrayList<>();
        for (Midia midia : listaMidia) {
            if (midia.getTitulo().equalsIgnoreCase(midiaTitulo)) {
                listaRetorno.add(midia);
            }
        }
        return listaRetorno;
    }

    /**
     * Método para verificar se uma determinada midia existe
     *
     * @param titulo recebido para procurar a midia desejada
     * @return True caso exista a mídia, caso contrário, retorna false
     */
    public boolean verificarMidia(String titulo) {
        for (int i = 0; i < listaMidia.size(); i++) {
            if (listaMidia.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList retornaMidias() {
        ArrayList<Midia> listaTodos = new ArrayList<>();
        for (int i = 0; i < listaMidia.size(); i++) {
            listaTodos.add(listaMidia.get(i));
        }
        return listaTodos;
    }

    public boolean salvar() {
        String novaLinha = System.getProperty("line.separator");
        try {
            FileWriter escritorArquivo = new FileWriter(new File(caminho));
            escritorArquivo.write(String.valueOf(listaMidia.size()));
            escritorArquivo.write(novaLinha + novaLinha);
            for (Midia midia : listaMidia) {
                escritorArquivo.write(midia.toFile());
                escritorArquivo.write(novaLinha + " " + novaLinha);
            }
            escritorArquivo.close();

        } catch (IOException ex) {
            Logger.getLogger(GerenciadorMidia.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean carregar() {
        File arquivo;
        arquivo = new File(caminho);
        if (arquivo.exists()) {
            ArrayList<String> dados = new ArrayList();
            try {
                FileReader fileReader = new FileReader(arquivo);
                BufferedReader buffR = new BufferedReader(fileReader);
                String linhas;
                buffR.readLine();
                buffR.readLine();
                while ((linhas = buffR.readLine()) != null) {
                    if (!linhas.equals(" ")) {
                        dados.add(linhas);
                    } else {
                        montarMidia(dados, arquivo);
                    }
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(GerenciadorMidia.class
                        .getName()).log(Level.SEVERE, null, ex);
                return false;

            } catch (IOException ex) {
                Logger.getLogger(GerenciadorMidia.class
                        .getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }

    private void montarMidia(ArrayList<String> dados, File arquivo) {

        switch (arquivo.getName()) {
            case "ebook.txt":
                montarEbook(dados);
                break;
            case "musica.txt":
                montarMusica(dados);
                break;
            case "podcast.txt":
                montarPodcast(dados);
                break;
            default:
                System.out.println("Nome de arquivo inválido!");
                break;
        }

    }

    private void montarEbook(ArrayList<String> dados) {
        Midia novo = new Ebook(dados.get(0),
                dados.get(1),
                dados.get(2),
                dados.get(3),
                dados.get(4),
                dados.get(5),
                dados.get(6),
                dados.get(7),
                dados.get(8),
                dados.get(9));
        adicionarMidia(novo);

    }

    private void montarMusica(ArrayList<String> dados) {
        Midia novo = new Musica(dados.get(0),
                dados.get(1),
                dados.get(2),
                dados.get(3),
                dados.get(4),
                dados.get(5),
                dados.get(6),
                dados.get(7),
                dados.get(8));
        listaMidia.add(novo);
        dados.clear();
    }

    private void montarPodcast(ArrayList<String> dados) {
        Midia novo = new Podcast(dados.get(0),
                dados.get(1),
                dados.get(2),
                dados.get(3),
                dados.get(4),
                dados.get(5),
                dados.get(6));
        adicionarMidia(novo);

    }

    public void ordenadorMusica(List listaMidia) {
        boolean houveTroca;
        do {
            houveTroca = false;
            for (int i = 0; i < listaMidia.size() - 2; i++) {
                Musica musica = (Musica) listaMidia.get(i);
                Musica musica2 = (Musica) listaMidia.get(i + 1);
                if (musica.compareTo(musica2) > 0) {
                    Musica aux = (Musica) listaMidia.get(i);
                    listaMidia.set(i, listaMidia.get(i + 1));
                    listaMidia.set(i + 1, aux);
                    houveTroca = true;
                }
            }
            if (!houveTroca) {
                break;
            }
            for (int i = listaMidia.size() - 2; i >= 0; i--) {
                Musica musica = (Musica) listaMidia.get(i);
                Musica musica2 = (Musica) listaMidia.get(i + 1);
                if (musica.compareTo(musica2) > 0) {
                    Musica aux = (Musica) listaMidia.get(i);
                    listaMidia.set(i, listaMidia.get(i + 1));
                    listaMidia.set(i + 1, aux);
                    houveTroca = true;
                }
            }

        } while (houveTroca);
    }

    public List exibir() {
        return listaMidia;
    }
}
