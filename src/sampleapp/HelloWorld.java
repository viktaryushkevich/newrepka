package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HelloWorld {
    public static void main(String[] args) {
        {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Viktar Yushkevich\\Documents\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--lang=en");

            WebDriver driver=new ChromeDriver();

            driver.manage().window().maximize();

            driver.get("https://store.steampowered.com");
            //driver.findElement(By.xpath("//a[contains(@href,'about')]")).click();
            driver.findElement(By.xpath("//a[contains(@class,'menuitem') and contains(text(),'ABOUT')]")).click();
            //driver.findElement(By.xpath("//a[contains(@class,'menuitem') and contains(text(),'ABOUT')]")).click();

            //Number of players online
            WebElement online = driver.findElement(By.xpath("//div[@class='online_stat'][1]"));
            String numberOnline = online.getText().replaceAll("[^\\.0123456789]","");
            int playersOnline = Integer.parseInt(numberOnline);
            //System.out.println(playersOnline);

            //Number of players in a game
            WebElement inGame = driver.findElement(By.xpath("//div[@class='online_stat'][2]"));
            String numberPlayers = inGame.getText().replaceAll("[^\\.0123456789]","");
            int playersInGame = Integer.parseInt(numberPlayers);
            //System.out.println(playersInGame);

            //Compare the numbers
            if (playersOnline > playersInGame) {
                System.out.println("Number of in-game players is less than number of players online");
            } else {
                System.out.println("Number of online players is less than number of in-game players");
            }

            driver.findElement(By.xpath("//a[contains(@class,'menuitem') and contains(text(),'STORE')]")).click();
            driver.quit();
        }
    }
}
