package tests;

import org.junit.jupiter.api.*;
import pageObjects.MainPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConstructorNavigationTests extends BaseTest {

    private MainPage constructorMainPage;

    @BeforeEach
    public void setupTest() {

        constructorMainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    public void navigateToBunsSectionTest() {
        constructorMainPage.clickSaucesSection();
        constructorMainPage.clickBunsSection();
        assertTrue(constructorMainPage.isBunsSectionActive(), "Раздел 'Булки' не стал активным");
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    public void navigateToSaucesSectionTest() {
        constructorMainPage.clickSaucesSection();
        assertTrue(constructorMainPage.isSaucesSectionActive(), "Раздел 'Соусы' не стал активным");
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    public void navigateToFillingsSectionTest() {
        constructorMainPage.clickFillingsSection();
        assertTrue(constructorMainPage.isFillingsSectionActive(), "Раздел 'Начинки' не стал активным");
    }
}