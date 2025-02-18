import java.io.*;
import java.lang.annotation.Target;
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
    public static boolean tryLogin(String email, File myFile) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(myFile));
        while(bufferedReader.readLine() != null) {
            if (bufferedReader.readLine().contains(email)) {
                System.out.println("Login realizado com sucesso!");
                bufferedReader.close();
                return false;
            } else {
                System.out.println("User não encontrado");
                bufferedReader.close();
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        File myFile = new File("./src/teste.txt");
        FileWriter fileWriter = new FileWriter(myFile, true);
        FileReader fileReader = new FileReader(myFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String name = "Camillao";
        Scanner sc = new Scanner(myFile);
        if(myFile.exists()){
            System.out.println("O arquivo existe mesmo: ");
            tryLogin(name,myFile);
        }
        else{
            System.out.println("O arquivo não existe");
        }

   }

}