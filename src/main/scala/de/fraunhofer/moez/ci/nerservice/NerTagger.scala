package de.fraunhofer.moez.ci.nerservice

import edu.stanford.nlp.ie.crf.CRFClassifier

/**
  * Created by max on 09.05.16.
  */
object NerTagger {

  var model = CRFClassifier.getClassifier("edu/stanford/nlp/models/ner/german.dewac_175m_600.crf.ser.gz")

  def anotate(text: String): String = {
    model.classifyWithInlineXML(text)
  }
}
