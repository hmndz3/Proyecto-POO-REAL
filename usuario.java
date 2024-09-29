import java.io.*;

public class Usuario {
    private String nombre;
    private String correo;
    private String contrasena;

    public Usuario(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public void registrarUsuario() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.csv", true))) {
            writer.write(nombre + "," + correo + "," + contrasena);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar el usuario.");
        }
    }
}
