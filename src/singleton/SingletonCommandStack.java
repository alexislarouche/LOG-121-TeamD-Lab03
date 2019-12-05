package singleton;

import app.AppState;

import java.util.Stack;

public class SingletonCommandStack
{
    private static SingletonCommandStack instance = new SingletonCommandStack();
    private Stack<AppState> appStates = new Stack<>();
    private Stack<AppState> undoStates = new Stack<>();
    public static SingletonCommandStack getInstance(){ return instance;}

    public AppState getCurrentAppState(){
        return this.appStates.peek();
    }

    public void setCurrentAppState(AppState appState){
        if(this.appStates.empty()){
            appState.initialScale();
        }
        this.appStates.push(appState);
        this.undoStates = new Stack<>();
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
