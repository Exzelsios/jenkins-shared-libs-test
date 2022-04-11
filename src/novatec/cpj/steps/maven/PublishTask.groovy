package de.novatec.cpj.steps.maven

import package de.novatec.cpj.steps.PipelineTask
import package de.novatec.cpj.RunParameters

class BuildTask extends PublishTask {

  PublishTask(steps, RunParameters runParameters) {
    super(steps, runParameters)
  }

  def run() {
    steps.mvn('deploy')
  }
}