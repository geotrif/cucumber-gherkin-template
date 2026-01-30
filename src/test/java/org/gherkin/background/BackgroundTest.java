package org.gherkin.background;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/background") // Path to your .feature files in src/test/resources/features/
@ConfigurationParameter(key = "cucumber.glue", value = "org.gherkin.background") // Package containing step definitions
@ConfigurationParameter(key = "cucumber.plugin", value = "json:target/cucumber-report.json, pretty")
public class BackgroundTest {
}
