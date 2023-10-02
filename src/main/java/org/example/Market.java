package org.example;

import org.example.People.Client;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Market implements QueueBehaviour{
    private String marketName;
    private Deque<Client> queue = new ArrayDeque<>();

    public Market(String marketName, List<Client> clients) {
        this.marketName = marketName;
        queue.addAll(clients);
        System.out.println("Market " + marketName + " has been created!");
    }

    /**
     * Добавить клиента в очередь
     * @param client Клиент
     */
    @Override
    public void addInQueue(Client client) {
        queue.addLast(client);
        System.out.println("+ " + client.getName() + " has been added in queue!");
    }

    /**
     * Удалить конкретного клиента из очереди {@link Client}
     * @param client Клиент
     */
    @Override
    public void removeFromQueue(Client client) {queue.remove(client);}

    /**
     * Удаляет первого в очереди клиента
     */
    @Override
    public void removeFirstInQueue() {queue.removeFirst();}

    /**
     * Обновляет очередь в {@link Market}
     * Удаляет первого в очереди и выводит список оставшихся клиентов
     */
    @Override
    public void updateQueue() {
        System.out.println("-".repeat(30));
        System.out.println("Client " + queue.getFirst().getName() + " received his order:");
        System.out.println(queue.getFirst().getProductList());
        queue.removeFirst();
        System.out.println(getClientList());
        System.out.println("-".repeat(30));
    }

    /**
     * Возвращает список клиентов в очереди
     * @return {@link String}
     */
    public String getClientList() {
        StringBuilder result = new StringBuilder("Clients in queue: ");
        for (Client client :
                queue) {
            result.append(client.getName()).append(", ");
        }
        result = new StringBuilder(result.substring(0, result.length() - 2));
        return result.toString();
    }

    @Override
    public void getQueueList() {
        System.out.println(queue);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("-".repeat(10) + " " + marketName + " " + "-".repeat(10) + "\n");
        for (Client client :
                queue) {
            result.append(client).append("\n");
        }
        result.append("-".repeat(27));
        return result.toString();
    }

    /**
     * Возвращает размер очереди
     * @return int
     */
    public int getQueueSize() {return queue.size();}
}
