import java.io.*;
import java.lang.annotation.Target;
import java.util.Scanner;

public class Main {

    public static void cadastraUser(String nome,String email,File myFile) throws IOException {
                FileWriter fw = new FileWriter(myFile, true);
                fw.write(nome + " " +  email + "   ");
                fw.close();
                System.out.println("Usuário cadastrado com sucesso!");

    }
    public static void deletaUsers(File myFile) throws IOException {
            FileWriter fw = new FileWriter(myFile);
            fw.flush();
            fw.close();
    }
    public static boolean tryLogin(String email, File myFile) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(myFile));
        String line = bufferedReader.readLine();
        if (line != null) {
            while(line != null) {
                if (line.contains(email)) {
                    System.out.println("Login realizado com sucesso!");
                    return true;
                } else {
                    System.out.println("User não encontrado");
                    return false;
                }
            }
        }else {
            System.out.println("Está nulo!");
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        File myFile = new File("./src/teste.txt");
        int selector;
        String name;
        String email;
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(myFile);

        if(myFile.exists()){
            System.out.println("Digite seu nome para efetuar login: ");
            name = scanner.nextLine();
            boolean bool = tryLogin(name,myFile);
            if(!bool){
                System.out.println("Usuário não encontrado, deseja efetuar o cadastro?\n" +
                        "Digite 1 para sim ou 2 para apagar todos usuários: ");
                selector = scanner.nextInt();
                if(selector == 1){
                    System.out.println("Digite seu email: ");
                    email = scanner.next();
                    System.out.println("Cadastrando usuário " + email + "...");
                    cadastraUser(name, email, myFile);
                }
                if(selector == 2){
                    deletaUsers(myFile);
                }
                else{
                    System.out.println("Gracias!");
                }
            }
        }
        else{
            System.out.println("O arquivo não existe");
        }
   }
}