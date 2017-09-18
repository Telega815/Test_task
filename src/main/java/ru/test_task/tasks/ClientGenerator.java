package ru.test_task.tasks;

import java.util.ArrayList;

public class ClientGenerator {
    private static ArrayList<Client> ClientList = new ArrayList<Client>();
    private static int count = 0;

    public static Client registerNewClient(final String name){
        count++;
        Client client = new Client(name, count);
        ClientList.add(client);
        return client;
    }

    /**
     * Search for client by name
     * @param name name of searched client
     * @return founded client
     * @throws UserExeption if there's no client with that name, throw ex
     */
    public static Client findClient (final String name) throws UserExeption{
        Client foundedClient = null;
        for(Client client : ClientList){
            if (name.equals(client.getName())){ foundedClient = client; }
        }
        if (foundedClient == null) throw new UserExeption("There's no client with that name");
        return foundedClient;
    }

    public static Client findClient (final int id) throws UserExeption{
        Client foundedClient = null;
        for(Client client : ClientList){
            if (client.getId() == id){ foundedClient = client; }
        }
        if (foundedClient == null) throw new UserExeption("There's no client with that id");
        return foundedClient;
    }

    public static ArrayList<String> getList(){
        ArrayList<String> list = new ArrayList<String>();
        for (Client client : ClientList)
            list.add(client.getName());
        return list;
    }
}
