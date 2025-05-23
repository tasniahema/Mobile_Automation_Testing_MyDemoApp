package Android;

import java.net.MalformedURLException;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class MobileAppTest {
	// android driver declaration
	public AndroidDriver driver;

	@SuppressWarnings("deprecation")

	@BeforeTest
	public void Setup() throws MalformedURLException {
		DesiredCapabilities apptest = new DesiredCapabilities();
		apptest.setCapability("appium:deviceName", "Pixel4a");
		apptest.setCapability("platformName", "android");
		apptest.setCapability("appium:automationName", "UiAutomator2");
		apptest.setCapability("appium:udid", "emulator-5554");
		apptest.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.rn");
		apptest.setCapability("appium:appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");

		URL remoteurl = new URL("http://127.0.0.1:4723");
		driver = new AndroidDriver(remoteurl, apptest);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test
	public void Testone() throws InterruptedException {

		System.out.println("Demo Apps Open Successfully");

		// Assert product page
		WebElement productpage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Products\"]"));
		String product = productpage.getText();
		Assert.assertEquals(product, "Products");
		System.out.println("Assertion Completed");

		// click first product
		driver.findElement(By.xpath(
				"(//android.view.ViewGroup[@content-desc=\"store item\"])[1]/android.view.ViewGroup[1]/android.widget.ImageView"))
				.click();
		Thread.sleep(5000);

		// click add to cart button to buy a product
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Add To Cart button\"]")).click();
		Thread.sleep(5000);

		// click cart icon
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView"))
				.click();
		Thread.sleep(3000);

		// Assert My cart page
		WebElement cart = driver.findElement(By.xpath("//android.widget.TextView[@text=\"My Cart\"]"));
		String cartpage = cart.getText();
		Assert.assertEquals(cartpage, "My Cart");
		System.out.println(" Cart page Hard Assertion Completed");

		// add 2nd products
		driver.findElement(
				By.xpath("//android.view.ViewGroup[@content-desc=\"counter plus button\"]/android.widget.ImageView"))
				.click();
		Thread.sleep(3000);
		// add 3rd products
		driver.findElement(
				By.xpath("//android.view.ViewGroup[@content-desc=\"counter plus button\"]/android.widget.ImageView"))
				.click();
		Thread.sleep(3000);

		// remove one item
		driver.findElement(
				By.xpath("//android.view.ViewGroup[@content-desc=\"counter minus button\"]/android.widget.ImageView"))
				.click();
		Thread.sleep(3000);

		// Assert My cart page
		WebElement item = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"total number\"]"));
		String itemcount = item.getText();
		Assert.assertEquals(itemcount, "2 items");
		System.out.println(" Item count Completed");

		// click proceed to checkout
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Proceed To Checkout button\"]")).click();
		Thread.sleep(3000);

		// Assert Login page
		WebElement login = driver.findElement(By.xpath("(//android.widget.TextView[@text=\"Login\"])[1]"));
		String loginpage = login.getText();
		Assert.assertEquals(loginpage, "Login");
		System.out.println(" Login page Hard Assertion Completed");

		// user name
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]"))
				.sendKeys("bob@example.com");
		// password
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]"))
				.sendKeys("10203040");

		// click login
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]")).click();
		Thread.sleep(3000);

		// Assert Checkout page
		WebElement checkout = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Checkout\"]"));
		String check = checkout.getText();
		Assert.assertEquals(check, "Checkout");
		System.out.println(" Checkout page  Assertion Completed");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Full Name* input field\"]")).sendKeys("Tasnia Sultana");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Address Line 1* input field\"]")).sendKeys("Mirpur 1");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Address Line 2 input field\"]")).sendKeys("Road 1");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"City* input field\"]")).sendKeys("Dhaka");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"State/Region input field\"]")).sendKeys("Dhaka");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Zip Code* input field\"]")).sendKeys("1216");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Country* input field\"]"))
				.sendKeys("Bangladesh");
		Thread.sleep(5000);

		// click To payment
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"To Payment button\"]")).click();

		// cart details
		WebElement carddetails = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Card\"]"));
		String card = carddetails.getText();
		Assert.assertEquals(card, "Card");
		System.out.println(" Card Details  page  Assertion Completed");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Full Name* input field\"]"))
				.sendKeys("Tasnia Sultana");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Card Number* input field\"]"))
				.sendKeys("3258 1265 7568 789");

		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Expiration Date* input field\"]"))
				.sendKeys("09/25");

		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Security Code* input field\"]"))
				.sendKeys("123");

		// click Review Order
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Review Order button\"]")).click();
		Thread.sleep(3000);

		// Review Your order
		WebElement Revieworder = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Review your order\"]"));
		String Review = Revieworder.getText();
		Assert.assertEquals(Review, "Review your order");
		System.out.println("Review Order page Assertion Completed");
		Thread.sleep(3000);

		// click Place Order
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Place Order button\"]")).click();

		// Checkout Complete
		WebElement CheckoutComplete = driver
				.findElement(By.xpath("//android.widget.TextView[@text=\"Checkout Complete\"]"));
		String Complete = CheckoutComplete.getText();
		Assert.assertEquals(Complete, "Checkout Complete");
		System.out.println("CheckoutComplete page  Assertion Completed");
		Thread.sleep(3000);

		// click Continue Shopping
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Continue Shopping button\"]")).click();

	}

	@AfterTest
	public void CloseApp() {
		driver.quit();
	}
}
