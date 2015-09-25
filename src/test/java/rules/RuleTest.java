package rules;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class RuleTest {

	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive javaArchive = ShrinkWrap.create(JavaArchive.class).addPackages(true, "rules")
				.addAsManifestResource("META-INF/beans.xml", "beans.xml");
		return javaArchive;
	}

	@Rule
	public MyRule myRule = new MyRule(new Container());

	@Test
	public void ruleWithServerContainer() throws Exception {
		assert(myRule.isInContainer());
	}
}
