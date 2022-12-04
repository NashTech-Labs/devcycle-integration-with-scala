# DevCycle-Integration-With-Scala

- This template helps you to integrate `DevCycle`(modern feature flag management tool) in your Scala project.
- It also provides some helper methods which can be used to fetch the current value for your feature flag based on different parameters.
- To use this template, make sure you have a DevCycle account and your feature flags are defined there. If you don't have any existing account, you can create one from here: https://devcycle.com/
- To create an instance for [DevCycleFeatureFlagHelper](src/main/scala/org/knoldus/devcycle/DevCycleFeatureFlagHelper.scala) class, you have to provide a `serverKey` which can be found under your DevCycle account settings.

## Prerequisites
- Scala Build Tool(SBT), version 1.8.0
- Scala, version 2.13.10