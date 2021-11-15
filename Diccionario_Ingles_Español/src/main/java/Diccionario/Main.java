package Diccionario;
import java.util.*;
import Diccionario.Db;

public class Main {

    int opcion = 0;
    int contador = 0;
    String palabraEspanol = "";
    String traduccionIngles = "";

    public int menu () {

        if(contador == 0){
            System.out.println("¡Bienvenid@ al diccionario bilingue Sofkiano!");
        }

        System.out.println("Para hacer uso de alguna de las funcionalidades de este diccionario" +
                " digita alguna de las siguientes opciones: ");
        System.out.println("1. Registrar una nueva palabra en el diccionario Sofkiano");
        System.out.println("2. Consultar todos los términos registrados en el diccionario Sofkiano");
        System.out.println("3. Consultar un término específico en el diccionario Sofkiano");
        System.out.println("4. Cesar la ejecución de este programa");
        System.out.print("Por favor, digite alguna de las opciones anteriores: ");

        Scanner input = new Scanner(System.in);
        contador++;
        return opcion = Integer.parseInt(input.nextLine());
    }

    public static void main(String[] args) {

        Main menu = new Main();
        Db diccionario = new Db();

        while(menu.opcion != 4){

            menu.menu();

            if(menu.opcion < 1 || menu.opcion > 4){
                System.out.println("Opción del menú equivocada. ¡Inténtelo de nuevo!");
            }else{

                diccionario.cargaInicial("diccionario.txt");

                switch (menu.opcion){

                    case 1: {

                        System.out.print("Digite el término en español que desea añadir al diccionario Sofkiano: ");
                        Scanner input = new Scanner(System.in);
                        menu.palabraEspanol = input.nextLine();
                        System.out.print("Digite la traducción en inglés de este término: ");
                        menu.traduccionIngles = input.nextLine();
                        diccionario.nuevo_termino(menu.palabraEspanol, menu.traduccionIngles);
                        break;
                    }

                    case 2: {

                        System.out.println("Términos registrados actualmente en el diccionario: ");
                        diccionario.consultaGeneral("diccionario.txt");
                        System.out.println("¡Lectura general del diccionario hecha satisfactoriamente!");
                        break;
                    }

                    case 3: {

                        System.out.print("Digite el término en español del cual desea buscar su traducción en el diccionario: ");
                        Scanner input = new Scanner(System.in);
                        menu.palabraEspanol = input.nextLine();
                        diccionario.consultaTermino("diccionario.txt", menu.palabraEspanol);
                        break;
                    }

                    default: {
                        break;
                    }
                }
            }
        }

        if (menu.opcion == 4){
            System.out.println("Programa finalizado con éxito. ¡Te esperamos pronto para seguir enriqueciendo " +
                    "tu inglés en este, tu diccionario Sofkiano!");
        }
    }
}
