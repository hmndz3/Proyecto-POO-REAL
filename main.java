import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        String correoLogin = "";

        Sistema sistema = new Sistema();
        sistema.agregarClase(new Clase(1, "PROGRAMACION ORIENTADA A OBJETOS", "1CC20086020242", "ERICK MARROQUIN", "Lunes 10:00-12:00", "Sección 60"));
        sistema.agregarClase(new Clase(2, "FISICA l", "1FF20164020242", "ZAIDY URRITIA", "MARTES 10:00-12:00", "Sección 90"));
        sistema.agregarClase(new Clase(3, "CIUDADANIA GLOBAL", "1MM20026020242", "ANDREA CHAVEZ", "MIERCOLES 10:00-12:00", "Sección 30"));

        boolean bandera1 = true;

        while (bandera1) {
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
                    bandera1 = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            boolean bandera2 = loggedIn;

            while (bandera2) {
                System.out.println("\n--- Menú de Opciones ---");
                System.out.println("1. MOSTRAR CLASES DISPONIBLES.");
                System.out.println("2. Inscribirse en Clase");
                System.out.println("3. Mostrar Horario de clases Inscritas.");
                System.out.println("4. Desasignar Clase");
                System.out.println("5. En Desarrollo");
                System.out.println("6. En Desarrollo");
                System.out.println("7. Cambiar datos");
                System.out.println("8. Cerrar sesión");
                System.out.print("Selecciona una opción: ");
                int opcionMenu2 = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcionMenu2) {
                    case 1:
                        sistema.mostrarClasesDisponibles();
                        break;
                    case 2:
                        System.out.print("Ingrese el código de la clase que desea inscribir: ");
                        String codigoClase = scanner.nextLine();
                        sistema.inscribirClase(correoLogin, codigoClase);
                        break;
                    case 3:
                        sistema.mostrarHorarioUsuario(correoLogin);
                        break;
                    case 4:
                        System.out.print("Ingrese el código de la clase que desea desasignar: ");
                        String codigoClaseADesasignar = scanner.nextLine();
                        sistema.desasignarClase(correoLogin, codigoClaseADesasignar);
                        break;
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
                        bandera2 = false;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            }
        }
    }
}
