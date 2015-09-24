package rules;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class NoRuleTest {

	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive javaArchive = ShrinkWrap.create(JavaArchive.class).addPackages(true, "rules")
				.addAsManifestResource("META-INF/beans.xml", "beans.xml");
		return javaArchive;
	}

	@Test
	public void ruleWithServerContainer() throws Exception {
		Container container = new Container();
		assert(container.isInContainer());
	}
}
