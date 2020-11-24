
package edu.upc.etsetb.poo.proyecto.dominio;

import edu.upc.etsetb.poo.proyecto.iu.InterficieUsuari;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Mercadillo {
    //Atributs
    private InterficieUsuari iu;
    private Random rand;
    private Map<String, Recurs> recursos;
    private List<Mercader> mercaders;
    private List<Aparellament> aparellaments;
    
    //Constructor
    public Mercadillo(InterficieUsuari iu){
        this.iu=iu;
        Recurs rec;
        recursos= new HashMap<>();
        mercaders= new ArrayList<>();
        aparellaments= new ArrayList<>();
        //Es creen els recursos i mercaders
        for (int i=0; i<Configuracio.NUM_RECURSOS; i++){
            rec = new Recurs(i, "Recurs id" );
            this.recursos.put(Integer.toString(i), rec);
        }
        for( int i=0; i<Configuracio.NUM_MERCADERS ; i++){
            Mercader m= new Mercader("Mercader " + i);
            mercaders.add(i, m);
        }
        rand= new Random(Configuracio.LLAVOR_RAND);
    }
    
    //Mètodes
    public void executa(){
        int transaccions;
        reparteix();
        this.iu.mostra("ESTAT INICIAL\n"+this);
        transaccions = simula();
        this.iu.mostra("APARELLAMENTS I TRANSACCIONS\n");
        
        this.iu.mostra(aparellaments.toString());
        this.iu.mostra("\nNum transaccions = " + transaccions +"\n");
        this.iu.mostra("ESTAT FINAL\n"+this);
    }

    public void reparteix(){
        int i=0;
        List<Recurs> l1 = new ArrayList<>();
        l1.addAll(recursos.values());
        List<Recurs> l2 = new ArrayList<>();
        l2.addAll(recursos.values());
        Collections.shuffle(l1,rand);
        Collections.shuffle(l2,rand);
        for(Mercader m: mercaders){
            for(int j = 0; j<Configuracio.NUM_BENS_CADA_MERCADER; j++){
               m.afageixNecessitat(l1.get(i));
               m.afageixBe(l2.get(i));
               i++;
            }
            m.consumeixBensPropis();
        }
    }
    
    public List<Aparellament> getAparellaments() {
        return aparellaments;
    }
    
    public int simula(){
        int atotals=0;
        //Dos bucles per fer totes les permutacions de mercaders possibles
        for(int i=0; i< mercaders.size(); i++){
            for(int j=0; j< mercaders.size();j++){
                //S'afegirà a la llista quan la combinació no sigui ell mateix
                if(!mercaders.get(i).equals(mercaders.get(j)) && j==i || j>i){  //relació de índex: i ha de ser igual a j o superior per no repetir permutacions
                    Aparellament a = new Aparellament(mercaders.get(i), mercaders.get(j));
                    //S'afegeix a la llista i es realitzen les transaccions possibles
                    aparellaments.add(a);
                    atotals += a.realitzaTransaccions();
                }
            }
        }
    return atotals;
    }    
    
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        Collections.sort(mercaders);
        for(Mercader m : mercaders){
            s.append(m);
        }
        return s.toString();
    }
}
