package esseex.glue;

import cucumber.api.java.en.Then;
import ui.TestDriveApplicationPage;
import ui.ViewTestDrivePage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static utilities.Constants.BOOKED;

public class TestDriveAppointmentStepDefinitions {
    TestDriveApplicationPage testDriveApplicationPage;
    ViewTestDrivePage viewTestDrivePage;

    @Then("^the user populates his details for test drive$")
    public void theUserCapturesATestDriveOnANewlyCreatedVehicleAndCancel(){
        testDriveApplicationPage.completeTestDriveAppointment();
    }


    @Then("^the user checks that appointment status and bookingId$")
    public void theUserChecksThatAppointmentStatus() {
        assertThat(viewTestDrivePage.getBookingStatus(), containsString(BOOKED));

    }


    @Then("^the user cancels the test drive appointment$")
    public void theUseCancelsTheTestDriveAppointment()  {
        viewTestDrivePage.cancelTestDriveAppointment();

    }

    @Then("^the user checks that appointment status is \"([^\"]*)\"$")
    public void theUserChecksThatAppointmentStatusIs(String appointmentStatus)  {
        assertThat(viewTestDrivePage.getBookingStatus(), containsString(appointmentStatus));
    }

    @Then("^the user updates test drive appointment$")
    public void theUserUpdatesTestDriveAppointment()  {
        viewTestDrivePage.updateTestDriveAppointment();
    }
}
