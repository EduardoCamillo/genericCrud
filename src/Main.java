import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {



        File myFile = new File("./src/teste.txt");
        FileWriter fileWriter = new FileWriter(myFile, true);
        Scanner sc = new Scanner(myFile);
        if(myFile.exists()){
            System.out.println("O arquivo existe mesmo: ");
            //System.out.println(sc.nextLine());
            fileWriter.write("Adicionando esta string");
            fileWriter.close();
            System.out.println("Acrescentado: " + sc.nextLine());
            sc.close();
        }
        else{
            System.out.println("O arquivo não existe");
        }
   }
    public void cadastraUser(String nome){

    }
}