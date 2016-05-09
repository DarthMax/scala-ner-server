package de.fraunhofer.moez.ci.nerservice

class NerService extends NerServiceStack {

  post("/") {
    NerTagger.anotate(params.getOrElse("text", halt(400)))
  }
}
