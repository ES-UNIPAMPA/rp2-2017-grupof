/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Midias.Midia;

/**
 *
 * @author Matheus Montanha
 */
public interface IMenu {

    public boolean criarMidia();

    public boolean removerMidia();

    public Midia consultarMidia();

    public boolean editarMidia();
}
