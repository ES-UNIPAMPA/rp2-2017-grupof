package Midias;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AllissonChervenski
 */
public class Podcast extends Midia {
    
    public Podcast(String CaminhoDoArquivo, String titulo, String genero, String idioma, String descricao, String autores, String ano) {
        super(CaminhoDoArquivo, titulo, genero, idioma, descricao, autores, ano);
    }
    public Podcast(String titulo){
    super(titulo);
    
    }
    public String[] toArrayString(){
        String[] dados = new String[7];
        dados[0] = this.CaminhoDoArquivo;
        dados[1] = this.titulo;
        dados[2] = this.descricao;
        dados[3] = this.genero;
        dados[4] = this.autores;
        dados[5] = this.idioma;
        dados[6] = this.ano;
        return dados;
    }
    
    @Override
    public boolean equals(Object o) {
        Podcast outroPodcast = (Podcast) o;
        return this.getTitulo().equals(outroPodcast.getTitulo());
    }
}
