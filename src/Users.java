import java.io.*;
import java.nio.file.Files;

public class Users {
    private String name;
    private String email;

    public Users(String name, String email){
        this.name = name;
        this.email = email;
    }
    public void setName(String Newname){
        this.name = Newname;
    }
    public String getName(){
        return this.name;
    }
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    public String getEmail(){
        return this.email;
    }
    public void cadastraUser(Users user, File myFile) throws IOException {
        FileWriter fw = new FileWriter(myFile, true);

        fw.write(user.getName() + " " +  user.getEmail() + " ");
        fw.close();
        System.out.println("Usuário cadastrado com sucesso!");

    }
    //in progress:
    public void updateUsers(String name, File myFile, String newName) throws IOException {
        FileWriter fw = new FileWriter(myFile, true);
        String teste = new String(Files.readAllBytes(myFile.toPath()));
        System.out.println("Alterando " + name + " para " + newName + "...");
        String alterado = teste.replaceAll(name, " d");
        deletaUsers(myFile);
        fw.write(alterado);
        fw.close();
    }
    public void deletaUsers(File myFile) throws IOException {
        FileWriter fw = new FileWriter(myFile);
        System.out.println("Deletando usuário");
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

}
