package rules;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Container {

	private InitialContext initialContext;

	public Container() {
		try {
			initialContext = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public boolean isInContainer() {

		try {
			initialContext.lookup("java:comp/BeanManager");
		} catch (NamingException e) {
			return false;
		}
		return true;
	}

}
