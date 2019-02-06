Feature: Add to products to the shopping cart
  As a Countdown customer, I want to add selected products to the shopping cart

  @tagsystem
  Scenario Outline: As a Countdown customer, I want to add selected products to the shopping cart
    Given customer lands in home page
    And logs into the application
    When click on search field
    And click on Shop From List screen
    And enters list of <products>
    And clicks on Find Products button
    And from the search results click on Add to Trolley button of <listOfProducts>
    And selects the Trolley image
    And selects View All button
    And clicks on the Save Trolley button
    And enters the <list> name
    Then I verify the <listOfProducts> appear in the shopping cart

    Examples: 
      | products      | listOfProducts                                                             | list     |
      | Milk,Rice,Egg | Anchor Milk Powder Instant bag 400g,Arnotts Malt Biscuits Malt O Milk 250g | TestList |
