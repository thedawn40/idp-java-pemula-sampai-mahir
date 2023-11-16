package idstar.idp;

import java.util.HashMap;
import java.util.Map;

public class Level1 {

    public int kuadrat(int n){
        int akarKuadrat = 1;
        int nilaiAwal = n;
        if(n>0){
            akarKuadrat = nilaiAwal * nilaiAwal;
        }
        return akarKuadrat;
    }

    public void kelipatanTigaDanLima(int n){

        for(int i =0; i < n; i++){
            if(i%3==0){
                if(i%5==0){
                    System.out.println("FizzBuzz");                   
                    continue;
                }
                System.out.println("Fizz");
            }
            else if(i%5==0){
                System.out.println("Buzz");
            }else{
                System.out.println(i);
            }
        }

    }

    public void nomor10(){
        Map<String, Integer> ageOfFriends = new HashMap<>();
        ageOfFriends.put("Mualim",27);
        ageOfFriends.put("Andi",27);
        ageOfFriends.put("Budi",23);

        for (Map.Entry<String, Integer> value : ageOfFriends.entrySet()) {
            String name = value.getKey();
            int age = value.getValue();
            System.out.printf("name: %s, value: %d%n", name, age);
        }
    }

    
}
