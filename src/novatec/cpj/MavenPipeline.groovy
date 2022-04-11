package novatec.cpj

import package de.novatec.cpj.steps.maven.BuildTask
import package de.novatec.cpj.steps.maven.PublishTask

class MavenPipeline extends GenericPipelineConstruct {

  MavenPipeline(steps, runParameters){
    super(steps, runParameters)
  }

  @Override
  def build() {
    new BuildTask(steps, runParameters).run()
  }

  @Override
  def publish() {
    new PublishTask(steps, runParameters).run()
  }

}