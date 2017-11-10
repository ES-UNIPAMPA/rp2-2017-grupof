
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

    public GerenciadorMidia(List listaMidia) {
        GerenciadorMidia.listaMidia = listaMidia;

    }

    public boolean adicionarMidia(Midia novaMidia) {
        return listaMidia.add(novaMidia);
    }

    public boolean excluirMidia(String titulo) {
        for (int i = 0; i < listaMidia.size(); i++) {
            if (listaMidia.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                listaMidia.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean editarMidia(String titulo, Midia novaMidia) {
        for (int i = 0; i < listaMidia.size(); i++) {
            if (listaMidia.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                listaMidia.add(i, novaMidia);
                return true;
            }
        }
        return false;
    }

    public Midia consultarMidia(String titulo) {
        for (int i = 0; i < listaMidia.size(); i++) {
            if (listaMidia.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                return listaMidia.get(i);
            }
        }
        return null;
    }

    public boolean verificarMidia(String titulo) {
        for (int i = 0; i < listaMidia.size(); i++) {
            if (listaMidia.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }
}
