package org.travel.stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//resources//Freature_file",
				glue= "org.travel.stepdefinition",
				plugin= {"html:target/html/","json:target/report.json"},
				monochrome = true,
				dryRun = false
				//tags={"@test1,@test2"}
				)
public class TestRunner {

}
