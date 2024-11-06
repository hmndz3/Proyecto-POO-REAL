import java.util.ArrayList;

public class Sistema 
{
    // Atributos de la clase sistema.
    private ArrayList<Usuario> listausuarios;    
    private ArrayList<Clase> listaclases;   
    private ArrayList<Horario> horarios;     
    private ArrayList<Grupo> grupos;    

    // Constructor de la clase sistema que inicializa las listas.
    public Sistema() {
        this.listausuarios = new ArrayList<>();
        this.listaclases = new ArrayList<>();
        this.horarios = new ArrayList<>();
        this.grupos = new ArrayList<>();
    }

    //---------------------------------------------------------------------------
    // Método para agregar una clase a la lista de clases disponibles
    public void agregarClase(Clase clase) {
        listaclases.add(clase);
    }

    //---------------------------------------------------------------------------
    // Método que recorre la lista de clases y las imprime
    public void mostrarClasesDisponibles() {
        if (listaclases.isEmpty()) {
            System.out.println("No hay clases disponibles.");
        } else {
            System.out.println("\n--- Clases Disponibles ---");
            for (Clase clase : listaclases) {
                System.out.println(clase);
            }
        }
    }

    //---------------------------------------------------------------------------
    // Método para inscribir una clase al usuario
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

    //---------------------------------------------------------------------------
    // Método para mostrar el horario de un usuario en particular
    public void mostrarHorarioUsuario(String correoUsuario) {
        ArrayList<Horario> horariosUsuario = obtenerHorariosUsuario(correoUsuario);

        if (horariosUsuario.isEmpty()) {
            System.out.println("No tienes clases inscritas.");
        } else {
            System.out.println("\n--- Horario del Usuario ---");
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

    //---------------------------------------------------------------------------
    // Método para desasignar una clase de un usuario
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

    //---------------------------------------------------------------------------
    // Método auxiliar para obtener el código de una clase desde un horario
    private String getCodigoclaseDeHorario(Horario horario) {
        for (Clase clase : listaclases) {
            if (clase.getIdentificador() == horario.getIdentificadorclase()) {
                return clase.getCodigoclase();
            }
        }
        return null; 
    }

    //---------------------------------------------------------------------------
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

    //---------------------------------------------------------------------------
    // Método para crear un nuevo grupo de asignación
    public void crearGrupo(String correoUsuario, String nombreGrupo, String contrasenaGrupo) {
        Grupo nuevoGrupo = new Grupo(nombreGrupo, contrasenaGrupo, correoUsuario);
        grupos.add(nuevoGrupo);
        System.out.println("Grupo creado exitosamente: " + nombreGrupo);
    }

    //---------------------------------------------------------------------------
    // Método para mostrar los grupos disponibles
    public void mostrarGruposDisponibles() {
        if (grupos.isEmpty()) {
            System.out.println("No hay grupos disponibles.");
        } else {
            System.out.println("\n--- Grupos Disponibles ---");
            for (Grupo grupo : grupos) {
                System.out.println("Grupo: " + grupo.getNombre());
            }
        }
    }

    //---------------------------------------------------------------------------
    // Método para unirse a un grupo existente
    public void unirseAGrupo(String correoUsuario, String nombreGrupo, String contrasenaGrupo) {
        for (Grupo grupo : grupos) {
            if (grupo.getNombre().equals(nombreGrupo) && grupo.getContrasena().equals(contrasenaGrupo)) {
                grupo.agregarMiembro(correoUsuario);
                System.out.println("Te has unido al grupo: " + nombreGrupo);
                return;
            }
        }
        System.out.println("El nombre o la contraseña del grupo son incorrectos.");
    }
}
