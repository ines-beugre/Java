package fr.caos.bravo.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * @author Ines Beugre
 */
public class AuthentificationManagerTest {
    String sid;
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void authorization() {
        //Url de base du webService REST
        RestAssured.baseURI = "http://localhost:8080/webresources";
        //Récupération de la requeête
        RequestSpecification httpRequest = given();
        //Construction de la requête en spécifiant sa méthode et ses paramètres
        Response response = httpRequest.request(Method.POST,"/authentification/login?log=login3&mdp=mdp3");
        //Récupération de l'identifiant de session, utile aux requêtes
        sid = response.getBody().asString();
        Assert.assertEquals("connection autorisée",response.getStatusCode(),200);
       // Assert.assert("Connection autorisée", response.getStatusCode(), 202);
        System.out.println(sid);
      //  given().auth()

    }

    @Test
    public void logout() {
        //Url de base du webService REST
        RestAssured.baseURI = "http://localhost:8080/webresources";
        //Récupération de la requeête
        RequestSpecification httpRequest = RestAssured.given();
        //Construction de la requête en spécifiant sa méthode et ses paramètres
        Response response = httpRequest.request(Method.POST,"/authentification/"+sid+"/logout");
        System.out.println(sid);
        /*Récuperation du statut de la réponse,
        * Si la requete a marché,
        * on a le status 200
        * */
        int statusCode = response.getStatusCode();
        //le test marche dans le cas où on a effectivement une déconnexion
        Assert.assertEquals("Deconnexion réussie", response.getStatusCode(), 200);
    }
}
