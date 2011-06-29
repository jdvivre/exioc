package sample;

public class Service {

	private String m_val;

	public void setVal(String val) {
		this.m_val = val;
	}

	public String getVal() throws NoValException {
		final String val = m_val;

		return new Context() {

			public String getVal() throws NoValException {
				if (val == null)
					throw new NoValException(this);
				return val;
			}

			public String handleException(UseValRestart r) {
				return r.getVal();
			}

			public String handleException(LetUserChooseValRestart r) {
				return showViewDialog();
			}

		}.getVal();

	}

	private String showViewDialog() {
		System.out.println("open dialog here");
		return "dialog input data";
	}

}
