import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Grupo {
    private String nombre;
    private String contrasena;
    private String creador;

    // Constructor 
    public Grupo(String nombre, String contrasena, String creador) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.creador = creador;
    }

    // Getters de Nombre y Contraseña
    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getCreador() {
        return creador;
    }

    // Metodo para guardar los datos de los grupos en el CSV
    public void guardarEnCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("grupos.csv", true))) {
            writer.write(nombre + "," + contrasena + "," + creador);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar el grupo en CSV.");
        }
    }
}
