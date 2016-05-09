import org.scalatra._
import javax.servlet.ServletContext

import de.fraunhofer.moez.ci.nerservice.NerService

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new NerService, "/*")
  }
}
