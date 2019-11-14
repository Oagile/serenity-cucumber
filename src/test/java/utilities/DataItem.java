package utilities;

import static utilities.TestDataProperty.getDataItem;

public interface DataItem {
    String USER_PASSWORD = getDataItem("tda.password");
    String TEST_DATA_VIN = getDataItem("manual.create.vin17");
    String TEST_DATA_BRAND_NAME = getDataItem("manual.create.brand");
    String TEST_DATA_MODEL = getDataItem("manual.create.model");
    String TEST_DATA_PROD_TYPE = getDataItem("manual.create.prodType");
    String TEST_DATA_LICENSE_PLATE = getDataItem("manual.create.licencePlate");
    String TEST_DATA_VEHICLE_GROUP_NAME = getDataItem("vehicle.group.name");
    String TEST_DATA_GROUP_DESCRIPTION = getDataItem("vehicle.group.description");
    String TEST_DATA_BUS_NO = getDataItem("tda.outletTenant");
    String TEST_DATA_FIRST_NAME = getDataItem("tda.firstName");
    String TEST_DATA_LAST_NAME =    getDataItem("tda.lastName");
    String TEST_DATA_STREET_AND_NUMBER = getDataItem("tda.streetAndNumber");
    String TEST_DATA_STREET =  getDataItem("tda.street");
    String TEST_DATA_ZIP_CODE = getDataItem("tda.zipcode");
    String TEST_DATA_STATE= getDataItem("tda.state");
    String TEST_DATA_CITY = getDataItem("tda.city");
    String TEST_DATA_EMAIL= getDataItem("tda.email");
    String TEST_DATA_PHONE = getDataItem("tda.phone");
    String TEST_DATA_CELLPHONE = getDataItem("tda.cellphone");
    String TEST_DATA_USERNAME = getDataItem("tda.username");
    String TEST_DATA_PREFERRED_LANGUAGE = getDataItem("tda.preferredLanguage");
    String TEST_DATA_OUTLET = getDataItem("tda.outletTenant");
}
