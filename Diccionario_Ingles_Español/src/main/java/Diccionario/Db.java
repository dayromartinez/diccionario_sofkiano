package Diccionario;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Db {

    public Map<String, String> diccionario = new HashMap<>();
    String texto = "";

    public void nuevo_termino (String palabraEspanol, String traduccionIngles){

        try {

            diccionario.put(palabraEspanol, traduccionIngles);

            String ruta = "diccionario.txt";
            File file = new File(ruta);

            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            texto = texto +""+ palabraEspanol.toLowerCase() +": "+traduccionIngles.toLowerCase() +"\n";
            bw.write(texto);
            bw.close();
            System.out.println("¡Nuevo término añadido al diccionario con éxito!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void consultaGeneral (String nombreArchivo){

        try{

            FileReader scanner = new FileReader(nombreArchivo);
            BufferedReader buffer = new BufferedReader(scanner);
            String linea = "";

            while (linea != null){
                linea = buffer.readLine();
                if(linea == null){
                    break;
                }
                System.out.println(linea);
            }
        }catch (Exception e){
            System.out.println("No ha sido posible leer el archivo. Inténtelo de nuevo");
        }
    }

    public void cargaInicial (String nombreArchivo){

        try{

            FileReader scanner = new FileReader(nombreArchivo);
            BufferedReader buffer = new BufferedReader(scanner);
            String linea = "";

            while (linea != null){
                linea = buffer.readLine();
                if(linea == null){
                    break;
                }
                texto = ""+texto + linea +"\n";
            }
        }catch (Exception e){
            System.out.println("No ha sido posible leer el archivo. Inténtelo de nuevo");
        }
    }

    public void consultaTermino (String nombreArchivo, String palabraEspanol){

        try{

            FileReader scanner = new FileReader(nombreArchivo);
            BufferedReader buffer = new BufferedReader(scanner);
            String linea = "";
            int match;
            String palabra = "";
            String traduccion = "";
            String[] partes;

            while (linea != null){

                linea = buffer.readLine();

                if(linea == null){
                    System.out.println("La traducción al inglés de la palabra: "+ palabraEspanol +", no fue encontrada en nuestro diccionario." +
                            " ¡Inténtalo nuevamente!");
                    break;
                }else{

                    partes = linea.split(":");
                    palabra = partes[0];
                    match = palabra.compareTo(palabraEspanol.toLowerCase());

                    if (match == 0){

                        traduccion = partes[1];
                        System.out.println("¡Búsqueda realizada con éxito!");
                        System.out.println("La traducción al inglés de la palabra "+ palabra +" es: "+ traduccion+".");
                        System.out.println("¡Haz aprendido una nueva palabra en inglés el día de hoy! Sigue Buscando :)");
                        break;

                    }
                }
            }
        }catch (Exception e){
            System.out.println("No ha sido posible leer el archivo. Inténtelo de nuevo");
        }
    }
}
