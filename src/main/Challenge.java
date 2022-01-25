package main;



import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Challenge {

    public static String option = "";
    public static String [][] memory = new String[20][10];


    public static void main(String[] args) throws Exception {

        DecimalFormat df = new DecimalFormat("000");

        Scanner sc = new Scanner(System.in);
        int contadorCa = 0;
        int contadorCs = 0;
        startMemory();

        do {
            System.out.println("===========================");
            System.out.println("        CHALLENGE");
            System.out.println("===========================");
            System.out.println("cs. Create system procces");
            System.out.println("ca. Create aplication procces");
            System.out.println("ds. Delete system procces");
            System.out.println("da. Delete aplication procces");
            System.out.println("e.  Exit");

            System.out.println("Ingresa una opcion");
            option = sc.nextLine();


            switch (option){
                case "cs":
                    System.out.println("------------------");
                    System.out.println("Add system procces");
                    System.out.println("------------------");
                    int ps = (int) (Math.random() * (15 - 5) ) + 5;
                    contadorCs += 1;
                    String valorS = " s" + df.format(contadorCs) + " ";
                    setMemory(ps, valorS);
                    showMemory();
                    break;
                case "ca":
                    System.out.println("------------------");
                    System.out.println("Add aplication procces");
                    System.out.println("------------------");
                    int pa = (int) (Math.random() * (20 - 10) ) + 10;
                    contadorCa += 1;
                    String valorA = " a" + df.format(contadorCa) + " ";
                    setMemory(pa, valorA);
                    showMemory();
                    break;
                case "da":
                    System.out.println("------------------");
                    System.out.println("Delete aplication procces");
                    System.out.println("------------------");
                    System.out.print("Escribe id a eliminar: ");
                    int id = Integer.parseInt(sc.nextLine());
                    String valorDelete = " a" + df.format(id) + " ";
                    deleteProcces(valorDelete);
                    showMemory();
                    break;
                case "ds":
                    System.out.println("------------------");
                    System.out.println("Delete system procces");
                    System.out.println("------------------");
                    System.out.print("Escribe id a eliminar: ");
                    int id1 = Integer.parseInt(sc.nextLine());
                    String valorDelete1 = " s" + df.format(id1) + " ";
                    deleteProcces(valorDelete1);
                    showMemory();
                    break;
                case "e":
                    System.out.println("Hasta pronto");
                    System.exit(1);
                    break;
                default:
                    System.out.println("*******************************************");
                    System.out.println("******** Ingrese un comando Válido ********");
                    System.out.println("*******************************************");
                    break;

            }
        }while (option != "e");

    }

    //mostrar cantidad de memoria
    public static void showMemory(){
        for (int i = 0; i < memory.length ; i++) {

            for (int j = 0; j < memory[i].length; j++) {
                System.out.print(memory[i][j]);
            }
            System.out.println();
        }
    }

    //dar valor a los null con ****
    public static void setMemory(int tam, String value)  {
        //recuperar(tam);

        for (int i = 0; i < memory.length ; i++) {

            for (int j = 0; j < memory[i].length; j++) {
               if(memory[i][j] == " **** "  && tam > 0){
                   memory[i][j] = value;
                   tam -= 1;
               }
            }
        }
    }

    //mostrar capacidad de memoria en pantalla -----> usados/libre
    public static void startMemory (){
        for (int i = 0; i < memory.length ; i++) {

            for (int j = 0; j < memory[i].length; j++) {
                memory[i][j] = " **** ";
                System.out.print(memory[i][0]);
            }
            System.out.println();
        }
    }

    public static void deleteProcces(String value){

        for (int i = 0; i < memory.length ; i++) {
            for (int j = 0; j < memory[i].length; j++) {
                if(memory[i][j].equals(value)){
                    memory[i][j] = " **** ";
                }
            }
        }
        memoryOverflowException();
        //clearMemory();************
    }



    public static void memoryOverflowException(){



    }












    /*
    public static void clearMemory(){
        String[] valor = new String[40];
        int[] cantidad = new int[40];

        for (int i = 0; i < 40; i++) {
            valor[i] = "";
            cantidad[i] = 0;
        }

        for (int i = 0; i < memory.length ; i++) {

            for (int j = 0; j < memory[i].length; j++) {
                if (memory[i][j] != " **** ") {
                    int aux;
                    for (int k = 1; k < valor.length; k++) {
                        if (valor[k].equals(memory[i][j])) {
                            cantidad[k] += 1;
                        } else {
                            valor[k] = memory[i][j];
                            break;
                        }
                        System.out.println(k + ". " + valor[k] + ": " + cantidad[k]);
                    }
                }
            }
        }
    }*/
}
