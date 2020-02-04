package models

import be.objectify.deadbolt.scala.models.Subject

/**
  *
  * @author Steve Chaloner (steve@objectify.be)
  */
class User(val userName: String) extends Subject {
  override def roles: List[SecurityRole] =
    List(SecurityRole("ROLE_ADMIN"),
         SecurityRole("ROLE_SUPER_ADMIN"))

  override def permissions: List[UserPermission] =
    List(UserPermission("printers.edit"))

  override def identifier: String = userName
}
