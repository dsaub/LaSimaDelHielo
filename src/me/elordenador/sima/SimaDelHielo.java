package me.elordenador.sima;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;

public class SimaDelHielo {

    // Estas constantes se utilizan para definir los codigos de colores, usados para poder escribir usando estos para una salida mas vistosa.
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    // El algoritmo principal.
    public static void main(String[] args) throws IOException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException {
        pAudioPlayer player = new pAudioPlayer();
        player.playFall();
        AnimationPlayer.printInitAnimation();

        while (player.isPlaying()) {} // Esto parara el programa hasta que el reproductor deje de reproducirlo.
        player.close();

        // Primero definimos el Scanner y los valores iniciales, por ejemplo la casilla a donde no se podrá ir, la vida, y los pinguinos derrotados.
        ScrUtils.clearScreen();
        Scanner sc = new Scanner(System.in); // Este codigo es necesario para poder leer lo que el usuario escribe
        String lastGone = "NORTH";
        int defeatedPenguins = 0;
        int health = 50;
        Pinguino pinguino;


        // Es mas vistoso que al inicio el programa obtenga el nombre de usuario activo del ordenador y que en vez de Explorador diga el nombre de usuario.
        String user = System.getProperty("user.name");
        ScrUtils.slowPrint(ANSI_RED + user+", acabas de caer en LA SIMA DEL HIELO" + ANSI_RESET);
        ScrUtils.printSeparator();
        ScrUtils.slowPrint(ANSI_GREEN+"Te diriges al "+ANSI_YELLOW+"SUR"+ANSI_GREEN+"."+ANSI_RESET);
        // Iniciamos un bucle que va a estar ejecutandose hasta que salida sea falso
        boolean salida = false;
        while (!salida) {
            // Informamos al usuario de su vida y cuantos pinguinos ha vencido
            System.out.println();
            ScrUtils.slowPrint(ANSI_GREEN+"Tienes "+ANSI_YELLOW+health+ANSI_GREEN+" puntos de vida."+ANSI_RESET);
            ScrUtils.slowPrint(ANSI_GREEN+"Has vencido a "+ANSI_YELLOW+defeatedPenguins+ANSI_RED+"/5 "+ANSI_GREEN+"Pinguinos"+ANSI_RESET);
            System.out.println();
            ScrUtils.slowPrint(ANSI_GREEN+"Has llegado a una encrucijada. ¿Qué dirección deseas seguir ahora?"+ANSI_RESET);
            printWhereCanIGo(lastGone);

            // Creamos otro bucle para que en caso de que el usuario se equivoque no se salga al resto de codigo sino que pregunte de nuevo
            boolean salida2 = false;
            while (!salida2) {
                String destination = sc.nextLine().toUpperCase();
                // Comprobamos si el usuario puede ir a la dirección indicada.
                if (destination.equals("N") && canIGO(lastGone, "NORTH")) {
                    ScrUtils.slowPrint(ANSI_GREEN + "Te dirijes hacia el " + ANSI_YELLOW + "NORTE" + ANSI_RESET);
                    lastGone = "SOUTH";
                    salida2 = true;
                } else if (destination.equals("E") && canIGO(lastGone, "EAST")) {
                    ScrUtils.slowPrint(ANSI_GREEN + "Te dirijes hacia el " + ANSI_YELLOW + "ESTE" + ANSI_RESET);
                    lastGone = "WEST";
                    salida2 = true;
                } else if (destination.equals("S") && canIGO(lastGone, "SOUTH")) {
                    ScrUtils.slowPrint(ANSI_GREEN + "Te dirijes hacia el " + ANSI_YELLOW + "SUR" + ANSI_RESET);
                    lastGone = "NORTH";
                    salida2 = true;
                } else if (destination.equals("W") && canIGO(lastGone, "WEST")) {
                    ScrUtils.slowPrint(ANSI_GREEN + "Te dirijes hacia el " + ANSI_YELLOW + "OESTE" + ANSI_RESET);
                    lastGone = "EAST";
                    salida2 = true;
                } else {
                    ScrUtils.slowPrint(ANSI_RED + "No has seleccionado una opción valida o no puedes ir a ese lugar" + ANSI_RESET);
                }
            }
            Thread.sleep(1000);
            AnimationPlayer.printGOAnimation();
            ScrUtils.clearScreen();
            ScrUtils.go(1,1);

            // Generamos un pinguino y mostramos información al usuario.
            pinguino = new Pinguino();
            pinguino.print();
            ScrUtils.slowPrint(ANSI_GREEN + "⚔ | Ha aparecido un "+ANSI_YELLOW+"Pinguino "+pinguino.getType() + ANSI_GREEN + " | ⚔"+ANSI_RESET);
            ScrUtils.slowPrint(ANSI_GREEN + "¿Que Quieres Hacer?"+ANSI_RESET);
            ScrUtils.slowWrite(ANSI_GREEN + "(" + ANSI_CYAN + "1. " + ANSI_GREEN + "Atacar, " + ANSI_CYAN + "2. " + ANSI_GREEN + "Huir): " + ANSI_RESET);
            // Debido a que poner letras en el input en este caso haria que el programa explote, si la excepción ocurre,
            // no salimos del bucle, mientras que si no ocurre, cerramos el bucle.
            int selection = 0;
            salida2 = false;
            while (!salida2) {
                try {
                    selection = sc.nextInt(); sc.nextLine();
                    salida2 = true;
                } catch (java.util.InputMismatchException e) {
                    ScrUtils.slowPrint(ANSI_RED + "Por favor, numeros." + ANSI_RESET);
                }
            }
            // Aqui es la logica de que si el usuario ataca o no
            if (selection == 1) {
                // Aqui el usuario ha decidido atacar, cojemos las monedas del resultado, y si gana se suman a su vida y si pierde se resta.
                int coins = pinguino.getCoins();
                if (pinguino.attack()) {
                    player.playAttack();
                    ScrUtils.slowPrint(ANSI_GREEN + "Has ganado al " + ANSI_YELLOW + "Pinguino "+pinguino.getType() + ANSI_GREEN + " y has obtenido " + ANSI_CYAN + coins + ANSI_GREEN + " puntos de vida" + ANSI_RESET);
                    health += coins;
                    defeatedPenguins += 1;
                } else {
                    player.playDefeat();
                    ScrUtils.slowPrint(ANSI_RED + "\uD83D\uDC80 Has perdido contra el " + ANSI_YELLOW + "Pinguino " + pinguino.getType() + ANSI_RED + " y has perdido " + ANSI_CYAN + coins + ANSI_RED + " puntos de vida." + ANSI_RESET);
                    health -= coins;
                }
                while (player.isPlaying());
                player.close();
            } else {
                // Ha huido, le restamos 1 punto de vida
                ScrUtils.slowPrint(ANSI_RED + "Has huido y mientras huias has perdido "+ ANSI_CYAN + "1" + ANSI_RED + " puntos de vida." + ANSI_RESET);
                health -= 1;
            }

            // Aqui comprobamos si ha ganado, o si ha muerto, y en caso de alguno, se imprime y se sale del bucle.
            if (defeatedPenguins >= 5) {
                ScrUtils.slowPrint(ANSI_PURPLE + "Has Ganado!"+ ANSI_RESET);
                salida = true;
            }

            if (health <= 0) {
                player.playDeath();

                ScrUtils.slowPrint(ANSI_RED + "☠ Has Muerto!" + ANSI_RESET);
                while (player.isPlaying());
                player.close();
                salida = true;
            }


            // Escribimos el separador, para separar.
            ScrUtils.printSeparator();

        }

    }

    /**
     * Esta función devuelve si se puede ir o no
     * @param lastDestination La ultima ubicacion
     * @param destination A donde vamos a ir
     * @return true si podemos ir y false si no podemos ir.
     */
    public static boolean canIGO(String lastDestination, String destination) {
        return !lastDestination.equals(destination);
    }

    /**
     * Esta función no devuelve nada pero imprime a donde puede ir.
     * @param lastDestination La ultima ubicacion
     */
    public static void printWhereCanIGo(String lastDestination) {
        System.out.print(ANSI_GREEN+"(");
        if (canIGO(lastDestination, "NORTH")) {
            System.out.print(ANSI_BLUE+"N"+ANSI_GREEN+": North, ");
        }
        if (canIGO(lastDestination, "EAST")) {
            System.out.print(ANSI_BLUE+"E"+ANSI_GREEN+": East, ");
        }
        if (canIGO(lastDestination, "SOUTH")) {
            System.out.print(ANSI_BLUE+"S"+ANSI_GREEN+": South, ");
        }
        if (canIGO(lastDestination, "WEST")) {
            System.out.print(ANSI_BLUE+"W"+ANSI_GREEN+": West, ");
        }
        System.out.println(")");
    }
}
