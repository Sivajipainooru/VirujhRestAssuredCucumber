Feature: Validating Place API's
 @AddPlace
  Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI
    Given Add Place Payload with "name", "langauge" and "address"
    When user calls"AddPlaceApi"with"Post"http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    Then Verify place_id and created maps to"<name>"using the"getPlaceApi"

    Examples: 
      | name | langauge | address          |
      | siva | English  | ws cross address |

  #|raja |Telugu    |Ns stright road |
  # When  user calls "getPlaceAPI" with "get" http request
  #Then the API call got success with status code 200
  #And "status" in response body is "OK"
  @DeletePlace
  Scenario: Verify if Delete Place functionality is working
    Given DeletePlace Payload
    When user calls"deletePlaceApi"with"Post"http request
    Then the Api call got success with status code 200
    And "Status" in response body is "OK"
