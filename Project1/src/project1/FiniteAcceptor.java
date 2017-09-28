package project1;

import java.util.ArrayList;

/**
 *
 * @author Tony Mendoza
 */
public class FiniteAcceptor {
    private ArrayList<State> states;
    private int initialStateKey;
    private ArrayList<Integer> finalStateKeys;

    public FiniteAcceptor() {
        this.states = new ArrayList();
    }
    public FiniteAcceptor(int amountOfStates, boolean overflowAllowed) {
        this.states = new ArrayList(amountOfStates);
    }
    
    public void addState() {
            states.add(new State());
    }
    
    public void addState(State state) {
            states.add(state);
    }
    
    public void setInitialStateKey(int index){
        initialStateKey = index;
    }
    
    public int getInitialStateKey(){
        return initialStateKey;
    }
        
    public void setFinalState(int stateIndex){
        for(int i = 0;i < finalStateKeys.size(); i++){
            if(finalStateKeys.get(i) == stateIndex)
                return;
        }
        finalStateKeys.add(stateIndex);
    }
    public void unsetFinalState(int stateIndex){
        for(int i = 0;i < finalStateKeys.size(); i++){
            if(finalStateKeys.get(i) == stateIndex){
                finalStateKeys.add(stateIndex);
                return;
            }
        }
        // do nothing, there is no final state to unset
    }
    
    public ArrayList<Integer> getFinalStates(){
        return finalStateKeys;
    }
    
    public State getInitialState(){
        return states.get(initialStateKey);
    }
    
    public State getState(int stateIndex){
        return states.get(stateIndex);
    }
    
    public int totalStates(){
        return states.size();
    }
}