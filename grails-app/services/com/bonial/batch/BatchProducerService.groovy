package com.bonial.batch

import com.bonial.batch.interfaces.Producer
import org.springframework.integration.Message
import org.springframework.integration.message.GenericMessage

/**
 * batch-processor
 * @author  Konstantin Bork
 * @version 0.2
 * @created 08/28/2015
 *
 * The implementation of the Producer interface.
 */

class BatchProducerService implements Producer {

    def batchQueueService

    @Override
    String produceTask() {
        // TODO message creation
        Message m = new GenericMessage<>("Hello World")
        batchQueueService.enqueue(m)
        return null
    }

}