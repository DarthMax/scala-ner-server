package de.fraunhofer.moez.ci.nerservice

import org.scalatra.test.specs2._

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
class NerServiceSpec extends ScalatraSpec { def is = s2"""
  POST / on NerService
    should return status 200                  $post_root_200
    should return anotated text               $anotate_text
    should return status 400 if text is missing $missing_text
                                                """

  addServlet(classOf[NerService], "/*")

  def post_root_200 = post("/",("text","TestText")) {
    status must_== 200
  }

  def anotate_text = post("/",("text","Dies ist Angela Merkel")) {
   body must_== "Dies ist <I-PER>Angela Merkel</I-PER>"
  }

  def missing_text = post("/") {
    status must_== 400
  }
}
