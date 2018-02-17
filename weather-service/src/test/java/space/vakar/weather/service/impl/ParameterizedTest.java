package space.vakar.weather.service.impl;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTest {

  private long size;
  private String colore;

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {{0, "Red"}, {1, "Green"}, {2, "Yellow"}});
  }

  public ParameterizedTest(int size, String colore) {
    this.size = size;
    this.colore = colore;
  }

  @Test
  public void testA() {
    System.out.println("Test A=======================");
    System.out.println(size);
    System.out.println(colore);
    System.out.println("=============================");
  }

  @Test
  public void testB() {
    System.out.println("Test B=======================");
    System.out.println(size);
    System.out.println(colore);
    System.out.println("=============================");
  }
}
