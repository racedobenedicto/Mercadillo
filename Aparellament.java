
package edu.upc.etsetb.poo.proyecto.dominio;

import java.util.List;

public class Aparellament {
    //Atributs
    private String descripcio;
    Mercader primer;
    Mercader segon;
    
    //Constructor
    public Aparellament(Mercader primer, Mercader segon){
        this.primer=primer;
        this.segon=segon;
        this.descripcio="";        
    }
    
    //Métodes
    public int realitzaTransaccions(){
        List <Recurs> l1, l2;
        int transaccions=0;
        l1=Duplicats.trobaDuplicats(primer.getNecessitats(), segon.getBens());
        l2=Duplicats.trobaDuplicats(primer.getBens(), segon.getNecessitats());
        while(l1.size()!=0&&l2.size()!=0){
            //S'agafa el primer element de cadascuna de les llistes i s'intercanvia
            intercanvi(l1.get(0), l2.get(0));
            l1.remove(0);
            l2.remove(0);
            //Per cada intercanvi són dues transaccions
            transaccions=transaccions+2;
        }
        return transaccions;
    }
    
    public void intercanvi(Recurs r1, Recurs r2){
        primer.entregaBe(r2);
        segon.entregaBe(r1);
        primer.satisfesNecessitat(r1);
        segon.satisfesNecessitat(r2);
        descripcio= "   <--: " + r1 + "\n   -->: " + r2 + "\n";
    }
    
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("(").append(primer.getNom());
        s.append(", ").append(segon.getNom());
        s.append(")\n").append(this.descripcio);
        return s.toString();
    }
}
