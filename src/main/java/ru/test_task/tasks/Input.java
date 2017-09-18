package ru.test_task.tasks;


import java.util.ArrayList;
import java.util.Scanner;
import static ru.test_task.tasks.ClientGenerator.*;

public class Input {
    private static Scanner reader = new Scanner(System.in);
    public static void main(String[] args){
        ArrayList<String> clients;
        String arg;
        boolean exit = false;
        int iterator;
        while (!exit) {
            System.out.println("1 - register new client");
            System.out.println("2 - find client");
            System.out.println("3 - print clients");
            System.out.println("4 - Exit");
            arg = reader.next();

            try {
                switch (Integer.valueOf(arg)){
                    case 4:
                        exit = true;
                        break;
                    case 3:
                        clients = getList();
                        iterator = 0;
                        for (String client : clients){
                            iterator++;
                            System.out.println(iterator + " - " + client);
                        }
                        System.out.println("Anything else - Exit");
                        arg = reader.next();
                        try {
                            workWithClient(findClient(clients.get(Integer.valueOf(arg) - 1)));
                        } catch (Exception e){
                            System.out.println("Exiting...");
                        }
                        break;
                    case 2:
                        workWithClient(searchClient());
                        break;
                    case 1:
                        workWithClient(register());
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("Enter a number");
            }
        }
        reader.close();
    }

    private static Client register(){
        Client client = null;

        System.out.println("Enter name");
        String arg = reader.next();
        client = registerNewClient(arg);
        return client;
    }

    private static Client searchClient(){
        Client client = null;

        System.out.println("Enter name");
        String arg = reader.next();
        try{
            client = findClient(arg);
        }catch (UserExeption e){
            System.out.println(e.getMessage());
        }
        return client;
    }

    private static void workWithClient(Client client){
        Animal currentAnimal;
        String arg;
        String name;
        boolean exit = false;

        while (!exit) {
            System.out.println("    " + client.getName());
            System.out.println("1 - register new animal");
            System.out.println("2 - find animal");
            System.out.println("3 - Exit");
            arg = reader.next();
            try {
                Integer.valueOf(arg);
            }catch (NumberFormatException e){
                System.out.println("Enter a number");
                continue;
            }

            switch (Integer.valueOf(arg)){
                case 3:
                    exit = true;
                    break;

                case 2:
                    System.out.println("Enter name:");
                    arg = reader.next();
                    try {
                        currentAnimal = client.findAnimal(arg);
                    } catch (UserExeption e) {
                        currentAnimal = null;
                        System.out.println(e.getMessage());
                    }
                    if (currentAnimal != null){
                        workWithAnimal(client, currentAnimal);
                    }
                    break;

                case 1:
                    System.out.println("Enter name");
                    name = reader.next();

                    System.out.println("1 - Cat");
                    System.out.println("2 - Dog");
                    System.out.println("3 - CatDog");
                    arg = reader.next();

                    try {
                        Integer.valueOf(arg);
                    }catch (NumberFormatException e){
                        System.out.println("Enter a number");
                        continue;
                    }

                    switch (Integer.valueOf(arg)){
                        case 1:
                            currentAnimal = client.addAnimal(name, "Cat", client.getId());
                            break;
                        case 2:
                            currentAnimal = client.addAnimal(name, "Dog", client.getId());
                            break;
                        case 3:
                            currentAnimal = client.addAnimal(name, "CatDog", client.getId());
                            break;
                        default:
                            currentAnimal = null;
                            System.out.println("There's no such option!");
                    }
                    if (currentAnimal != null){
                        workWithAnimal(client, currentAnimal);
                    }
                    break;
            }
        }
    }
    private static void workWithAnimal(Client client, Animal animal){
        Animal currentAnimal;
        String arg;
        String name;
        boolean exit = false;

        while (!exit){
            System.out.println("    " + client.getName());
            System.out.println("    ----" + animal.getName());
            System.out.println("1 - rename animal");
            System.out.println("2 - remove animal");
            System.out.println("3 - Exit");
            arg = reader.next();
            try {
                Integer.valueOf(arg);
            }catch (NumberFormatException e){
                System.out.println("Enter a number");
                continue;
            }

            switch (Integer.valueOf(arg)){
                case 3:
                    exit = true;
                    break;
                case 2:
                    client.removeAnimal(animal);
                    exit = true;
                    break;
                case 1:
                    System.out.println("Enter new name");
                    arg = reader.next();
                    animal.setName(arg);
                    exit = true;
                    break;
                default:
                    System.out.println("There's no such option!");
            }
        }
    }
}
