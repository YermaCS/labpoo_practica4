import java.util.ArrayList;

public class Jugador {
    int numeroDeJugador,puntos;
    boolean capacidadDeTirar=true;
    ArrayList<Carta> mano = new ArrayList();
    
    public Jugador(int numeroDeJugador){
        this.numeroDeJugador = numeroDeJugador;
        puntos=0;
        //aaaaa
    }
    
    public boolean getCapacidadDeTirar(){
        return capacidadDeTirar;
    }
    
    public void setNoTirar(){
        this.capacidadDeTirar=false;
    }
    
    public void setTirar(){
        this.capacidadDeTirar=true;
    }
    
    public void removerCarta(int i){
        mano.remove(i);
    }
    
    public void agregarCartas(ArrayList mano){
        this.mano = mano;
    }
    
    public Carta getCarta(int num){
        return mano.get(num);
    }
    
    public int getValorCarta(int num){
        return mano.get(num).getValor();
    }
    
    public ArrayList getMano(){
        return mano;
    }
    
    public int getPuntos(){
        return puntos;
    }
    
    public String toStringCarta(int num){
        
        return mano.get(num).toString(num);
    }
    
    @Override
    public String toString(){
        String cartas = "";
        
        for(int i=0;i<mano.size();i++)
            cartas = cartas + mano.get(i).toString(i);
        
        return "JUGADOR: " + numeroDeJugador +"   ----   PUNTOS: "+ puntos +" \n"+ cartas;
    }
    
    public boolean getManoVacia(){
        boolean vacia;
        if(mano.isEmpty())
            vacia = true;
        else
            vacia = false;
        
        return vacia;
    }
    
    public void setPunto(int puntos){
        this.puntos = this.puntos+puntos;
    }
    
}
