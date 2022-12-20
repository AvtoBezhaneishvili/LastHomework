package NewPackage;

import Utils.ChromeRunner;
import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class New extends ChromeRunner {

    @Test
    public void Hw_4() {


        $(byText("Create new account")).click();
        $(byName("firstname")).setValue("Avto");
        SelenideElement FirstName = $(byName("firstname")).setValue("Avto");
        Assert.assertTrue(FirstName.is(Condition.enabled));
        $(byName("lastname")).setValue("Bezhaneishvili");
        Assert.assertFalse($(byName("lastname")).is(Condition.empty), "name input");
        $(byName("reg_email__")).setValue("avtandilius@mail.com");
        $(byName("reg_passwd__")).setValue("facebook1993");
        $(byName("reg_email_confirmation__")).setValue("avtandilius@mail.com");
        $("#day").selectOption("16");
        $("#month").selectOption("Oct");
        $("#year").selectOption("1993");
        $(byText("Custom")).click();
        $(byName("preferred_pronoun")).shouldBe(Condition.visible, Duration.ofMillis(2000));
        $(byName("custom_gender")).shouldBe(Condition.visible, Duration.ofMillis(2000));
        $(byText("Male")).click();
        $(byName("preferred_pronoun")).shouldBe(Condition.disappear);
        $(byName("preferred_pronoun")).shouldBe(Condition.disappear);







    }

}
