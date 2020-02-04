package security

import javax.inject.Singleton

import be.objectify.deadbolt.scala.TemplateFailureListener
import play.api.Logger

/**
  * No-op implementation of TemplateFailureListener..
  *
  * @author Steve Chaloner (steve@objectify.be)
  */
@Singleton
class MyCustomTemplateFailureListener extends TemplateFailureListener {

  val logger: Logger = Logger("App name")

   override def failure(message: String, timeout: Long): Unit = logger.error(s"Failure! Message [$message]  timeout [$timeout]ms")
 }
