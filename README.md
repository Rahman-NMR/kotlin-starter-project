# Kotlin Starter Project

This is a small Kotlin JVM starter project with two runnable examples:

- `src/main/kotlin/fizzbuzz/main.kt`
- `src/main/kotlin/weather/main.kt`

## Tech Stack

- Kotlin JVM `2.3.20`
- Gradle Kotlin DSL
- Java toolchain `21`
- Kotlinx Serialization JSON
- Java HTTP Client
- IntelliJ IDEA

## Prerequisites

Before running the project, install:

- IntelliJ IDEA
- JDK 21

The project uses the Gradle Wrapper, so you do not need to install Gradle manually.

## Open the Project in IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Select **File > Open**.
3. Choose this project folder.
4. Wait until IntelliJ finishes importing and syncing the Gradle project.
5. Make sure the project SDK is set to JDK 21.

## Run the FizzBuzz Example

The FizzBuzz entry point is:

```text
src/main/kotlin/fizzbuzz/main.kt
```

To run it from IntelliJ IDEA:

1. Open `src/main/kotlin/fizzbuzz/main.kt`.
2. Click the green run icon next to the `main` function.
3. Choose **Run 'MainKt'**.

This example prints the FizzBuzz output from `100` down to `1`.

## Run the Weather Example

The weather forecast entry point is:

```text
src/main/kotlin/weather/main.kt
```

This example fetches a 5-day weather forecast for Jakarta from OpenWeather.

### Run from IntelliJ IDEA

1. Open `src/main/kotlin/weather/main.kt`.
2. Click the green run icon next to the `main` function.
3. Choose **Modify Run Configuration** or open **Run > Edit Configurations**.
4. Set one of the following values:
   - Environment variable: `OPENWEATHER_API_KEY=your_openweather_api_key_here`
   - VM option: `-DOPENWEATHER_API_KEY=your_openweather_api_key_here`
5. Save the run configuration.
6. Run `weather.MainKt`.

If the API key is valid, the program prints the average daily weather forecast for Jakarta.

## IntelliJ Run Configuration Names

Because this project has two files named `main.kt`, IntelliJ may show both run configurations as `MainKt`. Use the fully qualified main class to identify the correct one:

- `fizzbuzz.MainKt`
- `weather.MainKt`

## Optional Gradle API Key File

The project also supports reading the OpenWeather API key from a root-level `local.properties` file for Gradle `JavaExec` tasks:

```properties
openWeather_ApiKey=your_openweather_api_key_here
```

This is useful if a Gradle run task is added later. For the current IntelliJ workflow, setting the environment variable or VM option in the run configuration is the most direct option.
