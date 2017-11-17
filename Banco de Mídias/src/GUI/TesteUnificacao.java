/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Midias.Ebook;
import Midias.Musica;
import dominio.CatalagoMidia;
import dominio.CatalogoEbooks;
import java.util.ArrayList;

/**
 *
 * @author Matheus Montanha
 */
public class TesteUnificacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String local = "local 1";
        String titulo2 = "Vita";
        String editora = "darksiders";
        String numPaginas = "453";
        String CaminhoDoArquivo = "c:\\just\\works";
        String titulo = "Todd Howard";
        String genero = "SweetLies";
        String idioma = "Polonesa";
        String descricao = "Troquei!";
        String autores = "Bethesda";
        String ano = "2011";

        Musica eb1 = new Musica(CaminhoDoArquivo, titulo, genero, idioma, descricao, autores, ano, autores, descricao);
        Musica eb2 = new Musica(CaminhoDoArquivo, titulo, genero, idioma, descricao, autores, ano, autores, descricao);
        CatalagoMidia catalago = new CatalagoMidia(new ArrayList());
        catalago.adicionar(eb1.ArraytoString(), eb1);
        catalago.adicionar(eb2.ArraytoString(), eb2);
        //Musica eb1 = null;
        //catalago.remover("Todd Howard");
        //catalago.carregar(eb1);
        //String[] editado = eb2.ArraytoString();
        // String tituloEditado = editado[1];
        //editado[1] = "Caralho";
        //catalago.editar(editado, tituloEditado);
    }

}
