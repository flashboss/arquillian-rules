package rules;

import java.util.ArrayList;
import java.util.List;

import org.junit.internal.AssumptionViolatedException;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;

public class MyRule implements TestRule {

	private Container container;

	public MyRule(Container container) {
		this.container = container;
	}

	@Override
	public Statement apply(Statement base, Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				List<Throwable> errors = new ArrayList<Throwable>();

				try {
					base.evaluate();
					if (!isInContainer())
						errors.add(new NotInContainerException());
				} catch (AssumptionViolatedException e) {
					errors.add(e);
				}

				MultipleFailureException.assertEmpty(errors);
			}
		};
	}

	public boolean isInContainer() {
		return container.isInContainer();
	}
}
