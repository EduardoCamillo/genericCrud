import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void cadastraUser(Users user,File myFile) throws IOException {
           FileWriter fw = new FileWriter(myFile, true);

           fw.write(user.getName() + " " +  user.getEmail() + "   ");
           fw.close();
           System.out.println("Usuário cadastrado com sucesso!");

    }
    //in progress:
    public static void updateUsers(String name, File myFile, String newName) throws IOException {
        FileWriter fw = new FileWriter(myFile, true);
        String teste = new String(Files.readAllBytes(myFile.toPath()));
        System.out.println("Alterando " + name + " para " + newName + "...");
        String alterado = teste.replace(name, newName);
        fw.write(alterado);
        fw.close();


        }

    public static void deletaUsers(File myFile) throws IOException {
            FileWriter fw = new FileWriter(myFile);
            FileReader rd = new FileReader(myFile);
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
        System.out.println(myFile.toPath());
        int selector;
        Scanner scanner = new Scanner(System.in);

        if(myFile.exists()){
            System.out.println("Digite seu nome para efetuar login: ");
            String name = scanner.nextLine();
            System.out.println("Agora digite seu email: ");
            String email = scanner.nextLine();
            Users users = new Users(name,email);
            boolean bool = tryLogin(users.getName(),myFile);
            if(!bool){
                System.out.println("Usuário não encontrado, deseja efetuar o cadastro?\n" +
                        "Digite 1 para sim ou 2 para apagar todos usuários ou 3 para editar um usuário: ");
                selector = scanner.nextInt();
                if(selector == 1){
                    //System.out.println("Digite seu email: ");
                    //email = scanner.next();
                    System.out.println("Cadastrando usuário " + users.getEmail() + "...");
                    cadastraUser(users, myFile);
                }
                if(selector == 2){
                    deletaUsers(myFile);
                }
                else{
                    System.out.println("Gracias!");
                    main(args);
                }
            }
            System.out.println("---------------------------");
            System.out.println("Você está logado");
            System.out.println("---------------------------");
            }
        else{
            System.out.println("O arquivo não existe");
        }
   }
}