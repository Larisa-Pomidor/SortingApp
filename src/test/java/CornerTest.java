import org.example.Sorting;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CornerTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test
  public void zeroParameterTest() {
    Sorting.main(new String[]{});
    Assert.assertEquals("[]", outContent.toString());
  }

  @Test
  public void oneParameterTest() {
    Sorting.main(new String[]{"1"});
    Assert.assertEquals("[1]", outContent.toString());
  }

  @Test
  public void tenParameterTest() {
    Sorting.main(new String[]{"10", "9", "8", "7", "6", "5", "4", "3", "2", "1"});
    Assert.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", outContent.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void moreThanTenParameterTest() {
    Sorting.main(new String[]{"10", "9", "8", "7", "6", "5", "4", "3", "2", "1", "0"});
  }
}
