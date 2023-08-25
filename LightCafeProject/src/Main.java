// Stanley saputra - 2501961754

import java.io.Flushable;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    int table_number, delete, y;
    double itemprice = 0;
    double temp = 0;
    double earn;
    String item;
    Scanner sc = new Scanner(System.in);

    Vector<list> Listorder = new Vector<>();



    public class list{
        Vector<String> item = new Vector<>();
        double price = 0;
        int num = 0;
    }
    public Vector<list> getList(){
        return Listorder;
    }
    public void setList(Vector<list> Listorder){
        this.Listorder = Listorder;
    }

    void Menu(){
        System.out.println(" ");
        System.out.println("_________________________________");
        System.out.println("| ========  LIGHT CAFE  ======== |");
        System.out.println("---------------------------------");
        System.out.println("|Earn Money : " + earn + " $|");
        System.out.println("1. Add Order ");
        System.out.println("2. Show All Order ");
        System.out.println("3. Remove Order ");
        System.out.println("4. Exit ");
        System.out.print(">>> ");
    }

    public void cls(){
        for (int i=0;i<100;i++){
            System.out.println();
        }
    }

    public Main(){
        int num = 0;
        char x;

        do {
            Menu();
            num = sc.nextInt();

            switch(num){
                case 1 :
                    itemprice = 0;
                    list list = new list();
                    if(Listorder.size() == 0){

                        System.out.print("Table Number: ");
                        table_number = sc.nextInt();
                        list.num = table_number;



                        do {

                            System.out.print("How Many Items You Want To Order > ");
                            y = sc.nextInt();

                            double[] tempprice = new double[100];

                            for(int i=0; i<y;i++){
                                System.out.print("Food / Drinks Name : ");
                                item = sc.next();
                                list.item.add(item);

                                System.out.print("Price : ");
                                tempprice[i] = sc.nextDouble();

                                itemprice += tempprice[i];
                            }


                            do{
                                System.out.println("Add More Item ? [y/n] >> ");
                                x = sc.next().charAt(0);
                            } while(x != 'n' && x != 'y');

                        } while(x != 'n');
                        itemprice = itemprice + (0.1 * itemprice) + (0.075 * itemprice);
                        list.price = itemprice;
                        Listorder.add(list);

                    } else {

                        int temp = 0;
                        int getIndex = 0;

                        System.out.print("Number of Table : ");
                        table_number = sc.nextInt();

                        for(int i=0; i<Listorder.size();i++){
                            if(Listorder.get(i).num == table_number){
                                temp ++;
                                getIndex = i;
                                break;
                            }
                        }

                        if (temp > 0){
                            do{
                                System.out.print("How Many Items You Want To Order > ");
                                y = sc.nextInt();

                                double[] tempprice = new double[100];

                                for(int i=0; i<y;i++){
                                    System.out.print("Food / Drinks Name : ");
                                    item = sc.next();
                                    Listorder.get(getIndex).item.add(item);

                                    System.out.print("Price : ");
                                    tempprice[i] = sc.nextDouble();
                                    sc.nextLine();

                                    itemprice += tempprice[i];
                                }

                                do{
                                    System.out.println("Add More Item ? [y/n] >> ");
                                    x = sc.next().charAt(0);
                                } while(x != 'n' && x != 'y');
                            } while(x != 'n');

                            itemprice = itemprice + (0.1 * itemprice) + (0.075 * itemprice);
                            Listorder.get(getIndex).price += itemprice;

                        } else {
                            list.num = table_number;

                            do{
                                System.out.print("How Many Items You Want To Order > ");
                                y = sc.nextInt();

                                double[] tempprice = new double[100];

                                for(int i=0; i<y;i++){
                                    System.out.print("Food / Drinks Name : ");
                                    item = sc.next();
                                    list.item.add(item);

                                    System.out.print("Price : ");
                                    tempprice[i] = sc.nextDouble();
                                    sc.nextLine();

                                    itemprice += tempprice[i];
                                }

                                do{
                                    System.out.println("Add More Item ? [y/n] >> ");
                                    x = sc.next().charAt(0);
                                } while(x != 'n' && x != 'y');
                            } while(x != 'n');

                            itemprice = itemprice + (0.1 * itemprice) + (0.075 * itemprice);
                            list.price = itemprice;
                            Listorder.add(list);
                        }
                    }
                    break;

                case 2:
                    if(Listorder.size() == 0){
                        System.out.println("No Order Yet !!!");
                        System.out.print("Press enter to continue");
                        try{System.in.read();}
                        catch(Exception e){}
                    }
                    else{
                        for(int i=0;i<Listorder.size();i++){
                            System.out.println(" ");
                            System.out.println("Number of Table : " + Listorder.get(i).num);
                            System.out.println("List of items : ");
                            System.out.println("__________________________________");
                            for(int j=0;j<Listorder.get(i).item.size();j++){
                                System.out.println( j+1 + ". " + Listorder.get(i).item.get(j));
                            }
                            System.out.println("__________________________________");
                            System.out.println("Total Price :  " + Listorder.get(i).price);
                        }

                        System.out.print("Press enter to continue");
                        try{System.in.read();}
                        catch(Exception e){}
                    }
                    break;

                case 3:
                    int flag = 0;
                    System.out.print("Remove Table, No : ");
                    delete = sc.nextInt();
                    for(int i=0;i<Listorder.size();i++){
                        if(Listorder.get(i).num == delete){
                            earn += Listorder.get(i).price;
                            Listorder.remove(i);
                            flag = 1;
                        }
                    }

                    if(flag == 1){
                        System.out.println("Order Table Number " + delete + " Successfully Removed");
                    }
                    else{
                        System.out.println("No Order With That Number, Please Choose The Right Number !");
                    }
                    System.out.println("Press enter to continue");
                    try{System.in.read();}
                    catch(Exception e){}

                    break;

                case 4:

                    break;
            }


            cls();
        }while(num != 4);
    }


    public static void main(String[] args) {
        new Main();
    }
}