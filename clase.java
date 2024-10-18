public class Clase 
{ //Atributos de la clase 'Clase'
    private int identificador;     
    private String nombre;          
    private String codigoclase;     
    private String profesor;        
    private String horario;         
    private String seccion;    
//--------------------------------------------------------------------------    
//Constructoe de la Clase 'Clase'
    public Clase(int identificador, String nombre, String codigoclase, String profesor, String horario, String seccion) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.codigoclase = codigoclase;
        this.profesor = profesor;
        this.horario = horario;
        this.seccion = seccion;
    }
//--------------------------------------------------------------------------  
//Getters de los atributos de la clase 'Clase'
    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigoclase() {
        return codigoclase;
    }

    public String getProfesor() {
        return profesor;
    }

    public String getHorario() {
        return horario;
    }

    public String getSeccion() {
        return seccion;
    }
//--------------------------------------------------------------------------  
//ToString de la clase 'Clase'
    @Override
    public String toString() {
        return "Clase: " + nombre + "\n" +
               "Código: " + codigoclase + "\n" +
               "Profesor: " + profesor + "\n" +
               "Horario: " + horario + "\n" +
               "Sección: " + seccion + "\n" +
               "----------------------------------";
    }
//--------------------------------------------------------------------------  
}
