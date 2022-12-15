
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class TestCheval {
    protected Cheval chevalTest;
    @BeforeEach
    public void init() {
        chevalTest = Ecurie.createChevalTresRapide(new FrissonFactory(GenererNomCheval.donneNomCheval(), 0, 0, 2.5, Sexe.FEMALE));
    }

    @Test
    public void testPourSavoirSiLesRacesDeChevauxHeritentBienDeLaClasseCheval() {
        assertTrue(Cheval.class.isAssignableFrom(Frisson.class));
        assertTrue(Cheval.class.isAssignableFrom(Mustang.class));
        assertTrue(Cheval.class.isAssignableFrom(PurSangArabe.class));
        assertTrue(Cheval.class.isAssignableFrom(QuarterHorse.class));
    }

    @Test
    public void testPourSavoirSiLesFactoriesImplemententBienLInterface() {
        assertTrue(ChevalFactory.class.isAssignableFrom(FrissonFactory.class));
        assertTrue(ChevalFactory.class.isAssignableFrom(MustangFactory.class));
        assertTrue(ChevalFactory.class.isAssignableFrom(PurSangArabeFactory.class));
        assertTrue(ChevalFactory.class.isAssignableFrom(QuarterHorseFactory.class));
    }

    @Test
    public void testPourSavoirSiLaClasseChevalImplementeBienLInterfaceRunnable() {
        assertTrue(Runnable.class.isAssignableFrom(Cheval.class));
    }


    @Test
    public void testPourSavoirSiLeNomDuChevalABienEteSupprime() {
        for (Iterator<String> iterator = GenererNomCheval.getListeNomCheval().iterator(); iterator.hasNext();) {
            iterator.next();
            assertFalse(iterator.toString().equals(chevalTest.getNomCheval()));
        }
    }

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

    @Test
    public void testPourSavoirSiLesFabriquesRenvoientBienLesBonsChevaux() throws Exception {
        assertEquals(Class.forName("MustangFactory").getMethod("createChevalLent").getReturnType(), Cheval.class);
        assertEquals(Class.forName("FrissonFactory").getMethod("createChevalLent").getReturnType(), Cheval.class);
        assertEquals(Class.forName("QuarterHorseFactory").getMethod("createChevalLent").getReturnType(), Cheval.class);
        assertEquals(Class.forName("PurSangArabeFactory").getMethod("createChevalLent").getReturnType(), Cheval.class);
    }

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
