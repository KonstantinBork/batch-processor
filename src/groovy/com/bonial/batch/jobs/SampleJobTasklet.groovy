package com.bonial.batch.jobs

import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus

/**
 * batch-processor
 * @author Konstantin Bork
 * @version 0.1
 * @created 08/28/2015
 *
 * Example for the look of a tasklet.
 */

class SampleJobTasklet implements Tasklet {

    @Override
    RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        println("Hello World!")
        return RepeatStatus.FINISHED
    }

}