
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import Midias.Midia;
import java.util.List;

/**
 *
 * @author Matheus Montanha
 */
public class GerenciadorMidia {

    private static List<Midia> listaMidia;
/**
 * Método construtor para inicializar a list
 * @param listaMidia recebido para criar a list do tipo desejada
 */
    public GerenciadorMidia(List listaMidia) {
        GerenciadorMidia.listaMidia = listaMidia;

    }
/**
 * Método para adicionar uma nova midia
 * @param novaMidia midia a ser adicionada na lista
 * @return True caso foi adicionado, caso contrário, retorna False
 */
    public boolean adicionarMidia(Midia novaMidia) {
        return listaMidia.add(novaMidia);
    }
/**
 * Método para excluir uma mídia.
 * @param titulo saber qual midia deseja remover
 * @return True caso foi removido com sucesso, caso contrário, retorna False;
 */
    public boolean excluirMidia(String titulo) {
        for (int i = 0; i < listaMidia.size(); i++) {
            if (listaMidia.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                listaMidia.remove(i);
                return true;
            }
        }
        return false;
    }
/**
 * Método para editar uma musica existente
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
 * @param titulo para saber qual musica deve retornar
 * @return retorna a midia desejada
 */
    public Midia consultarMidia(String titulo) {
        for (int i = 0; i < listaMidia.size(); i++) {
            if (listaMidia.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                return listaMidia.get(i);
            }
        }
        return null;
    }
/**
 * Método para verificar se uma determinada midia existe 
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
}
