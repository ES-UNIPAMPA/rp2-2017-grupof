package dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roliv
 */
public class Musica extends Midia {
    String interpretes;
    String duracao;
    String quantidade;
    
    public Musica(String CaminhoDoArquivo, String titulo, String genero, String idioma, String descricao, String autores, String ano, String interpretes, String duracao, String quantidade) {
        super(CaminhoDoArquivo, titulo, genero, idioma, descricao, autores, ano);
        this.interpretes = interpretes;
        this.duracao = duracao;
        this.quantidade = quantidade;
    }
    
}
