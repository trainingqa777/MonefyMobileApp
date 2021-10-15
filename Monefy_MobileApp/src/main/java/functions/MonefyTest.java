package functions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MonefyTest extends Base {

	public static void main(String[] args) {
		MonefyTest mt = new MonefyTest();
		
		mt.verifyAddAccountOptions();

	}
	
	WebElement Settings() {
		return driver.findElement(By.id("com.monefy.app.lite:id/overflow"));}
	
	WebElement categories_panel() {
		return driver.findElement(By.id("com.monefy.app.lite:id/categories_panel"));}
	
	WebElement ExpenseTab() {
		return driver.findElement(By.id("com.monefy.app.lite:id/relativeLayoutManageCategoriesListItemType"));}
	
	WebElement accounts_panel() {
		return driver.findElement(By.id("com.monefy.app.lite:id/accounts_panel"));}
	
	WebElement currency_panel() {
		return driver.findElement(By.id("com.monefy.app.lite:id/currency_panel"));}
	
	WebElement settings_panel() {
		return driver.findElement(By.id("com.monefy.app.lite:id/settings_panel"));}
	WebElement AddButton() {
		return driver.findElement(By.id("com.monefy.app.lite:id/imageButtonAddCategory"));}
	WebElement CategoryName() {
		return driver.findElement(By.id("com.monefy.app.lite:id/editTextCategoryName"));}
	WebElement initialAmount() {
		return driver.findElement(By.id("com.monefy.app.lite:id/initialAmount"));}
	WebElement CashImage() {
		return driver.findElement(By.xpath("//android.widget.GridView/android.widget.FrameLayout[2]/android.widget.FrameLayout"));}
	WebElement SaveAmount() {
		return driver.findElement(By.id("com.monefy.app.lite:id/save"));}
	WebElement MainBalance() {
		return driver.findElement(By.id("com.monefy.app.lite:id/balance_amount"));}
	WebElement Add_Expense_Text() {
		return driver.findElement(By.id("com.monefy.app.lite:id/amount_text"));}
	WebElement Add_Expense_Note() {
		return driver.findElement(By.id("com.monefy.app.lite:id/textinput_placeholder"));}
	WebElement Submit_Button() {
		return driver.findElement(By.id("com.monefy.app.lite:id/keyboard_action_button"));}
	

	public void startApplication() {
		try {
			Repo repo = new Repo("build.properties");
			InitilizeAndOpenAppliction(repo.getValue("ApplicationMonefy"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void verifyCategories() {
		startApplication();
		Settings().click();
		categories_panel().click();
		boolean isExpenseTabDisplayed = ExpenseTab().isDisplayed();
		Assert.assertTrue(isExpenseTabDisplayed, "Expense Tab displayed under Categories");
		categories_panel().click();	
	}
	
	public void verifyAddAccountOptions() {
		startApplication();
		Settings().click();
		accounts_panel().click();
		AddButton().click();
		CategoryName().sendKeys("Cash");
		initialAmount().clear();
		String amount = "1000";
		initialAmount().sendKeys(amount);
		CashImage().click();
		SaveAmount().click();
		String MainBalance = MainBalance().getText();
		boolean isAmountAdded = MainBalance.contains(amount);
		Assert.assertTrue(isAmountAdded);		
	}

	public void addExpense() {
		startApplication();
		
		String Expenseamount = "1000";
		Add_Expense_Text().sendKeys(Expenseamount);
		Add_Expense_Note().sendKeys("Monthly Rent");
		Submit_Button().click();
		
	}
}
