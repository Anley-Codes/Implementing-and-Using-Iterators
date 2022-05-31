import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.append(new MenuItem("Miniature crab cakes", Menu.APPETIZER, Menu.NOTHEARTHEALTHY, "12.34"));
        menu.append(new MenuItem("Grilled chicken", Menu.MAIN_DISH, Menu.NOTHEARTHEALTHY, "40.32"));
        menu.append(new MenuItem("Sweet summer vegetables", Menu.MAIN_DISH, Menu.HEARTHEALTHY, "9.43"));
        menu.append(new MenuItem("Caprese salad", Menu.APPETIZER, Menu.NOTHEARTHEALTHY, "20.2"));
        menu.append(new MenuItem("Strawberry shortcake", Menu.DESSERT, Menu.NOTHEARTHEALTHY, "12.34"));
        menu.append(new MenuItem("Chicken Salad Sandwich", Menu.MAIN_DISH, Menu.HEARTHEALTHY, "10.0"));
        menu.append(new MenuItem("Lobstar mac and cheese", Menu.MAIN_DISH, Menu.HEARTHEALTHY, "1.23"));
        menu.append(new MenuItem("Cheeseburger", Menu.MAIN_DISH, Menu.NOTHEARTHEALTHY, "10.2"));

        MenuIterator iterator;
        MenuItem item = null;
        int optionChosen;
        Scanner scan = new Scanner(System.in);

        do {
            showMenu();
            optionChosen = scan.nextInt();
            switch (optionChosen) {

                case 1:
                    iterator =  menu.getAllItemsItr();
                    System.out.println("-----DISPLAY ALL MENU ITEMS---------");
                    while (iterator.hasNext()) {
                        item = iterator.next();

                        System.out.println(item.getItemName() + " " + item.getPrice());

                    }

                    break;

                case 2:
                    iterator =  menu.getItemIterator(Menu.APPETIZER);
                    System.out.println("-----DISPLAY ALL APPETIZERS---------");
                    while (iterator.hasNext()) {
                        item = iterator.next();
                        if(item.getCategory() == Menu.APPETIZER){

                            System.out.println(item.getItemName() + " " + item.getPrice());
                        }

                    }
                    break;
                case 3:
                    iterator =  menu.getItemIterator(Menu.MAIN_DISH);
                    System.out.println("-----DISPLAY ALL MAIN DISHES---------");
                    while (iterator.hasNext()) {
                        item = iterator.next();
                        if(item.getCategory() == Menu.MAIN_DISH){

                            System.out.println(item.getItemName() + " " + item.getPrice());
                        }

                    }
                    break;
                case 4:
                    iterator =  menu.getItemIterator(Menu.DESSERT);
                    System.out.println("--------DISPLAY ALL DESSERTS-----");
                    while (iterator.hasNext()) {
                        item = iterator.next();
                        if(item.getCategory() == Menu.DESSERT){

                            System.out.println(item.getItemName() + " " + item.getPrice());
                        }

                    }
                    break;
                case 5:
                    iterator =  menu.getHeartHealthyItemsItr();
                    System.out.println("-----DISPLAY ALL HEART HEALTHY ITEMS---------");
                    while (iterator.hasNext()) {
                        item = iterator.next();
                        if (item.getHeartHealthy()) {

                            System.out.println(item.getItemName() + " " + item.getPrice());
                        }

                    }

                    System.out.println("ALL MENU ITEMS");
                    break;
                case 6:
                    System.out.println("Enter a specified price");
                    String p = scan.next();
                    double SpecifiedPrice = Double.parseDouble(p);
                    iterator =  menu.getPriceIterator(SpecifiedPrice);
                    while (iterator.hasNext()) {
                        item = iterator.next();

                        double Itemprice = Double.parseDouble(item.getPrice());
                        if(Itemprice <= SpecifiedPrice){

                            System.out.println(item.getItemName() + " " + Itemprice);
                        }

                    }
                    break;
                case 7:
                    System.out.println("Enter Item name");
                    String name = scan.next();
                    System.out.println("Enter Category");
                    System.out.println("1- APPETIZER" );
                    System.out.println("2- MAIN_DISH" );
                    System.out.println("3- DESSERT" );
                    int category=scan.nextInt();
                    int cat = 0;
                    if (category==1){
                        cat=Menu.APPETIZER;
                    }
                    else if (category==2){
                        cat=Menu.MAIN_DISH;
                    }
                    else if (category==3){
                        cat=Menu.DESSERT;
                    }
                    System.out.println("Heart Healthy?");
                    System.out.println("1-HEART HEALTHY" );
                    System.out.println("2-NOT HEART HEALTHY" );
                    int heartHealthyCheck=scan.nextInt();
                    boolean heartHealthy = false;
                    if(heartHealthyCheck==1){
                       heartHealthy= Menu.HEARTHEALTHY;
                    }
                    else if(heartHealthyCheck==2){
                        heartHealthy=Menu.NOTHEARTHEALTHY;
                    }

                    System.out.println("Enter Price");
                    String price=scan.next();

                    menu.append(new MenuItem(name,cat,heartHealthy,price));
                    break;

                case 8:
                    System.out.println("Enter Item name");
                    String Dname = scan.next();
                    System.out.println("Enter Category");
                    System.out.println("1- APPETIZER" );
                    System.out.println("2- MAIN_DISH" );
                    System.out.println("3- DESSERT" );
                    int Dcategory=scan.nextInt();
                    int Dcat = 0;
                    if (Dcategory==1){
                        Dcat=Menu.APPETIZER;
                    }
                    else if (Dcategory==2){
                        Dcat=Menu.MAIN_DISH;
                    }
                    else if (Dcategory==3){
                        Dcat=Menu.DESSERT;
                    }
                    System.out.println("Heart Healthy?");
                    System.out.println("1-HEART HEALTHY" );
                    System.out.println("2-NOT HEART HEALTHY" );
                    int DheartHealthyCheck=scan.nextInt();
                    boolean DheartHealthy = false;
                    if(DheartHealthyCheck==1){
                        DheartHealthy= Menu.HEARTHEALTHY;
                    }
                    else if(DheartHealthyCheck==2){
                        DheartHealthy=Menu.NOTHEARTHEALTHY;
                    }

                    System.out.println("Enter Price");
                    String Dprice=scan.next();
                    menu.remove(new MenuItem(Dname,Dcat,DheartHealthy,Dprice));
                    break;
            }
        } while (optionChosen != 0);

    }




    public static void showMenu() {
        System.out.println("---------MENU OPTIONS--------------");
        System.out.println("1-Display all menu items");
        System.out.println("2-Display all appetizers");
        System.out.println("3-Display all main dishes");
        System.out.println("4-Display all desserts");
        System.out.println("5-Display all heart healthy items");
        System.out.println("6-Display all main dishes under a specified price");
        System.out.println("7-Add menu item");
        System.out.println("8-Delete menu item");
        System.out.println("0-quit");
    }
}
