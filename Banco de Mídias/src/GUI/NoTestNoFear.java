package GUI;

import dominio.CatalogoEbooks;
import Midias.Ebook;
import Midias.Midia;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author roliv
 */
public class NoTestNoFear {

    public static void main(String[] args) {
        String local = "local 1";
        String titulo2 = "Vita";
        String editora = "darksiders";
        String numPaginas = "453";
        String CaminhoDoArquivo = "c:\\just\\works";
        String titulo = "Todd Howard";
        String genero = "SweetLies";
        String idioma = "Ingles";
        String descricao = "It just works!";
        String autores = "Bethesda";
        String ano = "2011";

        Ebook eb1 = new Ebook(CaminhoDoArquivo, titulo, descricao, genero, autores, idioma, numPaginas, editora, local, ano);
        Ebook eb2 = new Ebook(CaminhoDoArquivo, titulo2, descricao, genero, autores, idioma, numPaginas, editora, local, ano);
        CatalogoEbooks catalogo = new CatalogoEbooks();

        catalogo.adicionar(eb1.toArrayString());
        catalogo.adicionar(eb2.toArrayString());

        String[] editado = eb1.toArrayString();
        String tituloOriginal = editado[1];
        editado[1] = "shablauuuuu";
        editado[0] = "c:\\just\\notyyyy";


        catalogo.editar(editado, tituloOriginal);

        
       // catalogo.editar(editado, tituloOriginal);
        
       catalogo.remover("Todd Howard");


       // catalogo.remover("shablauuuuu");

        //catalogo.carregar();

//        List<Midia> lista = catalogo.getListaMidias();
//        boolean teste = true;
    }
}
