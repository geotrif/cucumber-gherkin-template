Feature: Step Arguments

  Scenario: Doc Strings
    Given a blog post named "Random" with Markdown body:
  """
  Some Title, Eh?
  ===============
  Here is the first paragraph of my blog post. Lorem ipsum dolor sit amet,
  consectetur adipiscing elit.
  """
    When I visit the blog post titled "Random"
    Then I should see a heading "Some Title, Eh?"

  Scenario: Data Tables
    Given the following users exist:
      | name   | email              | twitter         |
      | Aslak  | aslak@cucumber.io  | @aslak_hellesoy |
      | Julien | julien@cucumber.io | @jbpros         |
      | Matt   | matt@cucumber.io   | @mattwynne      |
    When I visit the user list
    Then I should see the following users: "Aslak", "Julien" and "Matt"