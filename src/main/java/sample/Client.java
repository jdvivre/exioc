package sample;

public class Client {
 	private Service service;

	public Client(Service service) {
		this.service = service;
	}

	public static void main(String[] args) {
		System.out.println("startup");
		new Client(new Service()).run();
		System.out.println("shutdown");
	}

	public void run() {
		String val;
		try {
			val = service.getVal();

		} catch (NoValException e) {
//			val = e.getContext().handleException(new UseValRestart("restart using this"));
			val = e.getContext().handleException(new LetUserChooseValRestart());
		}
		System.out.println(val);
	}
	
}
