/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validação;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Matheus Montanha
 */
public class ValidarEntradaDeDados {
    
    public boolean validarTextos(String titulo) {
        if (titulo == null || " ".equals(titulo) || "".equals(titulo)) {
            return false;
        } else {
            Pattern pattern = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(titulo);
            if (matcher.find()) {
                return false;
            }
        }
        return true;
    }
}
