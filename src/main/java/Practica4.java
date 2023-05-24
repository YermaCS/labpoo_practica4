public class Practica4 {
    
    AplicacionDeCartas app = new AplicacionDeCartas();
    
  public static void main(String args[]) {
    Practica4 game = new Practica4();
    int num,i;
    boolean primerVez=true;
    
    num = game.app.definirNumJugadores();
    game.app.inicia(num);
    game.app.darAltaJugadores(num);
    game.app.repartirCartasInicio(num);
    
    for(int j=1;j<10;j++)
    {
        if(primerVez==false)
            System.out.println("RONDA  # "+(j));
        
        for(i=0;i<num;i++)
        {
            if(primerVez==true)
            {
                game.app.repartirCartasUnJugador(i, game.app.lanzarDado(i));
                game.app.mostrarCartasJugador(i);
            }            
            else
            {
                if(game.app.getJugadorCapacidadDeTirar(i))
                {

                    game.app.mostrarCartasJugador(i);
                    game.app.pedirCarta(i);
                }
                else
                    game.app.colocarCartaVacia();
            }  
            
            if(game.app.getManoVaciaJugador(i))
            {
                game.app.repartirCartasUnJugador(i, game.app.lanzarDado(i));
                game.app.mostrarCartasJugador(i);
                game.app.asignarPuntos(i, -3);
            }
        }

        if(primerVez==false)
            game.app.seleccionarMayor();
        else
            j--;
        
        primerVez=false;
    }

    for(i=0;i<num;i++)
    {
        System.out.println("Jugador "+(i+1)+" obtuvo "+ game.app.getPuntosJugador(i)+" puntos");
    }
    
      
  }
  
  public Practica4(){
      
  }
}