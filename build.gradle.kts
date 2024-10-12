plugins {
  kotlin("jvm") version "1.9.25"
  kotlin("plugin.spring") version "1.9.25"
  id("org.springframework.boot") version "3.3.4"
  id("io.spring.dependency-management") version "1.1.6"
  kotlin("plugin.jpa") version "1.9.25"
  kotlin("kapt") version "1.9.25"
}

group = "com.sofixit"
version = "0.0.1-SNAPSHOT"

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.postgresql:postgresql:42.7.4")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  runtimeOnly("org.postgresql:postgresql")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
  implementation("jakarta.validation:jakarta.validation-api:3.1.0")
  implementation("org.springframework.boot:spring-boot-starter-security:3.3.4")
  compileOnly("org.projectlombok:lombok:1.18.34")
  implementation("org.mapstruct:mapstruct:1.5.5.Final")
  kapt("org.mapstruct:mapstruct-processor:1.5.5.Final")
  compileOnly ("org.projectlombok:lombok")
  kapt("org.projectlombok:lombok")
  runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.6")
  implementation("io.jsonwebtoken:jjwt-api:0.12.6")
  runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.6")

}

kotlin {
  compilerOptions {
    freeCompilerArgs.addAll("-Xjsr305=strict")
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
