Feature: Casekaro mobile cover testing

Scenario: Add apple cover materials to cart

Given user opens casekaro website
When user clicks mobile covers
And user clicks search
And user searches Apple
And user selects first product

And user adds Hard material
And user adds Soft material
And user adds Glass material

When user opens cart

Then validate all three materials added
And print cart details