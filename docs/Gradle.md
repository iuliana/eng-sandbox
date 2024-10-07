# Gradle details

`buildSrc` is a subproject-like directory at the Gradle project root containing all the build logic.

Advantages:

* Reusable Build Logic
  * `buildSrc` allows you to organize and centralize your custom build logic, tasks, and plugins in a structured manner. The code written in `buildSrc` can be reused across your project, making it easier to maintain and share common build functionality.
* Isolation from the Main Build
  * Code placed in `buildSrc` is isolated from the other build scripts of your project. This helps keep the main build scripts cleaner and more focused on project-specific configurations.
* Automatic Compilation and Classpath
  * The contents of the `buildSrc` directory are automatically compiled and included in the classpath of your main build. This means that classes and plugins defined in `buildSrc` can be directly used in your project’s build scripts without any additional configuration.
* Ease of Testing
  * Since `buildSrc` is a separate build, it allows for easy testing of your custom build logic. You can write tests for your build code, ensuring that it behaves as expected.
* Gradle Plugin Development
  * If you are developing custom Gradle plugins for your project, `buildSrc` is a convenient place to house the plugin code. This makes the plugins easily accessible within your project.

Reference: https://docs.gradle.org/current/userguide/sharing_build_logic_between_subprojects.html#sec:using_buildsrc