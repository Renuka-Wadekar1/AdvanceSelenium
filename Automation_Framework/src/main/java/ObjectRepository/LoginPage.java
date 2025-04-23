package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule 1
	//Rule 2 -Declaration
	@FindBy(id="user-name") 
	private WebElement UsernameText;
	
	@FindBy(id="password") 
	private WebElement PasswordText;
	
	@FindBy(id="login-button") 
	private WebElement LoginBtn;

	//Rule 3 -intialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4 -Utilization

	public WebElement getUsernameText() {
		return UsernameText;
	}

	public WebElement getPasswordText() {
		return PasswordText;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
}
