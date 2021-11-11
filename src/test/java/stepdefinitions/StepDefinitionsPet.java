package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.swagger.POJOs.Category;
import com.swagger.POJOs.PetData;
import com.swagger.POJOs.Tag;
import com.swagger.libraries.Pet;
import com.swagger.utils.ConfigManager;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsPet {

    private static final String testDataFile = ConfigManager.getInstance().getString("testdata");
    private static Logger logger = LogManager.getLogger();
    private static Map<String, Object> testData = null;
    private Pet petLib = new Pet();
    private Scenario scenario;
    private PetData requestPetData = new PetData();
    private PetData responsePetDetails = new PetData();
    private static Integer petId;


    public void before(Scenario scenario) {
        this.scenario = scenario;
        logger.info(
                "********************************************************************************************************");
        logger.info(":::: Execution Started :::: {}", scenario.getName());
        logger.info(

                "********************************************************************************************************");

    }

    @Given("user puts id as {int}, name as {string}, and status as {string} about pet")
    public void user_puts_id_as_name_as_and_status_as_about_pet(Integer id, String name, String status) {
        logger.info("User puts id :: [{}], name :: [{}], status :: [{}] about pet ", id, name, status);
        petId = id;
        requestPetData.setName(name);
        requestPetData.setId(id);
        requestPetData.setStatus(status);

    }

    @Given("user puts category details id as {int} and name as {string}")
    public void user_puts_category_details_id_as_and_name_as(Integer categoryId, String categoryName) {
        logger.info("User puts category details id :: [{}], name :: [{}]", categoryId, categoryName);
        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);
        requestPetData.setCategory(category);

    }

    @Given("user puts photo url as {string}")
    public void user_puts_photo_url_as(String photoUrl) {
        logger.info("User puts photo url :: [{}]", photoUrl);
        List<String> photoURLS = new ArrayList<String>();
        photoURLS.add(photoUrl);
        requestPetData.setPhotoUrls(photoURLS);

    }

    @Given("user puts tags details, id as {int} and name as {string}")
    public void user_puts_tags_details_id_as_and_name_as(Integer tagsId, String tagsName) {
        logger.info("User puts tags details id :: [{}], name :: [{}]", tagsId, tagsName);
        Tag tags = new Tag();
        List<Tag> tagList = new ArrayList<Tag>();
        tags.setId(tagsId);
        tags.setName(tagsName);
        tagList.add(tags);
        requestPetData.setTags(tagList);

    }

    @Then("user adds pet to inventory")
    public void user_adds_pet_to_inventory() {

        // Add pet to inventory
        responsePetDetails = petLib.addPetToInv(requestPetData);
    }

    @Then("user validates pet details")
    public void user_validates_pet_details() {

        try {

            responsePetDetails = petLib.findPetByID(petId);
            assertEquals(responsePetDetails.getName(), requestPetData.getName());
            assertEquals(responsePetDetails.getId(), requestPetData.getId());
            assertEquals(responsePetDetails.getCategory().getId(), requestPetData.getCategory().getId());
            assertEquals(responsePetDetails.getCategory().getName(), requestPetData.getCategory().getName());
            assertEquals(responsePetDetails.getStatus(), requestPetData.getStatus());
            assertEquals(responsePetDetails.getPhotoUrls(), requestPetData.getPhotoUrls());
            assertEquals(responsePetDetails.getTags().get(0).getId(), requestPetData.getTags().get(0).getId());
            assertEquals(responsePetDetails.getTags().get(0).getName(), requestPetData.getTags().get(0).getName());

            logger.info("Successfully validated all the fields ::");

        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @When("user update pet details, name as {string} and status as {string}")
    public void user_update_pet_details_name_as_and_status_as(String updatedName, String updatedStatus) {
        requestPetData.setName(updatedName);
        requestPetData.setStatus(updatedStatus);
        responsePetDetails = petLib.updatePet(requestPetData);
        logger.info("RESPONSE DATA : {}", responsePetDetails);

    }

    @Then("user delete pet from inventory")
    public void user_delete_pet_from_inventory() {
        petLib.deletePetById(petId);
    }

}
