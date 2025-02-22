plugins {
    id("application")
    id("java")
    id("jacoco")
}

group = "org.longbox"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass = "org.longbox.Main"
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    implementation("com.toedter:jcalendar:1.4")
    implementation("com.jgoodies:jgoodies-forms:1.8.0")
    implementation("org.hibernate:hibernate-core:6.4.2.Final")
    implementation("org.postgresql:postgresql:42.7.1")
    implementation("jakarta.mail:jakarta.mail-api:2.1.2")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("commons-validator:commons-validator:1.8.0")
    testImplementation("org.mockito:mockito-core:2.1.0")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
    maxHeapSize = "1G"
    testLogging {
        events("passed")
    }
    finalizedBy(tasks.jacocoTestReport)
}

tasks.test{
    exclude("**/integration/*")
    exclude("**/presentation/*")
    exclude("**/mapper/*")
    exclude("**/controller/*")
    exclude("**/service/*")
    exclude("**/dao/*")
    exclude("**/StarRatingStubDbTest.class")
    useJUnitPlatform()
}

tasks.jacocoTestReport {
    dependsOn(tasks.named<Test>("test")) // tests are required to run before generating the report

    classDirectories.setFrom(files(classDirectories.files.map {
        fileTree(it) {
            setExcludes(listOf(
                    "**/controller/*",
                    "**/presentation/*",
                    "**/dao/*",
                    "**/service/*",
                    "**/mapper/*",
                    "**/service/*",
                    "**/config/*",
                    "**/StarRatingStubDb.class",
                    "**/MultiLineCellRendererForUser.class",
                    "**/MultiLineCellRenderer.class"
            ))
        }
    }))

    reports {
        xml.required = true
        csv.required = true
        html.required = true
        html.outputLocation = layout.buildDirectory.dir("jacoco-reports")
    }
}

jacoco {
    toolVersion = "0.8.11"
    reportsDirectory = layout.buildDirectory.dir("jacoco-reports")
}