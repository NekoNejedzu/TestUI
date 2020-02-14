package screens;

import testUI.elements.UIElement;

import static testUI.Utils.By.byAndroidUIAutomator;
import static testUI.Utils.By.byId;
import static testUI.elements.TestUI.E;

public class LandingScreen {
    // Elements
    private final UIElement shoppingListInput =
            E(byAndroidUIAutomator("textContains(\"Add a shopping list\")"));
    private final UIElement inputShoppingList = E(byId("editText"));
    private final UIElement addListButton = E(byId("android:id/button1"));
    private final UIElement addRecipeButton = E(byId("android:id/button1"));
    private final UIElement groceries =
            E(byAndroidUIAutomator("textContains(\"OurGroceries\")"));
    private final UIElement shoppingListTitle =
            E(byAndroidUIAutomator("textContains(\"SHOPPING LIST\")"));
    private final UIElement recipesTitle =
            E(byAndroidUIAutomator("textContains(\"RECIPES\")"));
    private final UIElement addRecipe =
            E(byAndroidUIAutomator("textContains(\"Add a recipe...\")"));
    private final UIElement addRecipeName =
            E(byAndroidUIAutomator("textContains(\"RecipesName\")"));



    // Methods
    public LandingScreen checkLandingScreen(String... args) {
        for (String arg : args) {
            UIElement element =
                    E(byAndroidUIAutomator("textContains(\"" + arg + "\")"));
            element.waitFor(5).untilIsVisible();
        }

        return this;
    }

    public void clickAddRecipe() {
        shoppingListInput.click();
    }

    public void typeInRecipeName(String var) {
        inputShoppingList.sendKeys(var);
    }

    public void clickOnAddRecipe() {
        addRecipeButton.shouldHave().attribute("text").equalTo("ADD RECIPE");
        addRecipeButton.click();
    }

    public void checkNewList(String arg) {
        UIElement element = E(byAndroidUIAutomator("textContains(\"" + arg + "\")"));
        element.waitFor(5).untilIsVisible();
    }

    public void goRecipe(String list) {
        E(byAndroidUIAutomator("text(\"" +list+"\")")).waitFor(5).untilIsVisible().click();
    }

    public void checkNoList(String arg) {
        UIElement element = E(byAndroidUIAutomator("textContains(\"" + arg + "\")"));
        element.waitFor(5).untilNotVisible();
    }
}
