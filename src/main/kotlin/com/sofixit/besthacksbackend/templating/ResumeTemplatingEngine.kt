package com.sofixit.besthacksbackend.templating

import com.sofixit.besthacksbackend.ai.AIResponse
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

  fun generateTemplate(templateName: TemplateName, aiResponse: AIResponse, userData: String): String {
    val context = Context().apply {
      setVariable("about", aiResponse.about)
      setVariable("experience", aiResponse.experience)
      setVariable("education",  aiResponse.education)
      setVariable("skills",  aiResponse.skills)
      setVariable("userData", userData)
    }
    return templateEngine.process(templateName.toName(), context)
  }
}