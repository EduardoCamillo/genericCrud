import javax.lang.model.util.ElementScanner6;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
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
            boolean bool = users.tryLogin(users.getName(),myFile);
            if(!bool){
                System.out.println("Usuário não encontrado, deseja efetuar o cadastro?\n" +
                        "Digite 1 para sim ou 2 para apagar todos usuários ou 3 para editar um usuário: ");
                selector = scanner.nextInt();
                if(selector == 1){
                    System.out.println("Cadastrando usuário " + users.getEmail() + "...");
                    users.cadastraUser(users, myFile);
                    return;
                }
                else if(selector == 2){
                    users.deletaUsers(myFile);
                    return;
                }
                else{
                    System.out.println("Gracias!");
                    main(args);
                }
            }
            System.out.println("---------------------------");
            System.out.println("Você está logado");
            System.out.println("---------------------------");
            System.out.println("Digite 1 para atualizar seu usuário ou 2 para sair: ");
            selector = scanner.nextInt();
            if(selector == 1){
                users.updateUsers(users.getName(), myFile, "NOVOnOME");
            }
            else{
                return;
            }
        }
        else{
            System.out.println("O arquivo não existe");
        }
   }
}