package com.bonial.batch

import com.bonial.batch.interfaces.InputController

/**
 * batch-processor
 * @author  Konstantin Bork
 * @version 0.2
 * @created 08/28/2015
 *
 * Controller for incoming batch tasks.
 */

class BatchInputController implements InputController {

    def batchProducerService

    @Override
    void registerTask() {
        batchProducerService.produceTask()
    }

    @Override
    void getStatus(String batchTaskID) {

    }

    @Override
    void pauseTask(String batchTaskID) {

    }

    @Override
    void stopTask(String batchTaskID) {

    }

}