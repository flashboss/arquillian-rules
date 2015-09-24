package rules;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ExecutionRuleTest {

	@Rule
	public MyRule myRuleWithServerContainer = new MyRule(null);

	@Rule
	public MyRule myRuleWithClientContainer = new MyRule(new Container());

	@Test
	public void ruleWithServerContainer() throws Exception {
		assert(myRuleWithServerContainer.isInContainer());
	}

	@Test
	public void ruleWithClientContainer() throws Exception {
		assert(myRuleWithClientContainer.isInContainer());
	}
}
