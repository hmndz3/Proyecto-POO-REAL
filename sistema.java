import java.util.ArrayList;

public class Sistema 
{
    private ArrayList<Usuario> listausuarios;    
    private ArrayList<Clase> listaclases;        

    public Sistema() {
        this.listausuarios = new ArrayList<>();
        this.listaclases = new ArrayList<>();
    }
    public void mostrarClasesDisponibles() {
        if (listaclases.isEmpty()) {
            System.out.println("No hay clases disponibles.");
        } else {
            System.out.println("\n--- Clases Disponibles ---");
            for (Clase clase : listaclases) {
                System.out.println(clase);
            }
        }
    }

    public void agregarClase(Clase clase) {
        listaclases.add(clase);
    }
}
