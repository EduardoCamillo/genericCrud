import java.io.*;
import java.util.Scanner;


public class Main {

    public static void cadastraUser(String nome,String email,File myFile) throws IOException {
            FileWriter fw = new FileWriter(myFile);
            fw.write(nome + " " +  email);
            fw.close();
            System.out.println("Usuário cadastrado com sucesso!");
    }
    public static void deletaUsers(File myFile) throws IOException {
            FileWriter fw = new FileWriter(myFile);
            fw.flush();
    }
    public static boolean login(String email, File myFile){
        if(email.isEmpty()){
            return false;
        }else{
            return true;
        }
    }


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

}