package application;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.ItemsSold;

public class App {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("Path onde diretório ficará: ");
        String pathName = scan.nextLine();
        System.out.print("Nome do diretorio: ");
        String nameDirectory = scan.nextLine();
        String fullNameDirectory = pathName + "\\" + nameDirectory;
        
        try {
            boolean sucessDirectory = new File(fullNameDirectory).mkdir(); 

            System.out.print("Criar Arquivo .txt ou csv (t/c): ");
            char extension = scan.next().charAt(0);
            
            if (sucessDirectory) {
                ItemsSold items = new ItemsSold();
                items.receiveItems();
                items.WriteItemsInFileCSV(fullNameDirectory);
                System.out.println("Arquivo .csv criado com sucesso");
            } else {
                System.out.println("Impossível criar o diretório, verifique o caminho ou se o diretório já existe");
            }

        } catch (IOException error) {
            System.out.println("Error: " + error.getMessage());
        } 

        scan.close();
    }

}
