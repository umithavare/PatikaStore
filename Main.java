import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        List<String> brandNames = new ArrayList<>(Arrays.asList("samsung","lenovo","apple",
                "huawei","casper","asus","hp","xioami","monster"));
        List<Phone> phones = addPhones();
        List<Notebook> notebooks = addNotebook();
        int choose;
        boolean duration = true;
        while (duration){
            System.out.println("\n 1 - Brand List \n 2 - Phones \n" +
                    " 3 - Notebooks \n 4 - Add product \n" +
                    " 5 - Delete Product \n 6 - Exit \n  Choose one: ");
            choose = input.nextInt();
            switch (choose){
                case 1: {
                    listBrands(brandNames);
                    break;
                }
                case 2: {
                    listedPhone(phones);
                    break;
                }
                case 3: {
                    listedNotebook(notebooks);
                    break;
                }
                case 4: {
                    addProduct(brandNames,phones,notebooks);
                    break;
                }
                case 5: {
                    deleteProduct(phones,notebooks);
                    break;
                }
                case 6: {
                    duration = false;
                    break;
                }
                default:{
                    System.out.println("Choose one Please");
                }
            }
        }

    }

    private static List<Phone> addPhones(){ //telefon eklemek icin yazdıgımız method
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Samsung","s23",50000,10,
                20,512,8.7,5000,12,"black"));
        phones.add(new Phone("Apple","14 Pro Max",90000,5,
                30,256,5.3,3000,8,"white"));
        phones.add(new Phone("Xioami","Mi 14 pro",40000,20,
                50,1024,6.4,7000,16,"Grey"));
        return phones;
    }

    private static List<Notebook> addNotebook(){ // Notebook eklemek için yazdıgımız method
        List<Notebook> notebooks = new ArrayList<>();
        notebooks.add(new Notebook("Monster","Tulpar",30000,
                20,60,512,15.6,16));
        notebooks.add(new Notebook("Apple","Macbook Pro M2",70000,
                10,25,2048,14,32));
        notebooks.add(new Notebook("Asus","Rog Strix",40000,
                15,30,512,15.6,24));
        return notebooks;
    }
    private static void listBrands(List<String> brandName){ // markaları Büyük harflerle sıralamak içi yazdıgımız method
         List<Brand> brands = new ArrayList<>();
         for (int i = 0 ; i < brandName.toArray().length ; i++){
             brands.add(new Brand(brandName.get(i)));
         }
         Collections.sort(brands);
         for (Brand b : brands){
             System.out.println("-" + b.getName().toUpperCase());
         }
    }
    private static void listedPhone(List<Phone> phones) {
        System.out.format("%-5s %-8s %-25s %-14s %-10s %-10s %-10s %-10s%n", "|ID|", "|Brand|", "|Descp|", "|Price|", "|Memory|", "|Ram|", "|Size|", "|Colour|");
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (Phone p : phones) {
            System.out.format("%-5s %-8s %-25s %-14s %-10s %-10s %-10s %-10s%n", p.getId(), p.getBrand(), p.getDescription(), p.getUnitPrice() + " TL", p.getMemory() + " GB", p.getRam() + " GB", p.getSize() + "`", p.getColour());
        }
    }

    private static void listedNotebook(List<Notebook> notebooks){ // Bilgisayarları format şeklinde listelemek için yazılan method
        System.out.format("%-5s %-8s %-25s %-14s %-10s %-10s %-10s%n", "|ID|", "|Brand|", "|Descp|", "|Price|", "|Memory|", "|Ram|", "|Size|");
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (Notebook n : notebooks){
            System.out.format("%-5s %-8s %-25s %-14s %-10s %-10s %-10s%n", n.getId(), n.getBrand(), n.getDescription(), n.getUnitPrice() + " TL", n.getMemory() + " GB", n.getRam() + " GB", n.getSize() + "`");
        }
    }

    public static void addProduct(List<String> brandNames, List<Phone> phones, List<Notebook> notebooks ){

        // Bu
        System.out.println("Choose product to you want add\n 1 - Phone \n 2 - Notebook \n Choose one :)) ");
        List<String> values = new ArrayList<>();
        int choose = input.nextInt();
        switch (choose){
            case 1: { // Telefon eklenmesi icin yazilan case
                String[] brands = new String[]{"Brand", "Descp", "Price", "Discount", "stock", "Memory", "Size", "Battery", "Ram", "Colour"};
                for (String brand : brands) {
                    System.out.println(brand + " : ");
                    String value = input.next();
                    while (brand.equals("Brand") && !brandNames.contains(value.toLowerCase())) {
                        System.out.print(brand + " -> write it again : ");
                        value = input.next();
                    }
                    values.add(value);
                }
                phones.add(new Phone(values.get(0).toUpperCase(), values.get(1).toUpperCase(),
                        Double.parseDouble(values.get(2)), Double.parseDouble(values.get(3)),
                        Integer.parseInt(values.get(4)), Integer.parseInt(values.get(5)),
                        Double.parseDouble(values.get(6)), Integer.parseInt(values.get(7)),
                        Integer.parseInt(values.get(8)), values.get(9)));
                break;
            }
            case 2: { // Notebook eklenmesi icin yazilan case
                String[] brands = new String[]{"Brand", "Descp", "Price", "Discount", "Stock", "Memory", "Size", "Ram"};
                for (String brand : brands){
                    System.out.println(brand + " : ");
                    String value = input.next();
                    while (brand.equals("Brand") && !brandNames.contains(value.toLowerCase())){
                        System.out.print(brand + " -> write it again : ");
                        value = input.next();
                    }
                    values.add(value);
                }
                notebooks.add(new Notebook(values.get(0).toUpperCase(),values.get(1).toUpperCase(),
                        Double.parseDouble(values.get(2)),Double.parseDouble(values.get(3)),
                        Integer.parseInt(values.get(4)), Integer.parseInt(values.get(5)),
                        Double.parseDouble(values.get(6)),Integer.parseInt(values.get(7))));
            }
        }
    }


    private static void deleteProduct(List<Phone> phones, List<Notebook> notebooks){

        // Here we brought the product from the list according to the id and then deleted that value.
        System.out.println("Choose product to you want delete \n 1 - Phone \n 2 - Notebook \n Choose one");
        List<String> values = new ArrayList<>();
        int choose = input.nextInt();
        switch (choose){
            case 1 : {
                listedPhone(phones);
                System.out.println("Enter items code of you want to delete ");
                int id = input.nextInt();
                phones.removeIf(phone -> phone.getId() == id);
                break;
            }
            case 2 : {
                listedNotebook(notebooks);
                System.out.println("Enter items code of you want to delete ");
                int id = input.nextInt();
                notebooks.removeIf(notebook -> notebook.getId() == id);
                break;
            }
        }
    }

}
