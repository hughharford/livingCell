#Author: hugh.harford@poscoconsulting.com
#Keywords Summary :
#Feature: Trial scenario only
@trialFeature
Feature: Is it Friday yet?
  Everybody wants to know when it's Friday
#Scenario: Is it Friday yet?
	@withExamples
  Scenario Outline: Sunday isn't Friday
    Given today is "<day>"
    When I ask whether it's Friday yet
    Then I should be told "<answer>"
    
  Examples:
    | day            | answer |
    | Friday         | TGIF   |
    | Sunday         | Nope   |
    | anything else! | Nope   |    

    
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@tag
#Feature: Title of your feature
#  I want to use this template for my feature file

#  @tag1
#  Scenario: Title of your scenario
#    Given I want to write a step with precondition
#    And some other precondition
#    When I complete action
#    And some other action
#    And yet another action
#    Then I validate the outcomes
#    And check more outcomes

#  @tag2
#  Scenario Outline: Title of your scenario outline
#    Given I want to write a step with <name>
#    When I check for the <value> in step
#    Then I verify the <status> in step

#    Examples: 
#      | name  | value | status  |
#      | name1 |     5 | success |
#      | name2 |     7 | Fail    |
