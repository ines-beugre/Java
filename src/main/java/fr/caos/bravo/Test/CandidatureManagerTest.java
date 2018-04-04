package fr.caos.bravo.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Ines Beugre
 */
public class CandidatureManagerTest {
    //sid utile aux requêtes
    String sid;
    String iud; //=> idCandidature
    @Before
    public void setUp() throws Exception {
        //Url de base du webService REST
        RestAssured.baseURI = "http://localhost:8080/webresources";
        //Récupération de la requête
        RequestSpecification httpRequest = RestAssured.given();
        //Construction de la requête en spécifiant sa méthode et ses paramètres
        Response response = httpRequest.request(Method.POST,"/authentification/login?log=login3&mdp=mdp3");
        //Récupération de l'identifiant de session, utile aux requêtes
        sid = response.getBody().asString();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCandidaturesList() {
        //Récupération de la requête
        RequestSpecification httpRequest = RestAssured.given();
        //Construction de la requête en spécifiant sa méthode et ses paramètres
        Response response = httpRequest.request(Method.GET,"/"+sid+"/candidature"+iud);
        System.out.println(sid);
        System.out.println(iud);
        System.out.print(response.getBody().prettyPrint());

        // Récupération du statut de la réponse,
        // si l'intéraction avec le web service est un succès,
        // cela doit être un statut 200
        int statusCode = response.getStatusCode();
        //Contenu existant
       Assert.assertEquals("Statut retourné correct", statusCode, 200);

        //Contenu vide
       // Assert.assertEquals("Statut retourné correct", statusCode, 204);
    }

    @Test
    public void deleteCandidature() {
        //Récupération de la requête
        RequestSpecification httpRequest = RestAssured.given();
        //Construction de la requête en spécifiant sa méthode et ses paramètres
        Response response = httpRequest.request(Method.GET,"/"+sid+"/candidature/"+iud);

    }

    @Test
    public void detailCandidature() {
    }

    @Test
    public void setCandidature() {
    }

    @Test
    public void setListeAttente() {
    }
}