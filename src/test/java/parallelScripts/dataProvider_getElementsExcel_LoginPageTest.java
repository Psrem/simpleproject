package parallelScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class dataProvider_getElementsExcel_LoginPageTest {
	
	WebDriver driver;
	Properties prop;

	@BeforeMethod
	public void setup() throws IOException {

		prop = new Properties();
		String path = System.getProperty("user.dir") + "//src//test//resources//configFiles//config.properties";
		FileInputStream fin = new FileInputStream(path);
		prop.load(fin);

		String strBrowser = prop.getProperty("browser");
		if (strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (strBrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test(dataProvider = "loginData")
	public void validLogin(String un, String pwd) throws InterruptedException {

		driver.get(prop.getProperty("url"));
		driver.findElement(By.cssSelector(readObjRepo("LoginUN"))).sendKeys(un);
		driver.findElement(By.xpath(readObjRepo("LoginPWD"))).sendKeys(pwd);
		driver.findElement(By.cssSelector(readObjRepo("LoginButton"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		boolean isDisp = driver.findElement(By.cssSelector(readObjRepo("SucessMsg"))).isDisplayed();
		Assert.assertTrue(isDisp);
	}
	
	public String readObjRepo(String objName) {
		
		String objPath = null;
		
		String path = System.getProperty("user.dir") + "//src//test//resources//testData//loginData.xlsx";
		//HSSF .. xlx
		//XSSF .. xlsx
		FileInputStream fin;
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet("loginPage");
		int numRows = sheet.getLastRowNum();
		for(int i=1; i<=numRows; i++) {
			XSSFRow row = sheet.getRow(i);
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(objName)) {
				objPath = row.getCell(1).getStringCellValue();
			}
		}
		return objPath;
	}

	@DataProvider(name = "loginData")
	public Object[][] getData() throws CsvValidationException, IOException {
		
		String path = System.getProperty("user.dir") + "//src//test//resources//testData//loginData.csv";
		CSVReader reader = new CSVReader(new FileReader(path));
		String cols[];
		ArrayList<Object> dataList = new ArrayList<Object>();
        while((cols = reader.readNext()) != null) {
			Object[] record = {cols[0], cols[1]};
			dataList.add(record);
		}
        return dataList.toArray(new Object[dataList.size()][]);		
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}


}
