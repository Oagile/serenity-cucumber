Feature:  Vehicle Administration
          Create vehicle Group, add service to group
          Manually Create New Vehicle
          Assign vehicle to a group
          Ensure that The Vehicle Can Be Searched
          Book a Test Drive on a New Vehicle
          Cancel Test Drive
          Delete Group Association
          Delete Vehicle
          Delete Vehicle Group

  Background: Authenticate via SGATE before accessing Test Drive Application
          Given that the user navigates to SGATE homepage on his browser
          When  the user enters username, Password and language
          When  the user clicks login
          Then  the landingPage is displayed and fully loaded
          Then  the user selects outlet of interest

   @SmokeTest
  Scenario: Create Vehicle Group, Import Vehicle
          When the user navigates to "Vehicle Administration" menu-tab and select "Create vehicle group"
          When the user captures group details and click create group
          Then the vehicle group must exist from list of groups
          And  the user manually creates vehicle and assign it to a group
          When the user navigates to "Vehicle Administration" menu-tab and select "Show vehicles"
          Then find your list vehicles page must be displayed
          Then the newly created vehicle must be returned when searched from vehicle lookup
          And  the user removes group and vehicle association
          When the user navigates to "Vehicle Administration" menu-tab and select "Show vehicles"
          Then find your list vehicles page must be displayed
          Then the newly created vehicle must be returned when searched from vehicle lookup
          And  the user deletes a vehicle
          And  the user navigates to "Vehicle Administration" menu-tab and select "Show vehicle groups"
          Then vehicle groups page must be displayed
          Then the user deletes vehicle group

  @SmokeTest
  Scenario: Test that A User Can Book A Test Drive
          When the user navigates to "Bookings" menu-tab and select "Book test drive"
          And  the user populates his details for test drive
          Then the user checks that appointment status is "Booked"
          #Then the user updates test drive appointment
          Then the user cancels the test drive appointment
          Then the user checks that appointment status is "Canceled"