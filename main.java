import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        String correoLogin = "";

        while (true) {
            System.out.println("\n--- Menú Inicial ---");
            System.out.println("1. Register");
            System.out.println("2. Log In");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
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
                    break;

                case 2:
                    System.out.println("Iniciar sesión");
                    System.out.print("Correo: ");
                    correoLogin = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String contrasenaLogin = scanner.nextLine();

                    if (Usuario.login(correoLogin, contrasenaLogin)) {
                        loggedIn = true;
                        System.out.println("Login correcto.");
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}