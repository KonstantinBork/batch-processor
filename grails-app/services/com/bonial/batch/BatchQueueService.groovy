package com.bonial.batch

import com.bonial.batch.interfaces.Queue
import org.springframework.integration.Message
import org.springframework.integration.channel.QueueChannel

/**
 * batch-processor
 * @author  Konstantin Bork
 * @version 0.2
 * @created 08/28/2015
 *
 * The implementation of the Queue interface.
 */

class BatchQueueService implements Queue {

    def queueChannel = new QueueChannel(100)

    @Override
    boolean enqueue(Message message) {
        def sent = queueChannel.send(message)
        return sent
    }

    @Override
    Message dequeue() {
        Message m = queueChannel.receive()
        return m
    }

    @Override
    int size() {
        return queueChannel.queueSize
    }

    @Override
    boolean isEmpty() {
        return size() == 0
    }

}