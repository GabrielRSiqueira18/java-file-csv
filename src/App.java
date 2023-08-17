import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.User;
import entities.UserProductsBuyeds;

public class App {
  public static void main(String[] args) throws Exception {
    Locale.setDefault(Locale.US);
    Scanner scanner = new Scanner(System.in);

    System.out.println("Program to convert a arquive csv in another arquive csv but formated.\nThe first arquives should be have: user name, price one product, product name, quantity the this product has buyeds, year of the buy!\n");
    
    List<UserProductsBuyeds> userProductsBuyedsList = new ArrayList<>();

    System.out.println("Enter path name:\nExample windows: c:\\...\\arquive_name.csv\nIn windows is double \\\n\nLinux: /home/user_name/.../arquive_name.csv");
    String sourceFileStr = scanner.nextLine();

    Character system = 'a';

    System.out.println("Enter W if your system is windows or L if is Linux");
    system = scanner.nextLine().toLowerCase().charAt(0);

    while(system != 'w' && system != 'l') {
      System.out.println("Enter W if your system is windows or L if is Linux");
      system = scanner.nextLine().toLowerCase().charAt(0);
    }

    File sourceFile = new File(sourceFileStr);
    String sourceFolderStr = sourceFile.getParent();
    String targetFileOutStr = null;

    if(system == 'l') {
      targetFileOutStr = sourceFolderStr + "/out/result.csv";
    } else {
      targetFileOutStr = sourceFolderStr + "\\out\\result.csv";
    } 


    try(BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFileStr))) {
      
      String itemCsv = bufferedReader.readLine();

      while(itemCsv != null) {
        String[] fields = itemCsv.split(",");
        
        String userName = fields[0];
        double productPrice = Double.parseDouble(fields[1]);
        Integer productQuantity = Integer.parseInt(fields[3]);

        User user = new User(userName);
                
        UserProductsBuyeds userProductsBuyeds = new UserProductsBuyeds(productQuantity,productPrice, user.getName());


        UserProductsBuyeds existUserProductsBuyedsInList = userProductsBuyedsList.stream().filter(u -> u.getUserName().equals(userProductsBuyeds.getUserName())).findFirst().orElse(null);

        if(existUserProductsBuyedsInList == null) {
          userProductsBuyedsList.add(userProductsBuyeds);
        } else {
          existUserProductsBuyedsInList.addPrice(productPrice);
          existUserProductsBuyedsInList.addQuantity(productQuantity);
        }

        itemCsv = bufferedReader.readLine();
      }

      try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFileOutStr))) {        
        for(UserProductsBuyeds item : userProductsBuyedsList) {
          bufferedWriter.write(item.getUserName() + "," + item.getQuantity() + "," + String.format("%.2f", item.getPrice()));
          bufferedWriter.newLine();
        }

      } catch (IOException e) {
        System.out.println(e.getMessage());
      }

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    scanner.close();
  }
}