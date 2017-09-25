package mastermind.main;

import mastermind.controllers.Logic;
import mastermind.controllers.OperationController;
import mastermind.views.MastermindView;

public class Mastermind {

    private Logic logic;
    
    private MastermindView view;
    
    public Mastermind() {
        logic = new Logic();
        view = new MastermindView();
    }
    
    public void play() {
        OperationController controller;
        do {
            controller = logic.getController();
            if (controller != null){
                view.interact(controller);
            }
        } while (controller != null);
        
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }

}
