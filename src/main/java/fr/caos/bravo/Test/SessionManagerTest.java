package fr.caos.bravo.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Ines Beugre
 */
public class SessionManagerTest {
    String sid;
    String idSession;

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
        System.out.println(sid);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSessions() {
        // Recupération de la requete
        RequestSpecification httpRequest = RestAssured.given();
        //Construction de la requête en spécifiant sa méthode et ses paramètres
        Response response = httpRequest.request(Method.GET,"/"+sid+"/sessions");

    }

    @Test
    public void getSessionDetail() {
    }

    @Test
    public void ajoutCandidature() {
    }

    @Test
    public void getSessionsValidees() {
    }
}