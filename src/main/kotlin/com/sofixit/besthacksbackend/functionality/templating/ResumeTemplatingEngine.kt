package com.sofixit.besthacksbackend.functionality.templating

import com.sofixit.besthacksbackend.functionality.ai.AIResponse
import com.sofixit.besthacksbackend.userinfo.dto.UserInfoResponse
import org.springframework.stereotype.Component
import org.thymeleaf.context.Context
import org.thymeleaf.spring6.SpringTemplateEngine
import org.thymeleaf.templatemode.TemplateMode.HTML
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

@Component
class ResumeTemplatingEngine {
  val templateResolver: ClassLoaderTemplateResolver = ClassLoaderTemplateResolver().apply {
    prefix = "templates/"
    suffix = ".html"
    templateMode = HTML
    characterEncoding = "UTF-8"
  }
  val templateEngine: SpringTemplateEngine = SpringTemplateEngine().apply {
    setTemplateResolver(templateResolver)
  }

  fun generateTemplate(templateName: TemplateName, aiResponse: AIResponse, userData: UserInfoResponse): String {
    val context = Context().apply {
      setVariable("name", "${userData.firstname} ${userData.lastname}")
      setVariable("phone", userData.phone)
      setVariable("email", userData.email)
      setVariable("about", aiResponse.about)
      setVariable("experience", aiResponse.experience)
      setVariable("education", aiResponse.education)
      setVariable("skills", aiResponse.skills)
      setVariable("userData", userData)
    }
    return templateEngine.process(templateName.value, context)
  }
}