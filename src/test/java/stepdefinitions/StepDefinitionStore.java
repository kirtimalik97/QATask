package stepdefinitions;
import static org.testng.Assert.assertEquals;

import com.swagger.libraries.Store;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import com.swagger.POJOs.OrderPlacedData;

public class StepDefinitionStore {

    private static Logger logger = LogManager.getLogger();
    private OrderPlacedData storeData = new OrderPlacedData();
    private Store storeLib = new Store();
    private OrderPlacedData storeResponse = new OrderPlacedData();
    private static Integer storeId;

    @Given("user puts Id as {int}, petId as {int}, and quantity as {int}")
    public void user_puts_id_as_pet_id_as_and_quantity_as(Integer id, Integer petId, Integer quantity) {
        storeId=id;
        storeData.setId(id);
        storeData.setPetId(petId);
        storeData.setQuantity(quantity);
        logger.info("Store data values as ID {} , PetId {}, Quantity {}", id, petId, quantity);
    }
    @Given("user puts shipDate as {string}, status {string} and complete as {string}")
    public void user_puts_ship_date_as_status_and_complete_as_true(String shipDate, String status, String complete) {
        storeData.setShipDate(shipDate);
        storeData.setStatus(status);
        storeData.setComplete(Boolean.valueOf(complete));
        logger.info("Store data values :::{},{},{}",shipDate,status,complete);

    }

    @Then("user place order for pet")
    public void user_place_order_for_pet() {
    storeResponse=storeLib.getStoreInventory(storeData);
    }

    @Then("user validates the purchase details")
    public void user_validates_the_purchase_details() {
    try{

        storeResponse=storeLib.getOrderById(storeId);
        assertEquals(storeResponse.getId(),storeData.getId());
        assertEquals(storeResponse.getPetId(),storeData.getPetId());
        assertEquals(storeResponse.getQuantity(),storeData.getQuantity());
        assertEquals(storeResponse.getShipDate(),storeData.getShipDate());
        assertEquals(storeResponse.getStatus(),storeData.getStatus());
        assertEquals(storeResponse.getComplete(),storeData.getComplete());

        logger.info("::::Successfully validated Store data::::");
    }
    catch (Exception e) {
        logger.error(e.getMessage());
        e.printStackTrace();
    }

    }

    @Then("user delete the purchase")
    public void user_delete_the_purchase() {
        storeLib.deleteOrderById(storeId);
    }


}
