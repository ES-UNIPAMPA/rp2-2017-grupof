/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Validação.ValidarEntradaDeDados;

/**
 *
 * @author roliv
 */
public class GUIMidia {
    
    protected String caminhoArquivo =  null, titulo = null, descricao = null,
            genero = null, autores = null, idioma = null, ano = null;
    
    public void criarMidia() {
        System.out.println("Digite o endereço do arquivo: ");
        this.caminhoArquivo = ValidarEntradaDeDados.nextLine();
        System.out.println("Digite o título: ");
        this.titulo = ValidarEntradaDeDados.nextLine();        
        System.out.println("Digite o gênero:");
        this.genero = ValidarEntradaDeDados.nextLine();
        System.out.println("Digite a descrição: ");
        this.descricao = ValidarEntradaDeDados.nextLine();
        System.out.println("Digite autores: ");
        this.autores = ValidarEntradaDeDados.nextLine();
        System.out.println("Digite o idioma: ");
        this.idioma = ValidarEntradaDeDados.nextLine();
        System.out.println("Digite o ano: ");
        this.ano = ValidarEntradaDeDados.nextInt();
        
    }
}
