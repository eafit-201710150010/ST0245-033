package arbol;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author scastrillg
 */
public class Node {
    public Node left;
    public Node right;
    public String name;
    public String data;

    public Node(String d, String n) {
        data = d;
        name = n;
    }
}
