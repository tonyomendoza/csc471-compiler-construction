/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.util.ArrayList;

/**
 *
 * @author Tony Mendoza
 */
public class Edge {

    private int stateIndex;
    private ArrayList<String> inputs;

    public Edge(int stateIndex, String inputValue) {
        this.stateIndex = stateIndex;
        inputs = new ArrayList<>();
        inputs.add(inputValue);
    }

    public int getStateIndex() {
        return stateIndex;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.stateIndex;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edge other = (Edge) obj;
        return true;
    }

    public String[] getInputs() {
        String[] set = new String[inputs.size()];
        for(int i = 0; i < inputs.size(); i++)
            set[i] = inputs.get(i);
        return set;
    }

    public int totalInputs() {
        return inputs.size();
    }

    public void addInput(String input) {
        if (!inputs.contains(input)) {
            inputs.add(input);
        }
    }
}
