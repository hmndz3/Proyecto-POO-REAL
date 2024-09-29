import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Menú Inicial ---");
        System.out.println("1. Register");
        System.out.println("2. Salir");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); 

        if (opcion == 1) {
            System.out.println("Registro de usuario");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Correo: ");
            String correo = scanner.nextLine();
            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine();
            
            Usuario nuevoUsuario = new Usuario(nombre, correo, contrasena);
            nuevoUsuario.registrarUsuario();
            System.out.println("Usuario registrado exitosamente.");
        } else if (opcion == 2) {
            System.out.println("Saliendo del sistema...");
        }
    }
}