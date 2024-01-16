package DataDrivenFramework.DataDrivenFramework;

public class OneDimArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//one dimensional array 
		
		String [] abc = new String[5];
		
		abc[0] = "Seleniun";
		abc[1] = "Cucumber";
		abc[2] = "TestNG";
		abc[3] = "Spring Boot FrameWork";
		abc[4] = "Rest Assured";
		
		System.out.println(abc.length);
		System.out.println(abc[1]);
		
		for(int i = 0; i < abc.length; i++)
		{
			System.out.println(abc[i]);
		}
		
	}

}
