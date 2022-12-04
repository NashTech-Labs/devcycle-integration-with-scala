package org.knoldus.devcycle

import com.devcycle.sdk.server.cloud.api.DVCCloudClient
import com.devcycle.sdk.server.cloud.model.DVCCloudOptions
import com.devcycle.sdk.server.common.model.{User, Variable}

class DevCycleFeatureFlagHelper(serverKey: String){
  private val dvcOptions: DVCCloudOptions = DVCCloudOptions.builder().enableEdgeDB(false).build()

  // Initialize DevCycle Client
  private val dvcClient = new DVCCloudClient(serverKey, dvcOptions)

  private val defaultValue = false

  def getFeatureFlagValueForUser(flagKey: String, user: User): Boolean = {
    val variable = dvcClient.variable(user, flagKey, defaultValue)
    getValue(variable)
  }

  def getFeatureFlagValueForUserId(flagKey: String, userId: String): Boolean = {
    val user = User.builder.userId(userId).build
    val variable: Variable[Boolean] = dvcClient.variable(user, flagKey, defaultValue)
    getValue(variable)
  }

  def getFeatureFlagValueForUserEmail(flagKey: String, userId: String, email: String): Boolean = {
    val user = User.builder.userId(userId).email(email).build
    val variable = dvcClient.variable(user, flagKey, defaultValue)
    getValue(variable)
  }

  def getFeatureFlagValueForPlatform(flagKey: String, userId: String, name: String): Boolean = {
    val user = User.builder.userId(userId).platform(name).build
    val variable = dvcClient.variable(user, flagKey, defaultValue)
    getValue(variable)
  }

  def getFeatureFlagValueForCountryCode(flagKey: String, userId: String, countryCode: String): Boolean = {
    val user = User.builder.userId(userId).country(countryCode).build
    val variable = dvcClient.variable(user, flagKey, defaultValue)
    getValue(variable)
  }

  private def getValue(variable: Variable[Boolean]): Boolean =
    // If the variable doesn't exist getIsDefaulted will be true
    if (variable.getIsDefaulted)
      defaultValue
    else
      variable.getValue
}
