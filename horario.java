public class Horario 
{
//Atributos de la clase 'Horario.'
    private int identificador;          
    private String correousuario;       
    private int identificadorclase;     
    private String fecha;              
    private String hora;               
//--------------------------------------------------------------------------  
//Constructor de la clase Horario.
    public Horario(int identificador, String correousuario, int identificadorclase, String fecha, String hora) {
        this.identificador = identificador;
        this.correousuario = correousuario;
        this.identificadorclase = identificadorclase;
        this.fecha = fecha;
        this.hora = hora;
    }
//--------------------------------------------------------------------------  
//Getters de la clase Horario
    public int getIdentificador() {
        return identificador;
    }

    public String getCorreousuario() {
        return correousuario;
    }

    public int getIdentificadorclase() {
        return identificadorclase;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }
//--------------------------------------------------------------------------  
//ToString de la clase Horario
    @Override
    public String toString() {
        return "Horario{" +
               "identificador=" + identificador +
               ", correousuario='" + correousuario + '\'' +
               ", identificadorclase=" + identificadorclase +
               ", fecha='" + fecha + '\'' +
               ", hora='" + hora + '\'' +
               '}';
    }
//--------------------------------------------------------------------------  
}
