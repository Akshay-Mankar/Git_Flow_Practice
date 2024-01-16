package DataDrivenFramework.DataDrivenFramework;

public class TwoDimArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//datatype [][] variable name = new datatype[row length][column length]
		
		String [][] abc = new String [3][2];
		
		//how to add values in Array
		
		abc[0][0] = "username1";
		abc[0][1] = "password1";
		
		abc[1][0] = "username2";
		abc[1][1] = "password2";
		
		abc[2][0] = "username3";
		abc[2][1] = "password3";
		
		System.out.println(abc[1][1]);
		
		System.out.println(abc[1][0]);
		
		int a = abc.length;
		
		System.out.println(a); //this will count rows
		
		//this will print rows using for loop and we entered the columns value from our side
		for(int i = 0; i < a; i++)
		{
			System.out.println("");
			 System.out.println(abc[i][0]+"\t"+abc[i][1]);
		}
		
				
	}

}
