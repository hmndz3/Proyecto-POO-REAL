import java.util.*;

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
                    } else {
                        System.out.println("Credenciales incorrectas.");
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

            if (loggedIn) {
                while (true) {
                    System.out.println("\n--- Menú de Opciones ---");
                    System.out.println("1. En Desarrollo");
                    System.out.println("2. En Desarrollo");
                    System.out.println("3. En Desarrollo");
                    System.out.println("4. En Desarrollo");
                    System.out.println("5. En Desarrollo");
                    System.out.println("6. En Desarrollo");
                    System.out.println("7. Cambiar datos");
                    System.out.println("8. Cerrar sesión");
                    System.out.print("Selecciona una opción: ");
                    int opcionMenu2 = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (opcionMenu2) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            System.out.println("Esta funcionalidad aún está en desarrollo.");
                            break;

                        case 7:
                            System.out.println("Cambiar datos del usuario");
                            System.out.print("Nuevo nombre: ");
                            String nuevoNombre = scanner.nextLine();
                            System.out.print("Nueva contraseña: ");
                            String nuevaContrasena = scanner.nextLine();

                            Usuario.cambiarDatos(correoLogin, nuevoNombre, nuevaContrasena);
                            System.out.println("Datos actualizados.");
                            break;

                        case 8:
                            System.out.println("Cerrando sesión...");
                            loggedIn = false;
                            break;

                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }

                    if (!loggedIn) {
                        break; 
                    }
                }
            }
        }
    }
}