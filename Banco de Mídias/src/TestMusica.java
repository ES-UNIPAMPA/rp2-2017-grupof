/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dominio.CatalagoMusicas;
import dominio.Musica;

/**
 *
 * @author Matheus Montanha
 */
public class TestMusica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* public Musica(String CaminhoDoArquivo, String titulo, String genero, String idioma, String descricao, String autores, String ano, String interpretes, String duracao) {
        super(CaminhoDoArquivo, titulo, genero, idioma, descricao, autores, ano);
        this.interpretes = interpretes;
        this.duracao = duracao;
    }
         */
        String titulo = "Chorou";
        String genero = "Classica";
        String idioma = "Alemã";
        String descricao = "Otima";
        String autores = "Owhtriblo";
        String interpretes = "Omhtiskmo";
        String duracao = "3:90";
        String ano = "1997";
        String caminho = "c:\\Documentos\\RP2";
        Musica musica = new Musica(caminho, titulo, genero, idioma, descricao, autores, ano, interpretes, duracao);
/*
        String titulo2 = "Caralho";
        String genero2 = "Rock";
        String idioma2 = "Polonesa";
        String descricao2 = "Boa";
        String autores2 = "Nunca nem vi";
        String interpretes2 = "Paulo";
        String duracao2 = "2:80";
        String ano2 = "1880";
        String caminho2 = "c:\\Documentos\\RP2";
        Musica musica2 = new Musica(caminho2, titulo2, genero2, idioma2, descricao2, autores2, ano2, interpretes2, duracao2);
*/
        CatalagoMusicas catalagoMusica = new CatalagoMusicas();
        catalagoMusica.adicionar(musica.ArraytoString());
        //catalagoMusica.adicionar(musica2.ArraytoString());
        /*
        String[] editar = musica.ArraytoString();
        String original = editar[1];
        editar[1] = "Titulo editado";
        catalagoMusica.editar(editar, original);
         */
    }

}
