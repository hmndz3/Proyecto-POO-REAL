import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ChatGlobal {
    private static final String FILE_PATH = "chat.csv"; 

//------------------------------------------------------------------------------------------------------------------------  
//Funcion para el comentario al CSV.  
    public static void chatGlobal(String nombreUsuario, String comentario) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.append(nombreUsuario)
                  .append(",")
                  .append(comentario)
                  .append("\n");
            System.out.println("Comentario guardado correctamente en el chat global.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
//------------------------------------------------------------------------------------------------------------------------
//Funcion para imprimir el chat hacia el usuario con el correo y el comentario. Regresa al menu principal volver a pedir esta funcion para actualizar el chat.
    public static void mostrarChat() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            System.out.println("\nMensajes del Chat Global");
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    System.out.println("Usuario: " + datos[0] + " - Comentario: " + datos[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de chat: " + e.getMessage());
        }
//------------------------------------------------------------------------------------------------------------------------
    }
}
