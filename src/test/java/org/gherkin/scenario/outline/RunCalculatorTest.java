package org.gherkin.scenario.outline;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/scenario_outline")
@ConfigurationParameter(key = "cucumber.glue", value = "org.gherkin.scenario.outline")
@ConfigurationParameter(key = "cucumber.plugin", value = "json:target/cucumber-report.json, pretty")
public class RunCalculatorTest {
}
