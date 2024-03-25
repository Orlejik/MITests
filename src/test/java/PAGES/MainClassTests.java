package PAGES;

import Core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainClassTests extends BaseSeleniumPage {
    public List<WebElement> findAllWebElems(){
        List<WebElement> webElemList = driver.findElements(new By.ByCssSelector("input-not-valid+span:before"));
        return webElemList;
    }
    int arrSize(List<WebElement> elems){
        return elems.size();
    }
    List<WebElement> listOfWebElems = findAllWebElems();
    int findAllWebElemsSize = findAllWebElems().size();

    public void printElemsAttribute(){
        if(!listOfWebElems.isEmpty()){
            for(WebElement elem : listOfWebElems){
                System.out.println(elem.getText() +" : "+elem.getCssValue("border"));
            }
        }
    }

}
