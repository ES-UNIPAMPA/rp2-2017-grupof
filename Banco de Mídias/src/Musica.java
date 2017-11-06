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
    
    public Musica(String CaminhoDoArquivo, String titulo, String genero, String idioma, String descricao, String autores, int ano, String interpretes, String duracao) {
        super(CaminhoDoArquivo, titulo, genero, idioma, descricao, autores, ano);
        this.interpretes = interpretes;
        this.duracao = duracao;
    }
    
}
