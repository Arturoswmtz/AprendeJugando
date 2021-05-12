/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliar;

import java.util.Random;

/**
 *
 * @author Arturo 
 */

//parte donde crear las posiciones de las cartas
public class LogicaJuego {
    
    public int[] getCardNumbers() {
        
        int[] numbers = new int[8];
        int count = 0;
        
        while(count < 8) {
            Random r = new Random();
            int na = r.nextInt(8) + 1;
            int nvr = 0;
            
            for (int i = 0; i < 8; i++) {
                if(numbers[i] == na) {
                    nvr++;
                }
            }
            if(nvr < 1) {
                numbers[count] = na;
                count++;
            }//fin
            
        }
        
        
        return numbers;
    }
            
}
