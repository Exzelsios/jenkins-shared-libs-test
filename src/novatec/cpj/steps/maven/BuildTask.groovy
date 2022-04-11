package de.novatec.cpj.steps.maven

import package de.novatec.cpj.steps.PipelineTask
import package de.novatec.cpj.RunParameters

class BuildTask extends PipelineTask {

  BuildTask(steps, RunParameters runParameters) {
    super(steps,runParameters)
  }

  def run() {
    steps.mvn('clean install')
  }
}