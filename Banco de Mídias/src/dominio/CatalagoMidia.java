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
public class CatalagoMidia {

    private static List<Midia> listaMidia;
    String novaLinha = System.getProperty("line.separator");

    public CatalagoMidia(List lista) {
        CatalagoMidia.listaMidia = lista;
    }

    public int tamanhoLista() {
        return listaMidia.size();
    }
    public boolean editar(String[] dados, String tituloOriginal) {
        int idOriginal = listaMidia.indexOf(new Midia(tituloOriginal));
        Midia procurada = listaMidia.get(idOriginal);
        if (procurada instanceof Musica) {
            Musica musica = (Musica) procurada;
            musica.setCaminhoDoArquivo(dados[0]);
            musica.setTitulo(dados[1]);
            musica.setGenero(dados[2]);
            musica.setIdioma(dados[3]);
            musica.setDescricao(dados[4]);
            musica.setAutores(dados[5]);
            musica.setAno(dados[6]);
            musica.setInterpretes(dados[7]);
            musica.setDuracao(dados[8]);
         //   return salvar(musica);
        }
        if (procurada instanceof Ebook) {
            Ebook original = (Ebook) procurada;
            original.setCaminhoDoArquivo(dados[0]);
            original.setTitulo(dados[1]);
            original.setDescricao(dados[2]);
            original.setGenero(dados[3]);
            original.setAutores(dados[4]);
            original.setIdioma(dados[5]);
            original.setNumPaginas(dados[6]);
            original.setEditora(dados[7]);
            original.setLocal(dados[8]);
            original.setAno(dados[9]);
          //  return salvar(original);
        }
        return false;
    }

    public Midia buscar(String titulo) {
        int idProcurado = listaMidia.indexOf(new Midia(titulo));
        Midia procurada = listaMidia.get(idProcurado);
        return procurada;
    }

}
