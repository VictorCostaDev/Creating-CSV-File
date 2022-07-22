package model.entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemsSold {
    
    private final Scanner scan = new Scanner(System.in);
    private List<Item> items = new ArrayList<>();

    public ItemsSold() {}

    public List<Item> getItems() {
        return items;
    }

    private void addItemSold(Item item) {
        items.add(item);
    }

    /* 
    private void removeItemSold(Item item) {
        items.remove(item);
    }
    */

    public void receiveItems() {
        System.out.print("Quantos produtos serão escritos? ");
        int quantityItems = scan.nextInt();

        for (int index = 0; index < quantityItems; index++) {
            scan.nextLine();
            System.out.print("Nome do Produto: ");
            String nameItem = scan.nextLine();
            System.out.print("Preço do Produto: ");
            double priceItem = scan.nextDouble();
            System.out.print("Quantidade a comprar do Produto: ");
            int quantityItem = scan.nextInt();
            addItemSold(new Item(nameItem, priceItem, quantityItem));
        }
    }

    public void WriteItemsInFileCSV(String pathName) throws IOException {
        scan.nextLine();
        System.out.print("Nome do arquivo csv: ");
        String nameFileInCSV = scan.nextLine();


        BufferedWriter bw = new BufferedWriter(new FileWriter(pathName + "\\" + nameFileInCSV));
        for (Item item : items) {
            bw.write(item.toString());
            bw.newLine();
        }
        bw.close();
    }

    
}
