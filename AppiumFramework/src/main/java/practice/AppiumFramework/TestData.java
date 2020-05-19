package practice.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name="InputData")
	public Object[][] getDataforEditField()
	{
		
		//2 sets of data, "hello", "!@#$%"
		//Testng will execute 2 times since there is 2 sets of data (2 arrays)
		Object[][] obj = new Object[][]
				{
			{"hello"}
			
				};
		
				return obj;
	}	
}
