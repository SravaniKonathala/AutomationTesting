Feature: Test the application by performing different actions on products like search, add, delete etc.


  @Search
  Scenario: Automate 'Search Product' Functionality
    Given I launch the browser "chrome"
    And I Open link "http://automationpractice.com/index.php"
    When I Move your cursor over Women's link.
    And I Click on sub menu 'Summer Dresses'
    And I Get Name/Text of the last product displayed on the page.
    And I Now enter the same product name in the search bar present on top of page and click the search button.
    Then I Validate that the same product is displayed on a searched page with the same details which were displayed on T-Shirt's page.
    And I quit the browser.

  @PurchaseAProduct
  Scenario Outline:Test the process of adding an item to cart and buy
    Given I launch the browser "chrome"
    And I Open link "http://automationpractice.com/index.php"
    When I Login to the website "<username>" and "<password>".
    And I Move the cursor over Women's link.
    And I Click on the sub menu 'Dresses'.
    And I Mouse hover on the last product displayed.
    And I click on 'More' button.
    And I Increase quantity to "<quantity>".
    And I Select size "<size>"
    And I Select color.
    And I Click the 'Add to Cart' button.
    And I Click the 'Proceed to checkout' button.
    And I Complete the buy order process till payment.
    Then I Make sure that Product is ordered.
    And I quit the browser.
    Examples:
      | username              | password | quantity | size |
      |sravani081188@gmail.com|happe123  |2         |L     |

    @WishList
  Scenario: Verify that 'Add to Wishlist' only works after login.

    Given I launch the browser "chrome"
    And I Open link "http://automationpractice.com/index.php"
    And I Make sure you are not logged in with any user. If yes, please, proceed with the ‘Sign out’.
    When I Move the cursor over Women's link.
    And I Click on sub menu 'Summer Dresses'
    And I Mouse hover on the first product displayed.
    And I 'Add to Wishlist' will appear on the bottom of that product, click on it.
    Then I Verify that the error message is displayed "You must be logged in to manage your wishlist."
      And I quit the browser.

  Scenario Outline: Add to Wishlist with SignIn
    Given I launch the browser "<browserType>"
    And I Open link "<url>"
    When I Login to the website "<username>" and "<password>".
    When I Move the cursor over Women's link.
    And I Click on sub menu 'Summer Dresses'
    And I Mouse hover on the second product displayed.
    And I 'Add to Wishlist' will appear on the bottom of second product, click on it.
    Then I Verify if the product is on your Whishlist under My account > My wishlists
    And I quit the browser.
    Examples:
      | browserType | url                                     | username                | password   |
      | chrome      | http://automationpractice.com/index.php | sravani081188@gmail.com | happe123 |

  Scenario Outline: Verify that Total Price is reflecting correctly if user changes quantity on 'Shopping Cart Summary' Page
    Given I launch the browser "<browserType>"
    And I Open link "<url>"
    When I Login to the website "<username>" and "<password>".
    When I Move the cursor over Women's link.
    And I Click on sub menu 'Summer Dresses'
    And I mouse hover on the second product displayed.
    And 'More' button will be displayed, click on 'More' button.
    And I Make sure the quantity is set to "1".
    And I Select size "<size>"
    And I Select product color.
    And I Click the 'Add to Cart' button.
   # And I Click the 'Proceed to checkout' button.
    And I Change the quantity to '2'.
    Then Verify that Total price is changing and reflecting the correct price.
    And I quit the browser.
    Examples:
      | browserType   | url                                     | username                | password   |size|
      | chrome        | http://automationpractice.com/index.php |sravani081188@gmail.com  | happe123   |M   |
