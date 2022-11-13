package com.example.autotests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import dev.failsafe.internal.util.Assert;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class SuperLanaPageTest {
    private final SuperLamaPage superLamaPage = new SuperLamaPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open(superLamaPage.URL);
    }

    @Test
    public void WhenMinAndMaxPriceIs0_NoItemsShouldBeDisplayedInProductGrid() {
        superLamaPage.accessoriesReference.click();
        superLamaPage.minPriceInput.setValue("0");
        superLamaPage.maxPriceInput.setValue("0");
        superLamaPage.minPriceInput.pressTab();
        Assert.isTrue(!superLamaPage.productGrid.find("div").isDisplayed(), "Product grid is not empty");
    }

    @Test
    public void WhenPressLamaboxesButton_HeaderShouldHaveTextLamaboxes() {
        superLamaPage.LamaboxesLink.click();
        Assert.isTrue(superLamaPage.header.getText().equals("Ламабоксы"), "Header text is not equal to 'Ламабоксы'");
    }

    @Test void WhenGoToJojoFranciseLink_HeaderShoudHaveTextJojonoKimyounaBouken(){
        superLamaPage.SearchByFranchise.click();
        superLamaPage.SearchByFranchise.hover();
        superLamaPage.GogoLink.click();
        Assert.isTrue(superLamaPage.header.getText().equals("Jojo no Kimyou na Bouken"), "Header text is not equal to 'Jojo no Kimyou na Bouken'");

    }

}
