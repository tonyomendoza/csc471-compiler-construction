package project1;

import java.util.Scanner;

/**
 *
 * @author Tony Mendoza
 */
public class Project1 {

    static Scanner input;
    static FiniteAcceptor NFA;
    static FiniteAcceptor DFA;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        input = new Scanner(System.in);

        System.out.println("Construct the nfa. How many states?");
        int size = Integer.parseInt(input.nextLine());
        NFA = new FiniteAcceptor();
        for (int i = 0; i < size; i++) {
            NFA.addState();
        }

        System.out.println("States added. Create edges (state, values{a, b})");
        for (int i = 0; i < NFA.totalStates(); i++) {
            String response = "n";
            do {
                System.out.println("Does state q" + i + " have any edges? y/n");
                response = input.nextLine();
            } while (response.equalsIgnoreCase("y") && response.equalsIgnoreCase("n"));

            if (response.equals("y")) {
                for (int j = 0; j < NFA.totalStates(); j++) {
                    System.out.println("Enter 'a', 'b', or 'both' for the inputs that connects q" + i + " to q" + j + ". Press enter anything else if there is no edge.");
                    String inputValue = input.nextLine();
                    switch (inputValue) {
                        case "a":
                        case "b":
                            NFA.getState(i).addEdge(j, inputValue);
                            break;
                        case "both":
                            NFA.getState(i).addEdge(j, "a");
                            NFA.getState(i).addEdge(j, "b");
                            break;
                        default:
                            System.out.println("No edges will be added to q" + j);
                            break;
                    }
                }
            }
        }

        System.out.println("Edges added. NFA constructed:");
        for (int i = 0; i < NFA.totalStates(); i++) {
            System.out.print("q" + i + ": ");
            for (int j = 0; j < NFA.getState(i).totalEdges(); j++) {
                System.out.print("(q" + j + ",{");
                for (int k = 0; k < NFA.getState(i).getEdge(j).totalInputs(); k++) {
                    System.out.print(NFA.getState(i).getEdge(j).getInputs()[k]);
                    if (k + 1 < NFA.getState(i).getEdge(j).totalInputs()) {
                        System.out.print(",");
                    }
                }
                System.out.print("}");
            }
            System.out.println(")");
        }
    }

}
