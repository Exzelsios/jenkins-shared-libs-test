package novatec.cpj

class RunParameters {
  Map parameters 

  RunParameters() {
    this([:])
  }

  RunParameters(Map parameters) {
    this.parameters = parameters
    project = parameters.project as String 
    gitUrl = parameters.gitUrl as String 
  }

  String project 
  String gitUrl
}