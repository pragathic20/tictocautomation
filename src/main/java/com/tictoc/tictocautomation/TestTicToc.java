package com.tictoc.tictocautomation;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestTicToc {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\ronak\\eclipse-workspace\\tictocautomation");
		driver = new ChromeDriver();
		driver.get("https://codepen.io/jshlfts32/full/bjambP/");
		TestTicToc tic = new TestTicToc();
		tic.checkTitle();
		tic.checkTextInInitialScreenDisplay();
		tic.checkWaterMarkTextInInitialScreenDisplay();
		tic.checkWaterMarkAppearsCompletely();
		tic.checkButtonInInitialScreenDisplay();
		tic.checkButtonNameInInitialScreenDisplay();
		tic.checkCreateBoardForAlphaInput();
		tic.checkCreateBoardForValidInput();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

	public void checkTitle() {
		int compare = driver.getTitle().compareTo("CodePen - Broken (on purpose) Tic Tac Toe");
		// assert compare==0:"Testcase 1: checkTitle Pass";
		if (compare == 0) {
			System.out.println("Testcase 1: checkTitle Pass");
		} else {
			System.out.println("Testcase 1: checkTitle Fail");

		}

	}

	public void checkTextInInitialScreenDisplay() {
		driver.switchTo().frame(driver.findElement(By.id("result")));
		WebElement textField = driver.findElement(By.xpath("//*[@id=\"number\"]"));
		// element.sendKeys("2");
		int compare = textField.getAttribute("type").compareTo("text");
		if (compare == 0) {
			System.out.println("Testcase 2:Text field found");
		} else {
			System.out.println("Testcase 2:Text field  not found");

		}

	}

	public void checkWaterMarkTextInInitialScreenDisplay() {
		// driver.switchTo().frame(driver.findElement(By.id("result")));
		WebElement textField = driver.findElement(By.xpath("//*[@id=\"number\"]"));

		int compare = textField.getAttribute("placeholder").compareTo("Enter a number to generate a tic tac toe board");
		if (compare == 0) {
			System.out.println("Testcase 3:Text field's water mark found");
		} else {
			System.out.println("Testcase 3:Text field's water mark  not found");

		}

	}

	public void checkWaterMarkAppearsCompletely() {
		WebElement textField = driver.findElement(By.xpath("//*[@id=\"number\"]"));
		int textFieldSize = textField.getSize().getWidth();
		int waterMarkSize = "Enter a number to generate a tic tac toe board".length();

		if (textFieldSize >= 348) {
			System.out.println("Testcase 4:WaterMark appears completely:Pass");
		} else {
			System.out.println("Testcase 4:WaterMark  does not appear completely:Fail");

		}

	}

	public void checkButtonInInitialScreenDisplay() {
		WebElement button = driver.findElement(By.xpath("//*[@id=\"start\"]"));
		int compare = button.getTagName().compareTo("button");
		if (compare == 0) {
			System.out.println("Testcase 5:Button found");

		} else {
			System.out.println("Testcase 5:Button  not found");

		}

	}

	public void checkButtonNameInInitialScreenDisplay() {
		WebElement button = driver.findElement(By.xpath("//*[@id=\"start\"]"));
		boolean isPlay = button.getText().matches("Play");

		if (isPlay) {
			System.out.println("Testcase 6:Button name is Play");

		} else {
			System.out.println("Testcase 6:Button  name is not Play");

		}
	}

	public void checkCreateBoardForAlphaInput() throws InterruptedException {

		WebElement textField = driver.findElement(By.xpath("//*[@id=\"number\"]"));
		WebElement button = driver.findElement(By.xpath("//*[@id=\"start\"]"));
		textField.clear();
		textField.sendKeys("abcd");
		button.click();
		Thread.sleep(5000);
		List<WebElement> trList = driver.findElements(By.tagName("tr"));
		List<WebElement> tdList = driver.findElements(By.tagName("td"));
		System.out.println("trList.size()" + trList.size());
		System.out.println("tdList.size()" + tdList.size());

		if (trList.size() == 0 && tdList.size() == 0) {
			System.out.println("Testcase 7:Tic Tac Toe Board is not created:Pass");

		} else {
			System.out.println("Testcase 7:Tic Tac Toe Board is  created:Fail");

		}

	}

	public void checkCreateBoardForValidInput() throws InterruptedException {

		WebElement textField = driver.findElement(By.xpath("//*[@id=\"number\"]"));
		WebElement button = driver.findElement(By.xpath("//*[@id=\"start\"]"));
		textField.clear();
		Random rand = new Random();
		int rows = 2 + rand.nextInt(8);
		textField.sendKeys("" + rows);
		button.click();
		Thread.sleep(8000);
		List<WebElement> trList = driver.findElements(By.tagName("tr"));
		List<WebElement> tdList = driver.findElements(By.tagName("td"));
		System.out.println("trList.size()" + trList.size());
		System.out.println("tdList.size()" + tdList.size());

		if (trList.size() == rows && tdList.size() == rows * rows) {
			System.out.println("Testcase 8:Tic Tac Toe Board is created:Pass");

		} else {
			System.out.println("Testcase 8:Tic Tac Toe Board is not created:Fail");

		}

	}
}
