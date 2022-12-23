package com.test;

import com.test.scenarios.Scenario_01;
import com.test.scenarios.Scenario_02;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({Scenario_01.class, Scenario_02.class})
public class ApplicationTest {
}
