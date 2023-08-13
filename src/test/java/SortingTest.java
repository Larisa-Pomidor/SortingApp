import org.example.Sorting;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class SortingTest {

  private String[] inputArray;
  private String[] expectedArray;

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  public SortingTest(String[] inputArray, String[] expectedArray) {
    this.inputArray = inputArray;
    this.expectedArray = expectedArray;
  }

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
            {new String[]{"5", "3", "9", "1", "7"}, new String[]{"1", "3", "5", "7", "9"}},
            {new String[]{}, new String[]{}},
            {new String[]{"7", "4", "1"}, new String[]{"1", "4", "7"}},
            {new String[]{"10", "-5", "8", "0"}, new String[]{"-5", "0", "8", "10"}},
            {new String[]{"1", "1", "1", "1", "1"}, new String[]{"1", "1", "1", "1", "1"}}
    });
  }

  @Test
  public void testSort() {
    Sorting.main(inputArray);
    assertEquals(Arrays.toString(expectedArray), outContent.toString());
  }

}