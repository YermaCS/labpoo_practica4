import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

public class AplicacionDeCartas {
private Random rmd = new Random();
int dado;
private Baraja b;
private Scanner entrada = new Scanner(System.in);
private ArrayList<Jugador> jugadores = new ArrayList();
private ArrayList<Integer> cartasPuestas = new ArrayList();
private ArrayList<Integer> puntuacion= new ArrayList();
    
  public AplicacionDeCartas(){
  
  }  
  
  public int obtenerMayor(){
      int mayor = Collections.max(cartasPuestas);
      
      return mayor;
  }
  
  public void asignarPuntos(int i,int puntos){
      jugadores.get(i).setPunto(puntos);
  }
  
  public void seleccionarMayor(){
      int mayor = obtenerMayor();
      System.out.println("Mayor = "+ mayor);
      int contador=0,i,ganador=0,puntos=2;
      boolean segundaVez=false;
      
      for(i=0;i<jugadores.size();i++)
          if(jugadores.get(i).getCapacidadDeTirar() == false)
              segundaVez = true;
      
      for(i=0;i<cartasPuestas.size();i++)
      {
          if(cartasPuestas.get(i)==mayor)
          {
              ganador = i;
              contador++;
          }
          else
              jugadores.get(i).setNoTirar();
      }
      
      if(contador==1)
      {
          asignarPuntos(ganador,puntos);
          System.out.println("El jugador: "+(ganador+1)+" ha ganado esta ronda!");
          
          setTirarJugadores();
      }
      else
      {
          if(segundaVez == false)
          {
                System.out.print("Ha sido empate entre los jugadores: ");
                for(i=0;i<cartasPuestas.size();i++)
                  if(cartasPuestas.get(i)==mayor)
                        System.out.print("["+(i+1)+"]");
                System.out.println("\nFAVOR DE VOLVER A TIRAR!");
          }
          else
          {
              System.out.print("Ha sido empate entre los jugadores: ");
              
              for(i=0;i<cartasPuestas.size();i++)
                  if(cartasPuestas.get(i)==mayor)
                  {
                      System.out.print("["+(i+1)+"]");
                      asignarPuntos(i,1);
                  }
              System.out.println(" de nuevo... \nSE LES HA DADO UN PUNTO A CADA UNO!");
              
              setTirarJugadores(); 
              
          } 
      }
      cartasPuestas.clear();
  }
  
  public void setTirarJugadores(){
      int i=0;
      for(i=0;i<jugadores.size();i++)
              jugadores.get(i).setTirar();
  }
  
  public void colocarCartaVacia(){
      cartasPuestas.add(0);
  }
  
  public void pedirCarta(int i){
      int num;
      System.out.println("Escribe el numero de carta que quieres poner");
      num = entrada.nextInt();
      num = num-1;
      
      cartasPuestas.add(jugadores.get(i).getValorCarta(num));
      System.out.println("Jugador "+(i+1)+" has puesto la carta: "+jugadores.get(i).toStringCarta(num));
      jugadores.get(i).removerCarta(num);
  }
  
  public void darAltaJugadores(int num){
      int i;
      
      for(i=0;i<num;i++)
          jugadores.add(new Jugador(i+1));
  }
  
  public void mostrarCartasJugador(int num){
      System.out.println(jugadores.get(num).toString());
  }
  
  public void repartirCartasInicio(int num){
      int i;
      
      for(i=0;i<num;i++)
          jugadores.get(i).agregarCartas(repartirCartas(5,jugadores.get(i).getMano()));
  }
  
  public void repartirCartasUnJugador(int i,int cant){
      jugadores.get(i).agregarCartas(repartirCartas(cant,jugadores.get(i).getMano()));
  }
  
  public ArrayList repartirCartas(int numCartas, ArrayList mano){
      return b.repartir(numCartas, mano);
  }
    
  public void inicia(int num) {
    b=new Baraja(num);
    b.barajar();  
  }
  
  public int definirNumJugadores(){
      int num;
      
      do
      {
          System.out.println("Escribe el numero de jugadores");
          num = entrada.nextInt();
          
          if(num>100 || num<2)
              System.out.println("Has escrito un numero invalido de jugadores, intenta de nuevo...");
              
      }while(num < 2 || num >= 100);
      
      return num;
  }
  
  public int lanzarDado(int i){
      int num;
      
      System.out.println("EL JUGADOR "+(i+1)+" DEBE LANZAR EL DADO!\n");
      System.out.println("Presiona cualquier numero + enter para tirar el dado");
      num = entrada.nextInt();
      
      dado = rmd.nextInt(5)+1;
      System.out.println("Te ha salido "+dado+" como resultado del dado\nSe agregaan "+dado+" cartas a tu mano");
      
      return dado;
  }
  
  public boolean getJugadorCapacidadDeTirar(int i){
      return jugadores.get(i).getCapacidadDeTirar();
  }
  
  public boolean getManoVaciaJugador(int i){
        return jugadores.get(i).getManoVacia();
    }
  
  public int getPuntosJugador(int i){
      
      return jugadores.get(i).getPuntos();
  }
  
  
}
