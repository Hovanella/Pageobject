package com.example.autotests;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SuperLamaPage {

    public final String URL = "https://superlama.by/";

    public final SelenideElement accessoriesReference = $x("/html/body/div[5]/div/div[2]/ul/li[2]/a");

    ////*[@id='min_price']
    public final SelenideElement minPriceInput = $x("//*[@id='min_price']");
    public final SelenideElement maxPriceInput = $x("//*[@id='max_price']");
    public final SelenideElement productGrid = $x("//div[@class='product-grid']");
    public final SelenideElement LamaboxesLink = $x("//a[@href='/boxes']");
    public final SelenideElement header = $x("//h1");

    public final SelenideElement SearchByFranchise  = $x("//a[contains(@style, '16px;')]");
    public final SelenideElement GogoLink = $x("//a[contains(@href, 'jojo')]");
}
