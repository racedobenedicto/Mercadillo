
package edu.upc.etsetb.poo.proyecto.dominio;

import static edu.upc.etsetb.poo.proyecto.dominio.Duplicats.trobaDuplicats;
import java.util.ArrayList;
import java.util.List;

public class Mercader implements Comparable {
    //Atributs
    private String nom;
    private List<Recurs> bens;
    private List<Recurs> necessitats;
    
    //Constructors
    public Mercader(String nom) {
        this.nom = nom;
        this.bens= new ArrayList<>();
        this.necessitats= new ArrayList<>();
    }
    
    //Mètodes   
    public String getNom() {
        return nom;
    }

    public List<Recurs> getBens() {
        return bens;
    }

    public List<Recurs> getNecessitats() {
        return necessitats;
    }
    
    public void afageixNecessitat(Recurs necessitat){
        necessitats.add(necessitat);
    }
    
    public void afageixBe(Recurs be){
        bens.add(be);
    }
    
    public void entregaBe(Recurs r){
        bens.remove(r);
    }
    
    public void satisfesNecessitat(Recurs r){
        necessitats.remove(r);
    }
    
    public void consumeixBensPropis(){
        List<Recurs> duplicats = trobaDuplicats(bens, necessitats);
        if(!duplicats.isEmpty()){
            for(Recurs p: duplicats){
                this.entregaBe(p);
                this.satisfesNecessitat(p);
            }
        }
    }
    
    @Override
    public int compareTo(Object o2){
        Mercader m2 = (Mercader) o2;
        return this.getNom().compareTo(m2.nom);
    }
    
    @Override
    public String toString(){
        StringBuilder p = new StringBuilder();
        p.append(nom).append("\n");
        p.append("\tNecessito: ").append(necessitats);
        p.append("\n\tOfereixo: ").append(bens).append("\n");
        return p.toString();
    }
}
