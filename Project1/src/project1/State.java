package project1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Tony Mendoza
 */
public class State {

    private ArrayList<Edge> edges;

    public State() {
        edges = new ArrayList<>();
    }

    public void addEdge(int stateIndex, String input) {
        if (edges.contains(new Edge(stateIndex, input))) {
            for (int i = 0; i < edges.size(); i++) {
                if (edges.get(i).getStateIndex() == stateIndex) {
                    edges.get(stateIndex).addInput(input);
                    return;
                }
            }
        } else {
            edges.add(new Edge(stateIndex, input));
        }
    }

    public Edge getEdge(int index) {
        return edges.get(index);
    }

    public int totalEdges() {
        return edges.size();
    }
}
