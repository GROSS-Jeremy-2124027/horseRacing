
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour tous les chevaux
 */
public class TestCheval {
    protected Cheval chevalTest;
    @BeforeEach
    public void init() {
        chevalTest = Ecurie.createChevalTresRapide(new FrissonFactory(GenererNomCheval.donneNomCheval(), 0, 0, 2.5, Sexe.FEMALE));
    }

    /**
     * Test permettant de savoir si les classes concrètes des différentes races de chevaux héritent bien de la classe
     * abstraite Cheval
     */
    @Test
    public void testPourSavoirSiLesRacesDeChevauxHeritentBienDeLaClasseCheval() {
        assertTrue(Cheval.class.isAssignableFrom(Frisson.class));
        assertTrue(Cheval.class.isAssignableFrom(Mustang.class));
        assertTrue(Cheval.class.isAssignableFrom(PurSangArabe.class));
        assertTrue(Cheval.class.isAssignableFrom(QuarterHorse.class));
    }

    /**
     * Test permettant de savoir si les classe concrètes des différentes fabriques de chevaux implémentent bien
     * l'interface ChevalFactory
     */
    @Test
    public void testPourSavoirSiLesFactoriesImplemententBienLInterface() {
        assertTrue(ChevalFactory.class.isAssignableFrom(FrissonFactory.class));
        assertTrue(ChevalFactory.class.isAssignableFrom(MustangFactory.class));
        assertTrue(ChevalFactory.class.isAssignableFrom(PurSangArabeFactory.class));
        assertTrue(ChevalFactory.class.isAssignableFrom(QuarterHorseFactory.class));
    }

    /**
     * Test permettant de savoir si la classe Chavel implémente bien la class Runnable
     */
    @Test
    public void testPourSavoirSiLaClasseChevalImplementeBienLInterfaceRunnable() {
        assertTrue(Runnable.class.isAssignableFrom(Cheval.class));
    }

    /**
     * Test permettant de savoir si la classe GénéreNomCheval écrase bien le nom précédent d'un cheval avant de lui
     * en attribuer un nouveau
     */
    @Test
    public void testPourSavoirSiLeNomDuChevalABienEteSupprime() {
        for (Iterator<String> iterator = GenererNomCheval.getListeNomCheval().iterator(); iterator.hasNext();) {
            iterator.next();
            assertFalse(iterator.toString().equals(chevalTest.getNomCheval()));
        }
    }

    /**
     * Test permettant de savoir si il y a bien une auto-incrémentation du numéro des chevaux lors de la création du
     * dispositif de la course
     */
    @Test
    public void testPourSavoirSiLesNumerosDeChevauxSontBienIncrementes() {
        DispositifsDeLaCourse course = new DispositifsDeLaCourse(5, 2.5);
        assertNotEquals(course.getChevauxDeCourse().size(), 0);
        int numero = 1;
        for (Cheval cheval : course.getChevauxDeCourse()) {
            assertEquals(numero, cheval.getNumeroCheval());
            numero += 1;
        }
    }

    /**
     * Test permettant de savoir si les fabriques des différentes races de chevaux renvoient bien des chevaux de la
     * race demandée
     * @throws Exception
     */
    @Test
    public void testPourSavoirSiLesFabriquesRenvoientBienLesBonsChevaux() throws Exception {
        assertEquals(Class.forName("MustangFactory").getMethod("createChevalLent").getReturnType(), Cheval.class);
        assertEquals(Class.forName("FrissonFactory").getMethod("createChevalLent").getReturnType(), Cheval.class);
        assertEquals(Class.forName("QuarterHorseFactory").getMethod("createChevalLent").getReturnType(), Cheval.class);
        assertEquals(Class.forName("PurSangArabeFactory").getMethod("createChevalLent").getReturnType(), Cheval.class);
    }

    /**
     * Test pemettant de savoir si les fabriques asigent les bonne vitesse aux chevaux demandés
     */
    @Test
    public void testPourSavoirSiLesFabriquesAssignentBienLesBonnesVitesses() {
        Cheval chevalTresLent = Ecurie.createChevalTresLent(new MustangFactory("nom", 0, 0, 0, Sexe.MALE));
        Cheval chevalLent = Ecurie.createChevalLent(new MustangFactory("nom", 0, 0, 0, Sexe.MALE));
        Cheval chevalMoyennementRapide = Ecurie.createChevalMoyen(new MustangFactory("nom", 0, 0, 0, Sexe.MALE));
        Cheval chevalRapide = Ecurie.createChevalRapide(new MustangFactory("nom", 0, 0, 0, Sexe.MALE));

        assertEquals(chevalTresLent.getVitesse(), Vitesse.TRES_LENT);
        assertEquals(chevalLent.getVitesse(), Vitesse.LENT);
        assertEquals(chevalMoyennementRapide.getVitesse(), Vitesse.MOYEN);
        assertEquals(chevalRapide.getVitesse(), Vitesse.RAPIDE);
        assertEquals(chevalTest.getVitesse(), Vitesse.TRES_RAPIDE);
    }

}
