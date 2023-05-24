import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
  private ArrayList<Carta> mazo;

  public Baraja(int num) {
    this.mazo = new ArrayList<>();
    inicializa(num);
  }

  private void inicializa(int num) {
    
      int numero = 1+(num/3);
      
    for(int i=0;i<numero;i++)
      for (Figura f: Figura.values()) 
        for( int v= 1 ; v <= 13 ; v++) 
          try {
            mazo.add(new Carta(v,f));
          } catch (FueraDeRangoException e) {
            System.out.println(e);
          }   
  }

  public void barajar() {
    Collections.shuffle(mazo);
  }

  public ArrayList<Carta> repartir(int n, ArrayList mano) {
    for(int i=1; i<=n; i++) {
      mano.add(mazo.remove(0));
    }
    return mano;
  }

  @Override
  public String toString() {
    StringBuffer mazoStr = new StringBuffer();
    for (Carta c : mazo) {
      mazoStr.append(c.toString()+"\n");
    }
    return mazoStr.toString();
  }


}