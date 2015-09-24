package rules;

import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
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

		NamingEnumeration<NameClassPair> list;
		try {
			list = initialContext.list("/");
			while (list.hasMoreElements()) {
				NameClassPair nameClassPair = list.next();
				if (!"TransactionManager".equals(nameClassPair.getName()))
					return false;
			}
		} catch (NamingException e) {
			return false;
		}
		return true;
	}

}
