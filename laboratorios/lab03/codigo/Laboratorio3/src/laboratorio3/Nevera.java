/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio3;

/**
 *
 * @author ljpalaciom
 */
public class Nevera {
    private final int codigo;
    private final String marca;

    public Nevera(int codigo, String marca) {
        this.codigo = codigo;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return  "(" + codigo + "," + marca + ")";
    }
    
    
}
