package sortngGame;

import java.util.Scanner;
import java.util.Stack;

public class GameControl 
{
	static Scanner sc = new Scanner(System.in);
	static GameData gd = new GameData();
	public static void main(String[] args) throws InterruptedException 
	{
		gameIntro();
		System.out.print("\n\n\n\n\n\nEnter Your name : ");
		String name=sc.nextLine();
		if(name.length()<3)
		{
			name=name+"\t\t\t";
		}
		else if(name.length()<11)
		{
			name=name+"\t\t";
		}
		else if(name.length()<19)
		{
			name=name+"\t";
		}
		Stack<String> al1 =gd.getAl1();
		al1.clear();
		shuffle(al1);
		Stack<String> al2 =gd.getAl2();	
		al2.clear();
		shuffle(al2);
		Stack<String> al3 =gd.getAl3();	
		al3.clear();
		shuffle(al3);
		Stack<String> al4 =gd.getAl4();	
		al4.clear();
		shuffle(al4);
		Stack<String> al5 =gd.getAl5();
		al5.clear();
		int steps=0;
		while(true)
		{
			System.out.println("\n\t\t\t   ASIDE SIMILAR\n\n");
			System.out.println(" Hii "+name+"\t\t\t Total Moves : "+steps+"\n\n\n\n\n\n\n\n");
			System.out.println("\t\t1\t2\t3\t4\t5");
			System.out.println("\t   ———————————————————————————————————————————");
			for(int i=0;i<=3;i++)
			{
				System.out.print("\t\t");
				stack(i,al1);
				stack(i,al2);
				stack(i,al3);
				stack(i,al4);
				stack(i,al5);
				System.out.print("\n");
			}
			checkWinner();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.print("\t From <space> To\t    →\t\t");
			String option1=sc.next();
			String option2=sc.next();
			switch(option1)
			{
			case "1":	positionChange(al1,option2);	break;
			case "2":	positionChange(al2,option2);	break;
			case "3":	positionChange(al3,option2);	break;
			case "4":	positionChange(al4,option2);	break;
			case "5":	positionChange(al5,option2);	break;
			case "exit":exit();							return;
			}
			steps++;
		}
	}
//
	private static void gameIntro() throws InterruptedException 
	{
		System.out.println("\n\n\n\n\n\n\n\n\n       o          o o      o o o o    o o o o o      o o o o o");
		Thread.sleep(150);
		System.out.println("      o o       o     o       o         o      o     o");
		Thread.sleep(150);
		System.out.println("     o   o        o           o         o       o    o o o o");
		Thread.sleep(150);
		System.out.println("    o o o o         o         o         o       o    o");
		Thread.sleep(150);
		System.out.println("   o       o    o     o       o         o      o     o");
		Thread.sleep(150);
		System.out.println("  o         o     o o      o o o o    o o o o o      o o o o o");
		Thread.sleep(150);
		System.out.println("\n\t\t\t ___\t\t\t\t  ___");
		Thread.sleep(150);
		System.out.println("\t\t\t \\    |  |\\  /|  |  |       /\\    |  \\");
		Thread.sleep(150);
		System.out.println("\t\t\t  \\   |  | \\/ |  |  |      /--\\   |__/");
		Thread.sleep(150);
		System.out.println("\t\t\t___\\  |  |    |  |  |____ /    \\  |  \\");
		Thread.sleep(500);
	}
	private static void checkWinner() throws InterruptedException 
	{
		String icon[]= {"+","○","□","~"};
		int j=0;
		for(int i=0;i<icon.length;i++)
		{
			if(gd.getAl1().contains(icon[i]))
			{
				j++;
			}
			if(gd.getAl2().contains(icon[i]))
			{
				j++;
			}
			if(gd.getAl3().contains(icon[i]))
			{
				j++;
			}
			if(gd.getAl4().contains(icon[i]))
			{
				j++;
			}
			if(gd.getAl5().contains(icon[i]))
			{
				j++;
			}
		}
		if(j==4)
		{
			System.out.println("\n\n\n\nV       V  I I I     C C C   T T T T     O O      R R R    Y     Y");
			System.out.println(" V     V     I     C            T      O     O    R    R    Y   Y");
			System.out.println("  V   V      I    C             T     O       O   R R R       Y");
			System.out.println("   V V       I     C            T      O     O    R   R       Y");
			System.out.println("    V      I I I     C C C      T        O O      R     R     Y\n\n\n\n");
			System.out.print("\t\tDo you want to try again ? (Y / N) :- ");
			String option = sc.next();
			switch(option)
			{
			case "Y":
			case "y":	main(icon);	break;
			case "N":
			case "n":	exit();		break;
			}
		}
	}
	private static void positionChange(Stack<String> al, String option2) 
	{
		switch(option2)
		{
		case "1":	gd.getAl1().push(al.peek());
					if(gd.getAl1().size()>4)
					{
						gd.getAl1().pop();
					}
					else
					{
						al.pop();
					}
					break;
		case "2":	gd.getAl2().push(al.peek());
					if(gd.getAl2().size()>4)
					{
						gd.getAl2().pop();
					}
					else
					{
						al.pop();
					}
					break;
		case "3":	gd.getAl3().push(al.peek());
					if(gd.getAl3().size()>4)
					{
						gd.getAl3().pop();
					}
					else
					{
						al.pop();
					}
					break;
		case "4":	gd.getAl4().push(al.peek());
					if(gd.getAl4().size()>4)
					{
						gd.getAl4().pop();
					}
					else
					{
						al.pop();
					}
					break;
		case "5":	gd.getAl5().push(al.peek());
					if(gd.getAl5().size()>4)
					{
						gd.getAl5().pop();
					}
					else
					{
						al.pop();
					}
					break;
		}		
	}
	private static void stack(int i, Stack<String> al)
	{
		int j=0;
		boolean k=false;
		for(Object o : al)
		{
			String b = (String) o;
			if(j++==i)
			{
				System.out.print(b+"\t");
				k=true;
			}
		}
		if(k==false)
		{
			System.out.print(" \t");
		}
		
	}
	private static void shuffle(Stack<String> al)
	{
		String icon[]= {"+","○","□","~"};
		int i=0;
		while(i!=4)
		{
			int random=(int)(Math.random()*10)%4;
			if(icon[random]!="0")
			{
				al.push(icon[random]);
				icon[random]="0";
				i++;
			}
		}
	}

