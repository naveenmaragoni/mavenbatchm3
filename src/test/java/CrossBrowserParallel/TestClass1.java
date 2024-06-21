package CrossBrowserParallel;

import org.testng.annotations.Test;

public class TestClass1 extends BaseClass{
@Test
public void googleTest() {
	driver.get("https://www.google.com/");
 }
}
