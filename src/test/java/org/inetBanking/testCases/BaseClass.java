package org.inetBanking.testCases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.inetBanking.utilities.ReadConfig;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseUrl = readconfig.getApplicationURL();
	public String username = readconfig.getLoginUserName();
	public String password = readconfig.getLoginPassWord();
	public String customername = readconfig.getCustomerName();
	public static WebDriver driver;
	
	public static JSONObject jsonObject = new JSONObject();
	
	public static JSONParser jsonParser = new JSONParser();

	static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void browserConfig(String br) {

		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(baseUrl);

	}

	@AfterClass
	public void browserClose() {

		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		File desc = new File(System.getProperty("user.dir") + "/Screenshot/" + tname + ".png");

		FileUtils.copyFile(src, desc);

	}

	public String randomStringGenerator(int countofString) {

		String email = RandomStringUtils.randomAlphabetic(countofString);
		return email;

	}

	public String randomNumberGenerator(int countOfNumber) {

		String phoneNo = RandomStringUtils.randomNumeric(countOfNumber);
		return phoneNo;
	}

	public void filewriter(JSONObject jsonObject) throws IOException {
		
		FileWriter fileWriter = new FileWriter("customerId.json");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(jsonObject.toJSONString());
		bufferedWriter.close();
		fileWriter.close();
		
	}

	public String fileReader() throws IOException, ParseException {
		
		FileReader fileReader = new FileReader("customerId.json");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		Object parse = jsonParser.parse(bufferedReader);
		
		jsonObject = (JSONObject) parse;
		
		String id = (String) jsonObject.get("customerID");
		
		return id;

	}
	

}
