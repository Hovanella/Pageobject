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
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        superLamaPage.openPage();
    }

    @Test
    public void WhenMinAndMaxPriceIs0_NoItemsShouldBeDisplayedInProductGrid() throws InterruptedException {
        superLamaPage.clickOnElement(superLamaPage.accessoriesLink);
        superLamaPage.setPriceInputsTo0Values();
        Assert.isTrue(superLamaPage.productGrid.findAll("div").size()==0, "Product grid is not empty");
    }

    @Test
    public void WhenPressLamaboxesButton_HeaderShouldHaveTextLamaboxes() {
        superLamaPage.clickOnElement(superLamaPage.LamaboxesLink);
        Assert.isTrue(superLamaPage.header.getText().equals("Ламабоксы"), "Header text is not equal to 'Ламабоксы'");
    }

    @Test void WhenGoToJojoFranciseLink_HeaderShoudHaveTextJojonoKimyounaBouken(){
        superLamaPage.goToGogoSection();
        Assert.isTrue(superLamaPage.header.getText().equals("Jojo no Kimyou na Bouken"), "Header text is not equal to 'Jojo no Kimyou na Bouken'");

    }

}
