package com.example.restassuredproject;

import com.example.restassuredproject.utility.ReadFromPropertiesFile;
import com.example.restassuredproject.utility.UTIL;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.io.IOException;
import java.util.List;
import java.util.Properties;


@SpringBootTest()
class RestAssuredProjectApplicationTests {

/*
	public static void main(String[] args) throws IOException {
		ReadFromPropertiesFile readFromPropertiesFile=new ReadFromPropertiesFile();
		UTIL util = new UTIL();
		Properties properties=util.readPropData();
		String prop = properties.getProperty("spring.config.import");
		System.out.println(prop);
		//System.out.println("file location is:" +readFromPropertiesFile.getPropertyKeyVariable());
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add(readFromPropertiesFile.getPropertyKeyVariable());//path to xml..
		testng.setTestSuites(suites);
		testng.run();
	}*/


}
