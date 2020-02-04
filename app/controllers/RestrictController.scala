package controllers

import javax.inject.Inject

import be.objectify.deadbolt.scala.{ActionBuilders, DeadboltActions}
import play.api.mvc.{Action, Controller}
import views.html.accessOk

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  *
  * @author Steve Chaloner (steve@objectify.be)
  */
class RestrictController @Inject()(deadbolt: DeadboltActions, actionBuilder: ActionBuilders) extends Controller {

    val roleAdmin:String = "ROLE_ADMIN";
    val roleSuperAdmin:String = "ROLE_SUPER_ADMIN";

  def index = Action {
                       Ok(accessOk())
                     }

  def restrictTOAdmin = deadbolt.Restrict(List(Array(roleAdmin)))() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                            }

  def restrictTwo = deadbolt.Restrict(List(Array(roleAdmin, roleSuperAdmin)))() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                   }
                                                                           }

  def restrictOne_fromBuilder = actionBuilder.RestrictAction(roleAdmin).defaultHandler() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                                     }

  def restrictTwo_fromBuilder = actionBuilder.RestrictAction(roleAdmin, roleSuperAdmin).defaultHandler() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                                                                 }
}