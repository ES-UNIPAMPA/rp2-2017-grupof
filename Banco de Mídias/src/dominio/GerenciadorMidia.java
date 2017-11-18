
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import Midias.Ebook;
import Midias.Midia;
import Midias.Musica;
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

    private static List<Midia> listaMidia;

    /**
     * Método construtor para inicializar a list
     *
     * @param listaMidia recebido para criar a list do tipo desejada
     */
    public GerenciadorMidia(List listaMidia) {
        GerenciadorMidia.listaMidia = listaMidia;

    }

    /**
     * Método para adicionar uma nova midia
     *
     * @param novaMidia midia a ser adicionada na lista
     * @param caminho
     * @return True caso foi adicionado, caso contrário, retorna False
     */
    public boolean adicionarMidia(Midia novaMidia, String caminho) {
        listaMidia.add(novaMidia);
        return salvar(novaMidia, caminho);
    }

    /**
     * Método para excluir uma mídia.
     *
     * @param titulo saber qual midia deseja remover
     * @return True caso foi removido com sucesso, caso contrário, retorna
     * False;
     */
    public boolean remover(String titulo, String caminho) {
        Ebook novo = new Ebook(titulo);
        listaMidia.remove(novo);
        return salvar(novo, caminho);
    }

    /**
     * Método para editar uma musica existente
     *
     * @param titulo para saber qual musica que deseja editar
     * @param novaMidia recebe a nova mídia já editada
     * @return True caso foi editado com sucesso, caso contrário, retorna False
     */
    public boolean editarMidia(String titulo, Midia novaMidia) {
        for (int i = 0; i < listaMidia.size(); i++) {
            if (listaMidia.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                listaMidia.set(i, novaMidia);
                return true;
            }
        }
        return false;
    }

    /**
     * Método para consultar uma mídia desejada
     *
     * @param titulo para saber qual musica deve retornar
     * @return retorna uma String com a midia desejada
     */
    public String consultarMidia(String titulo) {
        //ArrayList<Midia> consulta = new ArrayList<>();
        String dados = null;
        for (int i = 0; i < listaMidia.size(); i++) {
            if (listaMidia.get(i).getTitulo().equals(titulo)) {
                dados = listaMidia.get(i).toString();
            }
        }
        return dados;
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

    public boolean salvar(Midia midias, String caminho) {
        String novaLinha = System.getProperty("line.separator");
        try {
            FileWriter escritorArquivo = new FileWriter(new File(caminho));
            escritorArquivo.write(String.valueOf(listaMidia.size()));
            escritorArquivo.write(novaLinha + novaLinha);
            String[] dados;
            for (Midia midia : listaMidia) {
                Ebook ebook = (Ebook) midia;
                dados = ebook.toArrayString();
                for (int i = 0; i < dados.length; i++) {
                    escritorArquivo.write(dados[i] + novaLinha);
                }
                escritorArquivo.write(novaLinha);
            }
            escritorArquivo.close();
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorMidia.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean carregar(Midia midia, String caminho) {
        listaMidia = new ArrayList();
        File arquivo = new File(caminho);
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader buffR = new BufferedReader(fileReader);
            String linhas;
            String[] dados = new String[10];
            int cont = 0;
            buffR.readLine();
            buffR.readLine();
            while ((linhas = buffR.readLine()) != null) {
                if (!linhas.equals("")) {
                    dados[cont] = linhas;
                    cont++;
                } else {
                    adicionarMidia(midia, caminho);
                    cont = 0;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerenciadorMidia.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorMidia.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

}
