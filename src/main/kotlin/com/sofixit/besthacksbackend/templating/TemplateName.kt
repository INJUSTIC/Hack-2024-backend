package com.sofixit.besthacksbackend.templating

enum class TemplateName {
  RESUME1,
  RESUME2,
  RESUME3;

  fun toName(): String {
    return when (this) {
      RESUME1 -> "resume1"
      RESUME2 -> "resume2"
      RESUME3 -> "resume3"
    }
  }
}