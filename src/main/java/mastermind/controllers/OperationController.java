package mastermind.controllers;

import mastermind.models.Game;

public abstract class OperationController extends Controller {

	protected OperationController(Game game) {
		super(game);
	}
	
	public abstract void accept(OperationControllerVisitor operationControllerVisitor);
	

}
