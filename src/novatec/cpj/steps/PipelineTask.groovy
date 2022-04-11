package novatec.cpj.steps


import package de.novatec.cpj.RunParameters

abstract class PipelineTask {
  protected final def steps 
  protected final RunParameters runParameters

  PipelineTask(steps, RunParameters runParameters) {
    this.steps = steps
    this.runParameters = runParameters
  }
}