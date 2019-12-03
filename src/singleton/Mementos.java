package singleton;

import java.util.Stack;

public class Mementos
{
    private static Mementos instance = new Mementos();
    private Stack<AppState> appStates = new Stack<>();
    private Stack<AppState> undoStates = new Stack<>();
    public static Mementos getInstance(){ return instance;}

    public AppState getCurrentAppState(){
        return this.appStates.peek();
    }

    public void setCurrentAppState(AppState appState){
        this.appStates.push(appState);
    }

    public boolean canUndo(){
        return appStates.size() > 0;
    }

    public boolean canRedo(){
        return undoStates.size() > 0;
    }

    public AppState getPreviousState(){
        this.undoStates.push(this.appStates.pop());
        return this.undoStates.peek();
    }

    public AppState getUndoState(){
        this.appStates.push(this.undoStates.pop());
        return this.appStates.peek();
    }

}
