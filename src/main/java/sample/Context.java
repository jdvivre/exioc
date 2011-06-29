package sample;

public interface Context {

	String getVal() throws NoValException;
	
	String handleException(UseValRestart r);
	
	String handleException(LetUserChooseValRestart r); 
	
}
