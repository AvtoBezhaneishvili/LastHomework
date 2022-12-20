package NewPackage;

import com.codeborne.selenide.selector.ByAttribute;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.open;
import static com. codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.*;

public class Elit {
    @Test
    public void test() {
        open("https://ee.ge/");
        $(byId("search_list")).setValue("მობილური").pressEnter();  sleep(2000);
        $(byId("sort")).selectOption("ფასი ზრდადობით"); sleep(2000);
        int count = $(".product-list-parent").$$(".product-list").size();
        System.out.println(count);
        String firstPrice = $(By.className("price-section"),0).$(byTagName("span")).getText();
        System.out.println(firstPrice);
        Float firstPriceFloat = Float.parseFloat(firstPrice);
        for (int i = 1; i < count; i++) {
            String secondPrice = $(By.className("price-section"),1).$(byTagName("span")).getText();
            System.out.println(secondPrice);
            Float secondPriceFloat = Float.parseFloat(secondPrice);
            Assert.assertTrue(firstPriceFloat <= secondPriceFloat);
            firstPrice = secondPrice;

        }
    }
}
