package kz.ilyas;


import java.io.File;
import java.util.Scanner;


public class MyFS {

    public static void main(String[] args) {
        // write your code here
        try {
            File read_file = new File("src/manual.txt");
            Scanner obj = new Scanner(read_file);
            while (obj.hasNextLine()) {
                System.out.println(obj.nextLine());
            }
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("> ");
                String line = scanner.nextLine();
                String[] words = line.split(" ", 2);
                switch (words[0]) {
                    case "ls" -> MyFileCLI.listDirectory(words[1]);
                    case "ls_py" -> MyFileCLI.listPythonFiles(words[1]);
                    case "is_dir" -> MyFileCLI.isDirectory(words[1]);
                    case "define" -> MyFileCLI.define(words[1]);
                    case "readmod" -> MyFileCLI.printPermissions(words[1]);
                    case "setmod" -> MyFileCLI.setPermissions(words[1], words[2]);
                    case "cat" -> MyFileCLI.printContent(words[1]);
                    case "append" -> MyFileCLI.appendFooter(words[1]);
                    case "bc" -> MyFileCLI.createBackup(words[1]);
                    case "greplong" -> MyFileCLI.printLongestWord(words[1]);
                    case "help" -> MyFileCLI.help();
                    case "exit" -> MyFileCLI.exit();
                    default -> System.out.println("Please enter valid command");
                }
            }
        } catch (Exception e) {
            System.out.printf("%s", e);
        }
    }
}