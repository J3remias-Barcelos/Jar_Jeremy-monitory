package projeto.menu;

import projeto.login.Login;
import projeto.print.Prints;

import java.util.Scanner;

public class Menu {
    private boolean sair = false;

    public void exibirMenu() {
        Login login = new Login();
        Prints prints = new Prints();
        Scanner scanner = new Scanner(System.in);


        while (!sair) {
            prints.menu();
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    sair = login.login();
                    break;
                case 0:
                    prints.sair();
                    sair = true;
                    break;
                default:
                    break;
            }
        }
    }
}
// Realizado Pela Nexus Enterprises :)
