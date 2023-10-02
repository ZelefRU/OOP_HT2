package org.example;

import org.example.People.Client;

public interface QueueBehaviour {

    void addInQueue(Client client);
    void removeFromQueue(Client client);
    void removeFirstInQueue();
    void updateQueue();
    void getQueueList();
}
