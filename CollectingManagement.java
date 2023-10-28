package CollectingWaste;

import java.util.Scanner;

public class CollectingManagement {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CollectingManagement collectingManagement = new CollectingManagement();
        collectingManagement.displayMenu();
    }

    public void displayMenu() {
        System.out.println(
                "--------- collecting household waste-----------\n Please Enter number garbage transfer station \n");
        int station = checkNumber();
        int[] a = new int[station];
        System.out.println("Enter weight of garbage in each station (Kg)");
        for (int i = 0; i < a.length; i++) {
            a[i] = checkNumber();
        }
        int total =0;
        int time =0;
        int truck = 0;
        for (int i = 0; i < a.length; i++) {
            total += a[i];
            time += 8;
            if(total >10000 ){
                total -= a[i];
                time -= 8;
                time += 30;
                truck += 1;
                total = 0;
            }
            if( i == a.length -1){
                time += 30;
                truck +=1;
            }
        }
        
        System.out.println("Total cost: " + (time* 2000 + truck* 57000));

    }

    public int checkNumber(){
        int station=-1;
        while (true) {
            try {
                station = Integer.parseInt(sc.nextLine());
                
            } catch (NumberFormatException e) {
                System.out.println("Number not correct");
            }
            if (station < 0) {
                System.out.println("A Number must be a positive number");
                
            } else{
                return station;
            }
        }
    }
}
