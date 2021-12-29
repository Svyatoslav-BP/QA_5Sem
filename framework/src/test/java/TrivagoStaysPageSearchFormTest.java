import org.testng.Assert;
import org.testng.annotations.Test;
import page.TrivagoHomePage;
import page.TrivagoStaysResultsPage;
import util.CommonConditions;

public class TrivagoStaysPageSearchFormTest extends CommonConditions {
    private static final String DESTINATION = "Minsk";
    private static final String BIG_GROUP_HINT_TEXT = "Big group? Try Hotelplanner.com for 6+ rooms";
    private static final int NUMBER_OF_ADULTS = 4;
    private static final int BIG_NUMBER_OF_ADULTS = 99;

    @Test
    public void bigGroupHintStaysPageTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);

        final String bigGroupHintText = homePage.openHomePage()
                                                .openRoomForm()
                                                .fillAdultsField(BIG_NUMBER_OF_ADULTS)
                                                .getBigGroupHintText();

        Assert.assertEquals(BIG_GROUP_HINT_TEXT, bigGroupHintText);
    }

    @Test
    public void findStaysTest() {
        TrivagoHomePage homePage = new TrivagoHomePage(driver);
        TrivagoStaysResultsPage resultsPage = homePage.openHomePage()
                                                      .enterDestination(DESTINATION)
                                                      .openRoomForm()
                                                      .fillAdultsField(NUMBER_OF_ADULTS)
                                                      .searchHotels();

        Assert.assertTrue(resultsPage.isInitialized());
    }
}
