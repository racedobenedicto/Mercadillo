
package edu.upc.etsetb.poo.proyecto.dominio;


public class Recurs {
    //Atributs
    private int id;
    private String descripcio;
    
    //Constructor
    public Recurs(int id, String descripcio) {
        this.id = id;
        this.descripcio = descripcio;
    }
    
    //Mètodes
    @Override
    public boolean equals(Object o) {
        Recurs r = (Recurs)o;
        if (this.id == r.id) {
            return true;
        } else {
            return false;
        }
    }
  
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
        return hash;
    }
  
    @Override
    public String toString() {
        String id = new String();
        id = Integer.toString(this.id);
        return id;
    }
}

