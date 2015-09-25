package rules;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Container {

	private InitialContext initialContext;

	private boolean inContainer;

	public Container() {
		try {
			initialContext = new InitialContext();
			initialContext.lookup("java:comp/BeanManager");
			inContainer = true;
		} catch (NamingException e) {
			throw new NotInContainerException();
		}
	}

	public boolean isInContainer() {
		return inContainer;
	}

}
