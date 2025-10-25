package org.gherkin.basic_sintax;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/basic_sintax") // Path to your .feature files in src/test/resources/features/
@ConfigurationParameter(key = "cucumber.glue", value = "org.gherkin.basic_sintax") // Package containing step definitions
public class BasicGherkinTest {
}
