import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        String correoLogin = "";
        String nombreUsuario = "";

        Sistema sistema = new Sistema();
        sistema.agregarClase(new Clase(1, "PROGRAMACION ORIENTADA A OBJETOS", "1CC20086020242", "ERICK MARROQUIN", "Lunes 10:00-12:00", "Sección 60"));
        sistema.agregarClase(new Clase(2, "FISICA l", "1FF20164020242", "ZAIDY URRITIA", "MARTES 10:00-12:00", "Sección 90"));
        sistema.agregarClase(new Clase(3, "CIUDADANIA GLOBAL", "1MM20026020242", "ANDREA CHAVEZ", "MIERCOLES 10:00-12:00", "Sección 30"));

        boolean bandera1 = true;
        while (bandera1) {
            System.out.println("\nREGISTRO Y LOG IN!");
            System.out.println("1. Register");
            System.out.println("2. Log In");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = 0; //La opcion empieza en 0
            
            try { //Exception esta funciona para que el valor siempre tenga que ser numerico, no pueden ser letras ni caracteres especiales 'NomberFormatException'.
                opcion = Integer.parseInt(scanner.nextLine()); //Se pide el numero de oppcion que quiere selecciona el usuario.
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\nRegistro de usuario");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    String correo = ""; //Validacion de que el correo es de la UVG.
                    boolean correoValido = false;
                    while (!correoValido) {
                        System.out.print("Correo: ");
                        correo = scanner.nextLine();
                        if (correo.endsWith("@uvg.edu.gt")) {
                            correoValido = true;
                        } else {
                            System.out.println("Correo no válido. Debe usar un correo que termine en @uvg.edu.gt.");
                        }
                    }
                    System.out.print("Contraseña: ");
                    String contrasena = scanner.nextLine();
                    
                    Usuario nuevoUsuario = new Usuario(nombre, correo, contrasena);
                    nuevoUsuario.registrarUsuario();
                    System.out.println("Usuario registrado exitosamente.");
                    break;

                case 2:
                    System.out.println("\nIniciar sesión");
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
                    System.out.println("Gracias por usar el programa...");
                    bandera1 = false;
                    break;

                default:
                    System.out.println("La opcion que ingreso no es valida porfavor revisar...");
            }

            boolean bandera2 = loggedIn;

            while (bandera2) {
                System.out.println("\nINSCRIPCION DE CLASES UVG ESTUDIANTES");
                System.out.println("1. Mostrar clases disponibles.");
                System.out.println("2. Inscribirse en Clase");
                System.out.println("3. Mostrar Horario de clases Inscritas.");
                System.out.println("4. Desasignar Clase.");
                System.out.println("5. Inscribirse en grupo."); 
                System.out.println("6. En Desarrollo");
                System.out.println("7. Cambiar datos");
                System.out.println("8. Chat Global"); 
                System.out.println("9. Ver Chat Global"); 
                System.out.println("10. Cerrar sesión");
                System.out.print("Selecciona una opción: ");
                int opcionMenu2 = 0; 
                //Copy paste de lo que hicimos en el anterior.
                try { 
                opcionMenu2 = Integer.parseInt(scanner.nextLine()); 
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                continue;
            }
                

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
                        System.out.println("\nINSCRIBIRSE EN GRUPO!");
                        System.out.println("1. Crear grupo de asignación");
                        System.out.println("2. Unirse a grupo de asignación");
                        System.out.print("Selecciona una opción: ");
                        int opcionGrupo = 0;
                        try { //Copy paste del inicio otra vez. 
                            opcionGrupo = Integer.parseInt(scanner.nextLine()); 
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada no válida. Por favor, ingrese un número.");
                            continue;
                        }

                        switch (opcionGrupo) {
                            case 1:
                                System.out.print("Ingrese el nombre del grupo: ");
                                String nombreGrupo = scanner.nextLine();
                                System.out.print("Ingrese una contraseña para el grupo: ");
                                String contrasenaGrupo = scanner.nextLine();
                                sistema.crearGrupo(correoLogin, nombreGrupo, contrasenaGrupo);
                                break;
                            case 2:
                                sistema.mostrarGruposDisponibles();
                                System.out.print("Ingrese el nombre del grupo al que desea unirse: ");
                                String grupoUnirse = scanner.nextLine();
                                System.out.print("Ingrese la contraseña del grupo: ");
                                String contrasenaGrupoUnirse = scanner.nextLine();
                                sistema.unirseAGrupo(correoLogin, grupoUnirse, contrasenaGrupoUnirse);
                                break;
                            default:
                                System.out.println("Opción no válida en el submenú de grupos.");
                        }
                        break;
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
                            
                        System.out.println("\nBienvenido al CHAT GLOBAL!");
                        System.out.print("Ingrese su comentario: ");
                        String comentario = scanner.nextLine();
                        ChatGlobal.chatGlobal(nombreUsuario, comentario); 
                        break;
                            
                    case 9:
                        ChatGlobal.mostrarChat();
                        break;

                    case 10:
                        System.out.println("Gracias por usar el programa...");
                        loggedIn = false;
                        bandera2 = false;
                        break;

                    default:
                        System.out.println("La opcion que ingreso no es valida...");

                    
                }
            }
        }
    }
}
