package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;

public class CodeController extends OperationController {
        
    protected CodeController(Game game) {
        super(game);
    }

    public void control() {
        assert this.getState() == State.IN_GAME;
        if (this.isOver() || this.isVictory()){
            this.resetScore();
            this.generateCode();
            this.resetAttempts();  
            this.setState(State.FINAL);            
        } else {
            this.resetScore();
            this.nextAttempt();
            this.setState(State.IN_GAME);
        }
    }
    
    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);     
    }
}
