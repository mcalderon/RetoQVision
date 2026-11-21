package com.qvision.runners;


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")         // 3. "Los .feature están en resources/features"
@ConfigurationParameter(                     // 4. "Los steps están en este paquete"
        key = GLUE_PROPERTY_NAME,
        value = "com.qvision.stepdefinitions")
@ConfigurationParameter(                     // 5. "Reporta a Serenity y muestra bonito en consola"
        key = PLUGIN_PROPERTY_NAME,
        value = "net.serenitybdd.cucumber.core.plugin.SerenityReporterParallel,pretty")

public class CucumberTestSuite {
}
