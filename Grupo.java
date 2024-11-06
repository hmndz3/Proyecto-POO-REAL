import java.util.ArrayList;

public class Grupo {
    private String nombre;
    private String contrasena;
    private String creador;
    private ArrayList<String> miembros;
//------------------------------------------------------------------------------------------------------------------------
    // Constructor
    public Grupo(String nombre, String contrasena, String creador) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.creador = creador;
        this.miembros = new ArrayList<>();
        this.miembros.add(creador); 
    }
//------------------------------------------------------------------------------------------------------------------------
    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getCreador() {
        return creador;
    }
//------------------------------------------------------------------------------------------------------------------------
    public void agregarMiembro(String correoUsuario) {
        if (!miembros.contains(correoUsuario)) {
            miembros.add(correoUsuario);
            System.out.println("Usuario agregado al grupo.");
        } else {
            System.out.println("El usuario ya es miembro del grupo.");
        }
    }
//------------------------------------------------------------------------------------------------------------------------
    public boolean esCreador(String correoUsuario) {
        return creador.equals(correoUsuario);
    }
 //------------------------------------------------------------------------------------------------------------------------
    public ArrayList<String> getMiembros() {
        return miembros;
    }
}
