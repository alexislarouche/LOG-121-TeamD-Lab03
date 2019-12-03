package singleton;

import java.util.Stack;

public class Mementos
{
    private static Mementos instance = new Mementos();
    private Stack<AppState> appStates = new Stack<>();
    public static Mementos getInstance(){ return instance;}

    public AppState getCurrentAppState(){
        return this.appStates.peek();
    }

    public void setCurrentAppState(AppState appState){
        this.appStates.push(appState);
    }

    public AppState getPreviousState(){
        this.appStates.pop();//set in other stack for redo
        return this.appStates.peek();
    }

}
