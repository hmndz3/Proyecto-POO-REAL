import java.util.ArrayList;

public class Sistema 
{
    private ArrayList<Usuario> listausuarios;    
    private ArrayList<Clase> listaclases;   
    private ArrayList<Horario> horarios;     

    public Sistema() {
        this.listausuarios = new ArrayList<>();
        this.listaclases = new ArrayList<>();
        this.horarios = new ArrayList<>();
    }
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

    public void agregarClase(Clase clase) {
        listaclases.add(clase);
    }

    public void inscribirClase(String correoUsuario, String codigoClase) {
        Clase claseSeleccionada = null;
        for (Clase clase : listaclases) {
            if (clase.getCodigoclase().equals(codigoClase)) {
                claseSeleccionada = clase;
                break;
            }
        }
        if (claseSeleccionada != null) {
            // Crear nuevo horario y agregarlo a la lista de horarios del usuario
            Horario nuevoHorario = new Horario(horarios.size() + 1, correoUsuario, claseSeleccionada.getIdentificador(), claseSeleccionada.getHorario(), claseSeleccionada.getHorario());
            horarios.add(nuevoHorario);
            System.out.println("Clase inscrita con éxito: " + claseSeleccionada.getNombre());
        } else {
            System.out.println("Clase no encontrada.");
        }
    }
    public ArrayList<Horario> obtenerHorariosUsuario(String correoUsuario) {
        ArrayList<Horario> horariosUsuario = new ArrayList<>();
        for (Horario horario : horarios) {
            if (horario.getCorreousuario().equals(correoUsuario)) {
                horariosUsuario.add(horario);
            }
        }
        return horariosUsuario;
    }
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
    public void desasignarClase(String correoUsuario, String codigoClase) {
        Horario horarioAEliminar = null;

      
        for (Horario horario : horarios) {
            if (horario.getCorreousuario().equals(correoUsuario) && 
                getCodigoclaseDeHorario(horario).equals(codigoClase)) {
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

    private String getCodigoclaseDeHorario(Horario horario) {
        for (Clase clase : listaclases) {
            if (clase.getIdentificador() == horario.getIdentificadorclase()) {
                return clase.getCodigoclase();
            }
        }
        return null; 
    }
}
