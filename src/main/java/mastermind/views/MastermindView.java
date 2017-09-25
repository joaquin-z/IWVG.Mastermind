package mastermind.views;

import mastermind.controllers.CodeController;
import mastermind.controllers.ContinueController;
import mastermind.controllers.OperationController;
import mastermind.controllers.OperationControllerVisitor;
import mastermind.controllers.StartController;
import mastermind.models.State;
import mastermind.utils.IO;
import mastermind.utils.LimitedIntDialog;
import mastermind.utils.LimitedStringDialog;
import mastermind.utils.YesNoDialog;

public class MastermindView implements OperationControllerVisitor {

	private IO io = new IO();

	public void interact(OperationController operationController) {
		assert operationController != null;
		operationController.accept(this);
	}
	
	@Override
	public void visit(StartController startController) {
		int users = new LimitedIntDialog("0: Demo, 1: Partida", 0, 1).read();
		startController.setUsers(users);
	}
	
	@Override
    public void visit(CodeController codeController) {
        String code = new LimitedStringDialog("Intento "+codeController.getAttempt()+" [cuatro letras de entre A - amarillo, R - rojo, V - verde, Z - azul, B - blanco, N - negro]","ARVZBN").read();
        codeController.putCode(code);
        if (codeController.isVictory()) {
            io.writeln(codeController.getKilled() + " Muertos!!! Victoria");
        }else {
            io.writeln(codeController.getKilled() + " Muertos y " + codeController.getWounded() + " Heridos");
        }
        codeController.control();
    }

	@Override
	public void visit(ContinueController continueController) {
		continueController.setContinue(new YesNoDialog("Desea continuar")
				.read());
	}

}
