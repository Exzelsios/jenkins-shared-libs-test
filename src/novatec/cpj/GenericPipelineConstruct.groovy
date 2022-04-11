package novatec.cpj

abstract class GenericPipelineConstruct {

  protected final def steps
  protected final RunParameters runParameters

  GenericPipelineConstruct(steps, RunParameters runParameters) {
    this.steps = steps
    this.runParameters = runParameters
  }
  
  def abstract build() 

  def abstract publish()

}