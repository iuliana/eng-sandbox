plugins {
    id("eng-sandbox")
    application
    id("jacoco-report-aggregation") // <1>
}

dependencies {
    implementation(project(":utilities"))
}

application {
    mainModule = "eng.sandbox.aoc"
    mainClass = "org.eng.Main"
}

tasks.check {
    dependsOn(tasks.named<JacocoReport>("testCodeCoverageReport")) // <2>
}
