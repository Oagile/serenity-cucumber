package utilities;

import static utilities.WebElementLocators.*;

public class NavigationMenu {

    public NavigationMenu(tdaMenu tdaMenuTab){
        this.tdaMenuTab = tdaMenuTab;
    }

    public enum tdaMenu {
        BOOKINGS, VEHICLE_ADMINISTRATION, ADMINISTRATION,
    }

    tdaMenu tdaMenuTab;

    public String getMenuItemToClick() {
        String element = null;

        switch (tdaMenuTab) {
            case VEHICLE_ADMINISTRATION:

                element = GRP_AREA_COMPANY;
                break;
            case BOOKINGS:

                element = GRP_AREA_RESPONSIBILITY;
                break;
            case ADMINISTRATION:

                element = GRP_AREA_BRAND;
                break;
            default: element = GRP_AREA_INVESTOR;
        }

        return element;

    }

}
