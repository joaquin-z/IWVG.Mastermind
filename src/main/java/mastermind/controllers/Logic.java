package mastermind.controllers;

import mastermind.models.Game;

public class Logic {

	private Game game;

	private CodeController codeController;
	
	private StartController startController;

	private ContinueController continueController;

	public Logic() {
		game = new Game();
		codeController = new CodeController(game);
		startController = new StartController(game);
		continueController = new ContinueController(game);
	}

	public OperationController getController() {
		switch (game.getState()){
		case INITIAL:
			return startController;
		case IN_GAME:
			return codeController;
		case FINAL:
			return continueController;
		case EXIT:
		default:
			return null;
		}
	}
}
