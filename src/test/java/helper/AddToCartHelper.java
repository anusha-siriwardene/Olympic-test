package helper;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.Common;

public class AddToCartHelper extends Common {
	
	By loginLinkXPath = By.xpath("//*[@id='header-panel']//ul/li[contains(a, 'Login')]");
	By usernameXPath =  By.xpath("//*[@id='Email']");
	By passwordXPath =  By.xpath("//*[@id='Password']");
	By loginBtnXPath = By.xpath("//*[@id='content-panel']//input[@type='submit']");
	By searchTxtXPath = By.xpath("//*[@id='search']");
	By searchListLinkXPath = By.xpath("//*[@id=\"searchList\"]");
	By searchListTxtAreaXPath = By.xpath("//textarea[@name='searchList']");
	By findProductBtnXpath = By.xpath("//input[@value='Find products']");
	By productNameListXpath = By.xpath("//div[@id='product-list']//h3");
	By nextPageXPath = By.xpath("//*[@id='content-panel']/div/div[2]/div[1]/div[1]/div/ul/li[7]/a");
	By trollyImgXPath = By.xpath("//*[@id='trolley-summary-panel']//img[@alt='Trolley']");
	By viewAllLinkXPath = By.xpath("//*[@id='trolley-panel']//a[text()='View All']");
	By saveTrollyLinkXPath = By.xpath("//*[@id='trolley-container']//a[text()='Save Trolley']");
	By trollyNameXPath = By.xpath("//*[@id='listName']");
	By trollySaveBtnXPath = By.xpath("//*[@id='content-panel']//input[@value='Save']");
	By clearTrollyXPath = By.xpath("//*[@id='trolley-container']//a[text()='Clear Trolley']");
	
	WebDriver driver = myWebDriver();
	
	
	public void navigateToSite() {
		driver.get("http://shop.countdown.co.nz/");
	}
	
	public void loginToApp(String username, String password) {
		try {
			driver.findElement(loginLinkXPath).click();
			driver.findElement(usernameXPath).sendKeys(username);
			driver.findElement(passwordXPath).sendKeys(password);
			driver.findElement(loginBtnXPath).click();
		}catch (Exception e) {
			System.out.println("Error has occered while user logins!");
			System.out.println(e);
		}
	}
	
	public void clickSearch (){
		try {
			driver.findElement(searchTxtXPath).click();
		}catch (Exception e) {
			System.out.println("Error has occered while click serch text");
			System.out.println(e);
		}
		
	}
	
	public void clickSearchList() {
		try {
			driver.findElement(searchListLinkXPath).click();
		}catch (Exception e) {
			System.out.println("Error has occered while navigate to searchlist!");
			System.out.println(e);
		}
	}
	
	public void addItemList(String products) {
		try {
			WebElement element = driver.findElement(searchListTxtAreaXPath);
			element.clear();
			String[] productsList = products.split(",");
			for (String product : productsList) {
				element.sendKeys(product);
				element.sendKeys(Keys.ENTER);
			}
		}catch (Exception e) {
			System.out.println("Error has occered while enter items list!");
			System.out.println(e);
		}
	}
	
	public void clickFindProductBtn() {
		try {
			driver.findElement(findProductBtnXpath).click();
		}catch (Exception e) {
			System.out.println("Error has occered while adding items!");
			System.out.println(e);
		}
	}
	
	public void selectProduct(String productNameList) throws InterruptedException {
		Thread.sleep(5000);
		try {
			String[] productList = productNameList.split(",");
			ArrayList<String> prodArrayList = new ArrayList<String>(Arrays.asList(productList));
			do {
				for(int count = 0; count < prodArrayList.size(); count++) {
					//WebElement prodNameElem = driver.findElement(By.xpath("//*[@id='product-list']//h3[contains(text(), '"+ prodArrayList.get(count) + "')]"));
					
					if(driver.findElements(By.xpath("//*[@id='product-list']//h3[contains(text(), '"+ prodArrayList.get(count) + "')]")).size()!=0) {
						driver.findElement(By.xpath("//*[@id='product-list']//h3[contains(text(), '" + prodArrayList.get(count) + "')]/../../../../div[@class='gridProductStamp-trolley']//button[@data-action='addToTrolley']")).click();
					}
				}
				for(int count = 0; count < prodArrayList.size(); count++) {
					//WebElement prodNameElem = driver.findElement(By.xpath("//*[@id='product-list']//h3[contains(text(), '"+ prodArrayList.get(count) + "')]"));
					
					if(driver.findElements(By.xpath("//*[@id='product-list']//h3[contains(text(), '"+ prodArrayList.get(count) + "')]")).size()!=0) {
						prodArrayList.remove(count);
					}
				}
				driver.findElement(nextPageXPath).click();
				Thread.sleep(5000);
			}while(prodArrayList.size() > 0);
		}catch (Exception e) {
			System.out.println("Error has occered while selecting product items!");
			System.out.println(e);
		}
	}
	
	public void selectTrollyIcon() {
		try {
			driver.findElement(trollyImgXPath).click();
		}catch (Exception e) {
			System.out.println("Error has occered while clikc on trolly icon!");
			System.out.println(e);
		}
	}
	
	public void clickViewAll() {
		try {
			driver.findElement(viewAllLinkXPath).click();
		}catch (Exception e) {
			System.out.println("Error has occered while click on view all button!");
			System.out.println(e);
		}
	}
	
	public void clickSaveTrolly() {
		try {
			driver.findElement(saveTrollyLinkXPath).click();
		}catch (Exception e) {
			System.out.println("Error has occered while click on save trolly!");
			System.out.println(e);
		}
	}
	
	public void saveTrollyWithName(String trollyName) {
		try {
			driver.findElement(trollyNameXPath).sendKeys(trollyName);
			driver.findElement(trollySaveBtnXPath).click();
		}catch (Exception e) {
			System.out.println("Error has occered while save trolly!");
			System.out.println(e);
		}
	}
	
	public void verifyList(String listofproducts) {
		try {
			String[] arrayProdLis = listofproducts.split(",");
			selectTrollyIcon();
			for (String product : arrayProdLis) {
				assertTrue(driver.findElements(By.xpath("//*[@id='dropdown-trolley-wrapper']//span[contains(text(),'"+ product +"')]")).size()!=0);
			}
		}catch (Exception e) {
			System.out.println("Error has occered while verify trolly items!");
			System.out.println(e);
		}
	}
	
	public void clearTrolly() {
		clickViewAll();
		driver.findElement(clearTrollyXPath).click();
	}
	
	public void browserClose() {
		driver.close();
	}
}
