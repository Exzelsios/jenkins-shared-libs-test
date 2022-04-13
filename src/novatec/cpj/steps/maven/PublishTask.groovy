package de.novatec.cpj.steps.maven

import package de.novatec.cpj.steps.PipelineTask
import package de.novatec.cpj.RunParameters

class PublishTask extends PipelineTask {

  PublishTask(steps, RunParameters runParameters) {
    super(steps, runParameters)
  }

  def run() {
    steps.mvn('deploy')
  }
}