	private static void exit() 
	{
		for(int i=0;i<3;i++)
		{
			System.out.println(" ◇   ×   ◻   ▷   ▯    ◊   □   △   ×   ◁   ○   ◇   +   ◻   ▷   ▯\n");
			System.out.println(" □   ◊   △   ×   ◁    ○   ◇   +   ◻   ▷   ▯   □   ◇   ×   ○   △\n");
		}
		System.out.println(" ◇   ×   ◻   ▷   ▯    ◊   □   △   ×   ◁   ○   ◇   +   ◻   ▷   ▯\n");
		System.out.println(" △   ×   ◁   ○   -------------------------------   △   ×   ◁   ○");
		System.out.println("                 ⁝       T H A N K   Y O U       ⁝");
		System.out.println(" △   ×   ◁   ○   -------------------------------   △   ×   ◁   ○\n");
		for(int i=0;i<3;i++)
		{
			System.out.println(" □   ◊   △   ×   ◁    ○   ◇   +   ◻   ▷   ▯   □   ◇   ×   ○   △\n");
			System.out.println(" ◇   ×   ◻   ▷   ▯    ◊   □   △   ×   ◁   ○   ◇   +   ◻   ▷   ▯\n");
		}
		System.out.println(" □   ◊   △   ×   ◁    ○   ◇   +   ◻   ▷   ▯   □   ◇   ×   ○   △\n");
		System.out.print  (" ◇   ×   ◻   ▷   ▯    ◊   □   Designed by : Saswat Kumar Pradhan");
		int x=sc.nextInt();
	}
}
