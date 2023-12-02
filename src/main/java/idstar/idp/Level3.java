package idstar.idp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Level3 {

    public static void main(String[] args) throws IOException {    
        menu();
    }

    public static void header(){
        System.out.println("--------------------------------");
        System.out.println("Aplikasi Pengolah Nilai Siswa");
        System.out.println("--------------------------------");
    }

    public static void menu() throws IOException{
        try (Scanner sc1 = new Scanner(System.in)) {
            header();
            System.out.println("Letakan file csv dengan nama file data_sekolah di direktori berikut: C://temp/direktori");        
            System.out.println("1. Generate txt untuk menampilkan modus");
            System.out.println("2. Generate txt untuk menampilkan nilai rata-rata, median");
            System.out.println("3. Generate Kedua File");
            System.out.println("0. Exit");
            int pilih = sc1.nextInt();
            if(pilih==1||pilih==2||pilih ==3){
                menuGenerateFile(pilih);
            }else if(pilih==0){
                System.exit(0);
            }else{
                System.out.println("Command not found");
            }
        }

    }

    public static void menuGenerateFile(int pilih) throws IOException{
        if(pilih==1||pilih==2){
            generateTxt(pilih);                
        }else if(pilih==3){
            generateTxt(1);                
            generateTxt(2);                
        }
        try (Scanner sc1 = new Scanner(System.in)) {
            header();
            System.out.println("File telah di generate di C://temp/direktori");        
            System.out.println("Silakan Cek");        
            System.out.println("0. Exit");
            System.out.println("1. Kembali Ke Menu Utama");
            int input = sc1.nextInt();
            if(input==1){
                menu();
            }else if(input==0){
                System.exit(0);
            }else{
                System.out.println("Command not found");
            }    
        }
    }
    
    static void menuNotFound() throws IOException{
        try (Scanner sc1 = new Scanner(System.in)) {
            header();
            System.out.println("File tidak ditemukan");        
            System.out.println("0. Exit");
            System.out.println("1. Kembali Ke Menu Utama");
            int input = sc1.nextInt();
            if(input==1){
                menu();
            }else if(input==0){
                System.exit(0);
            }else{
                System.out.println("Command not found");
            }    
        }
    }

    public static void generateTxt(int type) throws IOException{
        String path = "C://temp/direktori/";
        String menu = "";
        if(type==1){
            menu = "modus";
        }else if(type==2){
            menu = "mean_median";
        }
        String filePath = (path+"data_sekolah.csv");
        if(exists(filePath, "file")){
            FileWriter myWriter = new FileWriter(new File(path,("data_sekolah_"+menu+".txt")));
            try (Scanner scanner = new Scanner(new File(filePath))) {
                while (scanner.hasNextLine()) {
                       myWriter.write(byClass(scanner.nextLine(), type));
                       myWriter.write("\n");    
                }
            }catch(Exception e){
                System.out.println("error");
            }
            myWriter.close();    
        }else{
            menuNotFound();
        }
    }

    public static String byClass(String a, int type){
        String[] b = a.split(";");
        String kelas = b[0];        
        List<Integer> list = new ArrayList<>();
        for(int i =1; i < b.length; i++){
            list.add(Integer.valueOf(b[i]));
        }
        if(type==1){
            return kelas+" : Mode "+mode(list);
        }else if(type==2){
            return kelas+" : Mean "+mean(list) + ", Median "+median(list);
        }
        return "";
    }

    static boolean exists(String path, String type){
        File file = new File(path);
        boolean result = false;
        if(type.equalsIgnoreCase("file")){
            result = file.exists();
        }else if(type.equalsIgnoreCase("dir")){
            result = file.isDirectory();
        }
        return result;
    }
    static int mode(List<Integer> a) {
        int n = a.size();
        int maxValue = 0, maxCount = 0, i, j;
  
        for (i = 0; i < n; ++i) {
           int count = 0;
           for (j = 0; j < n; ++j) {
              if (a.get(j) == a.get(i))
              ++count;
           }
  
           if (count > maxCount) {
              maxCount = count;
              maxValue = a.get(i);
           }
        }
        return maxValue;
    }

    static double mean(List<Integer> a ){
        int total = 0;
        int n = a.size();
        for(int i =0; i <n; i++){
            total = total + a.get(i);
        }
        return total/n;        
    }

    static double median(List<Integer> list){
        int[] arr = convertListInteger(list);
        int[] arrSort = sort(arr);
        int n = arr.length;
        double m=0;
        if(n%2==1)
        {
            m=arrSort[(n+1)/2-1];
        }
        else
        {
            m=(arrSort[n/2-1]+arrSort[n/2])/2;
        }
        return m;
    }

    static int[] convertListInteger(List<Integer> a){
        int[] result = new int[a.size()];
        for(int i  = 0 ; i < a.size(); i++){
            result[i] = a.get(i);
        }
        return result;
    }

    static int[] sort(int[] arr){
        int[] b = arr;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = 0;
                if (arr[j] < arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return b;
    }

    
}
