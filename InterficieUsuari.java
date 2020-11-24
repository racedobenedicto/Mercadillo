
package edu.upc.etsetb.poo.proyecto.iu;

import edu.upc.etsetb.poo.proyecto.dominio.Mercadillo;

public class InterficieUsuari {
    //Atribut
    public Mercadillo m;
    
    //main
    public static void main(String[] args){
        InterficieUsuari iu= new InterficieUsuari();
        iu.m.executa();
    }
    
    //Constructor
    public InterficieUsuari(){
        m = new Mercadillo(this);
    }
    
    //Mètode
    public void mostra(String s){
        System.out.print(s);
    }
}
