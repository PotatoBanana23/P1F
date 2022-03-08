import java.awt.print.Printable;
import java.io.File;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class p1 {

	int rows, cols, rooms;
	char[][] coordMap = new char[rows * rooms * cols][3];

	//ArrayDeque enlo;
	
	static Queue<Integer> enLo = new LinkedList<>(); 
	static Queue<Integer> deLo = new LinkedList<>(); 
	static int kX, kY; 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner;
		Scanner scanner2;
		Scanner scanner3;
		Scanner scanner4;
		Scanner scanner5;
		File f = new File("map1.txt");
		File f2 = new File("CoordinateMap1.txt");

		try {
			// code that might throw a special error
			scanner = new Scanner(f);
			scanner2 = new Scanner(f);
			scanner3 = new Scanner(f2);
			scanner4 = new Scanner(f2);
			scanner5 = new Scanner(f);
			// use next methods to grab first 3 numbers form the file
			// with your map info
			int rows = scanner.nextInt();
			System.out.println(rows);
			int cols = scanner.nextInt();
			System.out.println(cols);
			int rooms = scanner.nextInt();
			System.out.println(rooms);
			char[][] map = new char[rows * rooms][cols];
			int cX = 0;
			int cR = 0;
			
			scanner.nextLine();

			while (scanner.hasNextLine()) {

				String line = scanner.nextLine();

				// use charAt to grab the elements of the map for a given row

				// System.out.println(line);

				for (int j = 0; j < line.length(); j++) {

					map[cX][j] = line.charAt(j);

				}

				cX++;
			}

			for (int i = 0; i < rows * rooms; i++) {
				for (int j = 0; j < cols; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			coordinateBased(scanner2);

			// coordinateBased2(scanner3);

			char[][] cMap = coordinateBased2(scanner3);

			System.out.print(cMap);

			for (int i = 0; i < cMap.length; i++) {
				for (int j = 0; j < cMap[0].length; j++) {
					if ((cMap[i][j] + "").equals("K")) {
						kX = i / (rows);
						kY = j;
						System.out.print(" " + kX + " " + kY);

					}
				}

			}
			
			// ENQUEING KIRBY POSITION
			String kPos = (kX + "" + kY);
			int temp = Integer.parseInt(kPos);
			enLo.add(temp);
			//System.out.println(enLo.remove());
			deLo.add(enLo.remove());
			
			queueCake(scanner4);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static char[][] coordinateBased(Scanner scan) {
		int rows = scan.nextInt();
		int cols = scan.nextInt();
		int rooms = scan.nextInt();
		char[][] normMap = new char[rows * rooms][cols];
		char[][] coordMap = new char[rows * rooms * cols][3];
		int count = 0;
		int c = 0;

		scan.nextLine();
		while (scan.hasNextLine()) {

			String line = scan.nextLine();

			// use charAt to grab the elements of the map for a given row
			for (int i = 0; i < line.length(); i++) {
				coordMap[c][0] = line.charAt(i);
				coordMap[c][1] = ("" + count).charAt(0);
				coordMap[c][2] = ("" + i).charAt(0);

				c++;
			}
			count++;
			if (count > rows - 1) {
				count = 0;
			}
		}

		for (int i = 0; i < coordMap.length; i++) {
			for (int j = 0; j < coordMap[0].length; j++) {
				System.out.print(coordMap[i][j]);
			}
			System.out.println();
		}

		return coordMap;

	}

	public static char[][] coordinateBased2(Scanner scan) {
		int rows = scan.nextInt();
		System.out.println(rows);
		int cols = scan.nextInt();
		System.out.println(cols);
		int rooms = scan.nextInt();
		System.out.println(rooms);
		char[][] map = new char[rows * rooms * cols][3];
		int cX = 0;

		scan.nextLine();

		while (scan.hasNextLine()) {

			String line = scan.nextLine();

			// use charAt to grab the elements of the map for a given row
			for (int j = 0; j < line.length(); j++) {
				map[cX][j] = ("" + line).charAt(j);
			}
			cX++;
		}

		return map;

	}

	public static void queueCake(Scanner scan) {

	
		char[][] cMap = coordinateBased2(scan);

	
		
		System.out.println(enLo);
		System.out.println(deLo);
		
		//ENQUEING ALL WALKABLE TILES
		

	}

}