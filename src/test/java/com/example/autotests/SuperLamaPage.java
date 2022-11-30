package com.example.autotests;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class SuperLamaPage {

    public final String URL = "https://superlama.by/";

    public final SelenideElement accessoriesLink = $x("/html/body/div[5]/div/div[2]/ul/li[2]/a");

    public final SelenideElement minPriceInput = $x("//*[@id='min_price']");
    public final SelenideElement maxPriceInput = $x("//*[@id='max_price']");
    public final SelenideElement productGrid = $x("//div[@class='product-grid']");
    public final SelenideElement LamaboxesLink = $x("//a[@href='/boxes']");
    public final SelenideElement header = $x("//h1");

    public final SelenideElement SearchByFranchise  = $x("//a[contains(@style, '16px;')]");
    public final SelenideElement GogoLink = $x("//a[contains(@href, 'jojo')]");

    public void clickOnElement(SelenideElement element){
        element.click();
    }

    public void setValueOnInput(SelenideElement inputElement,String Value){
        inputElement.setValue(Value);
    }

    public void PressTabOnElement(SelenideElement element){
        element.pressTab();
    }

    public void hoverOnElement(SelenideElement element) {
        element.hover();
    }

    public void setPriceInputsTo0Values() throws InterruptedException {
        setValueOnInput(minPriceInput,"0");
        setValueOnInput(maxPriceInput,"0");
        PressTabOnElement(maxPriceInput);
        wait(100);
    }

    public void goToGogoSection() {
        clickOnElement(SearchByFranchise);
        hoverOnElement(SearchByFranchise);
        clickOnElement(GogoLink);
    }

    public void openPage() {
        open(URL);
    }
}
