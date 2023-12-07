Feature: Weather API Testing

  Background:
    Given I have a Weatherstack API key

  Scenario Outline: Positive Test - Current Weather in "<city>"
    When I request current weather for city "<city>"
    Then the response status code should be 200
    And the type should be "<type>"
    And the country should be "<country>"
    And the temperature should be between <minTemperature> and <maxTemperature>

    Examples:
      | city        | type | country | minTemperature | maxTemperature |
      | Gomel       | City | Belarus | -10            | 5              |
      | Novosibirsk | City | Russia  | -15            | 5              |
      | Yellowknife | City | Canada  | -25            | -15            |
      | Budapest    | City | Hungary | -10            | 15             |
