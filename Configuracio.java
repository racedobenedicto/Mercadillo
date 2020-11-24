package edu.upc.etsetb.poo.proyecto.dominio;

import static java.lang.System.currentTimeMillis;

/**
 * Constants que defineixen les dimensions del Mercadillo i la llavor de Random.
 */
public class Configuracio {
    /**
     * Nombre de mercaders
     */
    public static final int NUM_MERCADERS = 4;
    /**
     * Nombre de bens que ha de tenir cada mercader
     */
    public static final int NUM_BENS_CADA_MERCADER = 3;
    /**
     * Nombre total de recursos: producte del nombre de mercaders per el 
     * nombre de bens que ha de tenir cada mercader
     */
    public static final int NUM_RECURSOS = NUM_MERCADERS * NUM_BENS_CADA_MERCADER;
    /** Si li assignem un valor constant com a llavor, cada vegada que executem 
    sortirà el mateix repartiment de bens i necessitats. Si li assignem
    currentTimeMillis(), cada vegada sortirà un repartiment diferent. */
    /**
     * Llavor per generar un nombre pseudoaleatori que s'utilitzarà per generar 
     * permutacions de llistes de béns i necessitats. Cada valor genera 
     * unes permutacions. Si sempre s'inicialitza al mateix valor, sempre 
     * s'obtenen els mateixos resultats. 
     * Per al desenvolupament feu que prengui el valor 31. Després podeu 
     * assignarle el valor retornat per el mètode System.currentTimeMillis() 
     */
  //  public static final long LLAVOR_RAND = currentTimeMillis();
   public static final long LLAVOR_RAND = 31;
}
