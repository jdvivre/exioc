package sample;

public class NoValException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Context context;

	public NoValException(Context context) {
		this.context = context;
	}
	
	public Context getContext() {
		return context;
	}

}
