package sample;

public class Client {
 	private Service service;

	public Client(Service service) {
		this.service = service;
	}

	public static void main(String[] args) {
		System.out.println("+ starting..");
		
		Client client = new Client(new Service(
				new ExceptionHandler() {

					public String handleNoValException(ExceptionHandlerContext context) {
						return context.handleException(new UseValRestart("restart using this"));
//						return context.handleException(new LetUserChooseValRestart());
					}
				}
				
			));
		
			client.run();
		
		System.out.println("+ shutdown.");
	}

	public void run() {
		String val = service.getVal();

		System.out.println(val);
	}

}
