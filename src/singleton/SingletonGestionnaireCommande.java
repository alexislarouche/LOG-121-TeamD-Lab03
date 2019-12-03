package singleton;

import controller.Command;
import java.util.Stack;

/**
 * Classe qui gère la mémorisation des commandes et qui doit etre une instance unique.
 * Doit aussi défaire les commandes.
 * Voir énoncé.
 */
public class SingletonGestionnaireCommande {
     private static SingletonGestionnaireCommande instance;
     private Stack<Command> stackCommand;

     private SingletonGestionnaireCommande() {
          stackCommand = new Stack<>();
     }

     public static SingletonGestionnaireCommande getInstance() {
          return instance;
     }

     public void pushCommand(Command c) {
          stackCommand.push(c);
     }

     public void popCommand(Command c) {
          stackCommand.pop();
     }

     public void undoLastCommand() {
          //Undo last Command
     }
}
