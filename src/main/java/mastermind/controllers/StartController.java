package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;
import mastermind.utils.ClosedInterval;

public class StartController extends OperationController {

	StartController(Game game) {
		super(game);
	}
	
	public void setUsers(int users){
		assert new ClosedInterval(0, this.numPlayers()).includes(users);
		assert this.getState() == State.INITIAL;
		this.setState(State.IN_GAME);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}

}
