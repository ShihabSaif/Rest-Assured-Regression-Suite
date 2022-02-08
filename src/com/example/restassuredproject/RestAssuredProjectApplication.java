package com.example.restassuredproject;


import com.example.restassuredproject.utility.ReadFromPropertiesFile;
import com.example.restassuredproject.utility.UTIL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;


@SpringBootApplication()
public class RestAssuredProjectApplication {

	@Autowired
	static
	ResourceLoader resourceLoader;


	public RestAssuredProjectApplication() throws IOException {
	}

	public static void main(String[] args) throws IOException {
		/*Resource resource=resourceLoader.getResource("classpath:testng.xml");
		//File file = resource.getFile();
		String jrxmlFilePath = resource.getFile().getPath();*/


		ApplicationContext c = SpringApplication.run(RestAssuredProjectApplication.class, args);
		ReadFromPropertiesFile readFromPropertiesFile = new ReadFromPropertiesFile();

		/*File resource = new ClassPathResource("testng.xml").getFile();
		String text = new String(String.valueOf(resource.toPath()));*/

		/*ClassPath.ClassFile resource = new ClassPath("/data").getClassFile("testng.xml");
		String text = new String(String.valueOf(resource.getPath()));*/

		/*Resource sourceFile = new ClassPathResource("static/testng.xml");
		String jrxmlFilePath = sourceFile.getFile().getPath();*/

		/*Resource resource=resourceLoader.getResource("classpath:testng.xml");

		String jrxmlFilePath = resource.getFile().getPath();*/

		//String file = RestAssuredProjectApplication.class.getClassLoader().getResource("testng.xml").getPath();

		/*RestAssuredProjectApplication instance
				= new RestAssuredProjectApplication();

		File file = instance.getResourceFile("testng.xml");
		System.out.println(file);

		file = instance.getResourceFile("testng.xml");

		UTIL util = new UTIL();
		String prop = String.valueOf(util.fetchProperties());
		System.out.println(prop);
		//System.out.println("file location is:" +readFromPropertiesFile.getPropertyKeyVariable());
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add(String.valueOf(file));//path to xml..
		testng.setTestSuites(suites);
		testng.run();
	}

	private File getResourceFile(final String fileName)
	{
		URL url = this.getClass()
				.getClassLoader()
				.getResource(fileName);

		if(url == null) {
			throw new IllegalArgumentException(fileName + " is not found 1");
		}

		File file = new File(url.getFile());

		return file;
	}*/

		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add(readFromPropertiesFile.getPropertyKeyVariable());//path to xml..
		testng.setTestSuites(suites);
		testng.run();

	}
}
