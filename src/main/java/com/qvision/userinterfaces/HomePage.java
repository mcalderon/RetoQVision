package com.qvision.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    private HomePage(){}

    public static final Target PRODUCT = Target.the("Combination Pliers")
            .located(By.cssSelector("[data-test='product-01M7ZDCKM2CWJATQTJCPFMSVVP']"));
}
