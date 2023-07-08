import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        List<String> brandNames = new ArrayList<>(Arrays.asList("samsung","lenovo","apple",
                "huawei","casper","asus","hp","xioami","monster"));
        List<Phone> phones = addPhones();
        List<Notebook> notebooks = addNotebook();

    }

    private static List<Phone> addPhones(){
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Samsung","s23",50000,10,
                20,512,8.7,5000,12,"black"));
        phones.add(new Phone("Apple","14 Pro Max",90000,5,
                30,256,5.3,3000,8,"white"));
        phones.add(new Phone("Xioami","Mi 14 pro",40000,20,
                50,1024,6.4,7000,16,"Grey"));
        return phones;
    }

    private static List<Notebook> addNotebook(){
        List<Notebook> notebooks = new ArrayList<>();
        notebooks.add(new Notebook("Monster","Tulpar",30000,
                20,60,512,15.6,16));
        notebooks.add(new Notebook("Apple","Macbook Pro M2",70000,
                10,25,2048,14,32));
        notebooks.add(new Notebook("Asus","Rog Strix",40000,
                15,30,512,15.6,24));
        return notebooks;
    }
    private static void listBrands(List<String> brandName){
         List<Brand> brands = new ArrayList<>();
         for (int i = 0 ; i < brandName.toArray().length ; i++){
             brands.add(new Brand(brandName.get(i)));
         }
         Collections.sort(brands);
         for (Brand b : brands){
             System.out.println("-" + b.getName().toUpperCase());
         }
    }

}
