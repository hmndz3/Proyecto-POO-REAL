import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Sistema 
{
    // Atributos de la clase sistema.
    private ArrayList<Clase> listaclases;   
    private ArrayList<Horario> horarios;     

    // Constructor para inicializar las listas.
    public Sistema() {
        this.listaclases = new ArrayList<>();
        this.horarios = new ArrayList<>();
    }

    // Método para agregar una clase a la lista de clases disponibles
    public void agregarClase(Clase clase) {
        listaclases.add(clase);
    }

    // Método que sirve para identificar las clases y poder mostrarlas
    public void mostrarClasesDisponibles() {
        if (listaclases.isEmpty()) {
            System.out.println("No hay clases disponibles.");
        } else {
            System.out.println("\n--- CLASES DISPONIBLES ---");
            for (Clase clase : listaclases) {
                System.out.println(clase);
            }
        }
    }

    // Método para la inscripsión de clases a usuarios
    public void inscribirClase(String correoUsuario, String codigoClase) {
        Clase claseSeleccionada = null;
        for (Clase clase : listaclases) {
            if (clase.getCodigoclase().equals(codigoClase)) {
                claseSeleccionada = clase;
                break;
            }
        }
        if (claseSeleccionada != null) {
            Horario nuevoHorario = new Horario(horarios.size() + 1, correoUsuario, claseSeleccionada.getIdentificador(), claseSeleccionada.getHorario(), claseSeleccionada.getHorario());
            horarios.add(nuevoHorario);
            System.out.println("Clase inscrita con éxito: " + claseSeleccionada.getNombre());
        } else {
            System.out.println("Clase no encontrada.");
        }
    }

    // Método que sirve para mostrar el horario con cursos asignados.
    public void mostrarHorarioUsuario(String correoUsuario) {
        ArrayList<Horario> horariosUsuario = obtenerHorariosUsuario(correoUsuario);

        if (horariosUsuario.isEmpty()) {
            System.out.println("No tienes clases inscritas.");
        } else {
            System.out.println("\n--- HORARIO ---");
            for (Horario horario : horariosUsuario) {
                for (Clase clase : listaclases) {
                    if (clase.getIdentificador() == horario.getIdentificadorclase()) {
                        System.out.println("Clase: " + clase.getNombre());
                        System.out.println("Código: " + clase.getCodigoclase());
                        System.out.println("Profesor: " + clase.getProfesor());
                        System.out.println("Horario: " + clase.getHorario());
                        System.out.println("Sección: " + clase.getSeccion());
                        System.out.println("----------------------------------");
                        break;
                    }
                }
            }
        }
    }

    // Método para desasignar una clase.
    public void desasignarClase(String correoUsuario, String codigoClase) {
        Horario horarioAEliminar = null;

        for (Horario horario : horarios) {
            if (horario.getCorreousuario().equals(correoUsuario) && getCodigoclaseDeHorario(horario).equals(codigoClase)) {
                horarioAEliminar = horario;
                break;
            }
        }

        if (horarioAEliminar != null) {
            horarios.remove(horarioAEliminar);
            System.out.println("Clase desasignada con éxito.");
        } else {
            System.out.println("No se encontró una clase inscrita con ese código.");
        }
    }

    // Método auxiliar para obtener el código de una clase desde un horario
    private String getCodigoclaseDeHorario(Horario horario) {
        for (Clase clase : listaclases) {
            if (clase.getIdentificador() == horario.getIdentificadorclase()) {
                return clase.getCodigoclase();
            }
        }
        return null; 
    }

    // Método para obtener los horarios de un usuario en particular
    private ArrayList<Horario> obtenerHorariosUsuario(String correoUsuario) {
        ArrayList<Horario> horariosUsuario = new ArrayList<>();
        for (Horario horario : horarios) {
            if (horario.getCorreousuario().equals(correoUsuario)) {
                horariosUsuario.add(horario);
            }
        }
        return horariosUsuario;
    }

    // Método para crea un grupo de asignación.
    public void crearGrupo(String correoUsuario, String nombreGrupo, String contrasenaGrupo) {
        Grupo nuevoGrupo = new Grupo(nombreGrupo, contrasenaGrupo, correoUsuario);
        nuevoGrupo.guardarEnCSV(); // Se guarda el grupo en el archivo CSV
        System.out.println("Grupo creado exitosamente: " + nombreGrupo);
    }

    // Método que muestra los grupos disponibles para unirse.
    public void mostrarGruposDisponibles() {
        System.out.println("\n--- GRUPOS DISPONIBLES ---");
        try (BufferedReader reader = new BufferedReader(new FileReader("grupos.csv"))) {
            String linea;
            boolean hayGrupos = false;
            boolean bandera = true;
            
            
            linea = reader.readLine();
            
            while (bandera) {
                if (linea != null) {
                    String[] datos = linea.split(",");
                    if (datos.length >= 3) {
                        System.out.println("Grupo: " + datos[0] + " | Creador: " + datos[2]);
                        hayGrupos = true;}
                    linea = reader.readLine();
                } else 
                {
                    bandera = false;
                }
            }
            if (!hayGrupos) {
                System.out.println("No hay grupos disponibles.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer los grupos desde el archivo.");
        }
    }

    // Método para unirse a un grupo ya creado
    public void unirseAGrupo(String correoUsuario, String nombreGrupo, String contrasenaGrupo) {
        boolean grupoEncontrado = false;
        boolean bandera = true;
        String linea = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("grupos.csv"));
             FileWriter writer = new FileWriter("miembros_grupos.csv", true)) {
            
            linea = reader.readLine();

            while (bandera) {
                if (linea != null) {
                    String[] datos = linea.split(",");
                    if (datos[0].equals(nombreGrupo) && datos[1].equals(contrasenaGrupo)) {
                        System.out.println("Te has unido al grupo: " + nombreGrupo);
                        writer.write(nombreGrupo + "," + correoUsuario);
                        writer.write("\n");
                        grupoEncontrado = true;
                        bandera = false;
                    } else 
                    {
                        linea = reader.readLine();
                    }
                } else 
                {
                    bandera = false;
                }
            }

            if (!grupoEncontrado) {
                System.out.println("El nombre o la contraseña del grupo son incorrectos.");
            }
            
        } catch (IOException e) {
            System.out.println("Error al acceder al archivo de grupos.");
        }
    }
}
