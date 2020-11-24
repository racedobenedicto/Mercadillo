package edu.upc.etsetb.poo.proyecto.dominio;

import java.util.ArrayList;
import java.util.List;

public class Duplicats {
  //Métode
  public static List<Recurs> trobaDuplicats(List<Recurs> llista1, List<Recurs> llista2) {
    List<Recurs> duplicats = new ArrayList();
        for (Recurs r : llista1){
            if (llista2.contains(r)){
                duplicats.add(r);
            }
        }
    return duplicats;
  }
}

