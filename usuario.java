import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    public static boolean login(String correo, String contrasena) {
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.csv"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[1].equals(correo) && datos[2].equals(contrasena)) {
                    System.out.println("Login exitoso.");
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
        System.out.println("Credenciales incorrectas.");
        return false;
    }

    public static void cambiarDatos(String correo, String nuevoNombre, String nuevaContrasena) {
        List<String> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.csv"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[1].equals(correo)) {
                    datos[0] = nuevoNombre;
                    datos[2] = nuevaContrasena;
                }
                usuarios.add(String.join(",", datos));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.csv"))) {
            for (String usuario : usuarios) {
                writer.write(usuario);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo.");
        }
    }
}