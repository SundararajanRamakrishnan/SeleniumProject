package com.training.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class RTTC_046_Remove_add_order {
    private WebDriver driver;
    public RTTC_046_Remove_add_order(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//i[@class='fa fa-shopping-cart fw']")
    private WebElement mo;
    @FindBy(linkText="Orders")
    private WebElement orders;
    @FindBy(xpath="//i[@class='fa fa-pencil']")
    private WebElement editicon;
    @FindBy(xpath="//i[@class='fa fa-arrow-right']")
    private WebElement ccontinue;
    @FindBy(xpath="//i[@class='fa fa-minus-circle']")
    private WebElement clickremovebtn;
    @FindBy(id="input-product")
    private WebElement chooseprod;
    @FindBy(id="input-quantity")
    private WebElement quantity;
    @FindBy(id="button-product-add")
    private WebElement addprodbtn;
    @FindBy(linkText="Lorem ipsum dolor sit amet")
    private WebElement Lprod;
    @FindBy(id="button-cart")
    private WebElement continuebtn;
    @FindBy(id="button-payment-address")
    private WebElement continuepayment;
    @FindBy(id="button-shipping-address")
    private WebElement continueshipping;
    @FindBy(id="button-save")
    private WebElement savebtn;
    
    @FindBy(id="button-customer")
    private WebElement ContinueButtonClick;
    //Method to click on salesicon
    public void mouseonsalesicon()
    {
        Actions action=new Actions(driver);
        action.moveToElement(mo).build().perform();
    }
    //Method to click on orderslink
    public void clickonorderslink() {
        this.orders.click();
    }
    //Method to click on editbutton
    public void clickoneditbutton()
    {
        this.editicon.click();
    }
    // Method to click on continue
    public void clickoncontinue()
    {
        this.ccontinue.click();
    }
    ////Method to click on removeicon
    public void clickonremoveicon()
    {
        this.clickremovebtn.click();
    }
    //Method to type prodctname
    public void sendproductname(String prod)
    {
        
        this.chooseprod.clear();
        this.chooseprod.sendKeys(prod);
        this.Lprod.click();
    }
    ////Method to enter valid credentials in Quality text box
    public void sendQuantity(String quantity)
    {
        this.quantity.clear();
        this.quantity.sendKeys(quantity);
        
    }
    //Method to click on add product
    public void clickonaddproduct()
    {
        this.addprodbtn.click();
        
    }
    // To click on continue
    public void clickcontinue()
    {
        this.continuebtn.click();
    }
    //To click on continue of paymentpage
    public void clickcontinueonpaymentpage()
    {
        this.continuepayment.click();
    }
    //To click on continue of shipping page
    public void clickoncontinueshipping()
    {
        this.continueshipping.click();
    }
    // To click on save button
    public void clickonsave()
    {
        this.savebtn.click();
    }
    
    public void ContinueClickButton()
    {
    	this.ContinueButtonClick.click();
    }
    }
