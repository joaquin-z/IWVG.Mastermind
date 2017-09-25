package mastermind.controllers;

public interface OperationControllerVisitor {

	void visit(StartController startController);
		
	void visit(CodeController codeController);
		
	void visit(ContinueController continueController);

}

