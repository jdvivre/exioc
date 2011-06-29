package sample;

public class Service {
	
	private ExceptionHandler exceptionHandler;

	public Service(ExceptionHandler exceptionHandler) {
		this.exceptionHandler = exceptionHandler;
	}

	private String m_val;

	public void setVal(String val) {
		this.m_val = val;
	}

	public String getVal() {
		final String val = m_val;

		if (val == null)
			return exceptionHandler.handleNoValException(new ExceptionHandlerContext() {

				public String handleException(UseValRestart r) {
					return r.getVal();
				}

				public String handleException(LetUserChooseValRestart r) {
					return showViewDialog();
				}

			});
		
		return val;

	}

	private String showViewDialog() {
		return "dialog input data";
	}

}
